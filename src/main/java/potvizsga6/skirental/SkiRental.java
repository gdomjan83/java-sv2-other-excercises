package potvizsga6.skirental;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SkiRental {
    private Map<String, Equipment> rentals = new TreeMap<>();

    public Map<String, Equipment> getRentals() {
        return new HashMap<>(rentals);
    }

    public void loadFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.readLine();
            readLines(br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file: " + path.toString(), ioe);
        }
    }

    private void readLines(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            int ski = Integer.valueOf(parts[1].split(" ")[0]);
            int boot = Integer.valueOf(parts[1].split(" ")[1]);
            rentals.put(parts[0], new Equipment(ski, boot));
        }
    }


    public List<String> listChildren() {
        return rentals.entrySet().stream()
                .filter(e -> e.getValue().isChildSize())
                .map(e -> e.getKey())
                .toList();
    }

    public String getNameOfPeopleWithBiggestFoot() {
        List<String> filteredNames = rentals.entrySet().stream()
                .filter(e -> e.getValue().hasRentedBoth())
                .sorted(Comparator.comparing(e -> e.getKey()))
                .sorted(Comparator.comparingInt(e -> e.getValue().getSizeOfBoot()))
                .map(Map.Entry::getKey)
                .toList();
        return filteredNames.get(filteredNames.size() - 1);
    }
}
