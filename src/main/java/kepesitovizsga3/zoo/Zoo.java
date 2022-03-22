package kepesitovizsga3.zoo;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.*;

public class Zoo {
    private Set<ZooAnimal> animals = new HashSet<>();
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public Zoo() {
    }

    public Zoo(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Set<ZooAnimal> getAnimals() {
        return new HashSet<>(animals);
    }

    public void addAnimal(ZooAnimal animal) {
        if (animal != null) {
            animals.add(animal);
        }
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        return animals.stream()
                .max(Comparator.comparingLong(ZooAnimal::getWeight))
                .orElseThrow(() -> new IllegalStateException("No animal found."));
    }

    public long countWeights() {
        return animals.stream()
                .mapToLong(ZooAnimal::getWeight)
                .sum();
    }

    public ZooAnimal findExactAnimal(ZooAnimal animal) {
        return animals.stream()
                .filter(a -> animal.equals(a))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public ZooAnimal findExactAnimalByName(String name) {
        return animals.stream()
                .filter(a -> name.equals(a.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        return animals.stream()
                .sorted(Comparator.comparing(ZooAnimal::getName))
                .toList();
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        Map<AnimalType, Integer> animalTypes = new HashMap<>();
        for (ZooAnimal actual : animals) {
            AnimalType key = actual.getType();
            if (animalTypes.containsKey(key)) {
                animalTypes.put(key, animalTypes.get(key) + 1);
            } else {
                animalTypes.put(key, 1);
            }
        }
        return animalTypes;
    }
}
