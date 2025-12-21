package model;

import java.time.LocalDate;

public class Subscription {
    private String subscriptionId;
    private String subscriberUserId; // Bireysel Müşteri ID
    private String companyUserId;    // Kurumsal Şirket ID
    private String serviceName;      // Örn: Netflix, Enerjisa, İSKİ
    private Boolean isActive;        // Hizmet açık mı kesik mi?
    private LocalDate startDate;

    public Subscription(String subscriptionId, String subscriberUserId, String companyUserId, String serviceName, boolean isActive, LocalDate startDate) {
        this.subscriptionId = subscriptionId;
        this.subscriberUserId = subscriberUserId;
        this.companyUserId = companyUserId;
        this.serviceName = serviceName;
        this.isActive = isActive;
        this.startDate = startDate;
    }

    // Getter Metotları
    public String getSubscriptionId() { return subscriptionId; }
    public String getSubscriberUserId() { return subscriberUserId; }
    public String getCompanyUserId() { return companyUserId; }
    public String getServiceName() { return serviceName; }
    public boolean isActive() { return isActive; }
    public LocalDate getStartDate() { return startDate; }

    // Durum güncelleme (Hizmet kesme/açma için)
    public void setActive(boolean active) { isActive = active; }

    public String getInformation() {
        return String.format("Hizmet: %s | Durum: %s | Başlangıç: %s",
                serviceName, isActive ? "AKTİF" : "KESİK", startDate);
    }
}
