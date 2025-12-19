package model;

import java.sql.SQLException;

public abstract class Card {
    protected String cardNumber;
    protected String userId;
    protected String cvv;
    protected String expiryDate; // "12/28" formatında

    public Card(String cardNumber, String userId, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.userId = userId;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() { return cardNumber; }
    public String getUserId() { return userId; }

    // Her kartın harcama mantığı farklıdır
    // Banka kartı hesaptan düşer, Kredi kartı borcu artırır.
    public abstract boolean spend(float amount) throws SQLException;

    public abstract String getInformation();
}