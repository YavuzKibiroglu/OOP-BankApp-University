package Managers;

import java.time.LocalDate;

public class TimeManager {
    // Simülasyonun başladığı tarih (Bugün)
    private static LocalDate currentSystemDate = LocalDate.now();

    // Sistemin şu anki tarihini getir
    public static LocalDate getCurrentDate() {
        return currentSystemDate;
    }

    // Zamanı ileri sar
    public static void fastForward(int days) {
        currentSystemDate = currentSystemDate.plusDays(days);
        System.out.println("Yeni Tarih: " + currentSystemDate);
    }
}
