package model;

import Managers.DataBaseManager;
import Managers.TimeManager; // Simülasyon zamanı
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends Account {

    private int depositDays;         // Vade süresi
    private LocalDate creationDate;  // Açılış Tarihi
    private static final double TAX_RATE = 0.05; // %5 Vergi

    public DepositAccount(String userId, String accountId, float moneyInAccount, int depositDays, LocalDate creationDate) {
        super(userId, accountId, moneyInAccount);
        this.depositDays = depositDays;
        this.creationDate = creationDate;
    }

    // Faiz Oranı Mantığı
    private double getInterestRate() {
        if (this.depositDays >= 365) return 50.0;
        else if (this.depositDays >= 181) return 48.0;
        else if (this.depositDays >= 92) return 45.0;
        else return 40.0;
    }

    // Net Kazanç Hesaplama
    public double calculateNetProfit() {
        double rate = getInterestRate();
        // Formül: (Ana Para * Faiz * Gün) / 36500
        double grossProfit = (this.moneyInAccount * rate * this.depositDays) / 36500.0;
        return grossProfit * (1.0 - TAX_RATE); // Vergiyi düş
    }

    @Override
    public String getInformation() {
        long kalanGun = 0;
        if (creationDate != null) {
            long gecen = ChronoUnit.DAYS.between(creationDate, TimeManager.getCurrentDate());
            kalanGun = depositDays - gecen;
            if (kalanGun < 0) kalanGun = 0;
        }
        return String.format("Vadeli Hesap | Vade: %d Gün | Kalan: %d Gün | Tahmini Kazanç: %.2f TL",
                depositDays, kalanGun, calculateNetProfit());
    }

    // --- KENDİ HESABINA AKTARIM (ACCOUNT ID İLE) ---
    // Senaryo: Vade doldu, parayı kendi vadesiz hesabına çekiyorsun.
    @Override
    public void transferToCurrent(float ignoredAmount, String targetAccountId) throws SQLException {

        // 1. ZAMAN KONTROLÜ (Simülasyon)
        LocalDate today = TimeManager.getCurrentDate();
        long daysPassed = ChronoUnit.DAYS.between(this.creationDate, today);

        if (daysPassed < this.depositDays) {
            System.out.println("HATA: Vade süresi henüz dolmadı! Kalan gün: " + (this.depositDays - daysPassed));
            return;
        }

        // 2. HEDEF HESABI BUL (ID ile)
        Account targetAccount = DataBaseManager.getAccountById(targetAccountId);

        if (targetAccount == null) {
            System.out.println("Hata: Hedef hesap bulunamadı.");
            return;
        }

        // 3. GÜVENLİK: Hedef hesap senin mi?
        // (Parent class'taki userId 'protected' olduğu için direkt erişebiliriz)
        if (!targetAccount.userId.equals(this.userId)) {
            System.out.println("GÜVENLİK UYARISI: Vadeli hesabınızı başkasının hesabına bozamazsınız!");
            return;
        }

        // 4. TRANSFER İŞLEMİ
        if (targetAccount instanceof CheckingAccount) {

            // Hesaplamalar
            double anaPara = this.moneyInAccount;
            double netKazanc = calculateNetProfit();
            double toplamTutar = anaPara + netKazanc;

            // Veritabanı İşlemleri
            // A) Vadeli Hesabı Sıfırla
            boolean kaynakGuncellendi = DataBaseManager.updateBalance(this.accountId, 0);

            // B) Vadesiz Hesaba Ekle
            float hedefYeniBakiye = targetAccount.moneyInAccount + (float)toplamTutar;
            boolean hedefGuncellendi = DataBaseManager.updateBalance(targetAccountId, hedefYeniBakiye);

            if (kaynakGuncellendi && hedefGuncellendi) {
                System.out.println("Vade Bozma Başarılı!");
                System.out.println("Aktarılan Tutar (Ana Para + Faiz): " + toplamTutar + " TL");

                // RAM'deki nesneleri güncelle
                this.moneyInAccount = 0;
                ((CheckingAccount) targetAccount).addMoneyToAccount((float)toplamTutar); // Hedef nesneyi de güncelle
            } else {
                System.out.println("Veritabanı güncelleme hatası!");
            }

        } else {
            System.out.println("Hata: Hedef hesap bir Vadesiz Hesap değil.");
        }
    }

    @Override
    public void transferToCurrent(float moneyAmount) throws SQLException {

    }
}
