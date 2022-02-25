package potvizsga6.emailservice;

import java.util.HashSet;

public class EmailService {
    private HashSet<User> users = new HashSet<>();

    public HashSet<User> getUsers() {
        return new HashSet<>(users);
    }

    public void registerUser(String emailAddress) {
        if (!isValidEmail(emailAddress)) {
            throw new IllegalArgumentException("Email address is not valid: " + emailAddress);
        }
        users.add(new User(emailAddress));
    }

    public void sendEmail(String from, String to, String subject, String content) {
        User sender = users.stream().filter(u -> from.equals(u.getEmailAddress())).findFirst().orElseThrow(() -> new IllegalStateException("Sender not found."));
        User receiver = users.stream().filter(u -> to.equals(u.getEmailAddress())).findFirst().orElseThrow(() -> new IllegalStateException("Recipient not found."));
        sender.sendEmail(subject, content, receiver);
    }

    public void sendSpam(String subject, String content) {
        for (User actual : users) {
            Spam spam = new Spam(actual, subject, content);
            actual.getEmail(spam);
        }
    }

    private boolean isValidEmail(String emailAddress) {
        int atIndex = emailAddress.indexOf("@");
        int periodIndex = emailAddress.indexOf(".");

        if (!emailAddress.equals(emailAddress.toLowerCase())) {
            return false;
        }

        if (users.contains(new User(emailAddress))) {
            throw new IllegalArgumentException("Email address is already taken!");
        }
        return (atIndex > 0 && periodIndex > atIndex + 1);
    }
}
