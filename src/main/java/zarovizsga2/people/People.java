package zarovizsga2.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class People {
    public int getNumberOfMales(String path) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            br.readLine();
            return countMales(br);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file.", ioe);
        }
    }

    private int countMales(BufferedReader br) throws IOException {
        String line;
        int maleCount = 0;
        while ((line = br.readLine()) != null) {
            if ("Male".equalsIgnoreCase(line.split(",")[4])) {
                maleCount++;
            }
        }
        return maleCount;
    }
}
