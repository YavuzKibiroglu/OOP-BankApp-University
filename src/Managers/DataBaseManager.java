package Managers;
import java.sql.*;
import java.time.LocalDate;
import java.util.Random;

public class DataBaseManager {
    private static final String URL = "jdbc:sqlite:Bank.db";

    public static void start() {
        String sqlIndividualUsers = "CREATE TABLE IF NOT EXISTS Individual_Users ("+
                "UserId TEXT PRIMARY KEY, " +
                "TC_Kimlik TEXT UNIQUE, " + // TC benzersiz olmalı
                "name TEXT, " +
                "surname TEXT, " +
                "password TEXT, " +
                "Birth_Date TEXT, "+
                "City TEXT, "+
                "PhoneNumber TEXT)";

        String sqlEnterpriseUsers = "CREATE TABLE IF NOT EXISTS Enterprise_Users ("+
                "UserId TEXT PRIMARY KEY, " +
                "Enterprise_Name TEXT, " +
                "password TEXT, " +
                "Enterprise_Establishment TEXT, " +
                "Enterprise_HQ TEXT)";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlIndividualUsers);
            stmt.execute(sqlEnterpriseUsers);
            System.out.println("Database created and connected successfully.");
        } catch (SQLException e) {
            System.out.println("Start Error: " + e.getMessage());
        }
    }

    public static void addIndividualUser(String tc_Id, String name, String surname, String password, LocalDate birthDate, String city, String phoneNumber) {
        // Önce basit validasyonları yap, hata varsa veritabanını yorma
        if (!isValidPassword(password)) {
            System.out.println("Hata: Geçersiz şifre.");
            return;
        }
        // TC format kontrolü (Sadece rakam ve 11 hane mi?)
        if (!isTCFormatValid(tc_Id)) {
            System.out.println("Hata: Geçersiz TC Formatı.");
            return;
        }

        String sql = "INSERT INTO Individual_Users(UserId, TC_Kimlik, name, surname, password, Birth_Date, City, PhoneNumber) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Eşsiz ID bulana kadar dön
            String uniqueId;
            do {
                uniqueId = ProduceRandomID();
            } while (isIDExists(uniqueId)); // ID varsa döngü devam etsin

            stmt.setString(1, uniqueId);
            stmt.setString(2, tc_Id);
            stmt.setString(3, name);
            stmt.setString(4, surname);
            stmt.setString(5, password);
            stmt.setString(6, birthDate.toString());
            stmt.setString(7, city);
            stmt.setString(8, phoneNumber);

            stmt.executeUpdate();
            System.out.println("Bireysel kullanıcı eklendi. ID: " + uniqueId);

        } catch (SQLException e) {
            System.out.println("Kullanıcı Ekleme Hatası: " + e.getMessage());
        }
    }

    public static void addEnterpriseUser(String enterpriseName, String password, LocalDate enterpriseEstablishment, String enterpriseHQ) {
        if (!isValidPassword(password)) {
            System.out.println("Hata: Geçersiz şifre.");
            return;
        }

        String sql = "INSERT INTO Enterprise_Users(UserId, Enterprise_Name, password, Enterprise_Establishment, Enterprise_HQ) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String uniqueId;
            do {
                uniqueId = ProduceRandomID();
            } while (isIDExists(uniqueId));

            stmt.setString(1, uniqueId);
            stmt.setString(2, enterpriseName);
            stmt.setString(3, password);
            stmt.setString(4, enterpriseEstablishment.toString());
            stmt.setString(5, enterpriseHQ);

            stmt.executeUpdate(); // KRİTİK EKSİK
            System.out.println("Kurumsal kullanıcı eklendi. ID: " + uniqueId);

        } catch (SQLException e) {
            System.out.println("Kurumsal Ekleme Hatası: " + e.getMessage());
        }
    }

    // İki tabloyu aynı anda kontrol eder (SQL UNION)
    private static boolean isIDExists(String tempID) {
        // İki sorguyu birleştiriyoruz
        String sql = "SELECT UserId FROM Individual_Users WHERE UserId = ? " +
                "UNION " +
                "SELECT UserId FROM Enterprise_Users WHERE UserId = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // UNION kullandığımız için iki soru işareti (?) var, ikisine de aynı ID'yi veriyoruz
            pstmt.setString(1, tempID);
            pstmt.setString(2, tempID);

            ResultSet rs = pstmt.executeQuery();

            // Eğer herhangi bir tablodan sonuç dönerse, bu ID kullanılıyor demektir.
            return rs.next();

        } catch (SQLException e) {
            System.out.println("ID Kontrol Hatası: " + e.getMessage());
            return false; // Hata durumunda false dönerek sonsuz döngüyü engelleriz
        }
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 6) return false;
        for (char c : password.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // Benzersizlik kontrolünü veritabanı (UNIQUE constraint) yapmalı veya catch bloğunda yakalanmalı.
    private static boolean isTCFormatValid(String tc) {
        return tc.length() == 11 && tc.matches("\\d+");
    }

    private static String ProduceRandomID() {
        Random rnd = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            id.append(rnd.nextInt(10));
        }
        return id.toString();
    }
}
