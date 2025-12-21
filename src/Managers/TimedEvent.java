package Managers;

import java.time.LocalDate;

// İSTER 1: En az 1 generic sınıf tanımlanmalıdır. (Örn: TimedEvent<T>)
public class TimedEvent<T> {
    private T eventData;
    private LocalDate eventDate;

    public TimedEvent(T eventData) {
        this.eventData = eventData;
        // Olay oluşturulduğunda sistemin o anki tarihini alır
        this.eventDate = TimeManager.getCurrentDate();
    }

    public T getEventData() {
        return eventData;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    @Override
    public String toString() {
        return "[" + eventDate + "] Olay: " + eventData;
    }
}
