package potvizsga6.emailservice;

import java.lang.reflect.Array;
import java.util.*;

public class User {
    private String emailAddress;
    private List<Email> incoming = new ArrayList<>();
    private List<Email> sent = new ArrayList<>();
    private boolean hasSpamFilter;

    public User(String email) {
        this.emailAddress = email;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Email> getIncoming() {
        ArrayList<Email> sortedList = new ArrayList<>(incoming);
        Collections.sort(sortedList, Comparator.comparing((Email e) -> e.isImportant()).reversed());
        return sortedList;
    }

    public List<Email> getSent() {
        return new ArrayList<>(sent);
    }

    public boolean hasSpamFilter() {
        return hasSpamFilter;
    }

    public void getEmail(Email email) {
        if (hasSpamFilter && email.getFrom().getEmailAddress().contains("spam")) {
            throw new IllegalStateException("Be careful, tis is a spam!");
        }
        incoming.add(email);
    }

    public void sendEmail(String subject, String content, User to) {
        Normal sentEmail = new Normal(this, to, subject, content);
        sent.add(sentEmail);
        to.getEmail(sentEmail);
    }

    public void spamFilterChange() {
        hasSpamFilter = hasSpamFilter ? false : true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(emailAddress, user.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }
}
