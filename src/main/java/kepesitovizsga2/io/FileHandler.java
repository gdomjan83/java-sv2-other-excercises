package kepesitovizsga2.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {

    public int sumIgnoreComments(String path) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            return sumNumbers(br);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file.", ioe);
        }
    }

    private int sumNumbers(BufferedReader bufferedReader) throws IOException {
        String line;
        int sum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.startsWith("//")) {
                sum += Integer.parseInt(line.trim());
            }
        }
        return sum;
    }
}
