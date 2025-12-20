package model;

public class DebitCard extends Card {

    // Sadece ID değil, hesabın KENDİSİNİ tutuyoruz (Composition)
    private CheckingAccount linkedAccount;

    // Constructor artık CheckingAccount nesnesi istiyor
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

    // --- HARCAMA YAP (OOP) ---
    @Override
    public boolean spend(float amount) {
        if (linkedAccount == null) return false;

        try {
            // Kart harcaması aslında hesaptan para çekmektir.
            // Modeldeki 'withdraw' metodu kuralları kontrol eder (Bakiye yetiyor mu?)
            linkedAccount.withdraw(amount);

            // Eğer withdraw hata vermediyse işlem RAM'de başarılıdır.
            // (Veritabanı kaydı Service katmanında yapılacak)
            return true;

        } catch (Exception e) {
            // Yetersiz bakiye vb. durumlarda false döner
            return false;
        }
    }
}