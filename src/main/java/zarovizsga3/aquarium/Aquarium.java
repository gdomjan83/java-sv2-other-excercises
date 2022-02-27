package zarovizsga3.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> aquarium = new ArrayList<>();

    public void addFish(Fish fish) {
        if (fish != null) {
            aquarium.add(fish);
        }
    }

    public void feed() {
        for (Fish actual : aquarium) {
            actual.feed();
        }
    }

    public void removeFish() {
        List<Fish> toRemove = new ArrayList<>();
        for (Fish actual : aquarium) {
            if (actual.getWeight() >= 11) {
                toRemove.add(actual);
            }
        }
        aquarium.removeAll(toRemove);
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish actual : aquarium) {
            result.add(actual.status());
        }
        return result;
    }
}
