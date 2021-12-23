package potvizsga4.filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserFileManager {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void readUsersFromFile(Path path) {
        try {
            List<String> userData = Files.readAllLines(path);
            for (String line : userData) {
                users.add(createUser(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, getDataToWrite());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    private List<String> getDataToWrite() {
        List<String> dataToWrite = new ArrayList<>();
        for (User actual : users) {
            if (actual.getUserName().equalsIgnoreCase(actual.getNameFromEmail())) {
                dataToWrite.add(actual.getUserName());
            }
        }
        return dataToWrite;
    }

    private User createUser(String line) {
        String[] parts = new String[3];
        parts = line.split(" ");
        return new User(parts[0], parts[1], parts[2]);
    }
}
