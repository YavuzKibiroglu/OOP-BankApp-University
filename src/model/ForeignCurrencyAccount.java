package model;

import Managers.CurrencyManager;
import Managers.DataBaseManager;
import java.sql.SQLException;

public class ForeignCurrencyAccount extends Account {

    private String currencyType; // "USD", "EUR", "GOLD"

    public ForeignCurrencyAccount(String userId, String accountId, float moneyInAccount, String currencyType) {
        super(userId, accountId, moneyInAccount);
        this.currencyType = currencyType;
    }

    @Override
    public String getInformation() {
        double currentRate = CurrencyManager.getBuyRate(currencyType);
        double tlEquivalent = this.moneyInAccount * currentRate;
        return String.format("%s Hesabı | Bakiye: %.2f | TL: %.2f", currencyType, moneyInAccount, tlEquivalent);
    }

    // --- ZORUNLU INTERFACE METODU ---
    @Override
    public void transferToCurrent(float moneyAmount) throws SQLException {
        this.moneyInAccount -= moneyAmount;
        DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);
    }

    // =================================================================
    // 1. DÖVİZ AL (DÜZELTİLDİ: Miktar * Kur)
    // =================================================================
    // amountToBuy: Kullanıcının almak istediği DÖVİZ miktarı (Örn: 100 Dolar)
    public boolean buyCurrency(CheckingAccount tlAccount, double amountToBuy) {
        if (amountToBuy <= 0) return false;

        // 1. Gereken TL Tutarını Hesapla
        double rate = CurrencyManager.getSellRate(this.currencyType); // Banka Satış Kuru
        double tlRequired = amountToBuy * rate; // Örn: 100 Dolar * 32.50 = 3250 TL

        // 2. TL Hesabından Parayı Çek
        try {
            // RAM'den düş (CheckingAccount withdraw metodu kontrolü yapar)
            tlAccount.withdraw(tlRequired);

            // TL Hesabını Veritabanına Kaydet (Çünkü CheckingAccount.withdraw artık sadece RAM güncelliyor)
            boolean tlSaved = DataBaseManager.saveAccount(tlAccount);
            if (!tlSaved) return false;

        } catch (Exception e) {
            return false; // Yetersiz Bakiye
        }

        // 3. Döviz Hesabına Ekle ve Kaydet
        this.moneyInAccount += amountToBuy;
        boolean forexUpdated = DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);

        if (forexUpdated) {
            return true;
        } else {
            // HATA: Para düştü ama döviz gelmedi -> İADE ET (Rollback)
            tlAccount.deposit(tlRequired);
            DataBaseManager.saveAccount(tlAccount);
            return false;
        }
    }

    // =================================================================
    // 2. DÖVİZ SAT (Satış Mantığı Zaten Doğruydu)
    // =================================================================
    // forexAmountToSell: Satılacak DÖVİZ miktarı
    public boolean sellCurrency(CheckingAccount tlAccount, double forexAmountToSell) {
        if (forexAmountToSell <= 0) return false;
        if (this.moneyInAccount < forexAmountToSell) return false; // Yetersiz Döviz

        // 1. Kazanılacak TL'yi Hesapla
        double rate = CurrencyManager.getBuyRate(this.currencyType); // Banka Alış Kuru
        double tlGained = forexAmountToSell * rate;

        // 2. Döviz Hesabından Düş
        this.moneyInAccount -= forexAmountToSell;
        boolean forexUpdated = DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);

        if (forexUpdated) {
            // 3. TL Hesabına Ekle
            // addMoneyToAccount metodu hem RAM hem DB günceller
            tlAccount.addMoneyToAccount((float)tlGained);
            return true;
        } else {
            // Hata varsa geri al
            this.moneyInAccount += forexAmountToSell;
            return false;
        }
    }
}