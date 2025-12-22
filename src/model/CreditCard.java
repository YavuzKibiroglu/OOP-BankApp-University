package model;

import Exceptions.YetersizBakiyeException;

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

    //HARCAMA YAP (Nakit Avans veya Alışveriş)
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

    // BORÇ ÖDE
    public boolean payDebt(CheckingAccount sourceAccount, float amount) {
        if (amount <= 0) return false;
        if (amount > currentDebt) return false;

        try {
            // Hesaptan parayı çekmeyi deneme
            sourceAccount.withdraw(amount);

            // Para çekildiyse borcu düş
            this.currentDebt -= amount;

            // Veritabanı güncellemeleri
            Managers.DataBaseManager.updateCardDebt(this.cardNumber, this.currentDebt);
            Managers.DataBaseManager.updateBalance(sourceAccount.getAccountId(), sourceAccount.getMoneyInAccount());

            return true;

        } catch (Exceptions.YetersizBakiyeException e) {
            // Bakiye yetmezse işlem iptal
            return false;
        }
    }
}