package potvizsga5.contentsite;

public class User {
    private String userName;
    private int password;
    private boolean isPremiumMember;
    private boolean isLogIn;

    public User(String name, String password) {
        this.userName = name;
        this.password = (name + password).hashCode();
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return password;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public boolean isLogIn() {
        return isLogIn;
    }

    public void upgradeForPremium() {
        isPremiumMember = true;
    }

    public void setLogIn(boolean value) {
        isLogIn = value;
    }
}
