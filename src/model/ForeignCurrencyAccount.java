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

    @Override
    public void transferToCurrent() throws SQLException {

    }

    // =================================================================
    // 1. DÖVİZ AL (TL Hesabından Para Çeker -> Döviz Hesabına Ekler)
    // =================================================================
    public boolean buyCurrency(CheckingAccount tlAccount, double amountToBuy) {
        // amountToBuy: Alınacak döviz miktarı (Örn: 100 Dolar)
        if (amountToBuy <= 0) return false;

        // 1. Gereken TL Tutarını Hesapla
        // (Örn: 100 Dolar * 32.50 = 3250 TL lazım)
        double rate = Managers.CurrencyManager.getSellRate(this.currencyType);
        double tlRequired = amountToBuy * rate;

        try {
            // 2. TL Hesabından Parayı Çekmeyi Dene (RAM İşlemi)
            // Eğer bakiye yetmezse burada 'YetersizBakiyeException' fırlatır ve catch'e düşer.
            tlAccount.withdraw(tlRequired);

            // 3. TL Hesabını Veritabanına Kaydet
            // (Para çekildi, bunu DB'ye işle)
            boolean tlSaved = Managers.DataBaseManager.saveAccount(tlAccount);
            if (!tlSaved) {
                // DB hatası olursa parayı iade et (Rollback) ve çık
                tlAccount.deposit(tlRequired);
                return false;
            }

            // 4. Döviz Hesabına Ekle (RAM İşlemi)
            this.moneyInAccount += amountToBuy;

            // 5. Döviz Hesabını Veritabanına Kaydet
            boolean forexUpdated = Managers.DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);

            if (forexUpdated) {
                return true; // İşlem Başarılı
            } else {
                // KRİTİK HATA: TL düştü ama Döviz DB'ye yazılamadı -> İADE ET (Rollback)
                this.moneyInAccount -= amountToBuy; // RAM'i geri al
                tlAccount.deposit(tlRequired);      // TL'yi iade et
                Managers.DataBaseManager.saveAccount(tlAccount); // TL iadesini kaydet
                return false;
            }

        } catch (Exceptions.YetersizBakiyeException e) {
            // Bakiye yetersizse sessizce false dön (veya logla)
            // System.out.println("Döviz Alım Hatası: " + e.getMessage());
            return false;
        } catch (Exception e) {
            // Diğer veritabanı hataları
            e.printStackTrace();
            return false;
        }
    }

    // =================================================================
    // 2. DÖVİZ SAT (Döviz Hesabından Çeker -> TL Hesabına Ekler)
    // =================================================================
    public boolean sellCurrency(CheckingAccount tlAccount, double forexAmountToSell) {
        if (forexAmountToSell <= 0) return false;

        // Burada Exception fırlatmıyoruz, basit if kontrolü yetiyor çünkü bu sınıfın içindeyiz
        if (this.moneyInAccount < forexAmountToSell) return false; // Yetersiz Döviz

        // 1. Kazanılacak TL'yi Hesapla
        double rate = Managers.CurrencyManager.getBuyRate(this.currencyType); // Banka Alış Kuru
        double tlGained = forexAmountToSell * rate;

        // 2. Döviz Hesabından Düş
        this.moneyInAccount -= forexAmountToSell;

        // 3. Döviz Hesabını Güncelle
        boolean forexUpdated = Managers.DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);

        if (forexUpdated) {
            // 4. TL Hesabına Ekle
            // addMoneyToAccount hem RAM'i günceller hem de DB'ye yazar (CheckingAccount içinde)
            tlAccount.addMoneyToAccount((float)tlGained);
            return true;
        } else {
            // Hata varsa dövizi geri koy (Rollback)
            this.moneyInAccount += forexAmountToSell;
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) throws Exceptions.YetersizBakiyeException {
        if (this.moneyInAccount < amount) {
            throw new Exceptions.YetersizBakiyeException("Döviz Bakiyesi Yetersiz", this.moneyInAccount, amount);
        }
        this.moneyInAccount -= amount;
        return true;
    }
}