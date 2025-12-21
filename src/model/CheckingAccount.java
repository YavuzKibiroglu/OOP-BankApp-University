package model;

import Managers.DataBaseManager;
import java.sql.SQLException;

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
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Çekilecek tutar 0'dan büyük olmalı.");
        }
        if (this.moneyInAccount < amount) {
            throw new IllegalStateException("Yetersiz Bakiye!"); // Service bunu yakalar
        }
        this.moneyInAccount -= amount;
        return false;
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

    // Transfer İşlemi (UI tarafında kullanılıyor)
    public boolean transferTo(Account targetAccount, double amount) {
        if (targetAccount == null || amount <= 0) return false;

        try {
            // 1. Kendinden düş
            this.withdraw(amount);
            DataBaseManager.updateBalance(this.accountId, this.moneyInAccount); // Kaydet

            // 2. Hedefe ekle
            if (targetAccount instanceof CheckingAccount) {
                ((CheckingAccount) targetAccount).addMoneyToAccount((float)amount);
                return true;
            }
        } catch (Exception e) {
            return false;
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