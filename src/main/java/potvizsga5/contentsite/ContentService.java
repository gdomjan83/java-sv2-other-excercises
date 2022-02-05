package potvizsga5.contentsite;

import java.util.HashSet;
import java.util.Set;

public class ContentService {
    private Set<User> allUsers = new HashSet<>();
    private Set<Content> allContent = new HashSet<>();

    public void registerUser(String name, String password) {
        if (isUserNameAvailable(name)) {
            allUsers.add(new User(name, password));
        } else {
            throw new IllegalArgumentException("Username is already taken: " + name);
        }
    }

    public Set<User> getAllUsers() {
        return new HashSet<>(allUsers);
    }

    public Set<Content> getAllContent() {
        return new HashSet<>(allContent);
    }

    public void addContent(Content content) {
        if (!contentExists(content.getTitle())) {
            allContent.add(content);
        } else {
            throw new IllegalArgumentException("Content name is already taken: " + content.getTitle());
        }
    }

    public void logIn(String username, String password) {
        int pass = (username + password).hashCode();
        checkLoginError(username, pass);
        getUserForLogin(username, pass).setLogIn(true);
    }

    public void clickOnContent(User user, Content content) {
        checkLogin(user);
        checkPremium(user, content);
        content.click(user);
    }

    private void checkLoginError(String username, int password) {
        if (!allUsers.stream().anyMatch(u -> username.equals(u.getUserName()))) {
            throw new IllegalArgumentException("Username is wrong!");
        }
        if (!allUsers.stream().anyMatch(u -> username.equals(u.getUserName()) && password == u.getPassword())) {
            throw new IllegalArgumentException("Password is Invalid!");
        }
    }

    private void checkPremium(User user, Content content) {
        if (content.isPremiumContent() && !user.isPremiumMember()) {
            throw new IllegalStateException("Upgrade for Premium to watch this content!");
        }
    }

    private void checkLogin(User user) {
        if (!user.isLogIn()) {
            throw new IllegalStateException("Log in to watch this content!");
        }
    }

    private User getUserForLogin(String username, int password) {
        return allUsers.stream()
                .filter(u -> username.equals(u.getUserName()) && password == u.getPassword())
                .findFirst()
                .get();
    }

    private boolean isUserNameAvailable(String name) {
        return !allUsers.stream()
                .anyMatch(u -> name.equals(u.getUserName()));
    }

    private boolean contentExists(String name) {
        return allContent.stream()
                .anyMatch(c -> name.equals(c.getTitle()));
    }
}
