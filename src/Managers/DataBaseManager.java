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
                "Enterprise_HQ TEXT, " +
                "Corporate_Code TEXT UNIQUE)";

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

        String sqlCards = "CREATE TABLE IF NOT EXISTS Cards (" +
                "CardNumber TEXT PRIMARY KEY, " +
                "UserId TEXT, " +
                "CardType TEXT, " +         // 'DEBIT' veya 'CREDIT'
                "CVV TEXT, " +
                "ExpiryDate TEXT, " +
                "LinkedAccountId TEXT, " +  // Sadece Debit için dolu
                "CreditLimit REAL, " +      // Sadece Credit için dolu
                "CurrentDebt REAL)";        // Sadece Credit için dolu

        String sqlSubscriptions = "CREATE TABLE IF NOT EXISTS Subscriptions (" +
                "SubscriptionId TEXT PRIMARY KEY, " +
                "SubscriberUserId TEXT, " +
                "CompanyUserId TEXT, " +
                "ServiceName TEXT, " +
                "IsActive INTEGER, " + // 1: Aktif, 0: Kesik
                "StartDate TEXT)";

        String sqlInvoices = "CREATE TABLE IF NOT EXISTS Invoices (" +
                "InvoiceId TEXT PRIMARY KEY, " +
                "SubscriptionId TEXT, " +
                "Amount REAL, " +
                "DueDate TEXT, " +
                "IsPaid INTEGER)"; // 1: Ödendi, 0: Ödenmedi



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

    public static String addEnterpriseUser(String enterpriseName, String password, LocalDate enterpriseEstablishment, String enterpriseHQ) {

        // Şifre kontrolü (Hata varsa null döndürür)
        if (!isValidPassword(password)) {
            System.out.println("Hata: Geçersiz şifre.");
            return null;
        }

        String sql = "INSERT INTO Enterprise_Users(UserId, Enterprise_Name, password, Enterprise_Establishment, Enterprise_HQ, Corporate_Code) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // User ID üret (Konsolda görünecek)
            String uniqueId;
            do {
                uniqueId = ProduceRandomID();
            } while (isIDExists(uniqueId));

            // YENİ: 12 Haneli Benzersiz Kurum Kodu üret (Ekranda görünecek)
            String uniqueCorpCode;
            do {
                // Eğer generateCorporateCode metodun yoksa aşağıya onun kodunu da ekledim
                uniqueCorpCode = generateCorporateCode();
            } while (isCorporateCodeExists(uniqueCorpCode));

            stmt.setString(1, uniqueId);
            stmt.setString(2, enterpriseName);
            stmt.setString(3, password);
            stmt.setString(4, enterpriseEstablishment.toString());
            stmt.setString(5, enterpriseHQ);
            stmt.setString(6, uniqueCorpCode);

            stmt.executeUpdate();

            // KONSOL ÇIKTISI: ID burada görünüyor (İstediğin gibi)
            System.out.println("Kurumsal kullanıcı eklendi. ID: " + uniqueId);

            // EKRAN ÇIKTISI İÇİN: Kurum Kodunu geri döndürüyoruz
            return uniqueCorpCode;

        } catch (SQLException e) {
            System.out.println("Kurumsal Ekleme Hatası: " + e.getMessage());
            return null;
        }
    }

    //12 Haneli Sadece Rakamlardan Oluşan Kod Üretici
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

    //region Card Logic
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

    //KART BORCUNU GÜNCELLEME (Kredi Kartı İçin)
    public static void updateCardDebt(String cardNumber, float newDebt) {
        String sql = "UPDATE Cards SET CurrentDebt = ? WHERE CardNumber = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setFloat(1, newDebt);
            pstmt.setString(2, cardNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kart Güncelleme Hatası: " + e.getMessage());
        }
    }

    //Random Kart No
    private static String getRandomCardNumber() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder("4543"); // Visa başlangıç
        for(int i=0; i<12; i++) sb.append(rnd.nextInt(10));
        return sb.toString();
    }

    //KULLANICININ KARTLARINI GETİRME METODU
    public static java.util.ArrayList<model.Card> getCardsByUserId(String userId) {
        java.util.ArrayList<model.Card> userCards = new java.util.ArrayList<>();

        String sql = "SELECT * FROM Cards WHERE UserId = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Ortak Veriler
                String cardNo = rs.getString("CardNumber");
                String uId = rs.getString("UserId");
                String type = rs.getString("CardType"); // "DEBIT" veya "CREDIT"
                String cvv = rs.getString("CVV");
                String date = rs.getString("ExpiryDate");

                if ("DEBIT".equalsIgnoreCase(type)) {
                    // Banka Kartı ise LinkedAccountId verisini çek
                    String linkedAcc = rs.getString("LinkedAccountId");

                    // Listeye DebitCard olarak ekle
                    userCards.add(new model.DebitCard(cardNo, uId, cvv, date, linkedAcc));
                }
                else if ("CREDIT".equalsIgnoreCase(type)) {
                    // Kredi Kartı ise Limit ve Borç verilerini çek
                    float limit = rs.getFloat("CreditLimit");
                    float debt = rs.getFloat("CurrentDebt");

                    // Listeye CreditCard olarak ekle
                    userCards.add(new model.CreditCard(cardNo, uId, cvv, date, limit, debt));
                }
            }

        } catch (SQLException e) {
            System.out.println("Kartları Getirme Hatası: " + e.getMessage());
        }

        return userCards;
    }
    //endregion

    //region SubscriptionLogic

    // 1. ABONELİK OLUŞTURMA (Tarih TimeManager'dan gelir)
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

    // 2. OTOMATİK FATURA KESME SİMÜLASYONU
    // Bu metot, her ay döngüsü geldiğinde yeni fatura keser.
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

    // 3. ZAMAN ATLAYINCA BORÇLU HİZMETLERİ KESME
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

    // ID ile Fatura Bulma Metodu
    public static model.Invoice getInvoiceById(String invoiceId) {
        String sql = "SELECT * FROM Invoices WHERE InvoiceId = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, invoiceId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Veritabanından gelen verileri Model nesnesine çeviriyoruz
                String subId = rs.getString("SubscriptionId");
                float amount = rs.getFloat("Amount");
                String dateStr = rs.getString("DueDate");
                int isPaidInt = rs.getInt("IsPaid");

                // Tarihi String'den LocalDate'e çevir
                LocalDate dueDate = (dateStr != null) ? LocalDate.parse(dateStr) : null;

                // 1 ise true (Ödendi), 0 ise false (Ödenmedi)
                boolean isPaid = (isPaidInt == 1);

                return new model.Invoice(invoiceId, subId, amount, dueDate, isPaid);
            }

        } catch (SQLException e) {
            System.out.println("Fatura Bulma Hatası: " + e.getMessage());
        }

        return null; // Fatura bulunamazsa null döner
    }

    // Faturayı 'Ödendi' yap ve Hizmeti Tekrar Aç
    public static void markInvoiceAsPaidAndActivateService(String invoiceId) {
        // 1. Önce faturanın kime ait olduğunu bulalım (SubscriptionId lazım)
        model.Invoice inv = getInvoiceById(invoiceId);
        if (inv == null) return;

        String sqlPay = "UPDATE Invoices SET IsPaid = 1 WHERE InvoiceId = ?";
        String sqlActivate = "UPDATE Subscriptions SET IsActive = 1 WHERE SubscriptionId = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmtPay = conn.prepareStatement(sqlPay);
             PreparedStatement pstmtActivate = conn.prepareStatement(sqlActivate)) {

            // Transaction başlatılabilir ama basit tutuyoruz

            // A) Faturayı Ödendi İşaretle
            pstmtPay.setString(1, invoiceId);
            pstmtPay.executeUpdate();

            // B) Abonelik Hizmetini Aç (Kesikse açılır, açıksa açık kalır)
            pstmtActivate.setString(1, inv.getSubscriptionId());
            pstmtActivate.executeUpdate();

            System.out.println("Sistem: Fatura kapatıldı ve hizmet aktif edildi.");

        } catch (SQLException e) {
            System.out.println("Fatura Güncelleme Hatası: " + e.getMessage());
        }
    }
    //endregion

    public static model.IndividualUser getIndividualUserByLogin(String input, String password, String loginType) {
        String sql = "";

        // Hangi yöntemle giriş yapılıyor?
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
                // Şirket bulundu! Verileri çekip nesne yapalım.
                String userId = rs.getString("UserId");
                String name = rs.getString("Enterprise_Name");
                String dbPass = rs.getString("password");
                String hq = rs.getString("Enterprise_HQ");
                String code = rs.getString("Corporate_Code");

                // Tarih dönüşümü
                String dateStr = rs.getString("Enterprise_Establishment");
                LocalDate estDate = (dateStr != null) ? LocalDate.parse(dateStr) : LocalDate.now();

                return new model.EnterpriseUser(userId, name, dbPass, estDate, hq, code);
            }

        } catch (SQLException e) {
            System.out.println("Kurumsal Login Hatası: " + e.getMessage());
        }
        return null;
    }







}
