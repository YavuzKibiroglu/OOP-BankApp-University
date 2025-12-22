package Managers;

import model.Account;
import model.AccountType;
import model.CheckingAccount;
import model.DepositAccount;

import java.sql.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.ArrayList;

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
                "Enterprise_HQ TEXT, " +
                "Corporate_Code TEXT UNIQUE)";

        String sqlAccounts = "CREATE TABLE IF NOT EXISTS Accounts (" +
                "BelongedUserId TEXT, " +
                "AccountId TEXT PRIMARY KEY, " +
                "Iban TEXT UNIQUE, " +
                "Money_In_Account REAL, " +
                "AccountType TEXT, " +
                "CreationDate TEXT, " +
                "DepositDays INTEGER, " +
                "CurrencyType TEXT, " +
                "AccountName TEXT)";

        String sqlCards = "CREATE TABLE IF NOT EXISTS Cards (" +
                "CardNumber TEXT PRIMARY KEY, " +
                "UserId TEXT, " +
                "CardType TEXT, " +
                "CVV TEXT, " +
                "ExpiryDate TEXT, " +
                "LinkedAccountId TEXT, " +
                "CreditLimit REAL, " +
                "CurrentDebt REAL)";

        String sqlSubscriptions = "CREATE TABLE IF NOT EXISTS Subscriptions (" +
                "SubscriptionId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "SubscriberUserId TEXT, " +
                "SubscriberTC TEXT, " +
                "SubscriberName TEXT, " +
                "SubscriberSurname TEXT, " +
                "CompanyUserId TEXT, " +
                "ServiceName TEXT, " +
                "IsActive INTEGER, " +
                "BillingDay INTEGER, " +
                "FixedAmount REAL, " +
                "StartDate TEXT)";

        String sqlInvoices = "CREATE TABLE IF NOT EXISTS Invoices (" +
                "InvoiceId TEXT PRIMARY KEY, " +
                "SubscriptionId TEXT, " +
                "Amount REAL, " +
                "DueDate TEXT, " +
                "IsPaid INTEGER)";


        CurrencyManager.start();
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlIndividualUsers);
            stmt.execute(sqlEnterpriseUsers);
            stmt.execute(sqlAccounts);
            stmt.execute(sqlCards);
            stmt.execute(sqlSubscriptions);
            stmt.execute(sqlInvoices);
            System.out.println("Database created and connected successfully.");
        } catch (SQLException e) {
            System.out.println("Start Error: " + e.getMessage());
        }
    }

    //region User Logic
    public static String addIndividualUser(String tc_Id, String name, String surname, String password, java.time.LocalDate birthDate, String city, String phoneNumber) {

        if (!isValidPassword(password)) {
            System.out.println("Hata: Geçersiz şifre.");
            return null;
        }
        if (!isTCFormatValid(tc_Id)) {
            System.out.println("Hata: Geçersiz TC Formatı.");
            return null;
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

            createWelcomePackage(uniqueId);
            return uniqueId;

        } catch (SQLException e) {
            System.out.println("Kullanıcı Ekleme Hatası: " + e.getMessage());
            return null;
        }
    }

    public static String addEnterpriseUser(String enterpriseName, String password, LocalDate enterpriseEstablishment, String enterpriseHQ) {

        // Şifre kontrolü
        if (!isValidPassword(password)) {
            System.out.println("Hata: Geçersiz şifre.");
            return null;
        }

        String sql = "INSERT INTO Enterprise_Users(UserId, Enterprise_Name, password, Enterprise_Establishment, Enterprise_HQ, Corporate_Code) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String uniqueId;
            do {
                uniqueId = ProduceRandomID();
            } while (isIDExists(uniqueId));

            String uniqueCorpCode;
            do {
                uniqueCorpCode = generateCorporateCode();
            } while (isCorporateCodeExists(uniqueCorpCode));

            stmt.setString(1, uniqueId);
            stmt.setString(2, enterpriseName);
            stmt.setString(3, password);
            stmt.setString(4, enterpriseEstablishment.toString());
            stmt.setString(5, enterpriseHQ);
            stmt.setString(6, uniqueCorpCode);

            stmt.executeUpdate();

            createAccountRaw(uniqueId, "TL", 0.0);
            System.out.println("Kurumsal kullanıcı eklendi. ID: " + uniqueId);
            return uniqueCorpCode;

        } catch (SQLException e) {
            System.out.println("Kurumsal Ekleme Hatası: " + e.getMessage());
            return null;
        }
    }

    //12 Haneli Kod Üretici
    private static String generateCorporateCode() {
        Random rnd = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            code.append(rnd.nextInt(10)); // 0-9 arası rakam ekle
        }
        return code.toString();
    }

    //Kurum Kodu Veritabanında Var mı Kontrolü
    private static boolean isCorporateCodeExists(String code) {
        String sql = "SELECT 1 FROM Enterprise_Users WHERE Corporate_Code = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
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

    //Genel Hesap Kontrolü (Vadesiz ve Vadeli için)
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

    //Döviz Hesabı Kontrolü (Döviz türüne özel kontrol)
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

    //HESAP GETİRME (Deposit Entegrasyonu)
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

    public static void addDebitCard(String userId, String linkedAccountId) {
        String cardNo = getRandomCardNumber();
        String sql = "INSERT INTO Cards(CardNumber, UserId, CardType, CVV, ExpiryDate, LinkedAccountId) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cardNo);
            pstmt.setString(2, userId);
            pstmt.setString(3, "DEBIT");
            pstmt.setString(4, String.valueOf(new Random().nextInt(900)+100)); // Random CVV
            pstmt.setString(5, "12/30");
            pstmt.setString(6, linkedAccountId);
            pstmt.executeUpdate();
            System.out.println("Banka Kartı Oluşturuldu: " + cardNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCreditCard(String userId, float limit) {
        String cardNo = getRandomCardNumber();
        String sql = "INSERT INTO Cards(CardNumber, UserId, CardType, CVV, ExpiryDate, CreditLimit, CurrentDebt) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cardNo);
            pstmt.setString(2, userId);
            pstmt.setString(3, "CREDIT");
            pstmt.setString(4, String.valueOf(new Random().nextInt(900)+100));
            pstmt.setString(5, "12/30");
            pstmt.setFloat(6, limit);
            pstmt.setFloat(7, 0);
            pstmt.executeUpdate();
            System.out.println("Kredi Kartı Oluşturuldu: " + cardNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //KREDİ KARTI ÇEKME (Cards tablosundan)
    public static model.CreditCard getCreditCardObject(String userId) {
        // Kartı bulmak için: UserId ve Tip = 'CREDIT' kontrolü yapıyoruz
        String sql = "SELECT * FROM Cards WHERE UserId = ? AND CardType = 'CREDIT'";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            java.sql.ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new model.CreditCard(
                        rs.getString("CardNumber"),
                        userId,
                        rs.getString("CVV"),        // Sütun adı: CVV
                        rs.getString("ExpiryDate"), // Sütun adı: ExpiryDate
                        rs.getFloat("CreditLimit"),
                        rs.getFloat("CurrentDebt")
                );
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //KREDİ KARTI BORÇ GÜNCELLEME (Cards tablosunu günceller)
    public static boolean updateCardDebt(String cardNumber, float newDebt) {
        // Tablo adı: Cards
        String sql = "UPDATE Cards SET CurrentDebt = ? WHERE CardNumber = ?";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setFloat(1, newDebt);
            pstmt.setString(2, cardNumber);
            return pstmt.executeUpdate() > 0;

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Random Kart No
    private static String getRandomCardNumber() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder("4543"); // Visa başlangıç
        for(int i=0; i<12; i++) sb.append(rnd.nextInt(10));
        return sb.toString();
    }

    //ABONELİK OLUŞTURMA (Tarih TimeManager'dan gelir)
    public static void createSubscription(String subscriberId, String companyId, String serviceName) {
        String subId = ProduceRandomID();
        String sql = "INSERT INTO Subscriptions(SubscriptionId, SubscriberUserId, CompanyUserId, ServiceName, IsActive, StartDate) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, subId);
            pstmt.setString(2, subscriberId);
            pstmt.setString(3, companyId);
            pstmt.setString(4, serviceName);
            pstmt.setInt(5, 1); // Aktif
            // KRİTİK NOKTA: TimeManager kullanıyoruz
            pstmt.setString(6, TimeManager.getCurrentDate().toString());

            pstmt.executeUpdate();
            System.out.println("Abonelik Başladı: " + serviceName + " | Tarih: " + TimeManager.getCurrentDate());

        } catch (SQLException e) {
            System.out.println("Abonelik Hatası: " + e.getMessage());
        }
    }

    //OTOMATİK FATURA KESME SİMÜLASYON
    public static void generateMonthlyInvoices() {
        LocalDate simulationDate = TimeManager.getCurrentDate();

        // Mantık: Abonelik tarihi bugünle aynı gün ise (örn: her ayın 15'i) fatura kes.
        // Basitlik için: Eğer bugün fatura kesilmemişse kes (SQL kontrolü gerekir ama şimdilik manuel tetikleme varsayıyoruz)

        // Örnek Senaryo: Tüm aktif aboneliklere bu ayki faturayı kes
        String sqlSelect = "SELECT * FROM Subscriptions WHERE IsActive = 1";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlSelect)) {

            while(rs.next()) {
                String subId = rs.getString("SubscriptionId");
                // Random Tutar (Elektrik, Su gibi) veya Sabit Tutar
                float amount = (float)(Math.random() * 500) + 100;

                // Fatura oluştur (Vade tarihi: Simülasyon tarihi + 30 gün)
                createInvoice(subId, amount, simulationDate.plusDays(30));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fatura Kaydetme (Yardımcı Metot)
    private static void createInvoice(String subId, float amount, LocalDate dueDate) {
        String invId = ProduceRandomID();
        String sql = "INSERT INTO Invoices(InvoiceId, SubscriptionId, Amount, DueDate, IsPaid) VALUES(?,?,?,?,?)";

        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, invId);
            pstmt.setString(2, subId);
            pstmt.setFloat(3, amount);
            pstmt.setString(4, dueDate.toString());
            pstmt.setInt(5, 0); // Ödenmedi

            pstmt.executeUpdate();
            System.out.println("Otomatik Fatura Kesildi (ID: "+invId+") Tutar: " + amount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ZAMAN ATLAYINCA BORÇLU HİZMETLERİ KESME
    public static void checkOverdueAndCutServices() {
        LocalDate simulationDate = TimeManager.getCurrentDate();

        // Vadesi geçmiş (DueDate < SimülasyonTarihi) ve Ödenmemiş (IsPaid=0) faturaları bul
        String sql = "SELECT SubscriptionId FROM Invoices WHERE IsPaid = 0 AND DueDate < ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, simulationDate.toString());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String subId = rs.getString("SubscriptionId");
                // Hizmeti Kes
                cutService(subId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hizmet Kesme Update Sorgusu
    private static void cutService(String subId) {
        String sql = "UPDATE Subscriptions SET IsActive = 0 WHERE SubscriptionId = ?";
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, subId);
            pstmt.executeUpdate();
            System.out.println("UYARI: Abonelik hizmeti borç nedeniyle durduruldu! SubID: " + subId);
        } catch(SQLException e){ e.printStackTrace(); }
    }

    //ID ile Fatura Bulma Metodu
    public static model.Invoice getInvoiceById(String invoiceId) {
        String sql = "SELECT * FROM Invoices WHERE InvoiceId = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, invoiceId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String subId = rs.getString("SubscriptionId");
                float amount = rs.getFloat("Amount");
                String dateStr = rs.getString("DueDate");
                int isPaidInt = rs.getInt("IsPaid");

                LocalDate dueDate = (dateStr != null) ? LocalDate.parse(dateStr) : null;

                boolean isPaid = (isPaidInt == 1);

                return new model.Invoice(invoiceId, subId, amount, dueDate, isPaid);
            }

        } catch (SQLException e) {
            System.out.println("Fatura Bulma Hatası: " + e.getMessage());
        }

        return null;
    }

    //Faturayı Ödendi yapma ve Hizmeti Tekrar Açma
    public static void markInvoiceAsPaidAndActivateService(String invoiceId) {
        // 1. Önce faturanın kime ait olduğunu bulalım (SubscriptionId lazım)
        model.Invoice inv = getInvoiceById(invoiceId);
        if (inv == null) return;

        String sqlPay = "UPDATE Invoices SET IsPaid = 1 WHERE InvoiceId = ?";
        String sqlActivate = "UPDATE Subscriptions SET IsActive = 1 WHERE SubscriptionId = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmtPay = conn.prepareStatement(sqlPay);
             PreparedStatement pstmtActivate = conn.prepareStatement(sqlActivate)) {

            pstmtPay.setString(1, invoiceId);
            pstmtPay.executeUpdate();

            pstmtActivate.setString(1, inv.getSubscriptionId());
            pstmtActivate.executeUpdate();

            System.out.println("Sistem: Fatura kapatıldı ve hizmet aktif edildi.");

        } catch (SQLException e) {
            System.out.println("Fatura Güncelleme Hatası: " + e.getMessage());
        }
    }

    public static model.IndividualUser getIndividualUserByLogin(String input, String password, String loginType) {
        String sql = "";

        switch (loginType) {
            case "TC":
                sql = "SELECT * FROM Individual_Users WHERE TC_Kimlik = ? AND password = ?";
                break;
            case "MUSTERI_NO":
                sql = "SELECT * FROM Individual_Users WHERE UserId = ? AND password = ?";
                break;
            case "TELEFON":
                sql = "SELECT * FROM Individual_Users WHERE PhoneNumber = ? AND password = ?";
                break;
            default:
                return null;
        }

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, input);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Kullanıcı bulundu, nesneyi oluşturup döndür
                String userId = rs.getString("UserId");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String dbPassword = rs.getString("password");
                String tc = rs.getString("TC_Kimlik");
                String city = rs.getString("City");
                String phone = rs.getString("PhoneNumber");

                String dateStr = rs.getString("Birth_Date");
                LocalDate birthDate = (dateStr != null) ? LocalDate.parse(dateStr) : LocalDate.now();

                return new model.IndividualUser(userId, name, surname, dbPassword, tc, birthDate, city, phone);
            }

        } catch (SQLException e) {
            System.out.println("Login Hatası: " + e.getMessage());
        }
        return null;
    }

    public static model.EnterpriseUser getEnterpriseUserByLogin(String corporateCode, String password) {
        // Kurum Kodu ve Şifre kontrolü yapıyoruz
        String sql = "SELECT * FROM Enterprise_Users WHERE Corporate_Code = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, corporateCode);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String userId = rs.getString("UserId");
                String name = rs.getString("Enterprise_Name");
                String dbPass = rs.getString("password");
                String hq = rs.getString("Enterprise_HQ");
                String code = rs.getString("Corporate_Code");

                String dateStr = rs.getString("Enterprise_Establishment");
                LocalDate estDate = (dateStr != null) ? LocalDate.parse(dateStr) : LocalDate.now();

                return new model.EnterpriseUser(userId, name, dbPass, estDate, hq, code);
            }

        } catch (SQLException e) {
            System.out.println("Kurumsal Login Hatası: " + e.getMessage());
        }
        return null;
    }

//YARDIMCI ARAÇLAR (Rastgele Numara Üreticiler)
    // Rastgele TR ile başlayan IBAN üretir
    private static String generateIBAN() {
        java.util.Random rand = new java.util.Random();
        StringBuilder iban = new StringBuilder("TR");
        for (int i = 0; i < 24; i++) {
            iban.append(rand.nextInt(10));
        }
        return iban.toString();
    }

    // Rastgele 16 haneli Kart Numarası üretir (4 ile başlar)
    private static String generateCardNumber() {
        java.util.Random rand = new java.util.Random();
        StringBuilder cardNo = new StringBuilder("4");
        for (int i = 0; i < 15; i++) {
            cardNo.append(rand.nextInt(10));
        }
        return cardNo.toString();
    }

    // 3 haneli CVV kodu üretir
    private static String generateCVV() {
        int cvv = new java.util.Random().nextInt(900) + 100;
        return String.valueOf(cvv);
    }

    // Kart Son Kullanma Tarihi (Bugünden 5 yıl sonrası)
    private static String generateExpiryDate() {
        java.time.LocalDate futureDate = java.time.LocalDate.now().plusYears(5);
        return futureDate.getMonthValue() + "/" + futureDate.getYear();
    }

    //OTOMATİK HESAP VE KART OLUŞTURUCU
    private static void createWelcomePackage(String userId) {
        // Hesaplar tablosuna ekleme komutu
        String sqlAccount = "INSERT INTO Accounts(BelongedUserId, AccountId, Iban, Money_In_Account, AccountType, CreationDate, CurrencyType) VALUES(?,?,?,?,?,?,?)";
        // Kartlar tablosuna ekleme komutu
        String sqlCard = "INSERT INTO Cards(CardNumber, UserId, CardType, CVV, ExpiryDate, LinkedAccountId, CreditLimit, CurrentDebt) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL)) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtAccount = conn.prepareStatement(sqlAccount);
                 PreparedStatement pstmtCard = conn.prepareStatement(sqlCard)) {

                //VADESİZ TL HESABI
                String vadesizAccountId = String.valueOf(new java.util.Random().nextInt(900000) + 100000);
                String vadesizIban = generateIBAN();

                pstmtAccount.setString(1, userId);
                pstmtAccount.setString(2, vadesizAccountId);
                pstmtAccount.setString(3, vadesizIban);
                pstmtAccount.setDouble(4, 0.0);        // Bakiye 0
                pstmtAccount.setString(5, "CHECKING");  // Hesap Türü: Vadesiz
                pstmtAccount.setString(6, TimeManager.getCurrentDate().toString());
                pstmtAccount.setString(7, "TL");
                pstmtAccount.executeUpdate();

                //DÖVİZ HESAPLARI (DOLAR, EURO, ALTIN)
                String[] dovizTurleri = {"USD", "EUR", "ALTIN"};

                for (String doviz : dovizTurleri) {
                    String dovizAccountId = String.valueOf(new java.util.Random().nextInt(900000) + 100000);
                    String dovizIban = generateIBAN();

                    pstmtAccount.setString(1, userId);
                    pstmtAccount.setString(2, dovizAccountId);
                    pstmtAccount.setString(3, dovizIban);
                    pstmtAccount.setDouble(4, 0.0);
                    pstmtAccount.setString(5, "FOREIGN"); // Hesap Türü: Döviz
                    pstmtAccount.setString(6, java.time.LocalDate.now().toString());
                    pstmtAccount.setString(7, doviz);
                    pstmtAccount.executeUpdate();
                }

                //BANKA KARTI (DEBIT) -> Vadesiz TL Hesabına Bağlı
                pstmtCard.setString(1, generateCardNumber());
                pstmtCard.setString(2, userId);
                pstmtCard.setString(3, "DEBIT");
                pstmtCard.setString(4, generateCVV());
                pstmtCard.setString(5, generateExpiryDate());
                pstmtCard.setString(6, vadesizAccountId); // <-- Bağlantı burada!
                pstmtCard.setDouble(7, 0.0); // Limiti yok
                pstmtCard.setDouble(8, 0.0); // Borcu yok
                pstmtCard.executeUpdate();

                //KREDİ KARTI (CREDIT) -> 20.000 TL Limitli
                pstmtCard.setString(1, generateCardNumber());
                pstmtCard.setString(2, userId);
                pstmtCard.setString(3, "CREDIT");
                pstmtCard.setString(4, generateCVV());
                pstmtCard.setString(5, generateExpiryDate());
                pstmtCard.setString(6, null);    // Hesaba bağlı değil
                pstmtCard.setDouble(7, 20000.0); // LİMİT: 20.000 TL
                pstmtCard.setDouble(8, 0.0);     // Borç: 0 TL
                pstmtCard.executeUpdate();

                conn.commit(); // Hepsini kaydet
                System.out.println("Hoş geldin paketi (Hesaplar ve Kartlar) başarıyla oluşturuldu.");

            } catch (SQLException e) {
                conn.rollback(); // Hata varsa işlemleri geri al
                System.out.println("Hoş geldin paketi hatası: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }
    public static double getVadesizTLBakiye(String userId) {
        double bakiye = 0.0;
        String sql = "SELECT Money_In_Account FROM Accounts WHERE BelongedUserId = ? AND AccountType = 'CHECKING' AND CurrencyType = 'TL'";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) bakiye = rs.getDouble("Money_In_Account");
        } catch (SQLException e) { e.printStackTrace(); }
        return bakiye;
    }

    //KREDİ KARTI BİLGİSİ SORGULA
    public static double[] getCreditCardInfo(String userId) {
        double[] kartBilgisi = {0.0, 0.0}; // [0]: Limit, [1]: Borç

        String sql = "SELECT CreditLimit, CurrentDebt FROM Cards WHERE UserId = ? AND CardType = 'CREDIT'";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                kartBilgisi[0] = rs.getDouble("CreditLimit");
                kartBilgisi[1] = rs.getDouble("CurrentDebt");
            }
        } catch (SQLException e) {
            System.out.println("Kart Bilgisi Hatası: " + e.getMessage());
        }
        return kartBilgisi;
    }

    //HESAP DETAYI GETİR (Bakiye ve IBAN)
    public static String[] getAccountDetails(String userId, String currencyType) {
        String[] details = {"0.0", "TR..."}; // Varsayılan değerler

        String sql = "SELECT Money_In_Account, Iban FROM Accounts WHERE BelongedUserId = ? AND CurrencyType = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, currencyType);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                double bakiye = rs.getDouble("Money_In_Account");
                String iban = rs.getString("Iban");

                details[0] = String.valueOf(bakiye);
                details[1] = iban;
            }
        } catch (SQLException e) {
            System.out.println("Hesap Detay Hatası (" + currencyType + "): " + e.getMessage());
        }
        return details;
    }

    //YENİ VADELİ HESAP AÇMA
    //SADECE KAYIT YAPAN METOT (Logic Yok, Sadece SQL)
    public static boolean createDepositAccountRaw(String userId, String hesapAdi, double miktar, int vadeGun) {
        String sql = "INSERT INTO Accounts(BelongedUserId, AccountId, Iban, Money_In_Account, AccountType, CreationDate, CurrencyType, DepositDays, AccountName) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Rastgele ID ve IBAN üretimi (Helper metodun varsa onu kullan)
            String newAccountId = String.valueOf(new java.util.Random().nextInt(900000) + 100000);
            String newIban = "TR" + (new java.util.Random().nextLong() & Long.MAX_VALUE);

            pstmt.setString(1, userId);
            pstmt.setString(2, newAccountId);
            pstmt.setString(3, newIban);
            pstmt.setDouble(4, miktar);
            pstmt.setString(5, "DEPOSIT");
            pstmt.setString(6, TimeManager.getCurrentDate().toString());
            pstmt.setString(7, "TL");
            pstmt.setInt(8, vadeGun);
            pstmt.setString(9, hesapAdi);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //KULLANICININ VADELİ HESAPLARINI LİSTELE (GÜNCELLENMİŞ)
    public static java.util.ArrayList<String> getVadeliAccountNames(String userId) {
        java.util.ArrayList<String> hesapListesi = new java.util.ArrayList<>();

        String sql = "SELECT AccountName, Money_In_Account FROM Accounts WHERE BelongedUserId = ? AND UPPER(AccountType) = 'DEPOSIT'";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String ad = rs.getString("AccountName");
                double bakiye = rs.getDouble("Money_In_Account");

                if (ad == null || ad.isEmpty()) { ad = "Vadeli Hesap"; }

                hesapListesi.add(ad + " (" + bakiye + " TL)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hesapListesi;
    }

    //GÜVENLİ PARA TRANSFERİ METODU
    // Gönderen ID'den parayı düşer, Alıcı IBAN'a parayı ekler.
    public static String paraTransferiYap(String gonderenUserId, String aliciIban, double miktar) {
        Connection conn = null;
        PreparedStatement checkBalanceStmt = null;
        PreparedStatement checkReceiverStmt = null;
        PreparedStatement deductStmt = null;
        PreparedStatement addStmt = null;

        try {
            conn = DriverManager.getConnection(URL);
            conn.setAutoCommit(false); // Otomatik kaydı kapat (Transaction Başlat)

            //Gönderenin Vadesiz TL Hesabını ve Bakiyesini Bul
            String checkBalanceSql = "SELECT AccountId, Money_In_Account FROM Accounts WHERE BelongedUserId = ? AND AccountType = 'CHECKING' AND CurrencyType = 'TL'";
            checkBalanceStmt = conn.prepareStatement(checkBalanceSql);
            checkBalanceStmt.setString(1, gonderenUserId);
            ResultSet rsSender = checkBalanceStmt.executeQuery();

            if (!rsSender.next()) {
                return "HATA: Vadesiz TL hesabınız bulunamadı.";
            }

            String senderAccountId = rsSender.getString("AccountId");
            double currentBalance = rsSender.getDouble("Money_In_Account");

            if (currentBalance < miktar) {
                return "HATA: Yetersiz bakiye!";
            }

            //Alıcı IBAN Var mı Kontrol Et
            String checkReceiverSql = "SELECT AccountId FROM Accounts WHERE Iban = ?";
            checkReceiverStmt = conn.prepareStatement(checkReceiverSql);
            checkReceiverStmt.setString(1, aliciIban);
            ResultSet rsReceiver = checkReceiverStmt.executeQuery();

            if (!rsReceiver.next()) {
                return "HATA: Alıcı IBAN bulunamadı.";
            }
            String receiverAccountId = rsReceiver.getString("AccountId");

            //Kendi kendine transferi engelle
            if(senderAccountId.equals(receiverAccountId)) {
                return "HATA: Kendi hesabınıza bu menüden transfer yapamazsınız.";
            }

            //Gönderenden Parayı Düş
            String deductSql = "UPDATE Accounts SET Money_In_Account = Money_In_Account - ? WHERE AccountId = ?";
            deductStmt = conn.prepareStatement(deductSql);
            deductStmt.setDouble(1, miktar);
            deductStmt.setString(2, senderAccountId);
            deductStmt.executeUpdate();

            //Alıcıya Parayı Ekle
            String addSql = "UPDATE Accounts SET Money_In_Account = Money_In_Account + ? WHERE AccountId = ?";
            addStmt = conn.prepareStatement(addSql);
            addStmt.setDouble(1, miktar);
            addStmt.setString(2, receiverAccountId);
            addStmt.executeUpdate();

            conn.commit(); // Her şey yolundaysa KAYDET
            return "BASARILI";

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback(); //Hata varsa geri al
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return "HATA: Veritabanı hatası oluştu.";
        } finally {
            try {
                if (checkBalanceStmt != null) checkBalanceStmt.close();
                if (checkReceiverStmt != null) checkReceiverStmt.close();
                if (deductStmt != null) deductStmt.close();
                if (addStmt != null) addStmt.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //KULLANICININ VADESİZ HESABINI NESNE OLARAK GETİR
    public static model.CheckingAccount getCheckingAccountObject(String userId) {
        String sql = "SELECT * FROM Accounts WHERE BelongedUserId = ? AND AccountType = 'CHECKING' AND CurrencyType = 'TL'";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new model.CheckingAccount(
                        userId,
                        rs.getString("AccountId"),
                        rs.getString("Iban"),
                        rs.getFloat("Money_In_Account")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    //KULLANICININ DÖVİZ HESABINI NESNE OLARAK GETİR
    public static model.ForeignCurrencyAccount getForeignCurrencyAccountObject(String userId, String currencyType) {
        String sql = "SELECT * FROM Accounts WHERE BelongedUserId = ? AND CurrencyType = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, currencyType); // "USD", "EUR", "GOLD"
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new model.ForeignCurrencyAccount(
                        userId,
                        rs.getString("AccountId"),
                        rs.getFloat("Money_In_Account"),
                        currencyType
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    //NESNEYİ GÜNCELLE (Save/Update)
    public static boolean saveAccount(model.CheckingAccount account) {
        String sql = "UPDATE Accounts SET Money_In_Account = ? WHERE AccountId = ?";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Nesnenin RAM'deki güncel bakiyesini alıp SQL'e koyuyoruz
            pstmt.setDouble(1, account.getMoneyInAccount());
            pstmt.setString(2, account.getAccountId());

            return pstmt.executeUpdate() > 0;

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //BANKA KARTI NESNESİNİ GETİR
    public static model.DebitCard getDebitCardObject(String userId) {
        // Kartı bulmak için: UserId ve Tip = 'DEBIT' kontrolü yapıyoruz
        String sql = "SELECT * FROM Cards WHERE UserId = ? AND CardType = 'DEBIT'";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            java.sql.ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String linkedAccountId = rs.getString("LinkedAccountId");

                if (linkedAccountId == null) return null;

                model.Account account = getAccountById(linkedAccountId);
                if (account == null || !(account instanceof model.CheckingAccount)) return null;

                return new model.DebitCard(
                        rs.getString("CardNumber"),
                        userId,
                        rs.getString("CVV"),       // Sütun adı: CVV
                        rs.getString("ExpiryDate"),// Sütun adı: ExpiryDate
                        (model.CheckingAccount) account // Bağlı hesap nesnesi
                );
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // KURUMSAL MODÜL VE ABONELİK
    public static int getAboneSayisi(String corpId) {
        String sql = "SELECT COUNT(*) FROM Subscriptions WHERE CompanyUserId = ? AND IsActive = 1";
        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, corpId); ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {} return 0;
    }

    public static double getBeklenenTahsilat(String corpId) {
        String sql = "SELECT SUM(FixedAmount) FROM Subscriptions WHERE CompanyUserId = ? AND IsActive = 1";
        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, corpId); ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        } catch (Exception e) {} return 0.0;
    }

    public static ArrayList<String[]> getAboneler(String corpId) {
        ArrayList<String[]> liste = new ArrayList<>();
        String sql = "SELECT SubscriptionId, SubscriberTC, SubscriberName, SubscriberSurname, BillingDay, FixedAmount FROM Subscriptions WHERE CompanyUserId = ? AND IsActive = 1";
        try (Connection conn = DriverManager.getConnection(URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, corpId); ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] satir = new String[5];
                satir[0] = rs.getString("SubscriptionId");
                satir[1] = rs.getString("SubscriberTC");
                satir[2] = rs.getString("SubscriberName") + " " + rs.getString("SubscriberSurname");
                satir[3] = String.valueOf(rs.getInt("BillingDay"));
                satir[4] = String.valueOf(rs.getDouble("FixedAmount")) + " TL";
                liste.add(satir);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return liste;
    }

    //YENİ ABONE KAYDETME
    public static boolean addSubscription(String corpId, String tc, String ad, String soyad, int gun, double tutar) {

        // --- DEĞİŞİKLİK BURADA: Artık 3 parametreyi de kontrol ediyoruz ---
        if (!validateIndividualUser(tc, ad, soyad)) {
            // Buradan false dönersek UI tarafında "Kullanıcı bulunamadı" hatası gösterilecek.
            System.out.println("Doğrulama Başarısız: " + tc + " - " + ad + " " + soyad);
            return false;
        }

        String sql = "INSERT INTO Subscriptions(CompanyUserId, SubscriberTC, SubscriberName, SubscriberSurname, BillingDay, FixedAmount, IsActive, StartDate, ServiceName) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, corpId);
            pstmt.setString(2, tc);
            pstmt.setString(3, ad);
            pstmt.setString(4, soyad);
            pstmt.setInt(5, gun);
            pstmt.setDouble(6, tutar);
            pstmt.setInt(7, 1); // Aktif
            pstmt.setString(8, java.time.LocalDate.now().toString());
            pstmt.setString(9, "Hizmet Aboneliği");

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Abone Ekleme Hatası: " + e.getMessage());
            return false;
        }
    }

    //HATA AYIKLAYICI DOĞRULAMA METODU
    public static boolean validateIndividualUser(String tc, String ad, String soyad) {

        String cleanTC = tc.trim();
        String cleanAd = ad.trim();
        String cleanSoyad = soyad.trim();

        System.out.println("--- KULLANICI SORGULANIYOR ---");
        System.out.println("Aranan TC: '" + cleanTC + "'");
        System.out.println("Aranan Ad: '" + cleanAd + "'");
        System.out.println("Aranan Soyad: '" + cleanSoyad + "'");

        String sql = "SELECT * FROM Individual_Users WHERE TC_Kimlik = ? AND LOWER(name) = LOWER(?) AND LOWER(surname) = LOWER(?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cleanTC);
            pstmt.setString(2, cleanAd);
            pstmt.setString(3, cleanSoyad);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("SONUÇ: Kullanıcı BULUNDU! ID: " + rs.getString("UserId"));
                return true;
            } else {
                System.out.println("SONUÇ: Eşleşen kayıt BULUNAMADI.");
                checkIfOnlyTCExists(cleanTC);
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Kullanıcı Doğrulama Hatası: " + e.getMessage());
            return false;
        }
    }

    // DEBUG İÇİN YARDIMCI METOT
    private static void checkIfOnlyTCExists(String tc) {
        String sql = "SELECT name, surname FROM Individual_Users WHERE TC_Kimlik = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tc);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("HATA ANALİZİ: TC (" + tc + ") veritabanında VAR.");
                System.out.println("Veritabanındaki Kayıt -> Ad: '" + rs.getString("name") + "', Soyad: '" + rs.getString("surname") + "'");
                System.out.println("Sizin Girdiğiniz      -> Ad ve Soyad uyuşmuyor olabilir.");
            } else {
                System.out.println("HATA ANALİZİ: Bu TC (" + tc + ") veritabanında HİÇ YOK.");
                System.out.println("Aktif Veritabanı Yolu: " + new java.io.File("Bank.db").getAbsolutePath());
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    //BİREYSEL FATURA VE ABONELİK METOTLARI
    public static java.util.ArrayList<String[]> getBireyselAbonelikler(String tc) {
        java.util.ArrayList<String[]> liste = new java.util.ArrayList<>();

        String sql = "SELECT s.ServiceName, e.Enterprise_Name, s.FixedAmount, s.BillingDay " +
                "FROM Subscriptions s " +
                "JOIN Enterprise_Users e ON s.CompanyUserId = e.Corporate_Code " + // <-- DEĞİŞTİ
                "WHERE s.SubscriberTC = ? AND s.IsActive = 1";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tc);
            java.sql.ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String[] satir = new String[4];
                satir[0] = rs.getString("ServiceName");
                satir[1] = rs.getString("Enterprise_Name");
                satir[2] = rs.getString("FixedAmount") + " TL";
                satir[3] = "Her ayın " + rs.getInt("BillingDay") + ". günü";
                liste.add(satir);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    //Müşterinin Ödenmemiş Faturalarını Getir
    public static java.util.ArrayList<String[]> getBireyselFaturalar(String tc) {
        java.util.ArrayList<String[]> liste = new java.util.ArrayList<>();

        String sql = "SELECT i.InvoiceId, s.ServiceName, e.Enterprise_Name, i.Amount, i.DueDate " +
                "FROM Invoices i " +
                "JOIN Subscriptions s ON i.SubscriptionId = s.SubscriptionId " +
                "JOIN Enterprise_Users e ON s.CompanyUserId = e.Corporate_Code " + // <-- DEĞİŞTİ
                "WHERE s.SubscriberTC = ? AND i.IsPaid = 0";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tc);
            java.sql.ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String[] satir = new String[5];
                satir[0] = rs.getString("InvoiceId");
                satir[1] = rs.getString("ServiceName");
                satir[2] = rs.getString("Enterprise_Name");
                satir[3] = rs.getString("Amount") + " TL";
                satir[4] = rs.getString("DueDate");
                liste.add(satir);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    //FATURA ÖDEME İŞLEMİ (DEBUG VERSİYONU)
    public static String faturaOde(String userId, String invoiceId) {
        System.out.println("--- FATURA ÖDEME İŞLEMİ BAŞLADI ---");
        System.out.println("Kullanıcı ID: " + userId);
        System.out.println("Fatura ID: " + invoiceId);

        java.sql.Connection conn = null;
        try {
            conn = java.sql.DriverManager.getConnection(URL);
            conn.setAutoCommit(false); // Transaction Başlangıcı

            // ADIM 1: Faturayı ve Şirket ID'sini Bul
            String sqlFatura = "SELECT i.Amount, s.CompanyUserId " +
                    "FROM Invoices i " +
                    "JOIN Subscriptions s ON i.SubscriptionId = s.SubscriptionId " +
                    "WHERE i.InvoiceId = ? AND i.IsPaid = 0";

            java.sql.PreparedStatement pstmtFatura = conn.prepareStatement(sqlFatura);
            pstmtFatura.setString(1, invoiceId);
            java.sql.ResultSet rsFatura = pstmtFatura.executeQuery();

            if (!rsFatura.next()) {
                System.out.println("HATA: Fatura bulunamadı veya zaten ödenmiş!");
                return "HATA: Fatura bulunamadı.";
            }

            double tutar = rsFatura.getDouble("Amount");
            String sirketId = rsFatura.getString("CompanyUserId");

            System.out.println("1. ADIM BAŞARILI: Tutar=" + tutar + " , Alıcı Şirket ID=" + sirketId);

            // ADIM 2: Kullanıcının (Ödeyenin) TL Hesabını Bul
            String sqlUser = "SELECT AccountId, Money_In_Account FROM Accounts WHERE BelongedUserId = ? AND CurrencyType = 'TL'";
            java.sql.PreparedStatement pstmtUser = conn.prepareStatement(sqlUser);
            pstmtUser.setString(1, userId);
            java.sql.ResultSet rsUser = pstmtUser.executeQuery();

            if (!rsUser.next()) return "HATA: Vadesiz TL Hesabınız yok.";

            String userAccId = rsUser.getString("AccountId");
            double currentBalance = rsUser.getDouble("Money_In_Account");

            System.out.println("2. ADIM BAŞARILI: Gönderen Hesap ID=" + userAccId + " , Mevcut Bakiye=" + currentBalance);

            if (currentBalance < tutar) return "HATA: Yetersiz Bakiye.";

            // ADIM 3: Şirketin (Alıcının) TL Hesabını Bulma
            String sqlCorp = "SELECT a.AccountId FROM Accounts a " +
                    "JOIN Enterprise_Users e ON a.BelongedUserId = e.UserId " +
                    "WHERE e.Corporate_Code = ? AND a.CurrencyType = 'TL'";

            java.sql.PreparedStatement pstmtCorp = conn.prepareStatement(sqlCorp);
            pstmtCorp.setString(1, sirketId); // sirketId değişkeni burada Corporate Code taşıyor
            java.sql.ResultSet rsCorp = pstmtCorp.executeQuery();

            if(!rsCorp.next()) {
                System.out.println("!!! HATA !!!: Şirket Kodu (" + sirketId + ") için hesap bulunamadı!");
                return "HATA: Şirketin banka hesabı bulunamadı.";
            }

            String corpAccId = rsCorp.getString("AccountId");
            System.out.println("3. ADIM BAŞARILI: Alıcı Şirket Hesap ID=" + corpAccId);

            // ADIM 4: TRANSFER (UPDATE)
            java.sql.PreparedStatement sub = conn.prepareStatement("UPDATE Accounts SET Money_In_Account = Money_In_Account - ? WHERE AccountId = ?");
            sub.setDouble(1, tutar);
            sub.setString(2, userAccId);
            int rowsUser = sub.executeUpdate();
            System.out.println("4A. Kullanıcı Bakiyesi Güncellendi: " + (rowsUser > 0 ? "EVET" : "HAYIR"));

            //Şirkete Ekle
            java.sql.PreparedStatement add = conn.prepareStatement("UPDATE Accounts SET Money_In_Account = Money_In_Account + ? WHERE AccountId = ?");
            add.setDouble(1, tutar);
            add.setString(2, corpAccId);
            int rowsCorp = add.executeUpdate();
            System.out.println("4B. Şirket Bakiyesi Güncellendi: " + (rowsCorp > 0 ? "EVET" : "HAYIR"));

            //Faturayı Kapat
            java.sql.PreparedStatement close = conn.prepareStatement("UPDATE Invoices SET IsPaid = 1 WHERE InvoiceId = ?");
            close.setString(1, invoiceId);
            close.executeUpdate();

            conn.commit(); // İşlemi Onayla
            System.out.println("--- İŞLEM BAŞARIYLA TAMAMLANDI ---");
            return "BASARILI";

        } catch (java.sql.SQLException e) {
            System.out.println("SQL HATASI: " + e.getMessage());
            try { if(conn!=null) conn.rollback(); } catch(Exception ex){}
            return "HATA: " + e.getMessage();
        } finally {
            try { if(conn!=null) { conn.setAutoCommit(true); conn.close(); }} catch(Exception e){}
        }
    }

    // KURUMSAL: MANUEL FATURA KESME (INSERT)
    public static boolean addInvoice(String subscriptionId, double amount) {
        // Rastgele Fatura ID
        String invoiceId = ProduceRandomID();

        // Vade tarihi: Bugünden 30 gün sonrası
        String dueDate = java.time.LocalDate.now().plusDays(30).toString();

        String sql = "INSERT INTO Invoices(InvoiceId, SubscriptionId, Amount, DueDate, IsPaid) VALUES(?,?,?,?,?)";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, invoiceId);
            pstmt.setString(2, subscriptionId);
            pstmt.setDouble(3, amount);
            pstmt.setString(4, dueDate);
            pstmt.setInt(5, 0); // 0 = Ödenmedi (Borç)

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Fatura Veritabanına Eklendi! ID: " + invoiceId);
                return true;
            }
        } catch (java.sql.SQLException e) {
            System.out.println("Fatura Ekleme Hatası: " + e.getMessage());
        }
        return false;
    }

    //BASİT HESAP AÇMA (Kurumsal İçin)
    private static void createAccountRaw(String userId, String currency, double amount) {
        // Hesaplar tablosuna ekleme yapan SQL
        String sql = "INSERT INTO Accounts(BelongedUserId, AccountId, Iban, Money_In_Account, AccountType, CurrencyType, CreationDate) VALUES(?,?,?,?,?,?,?)";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 1. Rastgele Hesap ID'si üret
            String accId = String.valueOf(new java.util.Random().nextInt(900000) + 100000);

            // 2. Rastgele IBAN üret (Mevcut metodunu kullanıyoruz)
            String iban = generateIBAN();

            pstmt.setString(1, userId);
            pstmt.setString(2, accId);
            pstmt.setString(3, iban);
            pstmt.setDouble(4, amount);     // Bakiye (0.0)
            pstmt.setString(5, "CHECKING"); // Hesap Türü: Vadesiz
            pstmt.setString(6, currency);   // Para Birimi: TL
            pstmt.setString(7, java.time.LocalDate.now().toString()); // Tarih

            pstmt.executeUpdate();
            System.out.println("Sistem: Kurumsal kullanıcı için otomatik " + currency + " hesabı açıldı.");

        } catch (Exception e) {
            System.out.println("Otomatik Hesap Açma Hatası: " + e.getMessage());
        }
    }

    // KREDİ KARTI İLE ÖDEMEDE ŞİRKETE PARA YATIRMA
    public static boolean depositToCompany(String invoiceId) {
        String sqlInfo = "SELECT i.Amount, s.CompanyUserId FROM Invoices i " +
                "JOIN Subscriptions s ON i.SubscriptionId = s.SubscriptionId WHERE i.InvoiceId = ?";

        String sqlUpdate = "UPDATE Accounts SET Money_In_Account = Money_In_Account + ? WHERE BelongedUserId = ? AND CurrencyType = 'TL'";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmtInfo = conn.prepareStatement(sqlInfo);
             java.sql.PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {

            // 1. Fatura Tutarını ve Şirketi Bul
            pstmtInfo.setString(1, invoiceId);
            java.sql.ResultSet rs = pstmtInfo.executeQuery();

            if (rs.next()) {
                double tutar = rs.getDouble("Amount");
                String sirketId = rs.getString("CompanyUserId");

                // 2. Şirketin Hesabına Ekle
                pstmtUpdate.setDouble(1, tutar);
                pstmtUpdate.setString(2, sirketId);
                int rows = pstmtUpdate.executeUpdate();

                if(rows > 0) {
                    System.out.println("Sistem: " + tutar + " TL şirketin hesabına yatırıldı.");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Şirkete Yatırma Hatası: " + e.getMessage());
        }
        return false;
    }

    // ZAMAN SİMÜLASYONU (ADMIN KONSOLUNDAN ÇAĞRILIR)
    public static void processDailyOperations(int daysToAdvance) {
        java.time.LocalDate currentDate = Managers.TimeManager.getCurrentDate();

        for (int i = 0; i < daysToAdvance; i++) {
            currentDate = currentDate.plusDays(1);

            // A. Vadeli Hesap Kontrolü
            checkDepositMaturity(currentDate);

            // B. Otomatik Fatura Kesimi
            generateAutoInvoices(currentDate);
        }

        // Tarihi kalıcı olarak kaydet
        Managers.TimeManager.advanceDate(daysToAdvance);
    }

    //VADELİ HESAP FAİZ DAĞITIMI
    private static void checkDepositMaturity(java.time.LocalDate simulationDate) {
        String sql = "SELECT * FROM Accounts WHERE UPPER(AccountType) IN ('DEPOSIT', 'VADELI', 'DEPOSITACCOUNT')";

        java.util.ArrayList<String[]> islemListesi = new java.util.ArrayList<>();

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String accId = rs.getString("AccountId");
                String userId = rs.getString("BelongedUserId");
                double anapara = rs.getDouble("Money_In_Account");
                int vadeGun = rs.getInt("DepositDays");
                String createDateStr = rs.getString("CreationDate");

                if (createDateStr == null) continue;

                java.time.LocalDate createDate = java.time.LocalDate.parse(createDateStr);
                java.time.LocalDate vadeSonu = createDate.plusDays(vadeGun);

                // Vade doldu mu
                if (!simulationDate.isBefore(vadeSonu)) {
                    double netKazanc = model.DepositAccount.calculateProjectedNetProfit(anapara, vadeGun);
                    double toplam = anapara + netKazanc;

                    // Listeye ekle
                    islemListesi.add(new String[]{accId, userId, String.valueOf(toplam), String.valueOf(netKazanc)});
                }
            }
        } catch (Exception e) {
            System.out.println("Okuma Hatası: " + e.getMessage());
        }

        //Para yatırma ve Silme
        if (!islemListesi.isEmpty()) {
            for (String[] islem : islemListesi) {
                String vadeliAccId = islem[0];
                String userId = islem[1];
                double toplamTutar = Double.parseDouble(islem[2]);
                String kazancStr = islem[3]; // Log için

                System.out.println(">>>  VADE DOLDU! Hesap: " + vadeliAccId + " | Kazanç: " + kazancStr + " TL");

                // A) Parayı Vadesiz Hesaba Aktar (UPDATE)
                model.CheckingAccount vadesiz = getCheckingAccountObject(userId);
                if (vadesiz != null) {
                    try {
                        vadesiz.addMoneyToAccount((float) toplamTutar);
                        saveAccount(vadesiz); // Bu metot artık güvenle çalışır
                        System.out.println("    -> " + String.format("%.2f", toplamTutar) + " TL Müşterinin (ID: " + userId + ") Vadesiz Hesabına Yatırıldı.");
                    } catch (Exception e) {
                        System.out.println("    -> Transfer Hatası: " + e.getMessage());
                    }
                }

                // B) Vadeli Hesabı Sil (DELETE)
                try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
                     java.sql.PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Accounts WHERE AccountId = ?")) {
                    pstmt.setString(1, vadeliAccId);
                    pstmt.executeUpdate();
                    System.out.println("    -> Vadeli Hesap (ID: " + vadeliAccId + ") kapatıldı ve silindi.");
                } catch (Exception e) {
                    System.out.println("    -> Silme Hatası: " + e.getMessage());
                }
            }
        }
    }

    // B. OTOMATİK FATURA KESİMİ (GÜVENLİ VERSİYON)
    private static void generateAutoInvoices(java.time.LocalDate simulationDate) {
        int bugunGun = simulationDate.getDayOfMonth();
        String sql = "SELECT SubscriptionId, FixedAmount FROM Subscriptions WHERE BillingDay = ? AND IsActive = 1";

        // Fatura kesilecekleri önce hafızaya alıyoruz
        java.util.ArrayList<String[]> faturaListesi = new java.util.ArrayList<>();

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, bugunGun);
            java.sql.ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String subId = rs.getString("SubscriptionId");
                double tutar = rs.getDouble("FixedAmount");
                // Listeye ekle
                faturaListesi.add(new String[]{subId, String.valueOf(tutar)});
            }
        } catch (Exception e) { e.printStackTrace(); }

        // Bağlantı kapandı. Şimdi listeyi dönüp faturaları kesebiliriz (Çakışma olmaz)
        for (String[] veri : faturaListesi) {
            String subId = veri[0];
            double tutar = Double.parseDouble(veri[1]);

            if (addInvoice(subId, tutar)) {
                System.out.println(">>> OTOMATİK FATURA: AboneID " + subId + " için " + tutar + " TL kesildi.");
            }
        }
    }

    // GENEL HESAP KAYDETME (Polimorfizm)
    // Bu metot, CheckingAccount, DepositAccount veya ForeignCurrencyAccount fark etmeksizin
    // gelen her türlü hesabın sadece bakiyesini günceller.
    public static boolean saveAccount(model.Account account) {
        if (account == null) return false;

        // Hesabın ID'sini ve güncel parasını alıp updateBalance'a yolluyoruz.
        // updateBalance metodu zaten Accounts tablosunda ID'ye göre güncelleme yapıyor.
        return updateBalance(account.getAccountId(), account.getMoneyInAccount());
    }

    public static model.DepositAccount getDepositAccountByName(String userId, String accountName) {
        String query = "SELECT * FROM DepositAccounts WHERE User_ID = ? AND Account_Name = ?";

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(URL);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, accountName);
            java.sql.ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("Creation_Date");
                java.time.LocalDate creationDate = (sqlDate != null) ? sqlDate.toLocalDate() : java.time.LocalDate.now();

                model.DepositAccount acc = new model.DepositAccount(
                        rs.getString("Account_ID"),           // 1. String id
                        rs.getString("User_ID"),              // 2. String userId
                        (float) rs.getDouble("Balance"),      // 3. float balance (CAST işlemi şart!)
                        rs.getInt("Term_Days"),               // 4. int termDays
                        creationDate                          // 5. LocalDate creationDate
                );
                return acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}





