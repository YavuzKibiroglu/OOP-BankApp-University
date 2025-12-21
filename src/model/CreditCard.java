package model;

import Managers.DataBaseManager;

public class CreditCard extends Card {

    private Float creditLimit;
    private Float currentDebt;

    public CreditCard(String cardNumber, String userId, String cvv, String expiryDate, float creditLimit, float currentDebt) {
        super(cardNumber, userId, cvv, expiryDate);
        this.creditLimit = creditLimit;
        this.currentDebt = currentDebt;
    }

    public float getCreditLimit() { return creditLimit; }
    public float getCurrentDebt() { return currentDebt; }

    @Override
    public String getInformation() {
        return String.format("KREDİ KARTI | Limit: %.2f | Borç: %.2f", creditLimit, currentDebt);
    }

    // --- 1. HARCAMA YAP (Nakit Avans veya Alışveriş) ---
    @Override
    public boolean spend(float amount) {
        if (amount <= 0) return false;

        float availableLimit = creditLimit - currentDebt;
        if (availableLimit < amount) {
            return false; // Limit yetersiz
        }

        this.currentDebt += amount;
        return true;
    }

    // --- 2. BORÇ ÖDE (DÜZELTİLDİ: Try-Catch Yapısı) ---
    public boolean payDebt(CheckingAccount sourceAccount, float amount) {
        if (amount <= 0) return false;

        // KURAL: Borçtan fazla ödeme yapılamaz
        if (amount > currentDebt) return false;

        try {
            // Hesaptan parayı çekmeyi dene (Hata verirse catch'e düşer)
            sourceAccount.withdraw(amount);

            // Para çekildiyse borcu düş
            this.currentDebt -= amount;
            return true;

        } catch (Exception e) {
            return false; // Bakiye yetersiz
        }
    }
}