package model;

public abstract class User implements IUserOperations {
    // Encapsulation: Değişkenler private [cite: 37]
    private String userId;
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    // Getter ve Setter Metotları [cite: 38]
    @Override
    public String getUserId() {
        return userId;
    }

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

