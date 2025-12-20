
import Managers.DataBaseManager;
import java.sql.*;
import java.time.LocalDate;

public class TestVerisiOlustur {

    public static void main(String[] args) {
        // 1. Veritabanını Başlat (Tablolar yoksa oluşturur)
        DataBaseManager.start();

        System.out.println("--- TEST VERİLERİ OLUŞTURULUYOR ---");

        // 2. BİZİM KULLANICI (Zengin Müşteri)
        // Şifre: 123456
        String myId = DataBaseManager.addIndividualUser(
                "22222222222", "Test", "Kullanicisi", "000000",
                LocalDate.of(1990, 1, 1), "İstanbul", "5551112233"
        );

        // 3. ALICI KULLANICI (Para Göndereceğimiz Kişi)
        String otherId = DataBaseManager.addIndividualUser(
                "33333333333", "Ahmet", "Alıcı", "000000",
                LocalDate.of(1995, 5, 5), "Ankara", "5554445566"
        );

        // 4. BAKİYE AYARLAMA VE BİLGİ ALMA (SQL ile)
        String myIban = "", otherIban = "";

        try (Connection conn = DriverManager.getConnection(DataBaseManager.URL);
             Statement stmt = conn.createStatement()) {

            // A) Bizim Hesabı Bul ve Bakiye Yükle (50.000 TL)
            ResultSet rs1 = stmt.executeQuery("SELECT AccountId, Iban FROM Accounts WHERE BelongedUserId = '" + myId + "' AND AccountType = 'CHECKING' AND CurrencyType = 'TL'");
            if (rs1.next()) {
                String accId = rs1.getString("AccountId");
                myIban = rs1.getString("Iban");

                // Bakiyeyi 50.000 yap
                stmt.executeUpdate("UPDATE Accounts SET Money_In_Account = 50000.0 WHERE AccountId = '" + accId + "'");
            }

            // B) Alıcının IBAN'ını Bul
            ResultSet rs2 = stmt.executeQuery("SELECT Iban FROM Accounts WHERE BelongedUserId = '" + otherId + "' AND AccountType = 'CHECKING' AND CurrencyType = 'TL'");
            if (rs2.next()) {
                otherIban = rs2.getString("Iban");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\n✅ TEST ORTAMI HAZIR!");
        System.out.println("------------------------------------------------");
        System.out.println("GİRİŞ YAPACAĞIN MÜŞTERİ NO : " + myId);
        System.out.println("GİRİŞ ŞİFRESİ              : 123456");
        System.out.println("BAŞLANGIÇ BAKİYESİ         : 50.000 TL");
        System.out.println("------------------------------------------------");
        System.out.println("PARA GÖNDERECEĞİN IBAN     : " + otherIban);
        System.out.println("(Bu IBAN'ı kopyala, transferde kullanacaksın)");
        System.out.println("------------------------------------------------");
    }
}