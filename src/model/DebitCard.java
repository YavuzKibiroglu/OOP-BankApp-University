package model;

public class DebitCard extends Card {

    private CheckingAccount linkedAccount;

    // Constructor CheckingAccount nesnesi istiyor
    public DebitCard(String cardNumber, String userId, String cvv, String expiryDate, CheckingAccount linkedAccount) {
        super(cardNumber, userId, cvv, expiryDate);
        this.linkedAccount = linkedAccount;
    }

    public CheckingAccount getLinkedAccount() {
        return linkedAccount;
    }

    @Override
    public String getInformation() {
        return "BANKA KARTI | No: " + cardNumber + " | Bağlı Hesap: " + linkedAccount.getIbanNumber();
    }

    //HARCAMA YAPMA
    @Override
    public boolean spend(float amount) {
        if (linkedAccount == null) return false;

        try {

            linkedAccount.withdraw(amount);

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}