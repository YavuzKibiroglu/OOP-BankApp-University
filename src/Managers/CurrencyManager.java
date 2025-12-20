package Managers;

public class CurrencyManager {

    // Kurlar
    public static final double USD_BUY = 32.50;
    public static final double USD_SELL = 32.85;

    public static final double EUR_BUY = 35.10;
    public static final double EUR_SELL = 35.60;

    // Değişken isimlerini de ALTIN yapalım karışıklık olmasın
    public static final double ALTIN_BUY = 2450.0;
    public static final double ALTIN_SELL = 2500.0;

    public static double getBuyRate(String type) {
        switch(type) {
            case "USD": return USD_BUY;
            case "EUR": return EUR_BUY;
            case "ALTIN": return ALTIN_BUY; // <-- Burası "ALTIN" olmalı
            case "GOLD": return ALTIN_BUY;  // (Eski kayıtlar varsa diye yedek)
            default: return 0;
        }
    }

    public static double getSellRate(String type) {
        switch(type) {
            case "USD": return USD_SELL;
            case "EUR": return EUR_SELL;
            case "ALTIN": return ALTIN_SELL; // <-- Burası "ALTIN" olmalı
            case "GOLD": return ALTIN_SELL;
            default: return 0;
        }
    }
}