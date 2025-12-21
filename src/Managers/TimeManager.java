package Managers;

import java.io.*;
import java.time.LocalDate;
import java.util.Properties;

public class TimeManager {

    private static final String CONFIG_FILE = "config.txt";
    private static Properties properties = new Properties();

    // 1. SİSTEM TARİHİNİ GETİR
    public static LocalDate getCurrentDate() {
        loadConfig();
        String dateStr = properties.getProperty("DATE");
        if (dateStr == null) {
            dateStr = LocalDate.now().toString(); // Dosya yoksa bugün
        }
        return LocalDate.parse(dateStr);
    }

    // 2. ADMIN GİRİŞ KONTROLÜ
    public static boolean checkAdminCredentials(String user, String pass) {
        loadConfig();
        String realUser = properties.getProperty("ADMIN_USER", "admin");
        String realPass = properties.getProperty("ADMIN_PASS", "1234");
        return realUser.equals(user) && realPass.equals(pass);
    }

    // 3. ZAMANI İLERİ SAR VE KAYDET
    public static void advanceDate(int days) {
        LocalDate currentDate = getCurrentDate();
        LocalDate newDate = currentDate.plusDays(days);

        properties.setProperty("DATE", newDate.toString());
        saveConfig();
        System.out.println("Sistem Tarihi Güncellendi: " + newDate);
    }

    private static void loadConfig() {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
        } catch (IOException e) { /* Dosya yoksa sorun yok */ }
    }

    private static void saveConfig() {
        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            properties.store(fos, "Bank System Config");
        } catch (IOException e) { e.printStackTrace(); }
    }
}