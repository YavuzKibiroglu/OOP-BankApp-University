package model;

public abstract class User {
    // Encapsulation: Değişkenler private [cite: 37]
    private String userId;
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    // Getter ve Setter Metotları [cite: 38]
    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String getInformation();
}

