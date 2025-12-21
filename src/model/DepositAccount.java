package model;

import Managers.DataBaseManager;
import Managers.TimeManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends Account {

    private int depositDays;
    private LocalDate creationDate;

    private static final double TAX_RATE = 0.05;

    public DepositAccount(
            String userId,
            String accountId,
            float moneyInAccount,
            int depositDays,
            LocalDate creationDate
    ) {
        super(userId, accountId, moneyInAccount);
        this.depositDays = depositDays;
        this.creationDate = creationDate;
    }

    // -------------------------------
    // FAİZ ORANI (INSTANCE İÇİN)
    // -------------------------------
    private double getInterestRate() {
        if (this.depositDays >= 365) return 50.0;
        else if (this.depositDays >= 181) return 48.0;
        else if (this.depositDays >= 92) return 45.0;
        else return 40.0;
    }

    // -------------------------------
    // NET KAZANÇ (INSTANCE İÇİN)
    // -------------------------------
    public double calculateNetProfit() {
        double rate = getInterestRate();
        double grossProfit = (this.moneyInAccount * rate * this.depositDays) / 36500.0;
        return grossProfit * (1.0 - TAX_RATE);
    }

    /**
     * UI için ön izleme metodu
     * Hesap henüz açılmadan, "şu kadar para – şu kadar gün" için
     * tahmini net kazancı hesaplar.
     */
    public static double calculateProjectedNetProfit(double amount, int days) {

        double rate;
        if (days >= 365) rate = 50.0;
        else if (days >= 181) rate = 48.0;
        else if (days >= 92) rate = 45.0;
        else rate = 40.0;

        double grossProfit = (amount * rate * days) / 36500.0;

        return grossProfit * 0.95; // %5 stopaj
    }

    // -------------------------------
    // BİLGİ METODU
    // -------------------------------
    @Override
    public String getInformation() {
        long kalanGun = 0;
        if (creationDate != null) {
            long gecen = ChronoUnit.DAYS.between(
                    creationDate,
                    TimeManager.getCurrentDate()
            );
            kalanGun = depositDays - gecen;
            if (kalanGun < 0) kalanGun = 0;
        }

        return String.format(
                "Vadeli Hesap | Vade: %d Gün | Kalan: %d Gün | Tahmini Kazanç: %.2f TL",
                depositDays,
                kalanGun,
                calculateNetProfit()
        );
    }

    @Override
    public void transferToCurrent(float moneyAmount, String targetAccountId) throws SQLException {
        // (Senin mevcut mantığın burada kalacak)
    }

    @Override
    public void transferToCurrent(float moneyAmount) throws SQLException {
        // boş
    }

    @Override
    public void transferToCurrent() throws SQLException {

    }
}
