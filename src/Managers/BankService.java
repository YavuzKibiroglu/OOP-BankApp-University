package Managers;

import model.CheckingAccount;

public class BankService {

    // =================================================================
    // 1. VADELİ HESAP AÇMA İŞ AKIŞI
    // =================================================================
    public static String openDepositAccount(String userId, String accountName, double amount, int days) {

        CheckingAccount vadesizHesap = DataBaseManager.getCheckingAccountObject(userId);

        if (vadesizHesap == null) {
            return "HATA: Vadesiz TL hesabınız bulunamadı.";
        }

        try {
            // 2. Parayı Çek (RAM)
            vadesizHesap.withdraw(amount);

            // 3. Vadesiz Hesabı Kaydet
            boolean bakiyeGuncellendi = DataBaseManager.saveAccount(vadesizHesap);

            if (!bakiyeGuncellendi) {
                return "HATA: Veritabanı hatası (Bakiye güncellenemedi).";
            }

            // 4. Vadeli Hesabı Oluştur
            boolean hesapOlustu = DataBaseManager.createDepositAccountRaw(userId, accountName, amount, days);

            if (hesapOlustu) {
                return "BASARILI";
            } else {
                // ROLLBACK
                vadesizHesap.deposit(amount);
                DataBaseManager.saveAccount(vadesizHesap);
                return "HATA: Hesap oluşturulamadı (Tutar iade edildi).";
            }

        } catch (IllegalStateException e) {
            return "HATA: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "HATA: " + e.getMessage();
        } catch (Exception e) {
            return "HATA: Beklenmedik bir sorun oluştu: " + e.getMessage();
        }
    }

    // =================================================================
    // 2. PARA YATIRMA
    // =================================================================
    public static String paraYatir(String userId, double miktar) {
        CheckingAccount hesap = DataBaseManager.getCheckingAccountObject(userId);
        if (hesap == null) return "Hesap Bulunamadı";

        try {
            hesap.deposit(miktar);
            boolean kaydedildi = DataBaseManager.saveAccount(hesap);
            return kaydedildi ? "BASARILI" : "HATA: Veritabanı Güncellenemedi";
        } catch (IllegalArgumentException e) {
            return "HATA: " + e.getMessage();
        }
    }

    // =================================================================
    // 3. PARA ÇEKME
    // =================================================================
    public static String paraCek(String userId, double miktar) {
        CheckingAccount hesap = DataBaseManager.getCheckingAccountObject(userId);
        if (hesap == null) return "Hesap Bulunamadı";

        try {
            hesap.withdraw(miktar);
            DataBaseManager.saveAccount(hesap);
            return "BASARILI";
        } catch (Exception e) {
            return "HATA: " + e.getMessage();
        }
    }

    // =================================================================
    // 4. BANKA KARTI İLE HARCAMA
    // =================================================================
    public static String bankaKartiIleHarcama(String userId, double miktar) {
        model.DebitCard kart = DataBaseManager.getDebitCardObject(userId);
        if (kart == null) return "HATA: Kart bulunamadı.";

        boolean harcamaBasarili = kart.spend((float)miktar);

        if (harcamaBasarili) {
            model.CheckingAccount bagliHesap = kart.getLinkedAccount();
            boolean kaydedildi = DataBaseManager.saveAccount(bagliHesap);
            return kaydedildi ? "BASARILI" : "HATA: Veritabanı hatası.";
        } else {
            return "HATA: Yetersiz Bakiye.";
        }
    }

    // =================================================================
    // 5. KREDİ KARTI BORCU ÖDEME (EKSİK OLAN KISIMDI)
    // =================================================================
    public static String krediKartiBorcuOde(String userId, double miktar) {
        CheckingAccount hesap = DataBaseManager.getCheckingAccountObject(userId);
        model.CreditCard kart = DataBaseManager.getCreditCardObject(userId);

        if (hesap == null || kart == null) return "HATA: Hesap veya Kart bulunamadı.";

        try {
            // OOP Mantığı: Kart nesnesine "Borcumu şu hesaptan öde" diyoruz.
            boolean islemBasarili = kart.payDebt(hesap, (float)miktar);

            if (islemBasarili) {
                // İkisini de kaydet
                boolean hesapKayit = DataBaseManager.saveAccount(hesap);
                // CreditCard borcu güncellendi, onu da kaydetmeliyiz (updateCardDebt ile)
                boolean kartKayit = DataBaseManager.updateCardDebt(kart.getCardNumber(), kart.getCurrentDebt());

                if (hesapKayit && kartKayit) return "BASARILI";
                else return "HATA: Veritabanı kayıt sorunu.";
            } else {
                return "HATA: Bakiye yetersiz veya tutar hatalı.";
            }
        } catch (Exception e) {
            return "HATA: " + e.getMessage();
        }
    }

    // =================================================================
    // 6. NAKİT AVANS ÇEKME (EKSİK OLAN KISIMDI)
    // =================================================================
    public static String nakitAvansCek(String userId, double miktar) {
        CheckingAccount hesap = DataBaseManager.getCheckingAccountObject(userId);
        model.CreditCard kart = DataBaseManager.getCreditCardObject(userId);

        if (hesap == null || kart == null) return "HATA: Bilgilere erişilemedi.";

        // 1. Karttan Harcama Yap (Limit düşer/Borç Artar)
        // Nakit avans aslında karttan para harcamaktır.
        boolean harcamaBasarili = kart.spend((float)miktar);

        if (harcamaBasarili) {
            // 2. Hesaba Para Ekle (Nakit giriş)
            hesap.deposit(miktar);

            // 3. Kaydet
            DataBaseManager.updateCardDebt(kart.getCardNumber(), kart.getCurrentDebt());
            DataBaseManager.saveAccount(hesap);
            return "BASARILI";
        } else {
            return "HATA: Kart limiti yetersiz.";
        }
    }
}