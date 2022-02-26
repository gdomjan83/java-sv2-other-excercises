package zarovizsga1.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        return readFile(Paths.get(file));
    }

    private String readFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            String result = findSmallestHour(lines);
            String[] parts = result.split(",");
            return parts[0] + ": " + parts[2];
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found.", ioe);
        }
    }

    private String findSmallestHour(List<String> lines) {
        int minHour = Integer.MAX_VALUE;
        String result = lines.get(0);
        for (String actual : lines) {
            String[] parts = actual.split(",");
            int hour = Integer.parseInt(parts[1]);
            if (hour < minHour) {
                minHour = hour;
                result = actual;
            }
        }
        return result;
    }





}
