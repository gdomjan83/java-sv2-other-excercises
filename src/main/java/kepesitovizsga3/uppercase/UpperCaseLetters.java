package kepesitovizsga3.uppercase;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UpperCaseLetters {
    public int getNumberOfUpperCase(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            return readLines(br);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file.", ioe);
        }
    }

    private int readLines(BufferedReader bufferedReader) throws IOException {
        String line;
        int numberOfUppercase = 0;
        while ((line = bufferedReader.readLine()) != null) {
            numberOfUppercase += countUpperCase(line);
        }
        return numberOfUppercase;
    }

    private int countUpperCase(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
}
