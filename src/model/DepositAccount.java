package model;

public class DepositAccount extends Account {

    public DepositAccount(String userId,String ibanNumber,int moneyInAccount) {
        this.userId = userId;
        this.ibanNumber = ibanNumber;
        this.moneyInAccount = moneyInAccount;
    }
    @Override
    public String getInformation() {
        return "";
    }
}
