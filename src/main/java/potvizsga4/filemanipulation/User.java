package potvizsga4.filemanipulation;

public class User {
    private String userName;
    private String yearOfBirth;
    private String email;

    public User(String userName, String yearOfBirth, String email) {
        this.userName = userName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getNameFromEmail() {
        int indexOfAt = email.indexOf("@");
        if (indexOfAt != -1) {
            return email.substring(0, indexOfAt);
        }
        return "";
    }
}
