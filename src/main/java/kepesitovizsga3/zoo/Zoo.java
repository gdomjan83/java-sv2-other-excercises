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

    public void loadAnimals() {
        int rows = jdbcTemplate.queryForObject("select count(id) from animals", (rs, i) -> rs.getInt("count(id)"));
        for (int i = 1; i <= rows; i++) {
            addAnimal(getAnimalFromDB(i));
        }
    }

    public void addAnimalToDatabase(ZooAnimal animal) {
        jdbcTemplate.update("insert into animals (animal_name, length_of_member, weight, animal_type) values (?, ?, ?, ?)",
                animal.getName(), animal.getLength(), animal.getWeight(), animal.getType().name());
    }

    private ZooAnimal getAnimalFromDB(int row) {
        return jdbcTemplate.queryForObject("select * from animals where id = ?",
                (rs, i) -> createAnimal(
                        rs.getString("animal_name"),
                        rs.getInt("length_of_member"),
                        rs.getLong("weight"),
                        rs.getString("animal_type")), row);
    }

    private ZooAnimal createAnimal(String name, int length, long weight, String type) {
        switch(AnimalType.valueOf(type)) {
            case ELEPHANT:
                return new Elephant(name, length, weight);
            case GIRAFFE:
                return new Giraffe(name, length);
            case LION:
                return new Lion(name);
            default:
                throw new IllegalArgumentException("Animal type incorrect.");
        }
    }
}
