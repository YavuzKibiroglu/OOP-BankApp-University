package model;

import Managers.DataBaseManager;
import java.sql.SQLException;
import Exceptions.YetersizBakiyeException;

public class CheckingAccount extends Account {

    private final String ibanNumber;

    public CheckingAccount(String userId, String accountId, String ibanNumber, float moneyInAccount) {
        super(userId, accountId, moneyInAccount);
        this.ibanNumber = ibanNumber;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    @Override
    public String getInformation() {
        return String.format("Vadesiz Hesap | IBAN: %s | Bakiye: %.2f TL", ibanNumber, moneyInAccount);
    }

    // =============================================================
    // 1. BANKSERVICE İÇİN GEREKLİ METOTLAR (SAF OOP)
    // =============================================================

    // Para Çekme (Sadece RAM'de işlem yapar, kuralı kontrol eder)
    // BankService bunu çağırır ve sonra saveAccount yapar.
    @Override
    public boolean withdraw(double amount) throws Exceptions.YetersizBakiyeException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Çekilecek tutar 0'dan büyük olmalı.");
        }

        // Bakiye Kontrolü
        if (this.moneyInAccount < amount) {
            // Hata Fırlatılıyor
            throw new Exceptions.YetersizBakiyeException("Yetersiz Vadesiz Hesap Bakiyesi!", this.moneyInAccount, amount);
        }

        this.moneyInAccount -= amount;
        return true;
    }

    // Para Yatırma (Sadece RAM'de işlem yapar)
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Yatırılacak tutar 0'dan büyük olmalı.");
        }
        this.moneyInAccount += amount;
    }

    // =============================================================
    // 2. DİĞER YARDIMCI METOTLAR
    // =============================================================

    // Interface Zorunluluğu
    @Override
    public void transferToCurrent(float moneyAmount) throws SQLException {
        deposit(moneyAmount); // deposit metodunu kullanabiliriz
        // Veritabanı güncellemesi gerekiyorsa:
        DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);
    }

    @Override
    public void transferToCurrent() throws SQLException {

    }

    // Helper: Hızlı para ekleme (Eski kodlarla uyum için)
    public void addMoneyToAccount(float moneyToAdd) {
        deposit(moneyToAdd);
        DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);
    }

    public void addMoneyToAccount(float moneyToAdd, String description) {
        this.moneyInAccount += moneyToAdd;
        DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);
        System.out.println("Para Eklendi (" + description + "): " + moneyToAdd + " TL");
    }

    // Transfer İşlemi (UI tarafında kullanılıyor)
    public boolean transferTo(Account targetAccount, double amount) throws Exceptions.YetersizBakiyeException {
        if (targetAccount == null || amount <= 0) return false;

        // BURASI ARTIK HATA FIRLATABİLİR (withdraw metodundan dolayı)
        // Biz burada try-catch kullanmıyoruz, çünkü hatayı UI (Ekran) yakalasın istiyoruz.

        // 1. Kendinden düş (withdraw metodu YetersizBakiye hatası fırlatırsa işlem durur ve UI'a gider)
        this.withdraw(amount);

        // Para düştüyse veritabanını güncelle
        Managers.DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);

        // 2. Hedefe ekle
        if (targetAccount instanceof CheckingAccount) {
            ((CheckingAccount) targetAccount).addMoneyToAccount((float)amount);
            // Hedef hesap DB kaydı addMoneyToAccount içinde yapılıyor olabilir,
            // yapılmıyorsa buraya Managers.DataBaseManager.saveAccount(targetAccount); eklenebilir.
            return true;
        } else if (targetAccount instanceof DepositAccount) {
            // Vadeli hesaba dışarıdan para girişi genellikle olmaz ama senaryona göre ekleyebilirsin
            targetAccount.deposit(amount);
            Managers.DataBaseManager.saveAccount(targetAccount);
            return true;
        } else if (targetAccount instanceof ForeignCurrencyAccount) {
            // Dövize TL atılmaz, burası ayrı mantık gerektirir ama şimdilik bakiye ekle geç
            targetAccount.deposit(amount);
            Managers.DataBaseManager.saveAccount(targetAccount);
            return true;
        }

        return false;
    }

    // Fatura Ödeme
    public boolean payBill(String invoiceId, double amount) {
        try {
            this.withdraw(amount);
            boolean guncellendi = DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);
            return guncellendi;
        } catch (Exception e) {
            return false;
        }
    }
}