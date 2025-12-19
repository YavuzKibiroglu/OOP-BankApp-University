package model;

import Managers.DataBaseManager;
import java.sql.SQLException;

public class DebitCard extends Card {

    private String linkedAccountId; // Bağlı olduğu Vadesiz Hesap ID'si

    public DebitCard(String cardNumber, String userId, String cvv, String expiryDate, String linkedAccountId) {
        super(cardNumber, userId, cvv, expiryDate);
        this.linkedAccountId = linkedAccountId;
    }

    @Override
    public boolean spend(float amount) throws SQLException {
        // 1. Bağlı olduğu hesabı bul
        Account account = DataBaseManager.getAccountById(linkedAccountId);

        // 2. Hesap kontrolü
        if (account == null || !(account instanceof CheckingAccount)) {
            System.out.println("Hata: Bu karta bağlı geçerli bir vadesiz hesap bulunamadı.");
            return false;
        }

        CheckingAccount checkingAccount = (CheckingAccount) account;

        // 3. Bakiye Yeterli mi?
        if (checkingAccount.getMoneyInAccount() >= amount) {
            // 4. Parayı hesaptan düş (Karttan değil, hesaptan düşer)
            float newBalance = checkingAccount.getMoneyInAccount() - amount;

            // Veritabanını güncelle
            DataBaseManager.updateBalance(linkedAccountId, newBalance);

            // RAM'deki nesneyi güncelle
            checkingAccount.setMoneyInAccount(newBalance);

            System.out.println("Banka Kartı ile ödeme başarılı. Hesaptan düşülen: " + amount + " TL");
            return true;
        } else {
            System.out.println("Yetersiz Bakiye! Hesabınızda yeterli para yok.");
            return false;
        }
    }

    @Override
    public String getInformation() {
        return "BANKA KARTI | No: " + cardNumber + " | Bağlı Hesap: " + linkedAccountId;
    }
}
