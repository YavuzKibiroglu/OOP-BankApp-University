package Managers;

import java.util.List;
import java.util.ArrayList;

public class EventUtils {

    // Gönderilen listedeki son olayı getirir. T tipi neyse onu döner.
    public static <T> T getLastEventData(List<TimedEvent<T>> events) {
        if (events == null || events.isEmpty()) {
            return null;
        }
        return events.get(events.size() - 1).getEventData();
    }

    // Generic bir nesneyi listeye eklerken konsola bilgi basan yardımcı metot.
    public static <T> void logAndAdd(List<TimedEvent<T>> list, T data) {
        TimedEvent<T> newEvent = new TimedEvent<>(data);
        list.add(newEvent);
        System.out.println("Kayıt Eklendi: " + newEvent);
    }

    // Hangi tipte TimedEvent tuttuğu fark etmeksizin listeyi ekrana basar.
    public static void printHistory(List<? extends TimedEvent<?>> historyLog) {
        System.out.println("--- Simülasyon Geçmişi ---");
        for (TimedEvent<?> event : historyLog) {
            System.out.println(event); // toString metodunu çağırır
        }
        System.out.println("--------------------------");
    }

    // List<? extends Number>
    public static double sumNumericalEvents(List<? extends Number> numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
