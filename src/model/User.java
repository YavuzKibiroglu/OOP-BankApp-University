package model;

public abstract class User {
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public abstract String getInformation();

}

