package potvizsga5.examinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExamService {
    private Map<String, ExamResult> results = new TreeMap<>();
    private int theoryMax;
    private int practiceMax;

    public Map<String, ExamResult> getResults() {
        return new TreeMap<>(results);
    }

    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();
            parseMaxPoints(line);
            while((line = br.readLine()) != null) {
                parseExamResults(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: " + path, ioe);
        }
    }

    public List<String> findPeopleFailed() {
        return results.entrySet().stream()
                .filter(e -> !passedExam(practiceMax, e.getValue().getPractice()) ||
                        !passedExam(theoryMax, e.getValue().getTheory()))
                .map(e -> e.getKey())
                .toList();
    }

    public String findBestPerson() {
        List<String> failed = findPeopleFailed();
        return results.entrySet().stream()
                .filter(e -> !failed.contains(e.getKey()))
                .sorted(((o1, o2) -> (o2.getValue().getTheory() + o2.getValue().getPractice()) - (o1.getValue().getPractice() + o1.getValue().getTheory())))
                .map(e -> e.getKey())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No result found."));
    }

    private void parseMaxPoints(String line) {
        theoryMax = Integer.parseInt(line.split(" ")[0]);
        practiceMax = Integer.parseInt(line.split(" ")[1]);
    }

    private void parseExamResults(String line) {
        String[] lineParsed = line.split(";");
        results.put(lineParsed[0], new ExamResult(Integer.parseInt(lineParsed[1].split(" ")[0]),
                Integer.parseInt(lineParsed[1].split(" ")[1])));
    }

    private boolean passedExam (int maxPoint, int actualPoint) {
        return ((double) actualPoint / maxPoint) >= 0.51;
    }
}
