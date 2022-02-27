package zarovizsga3.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DaVinciCode {
    public int encode(String path, char character) {
        validateCharacter(character);
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count += readLineAndCountCharacers(line, character);
            }
            return count;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file.", ioe);
        }
    }

    private int readLineAndCountCharacers(String line, char character) {
        int counter = 0;
        for (char c : line.toCharArray()) {
            if (c == character) {
                counter++;
            }
        }
        return counter;
    }

    private void validateCharacter(char character) {
        if (!"01x".contains(Character.toString(character))) {
            throw new IllegalArgumentException("Invalid character.");
        }
    }
}
