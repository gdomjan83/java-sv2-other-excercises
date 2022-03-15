package kepesitovizsga1.phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        validateInput(contacts, output);
        List<String> entries = new ArrayList<>();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            addEntry(entry, entries);
        }
        writeFile(output, entries);
    }

    private String createEntry(Map.Entry<String, String> entry) {
        return entry.getKey() + ": " + entry.getValue();
    }

    private void writeFile(String output, List<String> entries) {
        try {
            Files.write(Paths.get(output), entries);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not write file.", ioe);
        }
    }

    private void addEntry(Map.Entry<String, String> entry, List<String> entries) {
        String input = createEntry(entry);
        if (!entries.contains(input)) {
            entries.add(input);
        }
    }

    private void validateInput(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException("Input parameter is null.");
        }
    }
}
