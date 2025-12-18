package Managers;

public class CurrencyManager {

    // Kurlar (Simülasyon)
    // Gerçek hayatta bunlar API'den çekilir veya Admin panelinden güncellenir (Source 238)

    // DOLAR
    public static final double USD_BUY = 32.50; // Bankanın alış fiyatı (Biz satarken)
    public static final double USD_SELL = 33.20; // Bankanın satış fiyatı (Biz alırken)

    // EURO
    public static final double EUR_BUY = 35.00;
    public static final double EUR_SELL = 35.80;

    // ALTIN (Gram)
    public static final double GOLD_BUY = 2400.0;
    public static final double GOLD_SELL = 2450.0;

    // Döviz türüne göre SATIŞ kurunu getirir (Kullanıcı Döviz ALIRKEN bu fiyatı öder)
    public static double getSellRate(String currencyType) {
        switch (currencyType.toUpperCase()) {
            case "USD": return USD_SELL;
            case "EUR": return EUR_SELL;
            case "GOLD": return GOLD_SELL;
            default: return 1.0;
        }
    }

    // Döviz türüne göre ALIŞ kurunu getirir (Kullanıcı Döviz SATARKEN bu fiyattan bozar)
    public static double getBuyRate(String currencyType) {
        switch (currencyType.toUpperCase()) {
            case "USD": return USD_BUY;
            case "EUR": return EUR_BUY;
            case "GOLD": return GOLD_BUY;
            default: return 1.0;
        }
    }
}
