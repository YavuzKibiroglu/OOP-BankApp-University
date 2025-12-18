package model;

import Managers.DataBaseManager;
import java.sql.SQLException;

public class CheckingAccount extends Account {

    private final String ibanNumber; // Vadesiz hesaba özel alan

    public CheckingAccount(String userId, String accountId, String ibanNumber, float moneyInAccount) {
        super(userId, accountId, moneyInAccount); // Abstract sınıfın constructor'ı
        this.ibanNumber = ibanNumber;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    @Override
    public String getInformation() {
        return String.format("Vadesiz Hesap | IBAN: %s | Bakiye: %.2f TL", ibanNumber, moneyInAccount);
    }

    // Para Ekleme Metodu (Hem RAM hem Veritabanı)
    public void addMoneyToAccount(float moneyToAdd) {
        this.moneyInAccount += moneyToAdd;
        // Veritabanını güncelle
        DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);
    }

    // --- BAŞKASINA PARA TRANSFERİ (IBAN İLE) ---
    // Senaryo: Arkadaşına para yolluyorsun.
    public void transferMoneyToOtherAccount(String targetIban, float amountToSend) {
        // 1. Bakiye Yeterli mi?
        if (this.moneyInAccount < amountToSend) {
            System.out.println("Yetersiz Bakiye! İşlem iptal edildi.");
            return;
        }

        try {
            // 2. IBAN'dan Karşı Tarafın ID'sini bul (Manager Metodu)
            String targetAccountId = DataBaseManager.getAccountIdByIBAN(targetIban);

            if (targetAccountId == null) {
                System.out.println("Hata: Bu IBAN'a ait hesap bulunamadı.");
                return;
            }

            // 3. Karşı Hesabı Getir
            Account receiverAccount = DataBaseManager.getAccountById(targetAccountId);

            // 4. Transfer İşlemi
            if (receiverAccount != null) {
                // A) Benden Düş
                this.moneyInAccount -= amountToSend;
                DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);

                // B) Karşı Tarafa Ekle
                // Karşı taraf Vadesiz Hesap ise:
                if (receiverAccount instanceof CheckingAccount) {
                    ((CheckingAccount) receiverAccount).addMoneyToAccount(amountToSend);
                    System.out.println("Transfer Başarılı: " + amountToSend + " TL gönderildi.");
                } else {
                    // Karşı taraf Vadeli ise para gönderilemez, iade et.
                    System.out.println("Hata: Vadeli hesaba doğrudan para gönderilemez.");
                    this.addMoneyToAccount(amountToSend); // İade
                }
            }

        } catch (SQLException e) {
            System.out.println("Transfer sırasında veritabanı hatası: " + e.getMessage());
        }
    }

    // Interface'den gelen metot (Genelde sistem tarafından çağrılır)
    @Override
    public void transferToCurrent(float moneyAmount, String accountId) throws SQLException {
        addMoneyToAccount(moneyAmount);
    }

    @Override
    public void transferToCurrent(float moneyAmount) throws SQLException {
        addMoneyToAccount(moneyAmount);
    }
}
