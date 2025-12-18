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

    public String getCurrencyType() {
        return currencyType;
    }

    @Override
    public String getInformation() {
        // Source 185: TL karşılığını gösterme
        double currentRate = CurrencyManager.getBuyRate(currencyType); // Satarsak kaç TL eder?
        double tlEquivalent = this.moneyInAccount * currentRate;

        return String.format("Döviz Hesabı (%s) | Bakiye: %.2f %s | TL Karşılığı: %.2f TL",
                currencyType, moneyInAccount, currencyType, tlEquivalent);
    }

    // --- DÖVİZ ALMA İŞLEMİ (TL -> DÖVİZ) ---
    // Kullanıcı TL verip Dolar/Euro/Altın alır.
    // Parametre: checkingAccountId (Hangi vadesiz hesaptan para çekilecek?)
    // Parametre: amountTL (Kaç TL'lik alım yapılacak?)
    public void buyCurrency(String checkingAccountId, float amountTL) {
        try {
            // 1. Vadesiz Hesabı Bul
            Account checkingAccount = DataBaseManager.getAccountById(checkingAccountId);

            // 2. Kontroller
            if (checkingAccount == null || !(checkingAccount instanceof CheckingAccount)) {
                System.out.println("Hata: Geçerli bir vadesiz hesap bulunamadı.");
                return;
            }
            if (!checkingAccount.getUserId().equals(this.userId)) {
                System.out.println("Güvenlik Hatası: Başkasının hesabından işlem yapamazsınız.");
                return;
            }
            if (checkingAccount.getMoneyInAccount() < amountTL) {
                System.out.println("Yetersiz Bakiye: Vadesiz hesabınızda yeterli TL yok.");
                return;
            }

            // 3. Hesaplama (Bankanın Satış Kuru kullanılır)
            double rate = CurrencyManager.getSellRate(this.currencyType);
            double forexAmount = amountTL / rate;

            // 4. İşlem (Transaction)
            // A) Vadesizden TL düş
            float newTLBalance = checkingAccount.getMoneyInAccount() - amountTL;
            DataBaseManager.updateBalance(checkingAccountId, newTLBalance);

            // B) Döviz Hesabına Ekle
            float newForexBalance = this.moneyInAccount + (float) forexAmount;
            DataBaseManager.updateBalance(this.accountId, newForexBalance);

            // C) RAM güncelleme
            ((CheckingAccount) checkingAccount).setMoneyInAccount(newTLBalance);
            this.moneyInAccount = newForexBalance;

            System.out.println("İşlem Başarılı!");
            System.out.println(amountTL + " TL karşılığında " + String.format("%.2f", forexAmount) + " " + currencyType + " alındı.");
            System.out.println("Kur: " + rate);

        } catch (SQLException e) {
            System.out.println("Veritabanı Hatası: " + e.getMessage());
        }
    }

    // --- DÖVİZ SATMA İŞLEMİ (DÖVİZ -> TL) ---
    // Kullanıcı Dolar/Euro satıp Vadesiz hesabına TL yükler. (Source 166)
    // Parametre: checkingAccountId (Para nereye gidecek?)
    // Parametre: amountForex (Ne kadar döviz bozdurulacak?)
    public void sellCurrency(String checkingAccountId, float amountForex) {
        try {
            // 1. Kontrol: Döviz bakiyesi yetiyor mu?
            if (this.moneyInAccount < amountForex) {
                System.out.println("Yetersiz Bakiye: Hesabınızda bu kadar döviz yok.");
                return;
            }

            // 2. Vadesiz Hesabı Bul
            Account checkingAccount = DataBaseManager.getAccountById(checkingAccountId);

            if (checkingAccount == null || !(checkingAccount instanceof CheckingAccount)) {
                System.out.println("Hata: Hedef vadesiz hesap bulunamadı.");
                return;
            }
            if (!checkingAccount.getUserId().equals(this.userId)) {
                System.out.println("Güvenlik Hatası: Döviz bozdurup başkasına atamazsınız.");
                return;
            }

            // 3. Hesaplama (Bankanın Alış Kuru kullanılır)
            double rate = CurrencyManager.getBuyRate(this.currencyType);
            double tlAmount = amountForex * rate;

            // 4. İşlem
            // A) Döviz düş
            float newForexBalance = this.moneyInAccount - amountForex;
            DataBaseManager.updateBalance(this.accountId, newForexBalance);

            // B) Vadesiz TL ekle
            float newTLBalance = checkingAccount.getMoneyInAccount() + (float) tlAmount;
            DataBaseManager.updateBalance(checkingAccountId, newTLBalance);

            // C) RAM güncelleme
            this.moneyInAccount = newForexBalance;
            ((CheckingAccount) checkingAccount).setMoneyInAccount(newTLBalance);

            System.out.println("Satış Başarılı!");
            System.out.println(amountForex + " " + currencyType + " bozduruldu. Hesaba geçen: " + String.format("%.2f", tlAmount) + " TL.");
            System.out.println("Kur: " + rate);

        } catch (SQLException e) {
            System.out.println("Veritabanı Hatası: " + e.getMessage());
        }
    }

    // Abstract metod implementasyonu (CheckingAccount'a aktarım mantığı - Satış ile aynı)
    @Override
    public void transferToCurrent(float moneyAmount, String accountId) throws SQLException {
        // Bu metod çağrılırsa direkt satış işlemi yapar
        sellCurrency(accountId, moneyAmount);
    }

    // Kullanılmayan overload
    @Override
    public void transferToCurrent(float moneyAmount) throws SQLException {
    }
}
