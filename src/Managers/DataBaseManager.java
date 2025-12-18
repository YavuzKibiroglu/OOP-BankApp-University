package Managers;

import model.Account;
import model.AccountType;
import model.CheckingAccount;
import model.DepositAccount; // DepositAccount import edildi

import java.sql.*;
import java.time.LocalDate;
import java.util.Random;

public class DataBaseManager {
    public static final String URL = "jdbc:sqlite:Bank.db";

    public static void start() {
        String sqlIndividualUsers = "CREATE TABLE IF NOT EXISTS Individual_Users ("+
                "UserId TEXT PRIMARY KEY, " +
                "TC_Kimlik TEXT UNIQUE, " +
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

        // GÜNCELLEME: Accounts tablosuna CreationDate ve DepositDays eklendi
        // Checking hesaplar için bu alanlar NULL kalabilir.
        String sqlAccounts = "CREATE TABLE IF NOT EXISTS Accounts (" +
                "BelongedUserId TEXT, " +
                "AccountId TEXT PRIMARY KEY, " +
                "Iban TEXT UNIQUE, " +
                "Money_In_Account REAL, " +
                "AccountType TEXT, " +
                "CreationDate TEXT, " +
                "DepositDays INTEGER, " +
                "CurrencyType TEXT)";  // YENİ: Vade günü (Sadece vadeli için)

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlIndividualUsers);
            stmt.execute(sqlEnterpriseUsers);
            stmt.execute(sqlAccounts);
            System.out.println("Database created and connected successfully.");
        } catch (SQLException e) {
            System.out.println("Start Error: " + e.getMessage());
        }
    }

    //region User Logic
    public static void addIndividualUser(String tc_Id, String name, String surname, String password, LocalDate birthDate, String city, String phoneNumber) {
        if (!isValidPassword(password)) {
            System.out.println("Hata: Geçersiz şifre.");
            return;
        }
        if (!isTCFormatValid(tc_Id)) {
            System.out.println("Hata: Geçersiz TC Formatı.");
            return;
        }

        String sql = "INSERT INTO Individual_Users(UserId, TC_Kimlik, name, surname, password, Birth_Date, City, PhoneNumber) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String uniqueId;
            do {
                uniqueId = ProduceRandomID();
            } while (isIDExists(uniqueId));

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

            stmt.executeUpdate();
            System.out.println("Kurumsal kullanıcı eklendi. ID: " + uniqueId);

        } catch (SQLException e) {
            System.out.println("Kurumsal Ekleme Hatası: " + e.getMessage());
        }
    }

    private static boolean isIDExists(String tempID) {
        String sql = "SELECT UserId FROM Individual_Users WHERE UserId = ? UNION SELECT UserId FROM Enterprise_Users WHERE UserId = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tempID);
            pstmt.setString(2, tempID);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 6) return false;
        for (char c : password.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

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
    //endregion

    //region Account Logic & Updates

    // 1. UPDATE METODU (Bakiye Güncelleme)
    public static boolean updateBalance(String accountId, float newBalance) {
        String sql = "UPDATE Accounts SET Money_In_Account = ? WHERE AccountId = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setFloat(1, newBalance);
            pstmt.setString(2, accountId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Bakiye Güncelleme Hatası: " + e.getMessage());
            return false;
        }
    }

    //region Account Checks
    // 1. Genel Hesap Kontrolü (Vadesiz ve Vadeli için)
    public static boolean hasAccountType(String userId, String accountType) {
        String sql = "SELECT 1 FROM Accounts WHERE BelongedUserId = ? AND AccountType = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, accountType);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // Eğer kayıt varsa TRUE döner (Yani hesabı zaten var)

        } catch (SQLException e) {
            return false;
        }
    }

    // 2. Döviz Hesabı Kontrolü (Döviz türüne özel kontrol)
    // Kullanıcının Dolar'ı varsa yeni Dolar açamasın ama Euro açabilsin diye.
    public static boolean hasCurrencyAccount(String userId, String currencyType) {
        String sql = "SELECT 1 FROM Accounts WHERE BelongedUserId = ? AND CurrencyType = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, currencyType);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            return false;
        }
    }
    //endregion

    // 2. STANDART HESAP EKLEME (Vadesiz / Checking)
    public static void addAccount(String belongedUserId, String accountId, String ibanNumber, float moneyInAccount, AccountType accountType) throws SQLException {

        // --- KISITLAMA BURADA KALIYOR ---
        // Eğer Vadesiz (Checking) hesapsa ve zaten varsa izin verme!
        if (accountType == AccountType.Checking && hasAccountType(belongedUserId, "Checking")) {
            System.out.println("UYARI: Zaten bir Vadesiz Hesabınız var. İkinciyi açamazsınız.");
            return; // İşlemi iptal et
        }
        // -------------------------------

        // Vadesiz hesap aslında "Vadesi 0 olan" bir hesaptır, o yüzden addDepositAccount metodunu çağırabiliriz
        // (Ama oradaki kısıtlamayı kaldırdığımız için yukarıdaki IF bloğu bizi koruyacak)
        addDepositAccount(belongedUserId, accountId, ibanNumber, moneyInAccount, accountType, 0, null);
    }

    // 3. VADELİ HESAP EKLEME (Deposit - Overloaded)
    // Bu metod hem checking hem deposit ekleyebilir, alttaki SQL ona göre ayarlandı.
    public static void addDepositAccount(String belongedUserId, String accountId, String ibanNumber, float moneyInAccount, AccountType accountType, int depositDays, LocalDate creationDate) throws SQLException {

        String sql = "INSERT INTO Accounts (BelongedUserId, AccountId, Iban, Money_In_Account, AccountType, DepositDays, CreationDate) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, belongedUserId);
            stmt.setString(2, accountId);

            if (accountType == AccountType.Checking) {
                stmt.setString(3, ibanNumber);
            } else {
                stmt.setString(3, null); // Vadeli hesaplarda IBAN hücresi boş (NULL) kalır
            }

            stmt.setFloat(4, moneyInAccount);
            stmt.setString(5, accountType.toString());

            // Eğer Vadesiz hesapsa bu değerler veritabanına NULL veya 0 olarak gider
            stmt.setInt(6, depositDays);
            if (creationDate != null) {
                stmt.setString(7, creationDate.toString());
            } else {
                stmt.setString(7, null);
            }

            stmt.executeUpdate();
            System.out.println("Hesap başarıyla eklendi (" + accountType + "): " + ibanNumber);

        } catch (SQLException e) {
            System.out.println("Hesap eklenirken hata oluştu: " + e.getMessage());
            throw e;
        }
    }

    //DÖVİZ HESABI EKLEME
    public static void addForeignCurrencyAccount(String belongedUserId, String accountId, float moneyInAccount, String currencyType) throws SQLException {

        if (hasCurrencyAccount(belongedUserId, currencyType)) {
            System.out.println("UYARI: Zaten bir " + currencyType + " hesabınız mevcut.");
            return;
        }

        String sql = "INSERT INTO Accounts (BelongedUserId, AccountId, Money_In_Account, AccountType, CurrencyType) VALUES(?, ?, ?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, belongedUserId);
            stmt.setString(2, accountId);
            stmt.setFloat(3, moneyInAccount);
            stmt.setString(4, "Foreign"); // Tip olarak 'Foreign' kullanıyoruz
            stmt.setString(5, currencyType); // "USD", "EUR" vs.

            stmt.executeUpdate();
            System.out.println("Döviz Hesabı Açıldı (" + currencyType + "): " + accountId);
        } catch (SQLException e) {
            System.out.println("Döviz Hesabı Hatası: " + e.getMessage());
            throw e;
        }
    }

    public static String getUniqueAccountId() {
        String id = "";
        do {
            id = getRandomAccountId();
        } while (isAccountIdExists(id));
        return id;
    }

    public static String getRandomAccountId() {
        Random rnd = new Random();
        StringBuilder id = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            id.append(rnd.nextInt(10));
        }
        return id.toString();
    }

    public static boolean isAccountIdExists(String tempId) {
        String sql = "SELECT AccountId FROM Accounts WHERE AccountId = ?";
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,tempId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e){
            return false;
        }
    }

    // 4. HESAP GETİRME (Deposit Entegrasyonu)
    public static Account getAccountById(String id) throws SQLException {
        String sql = "SELECT * FROM Accounts WHERE AccountId = ?";

        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                String userId = rs.getString("BelongedUserId");
                String accountTypeStr = rs.getString("AccountType");
                float moneyInAccount = rs.getFloat("Money_In_Account");
                String ibanNumber = rs.getString("Iban"); // IBAN'ı buradan alıyoruz

                // AccountType enum veya string kontrolü
                if (accountTypeStr.equalsIgnoreCase("Checking") || accountTypeStr.equals("VADESIZ")) {
                    return new CheckingAccount(userId, id, ibanNumber, moneyInAccount);
                }
                else if (accountTypeStr.equalsIgnoreCase("Deposit") || accountTypeStr.equals("VADELI")) {
                    // Vadeli hesap için ek verileri çek
                    int depositDays = rs.getInt("DepositDays");
                    String dateStr = rs.getString("CreationDate");
                    LocalDate creationDate = (dateStr != null) ? LocalDate.parse(dateStr) : LocalDate.now();

                    return new DepositAccount(userId, id, moneyInAccount, depositDays, creationDate);
                }

                else if (accountTypeStr.equalsIgnoreCase("Foreign") || accountTypeStr.equals("DOVIZ")) {
                    String currencyType = rs.getString("CurrencyType");
                    // Döviz hesabını döndür
                    return new model.ForeignCurrencyAccount(userId, id, moneyInAccount, currencyType);
                }
            }
        } catch (SQLException e) {
            System.out.println("Hesap Bulma Hatası: " + e.getMessage());
            throw e;
        }
        return null;
    }

    //region IBAN Logic
    public static String getUniqueIBAN() throws SQLException {
        String iban = "";
        do {
            iban = getRandomIBANString();
        } while(isIBANExists(iban));
        return iban;
    }

    private static String getRandomIBANString() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("TR");
        for(int i = 0; i < 24; i++) {
            sb.append(rnd.nextInt(10));
        }
        return sb.toString();
    }

    private static boolean isIBANExists(String iban) {
        String sql = "SELECT 1 FROM Accounts WHERE IBAN = ?";
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, iban);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e){
            return false;
        }
    }

    // IBAN verip, o IBAN'a sahip olan hesabın ID'sini bulur.
    public static String getAccountIdByIBAN(String iban) {
        String sql = "SELECT AccountId FROM Accounts WHERE Iban = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, iban);
            ResultSet rs = pstmt.executeQuery();

            // Eğer bir kayıt bulunursa ID'yi döndür
            if (rs.next()) {
                return rs.getString("AccountId");
            }

        } catch (SQLException e) {
            System.out.println("IBAN ile Hesap Bulma Hatası: " + e.getMessage());
            return null;
        }

        // Kayıt bulunamazsa null döner
        return null;
    }
    //endregion
    //endregion
}
