package model;

import java.time.LocalDate;

public class Invoice {
    private String invoiceId;
    private String subscriptionId;
    private float amount;
    private LocalDate dueDate;
    private boolean isPaid;

    public Invoice(String invoiceId, String subscriptionId, float amount, LocalDate dueDate, boolean isPaid) {
        this.invoiceId = invoiceId;
        this.subscriptionId = subscriptionId;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = isPaid;
    }

    public String getInvoiceId() { return invoiceId; }
    public String getSubscriptionId() { return subscriptionId; }
    public float getAmount() { return amount; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isPaid() { return isPaid; }
}
