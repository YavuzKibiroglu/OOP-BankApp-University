package model;

public class CheckingAccount extends Account{


    public CheckingAccount(String userId,String ibanNumber,int moneyInAccount) {
        this.userId = userId;
        this.ibanNumber = ibanNumber;
        this.moneyInAccount = moneyInAccount;
    }

    @Override
    public String getInformation() {
        return "";
    }
}
