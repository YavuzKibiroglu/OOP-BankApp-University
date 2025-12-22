package UI;

import Managers.DataBaseManager;
import Managers.TimeManager;
import java.util.Scanner;

public class AdminConsole {

    // Bu metot MainMenuUI'daki butondan çağrılacak
    public static void startConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n========================================");
        System.out.println("      ADMIN PANELİNE HOŞ GELDİNİZ       ");
        System.out.println("========================================");
        System.out.println("(Lütfen bilgileri aşağıya yazıp Enter'a basınız)");

        // 1. GİRİŞ KISMI
        System.out.print("Kullanıcı Adı: ");
        String username = scanner.nextLine();

        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        if (TimeManager.checkAdminCredentials(username, password)) {
            System.out.println("\n[+] Giriş Başarılı!");
            showMenu(scanner); // Menü Döngüsüne Gir
        } else {
            System.out.println("\n[!] Hatalı Kullanıcı Adı veya Şifre!");
            System.out.println("Panel kapatılıyor...");
        }
    }

    //MENÜ DÖNGÜSÜ
    private static void showMenu(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\n-------------- ADMIN MENÜ --------------");
            System.out.println("Şu anki Tarih: " + TimeManager.getCurrentDate());
            System.out.println("----------------------------------------");
            System.out.println("1. Gün Atlat (Simülasyon)");
            System.out.println("2. Genel Durum (İstatistik)");
            System.out.println("3. Döviz Kurlarını Güncelle");
            System.out.println("4. Çıkış Yap");
            System.out.print("Seçiminiz: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Kaç gün ileri gidilsin?: ");
                    try {
                        int days = Integer.parseInt(scanner.nextLine());
                        if (days > 0) {
                            System.out.println("\n--- Simülasyon Başlıyor ---");
                            // DataBaseManager'daki simülasyon metodunu tetikle
                            DataBaseManager.processDailyOperations(days);
                            System.out.println("--- Simülasyon Tamamlandı ---");
                        } else {
                            System.out.println("[!] Gün sayısı 0'dan büyük olmalı.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("[!] Lütfen sayısal bir değer giriniz.");
                    }
                    break;

                case "2":
                    showGeneralStats();
                    break;

                case "3":
                    updateCurrencyRates(); // Yeni metodumuz
                    break;
                case "4":
                    running = false;
                    System.out.println("Admin panelinden çıkılıyor...");
                    break;

                default:
                    System.out.println("[!] Geçersiz seçim, tekrar deneyin.");
            }
        }
    }
    //DÖVİZ GÜNCELLEME EKRANI (SEÇMELİ)
    private static void updateCurrencyRates() {
        Scanner scanner = new Scanner(System.in);

        // 1. Mevcut Durumu Göster
        System.out.println("\n--- GUNCEL KURLAR (CONFIG) ---");
        System.out.println(String.format("1. USD (Dolar) : Alis %-8.2f | Satis %-8.2f",
                Managers.CurrencyManager.getUsdBuy(), Managers.CurrencyManager.getUsdSell()));
        System.out.println(String.format("2. EUR (Euro)  : Alis %-8.2f | Satis %-8.2f",
                Managers.CurrencyManager.getEurBuy(), Managers.CurrencyManager.getEurSell()));
        System.out.println(String.format("3. GAU (Altin) : Alis %-8.2f | Satis %-8.2f",
                Managers.CurrencyManager.getGauBuy(), Managers.CurrencyManager.getGauSell()));
        System.out.println("------------------------------");
        System.out.println("4. Iptal / Geri Don");

        System.out.print("\nHangi kuru guncellemek istersiniz? (1-4): ");
        String secim = scanner.nextLine();

        // İptal Seçeneği
        if (secim.equals("4")) {
            System.out.println("Islem iptal edildi.");
            return;
        }

        try {
            double newBuy = 0.0;
            double newSell = 0.0;

            // Seçime göre işlem yap
            switch (secim) {
                case "1": // USD GÜNCELLEME
                    System.out.println("\n--- USD GUNCELLEME ---");
                    System.out.print("Yeni USD Alis: ");
                    newBuy = Double.parseDouble(scanner.nextLine());
                    System.out.print("Yeni USD Satis: ");
                    newSell = Double.parseDouble(scanner.nextLine());

                    Managers.CurrencyManager.updateRates(
                            newBuy, newSell,
                            Managers.CurrencyManager.getEurBuy(), Managers.CurrencyManager.getEurSell(),
                            Managers.CurrencyManager.getGauBuy(), Managers.CurrencyManager.getGauSell()
                    );
                    System.out.println(">>> USD kurlari guncellendi!");
                    break;

                case "2": // EUR GÜNCELLEME
                    System.out.println("\n--- EUR GUNCELLEME ---");
                    System.out.print("Yeni EUR Alis: ");
                    newBuy = Double.parseDouble(scanner.nextLine());
                    System.out.print("Yeni EUR Satis: ");
                    newSell = Double.parseDouble(scanner.nextLine());

                    Managers.CurrencyManager.updateRates(
                            Managers.CurrencyManager.getUsdBuy(), Managers.CurrencyManager.getUsdSell(),
                            newBuy, newSell,
                            Managers.CurrencyManager.getGauBuy(), Managers.CurrencyManager.getGauSell()
                    );
                    System.out.println(">>> EUR kurlari guncellendi!");
                    break;

                case "3": // ALTIN GÜNCELLEME
                    System.out.println("\n--- ALTIN (GAU) GUNCELLEME ---");
                    System.out.print("Yeni GAU Alis: ");
                    newBuy = Double.parseDouble(scanner.nextLine());
                    System.out.print("Yeni GAU Satis: ");
                    newSell = Double.parseDouble(scanner.nextLine());

                    // Kaydet (GAU Yeni, Diğerleri Eski)
                    Managers.CurrencyManager.updateRates(
                            Managers.CurrencyManager.getUsdBuy(), Managers.CurrencyManager.getUsdSell(),
                            Managers.CurrencyManager.getEurBuy(), Managers.CurrencyManager.getEurSell(),
                            newBuy, newSell
                    );
                    System.out.println(">>> ALTIN kurlari guncellendi!");
                    break;

                default:
                    System.out.println("Gecersiz secim!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Hatali giris! Lutfen sayilari nokta ile girin (Orn: 34.50).");
        } catch (Exception e) {
            System.out.println("Bir hata olustu: " + e.getMessage());
        }
    }

    private static void showGeneralStats() {
        // 1. Tarihi Çek
        java.time.LocalDate currentDate = Managers.TimeManager.getCurrentDate();

        System.out.println("\n---------- GENEL DURUM RAPORU ----------");
        System.out.println("Simulasyon Tarihi : " + currentDate);
        System.out.println("----------------------------------------");

        // 2. Güncel Kurları Yazdır
        System.out.println("GUNCEL PIYASA KURLARI");

        // %-8.2f: Sola dayalı, 8 karakter yer ayır, virgülden sonra 2 hane göster
        System.out.println(String.format("USD (Dolar)  : Alis %-8.2f | Satis %-8.2f",
                Managers.CurrencyManager.getUsdBuy(), Managers.CurrencyManager.getUsdSell()));

        System.out.println(String.format("EUR (Euro)   : Alis %-8.2f | Satis %-8.2f",
                Managers.CurrencyManager.getEurBuy(), Managers.CurrencyManager.getEurSell()));

        System.out.println(String.format("GAU (Altin)  : Alis %-8.2f | Satis %-8.2f",
                Managers.CurrencyManager.getGauBuy(), Managers.CurrencyManager.getGauSell()));

        System.out.println("----------------------------------------");

        // Kullanıcı okuyabilsin diye kısa bir bekleme
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }
}