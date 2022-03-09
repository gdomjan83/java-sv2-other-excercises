package potvizsga8.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ExamLearnings {
    private Map<String, Integer> learnings = new HashMap<>();

    public Map<String, Integer> getLearnings() {
        return new HashMap<>(learnings);
    }

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                learnings.put(data[0], sumLearningTime(data));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file.", ioe);
        }
    }

    public double getAverageLearningInMinutes() {
        return learnings.values().stream()
                .mapToDouble(v -> v)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("There are no learning times."));
    }

    private int sumLearningTime(String[] data) {
        int sum = 0;
        for (int i = 1; i < data.length; i++) {
            String replaced = data[i].replace(',', '.');
            sum += 60 * Double.parseDouble(replaced);
        }
        return sum;
    }
}
