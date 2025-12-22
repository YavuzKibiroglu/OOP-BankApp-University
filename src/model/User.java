package model;

import java.time.LocalDate;

public abstract class User implements IUserOperations {
    // Encapsulation: Değişkenler private
    private String userId;
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    // Getter ve Setter Metotları
    @Override
    public String getUserId() {
        return userId;
    }

    //public String getUserId() { return tcKimlik; }
    public abstract LocalDate getBirthDate();

    @Override
    public String getInformation()
    {

        return "";
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

