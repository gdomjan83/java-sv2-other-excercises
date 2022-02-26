package zarovizsga1.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void feedAll() {
        for (Dog actual : dogs) {
            actual.feed();
        }
    }

    public Dog findByName(String name) {
        return dogs.stream()
                .filter(d -> name.equals(d.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No dog found by that name."));
    }

    public void playWith(String name, int hours) {
        Dog dog = findByName(name);
        dog.play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        return dogs.stream()
                .filter(d -> d.getHappiness() > minHappiness)
                .map(d -> d.getName())
                .toList();
    }
}
