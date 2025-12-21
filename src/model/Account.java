package model;

import java.sql.SQLException;

public abstract class Account implements IReemable {
    protected String userId;
    protected String accountId;
    protected float moneyInAccount;

    public Account(String userId, String accountId, float moneyInAccount) {
        this.userId = userId;
        this.accountId = accountId;
        this.moneyInAccount = moneyInAccount;
    }

    public Account() {}

    public abstract boolean withdraw(double amount) throws Exceptions.YetersizBakiyeException;

    public void deposit(double amount) {
        this.moneyInAccount += amount;
    }

    // --- Diğer Getter/Setter ve Metotlar ---
    @Override
    public void transferToCurrent(float moneyAmount, String accountId) throws SQLException {}

    public float getMoneyInAccount() { return moneyInAccount; }
    public void setMoneyInAccount(float moneyAmount) { this.moneyInAccount = moneyAmount; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getAccountId() { return accountId; }

    public abstract String getInformation();
}