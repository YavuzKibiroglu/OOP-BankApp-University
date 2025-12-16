package model;

public abstract class Account {
    protected  String userId;
    protected String ibanNumber;

    protected int moneyInAccount;

    public abstract String getInformation();

}
