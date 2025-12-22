package model;

// DebitCard ve CreditCard buradan özellik alır.
public abstract class Card {

    protected String cardNumber;
    protected String userId;
    protected String cvv;
    protected String expiryDate;

    public Card(String cardNumber, String userId, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.userId = userId;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    // Alt sınıflar (Debit/Credit) bu metotları miras alır.

    public String getCardNumber() {
        return cardNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    // Her kartın bilgi verme şekli farklıdır, o yüzden abstract
    public abstract String getInformation();

    // Her kartın harcama mantığı farklıdır, o yüzden abstract
    public abstract boolean spend(float amount) throws java.sql.SQLException;
}