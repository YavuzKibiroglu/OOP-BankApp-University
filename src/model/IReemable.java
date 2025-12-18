package model;

import java.sql.SQLException;

public interface IReemable{
    public void transferToCurrent(float moneyAmount,String accountId) throws SQLException;

    public void transferToCurrent(float moneyAmount) throws SQLException;

}
