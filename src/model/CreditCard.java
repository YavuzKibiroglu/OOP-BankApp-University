package model;

import Managers.DataBaseManager;
import java.sql.SQLException;

public class CreditCard extends Card {

    private float creditLimit;
    private float currentDebt; // Güncel Borç

    public CreditCard(String cardNumber, String userId, String cvv, String expiryDate, float creditLimit, float currentDebt) {
        super(cardNumber, userId, cvv, expiryDate);
        this.creditLimit = creditLimit;
        this.currentDebt = currentDebt;
    }

    // Getter Metotları
    public float getCreditLimit() { return creditLimit; }
    public float getCurrentDebt() { return currentDebt; }

    // --- BORÇ ÖDEME METODU ---
    // Bu metot, parayı vadesiz hesaptan çeker ve borcu düşer.
    public void payDebt(CheckingAccount sourceAccount, float amountToPay) {
        try {
            // 1. Validasyonlar
            if (amountToPay <= 0) {
                System.out.println("Hata: Ödenecek tutar 0'dan büyük olmalı.");
                return;
            }
            if (amountToPay > this.currentDebt) {
                System.out.println("Hata: Mevcut borçtan (" + currentDebt + " TL) fazla ödeme yapamazsınız.");
                return;
            }

            // 2. Kaynak Hesapta Para Var mı?
            if (sourceAccount.getMoneyInAccount() < amountToPay) {
                System.out.println("Yetersiz Bakiye: Vadesiz hesabınızda bu kadar para yok.");
                return;
            }

            // 3. İŞLEM BAŞLIYOR (Transaction)

            // A) Vadesiz Hesaptan Parayı Düş
            float newAccountBalance = sourceAccount.getMoneyInAccount() - amountToPay;
            boolean accountUpdated = DataBaseManager.updateBalance(sourceAccount.getAccountId(), newAccountBalance);

            // B) Kredi Kartı Borcunu Düş
            float newDebt = this.currentDebt - amountToPay;
            // updateCardDebt metodunu DataBaseManager'da yazmıştık
            DataBaseManager.updateCardDebt(this.cardNumber, newDebt);

            if (accountUpdated) {
                // RAM'deki nesneleri güncelle (Program kapanmadan arayüz güncellensin diye)
                sourceAccount.setMoneyInAccount(newAccountBalance);
                this.currentDebt = newDebt;

                System.out.println("--------------------------------");
                System.out.println("BORÇ ÖDEME BAŞARILI!");
                System.out.println("Ödenen Tutar: " + amountToPay + " TL");
                System.out.println("Kalan Borç: " + this.currentDebt + " TL");
                System.out.println("Hesapta Kalan: " + sourceAccount.getMoneyInAccount() + " TL");
                System.out.println("--------------------------------");
            } else {
                System.out.println("Veritabanı hatası nedeniyle işlem tamamlanamadı.");
            }

        } catch (Exception e) {
            System.out.println("Borç Ödeme Hatası: " + e.getMessage());
        }
    }

    @Override
    public boolean spend(float amount) throws SQLException {
        // (Bu metodun içeriği önceki attığım koddakiyle aynı kalacak)
        // Harcama yapınca currentDebt artacak.
        float availableLimit = creditLimit - currentDebt;
        if (availableLimit >= amount) {
            this.currentDebt += amount;
            DataBaseManager.updateCardDebt(this.cardNumber, this.currentDebt);
            System.out.println("Kredi Kartı Harcaması Onaylandı. Yeni Borç: " + currentDebt);
            return true;
        } else {
            System.out.println("Yetersiz Limit!");
            return false;
        }
    }

    @Override
    public String getInformation() {
        return String.format("KREDİ KARTI | Limit: %.2f | Borç: %.2f | Kullanılabilir: %.2f",
                creditLimit, currentDebt, (creditLimit - currentDebt));
    }
}
