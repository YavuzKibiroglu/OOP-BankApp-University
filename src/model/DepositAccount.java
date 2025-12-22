package model;

import Managers.TimeManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends Account {

    private int termDays;
    private LocalDate creationDate;

    private static final double TAX_RATE = 0.05;

    //CONSTRUCTOR
    public DepositAccount(
            String accountId,
            String userId,
            float moneyInAccount,
            int termDays,
            LocalDate creationDate
    ) {
        // Account sınıfının constructor yapısına göre super çağrısı:
        super(userId, accountId, moneyInAccount);

        this.termDays = termDays;
        this.creationDate = creationDate;
    }


    // UI VE MANAGER İÇİN GEREKLİ GETTER'LAR
    // 1. Bakiye
    public double getBalance() {
        return super.getMoneyInAccount();
    }

    // 2. Vade Günü
    public int getOriginalTermDays() {
        return this.termDays;
    }

    // 3. Oluşturulma Tarihi
    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    // FAİZ ORANI
    private double getInterestRate() {
        if (this.termDays >= 365) return 50.0;
        else if (this.termDays >= 181) return 48.0;
        else if (this.termDays >= 92) return 45.0;
        else return 40.0;
    }


    // NET KAZANÇ
    public double calculateNetProfit() {
        double rate = getInterestRate();
        // depositDays yerine termDays kullandık
        double grossProfit = (this.moneyInAccount * rate * this.termDays) / 36500.0;
        return grossProfit * (1.0 - TAX_RATE);
    }

    public static double calculateProjectedNetProfit(double amount, int days) {
        double rate;
        if (days >= 365) rate = 50.0;
        else if (days >= 181) rate = 48.0;
        else if (days >= 92) rate = 45.0;
        else rate = 40.0;

        double grossProfit = (amount * rate * days) / 36500.0;
        return grossProfit * 0.95; // %5 stopaj
    }

    // BİLGİ METODU
    @Override
    public String getInformation() {
        long kalanGun = 0;
        if (creationDate != null) {
            long gecen = ChronoUnit.DAYS.between(
                    creationDate,
                    TimeManager.getCurrentDate()
            );
            kalanGun = termDays - gecen;
            if (kalanGun < 0) kalanGun = 0;
        }

        return String.format(
                "Vadeli Hesap | Vade: %d Gün | Kalan: %d Gün | Tahmini Kazanç: %.2f TL",
                termDays,
                kalanGun,
                calculateNetProfit()
        );
    }

    @Override
    public boolean withdraw(double amount) throws Exceptions.YetersizBakiyeException {
        if (this.moneyInAccount < amount) {
            throw new Exceptions.YetersizBakiyeException("Vadeli Hesap Bakiyesi Yetersiz", this.moneyInAccount, amount);
        }
        this.moneyInAccount -= amount;
        return true;
    }

    @Override
    public void transferToCurrent(float moneyAmount, String targetAccountId) throws SQLException {
    }

    @Override
    public void transferToCurrent(float moneyAmount) throws SQLException {
    }

    @Override
    public void transferToCurrent() throws SQLException {
    }
}