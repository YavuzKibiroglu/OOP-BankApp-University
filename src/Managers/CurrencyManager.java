package Managers;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CurrencyManager {

    // Kurlar artık değişken (Variable)
    private static Double USD_BUY;
    private static Double USD_SELL;
    private static Double EUR_BUY;
    private static Double EUR_SELL;
    private static Double GAU_BUY;  // Altın (Gram)
    private static Double GAU_SELL;

    private static final String CONFIG_FILE = "config.txt";

    // Program başlarken çağrılır (DataBaseManager.start içinde çağırabilirsin)
    public static void start() {
        loadRatesFromConfig();
    }

    // --- DOSYADAN OKUMA ---
    private static void loadRatesFromConfig() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CONFIG_FILE));
            for (String line : lines) {
                if (line.startsWith("USD_BUY=")) USD_BUY = Double.parseDouble(line.split("=")[1]);
                else if (line.startsWith("USD_SELL=")) USD_SELL = Double.parseDouble(line.split("=")[1]);
                else if (line.startsWith("EUR_BUY=")) EUR_BUY = Double.parseDouble(line.split("=")[1]);
                else if (line.startsWith("EUR_SELL=")) EUR_SELL = Double.parseDouble(line.split("=")[1]);
                else if (line.startsWith("GAU_BUY=")) GAU_BUY = Double.parseDouble(line.split("=")[1]);
                else if (line.startsWith("GAU_SELL=")) GAU_SELL = Double.parseDouble(line.split("=")[1]);
            }
            // System.out.println("Döviz kurları config.txt'den yüklendi.");
        } catch (Exception e) {
            System.out.println("Kurlar yüklenirken hata oluştu! Varsayılanlar kullanılıyor.");
            // Dosya yoksa veya bozuksa varsayılanlar
            USD_BUY = 34.0; USD_SELL = 35.0;
            EUR_BUY = 36.0; EUR_SELL = 37.0;
            GAU_BUY = 2900.0; GAU_SELL = 3000.0;
        }
    }

    // --- KURLARI GÜNCELLE VE DOSYAYA YAZ ---
    public static void updateRates(double usdBuy, double usdSell, double eurBuy, double eurSell, double gauBuy, double gauSell) {
        USD_BUY = usdBuy; USD_SELL = usdSell;
        EUR_BUY = eurBuy; EUR_SELL = eurSell;
        GAU_BUY = gauBuy; GAU_SELL = gauSell;

        // Config Dosyasını Güncelle
        try {
            List<String> lines = Files.readAllLines(Paths.get(CONFIG_FILE));
            List<String> newLines = new ArrayList<>();

            // Mevcut satırları kontrol et, varsa değiştir, yoksa olduğu gibi bırak
            boolean usdBuyFound = false, usdSellFound = false;
            boolean eurBuyFound = false, eurSellFound = false;
            boolean gauBuyFound = false, gauSellFound = false;

            for (String line : lines) {
                if (line.startsWith("USD_BUY=")) { newLines.add("USD_BUY=" + USD_BUY); usdBuyFound = true; }
                else if (line.startsWith("USD_SELL=")) { newLines.add("USD_SELL=" + USD_SELL); usdSellFound = true; }
                else if (line.startsWith("EUR_BUY=")) { newLines.add("EUR_BUY=" + EUR_BUY); eurBuyFound = true; }
                else if (line.startsWith("EUR_SELL=")) { newLines.add("EUR_SELL=" + EUR_SELL); eurSellFound = true; }
                else if (line.startsWith("GAU_BUY=")) { newLines.add("GAU_BUY=" + GAU_BUY); gauBuyFound = true; }
                else if (line.startsWith("GAU_SELL=")) { newLines.add("GAU_SELL=" + GAU_SELL); gauSellFound = true; }
                else { newLines.add(line); } // Tarih, admin pass vs. elleme
            }

            // Eğer dosyada bu satırlar hiç yoksa sona ekle (İlk kurulum için)
            if (!usdBuyFound) newLines.add("USD_BUY=" + USD_BUY);
            if (!usdSellFound) newLines.add("USD_SELL=" + USD_SELL);
            if (!eurBuyFound) newLines.add("EUR_BUY=" + EUR_BUY);
            if (!eurSellFound) newLines.add("EUR_SELL=" + EUR_SELL);
            if (!gauBuyFound) newLines.add("GAU_BUY=" + GAU_BUY);
            if (!gauSellFound) newLines.add("GAU_SELL=" + GAU_SELL);

            Files.write(Paths.get(CONFIG_FILE), newLines);
            System.out.println(" Yeni kurlar config.txt dosyasına kaydedildi.");

        } catch (IOException e) {
            System.out.println(" Kurlar dosyaya kaydedilemedi: " + e.getMessage());
        }
    }

    // --- GETTER METOTLARI (Artık switch ile değişkeni döndürüyor) ---
    public static double getBuyRate(String currencyType) {
        switch (currencyType.toUpperCase()) {
            case "USD": return USD_BUY;
            case "EUR": return EUR_BUY;
            case "GAU": return GAU_BUY;
            default: return 1.0;
        }
    }

    public static double getSellRate(String currencyType) {
        switch (currencyType.toUpperCase()) {
            case "USD": return USD_SELL;
            case "EUR": return EUR_SELL;
            case "GAU": return GAU_SELL;
            default: return 1.0;
        }
    }

    // Admin menüsü için getter'lar
    public static double getUsdBuy() { return USD_BUY; }
    public static double getUsdSell() { return USD_SELL; }
    public static double getEurBuy() { return EUR_BUY; }
    public static double getEurSell() { return EUR_SELL; }
    public static double getGauBuy() { return GAU_BUY; }
    public static double getGauSell() { return GAU_SELL; }
}