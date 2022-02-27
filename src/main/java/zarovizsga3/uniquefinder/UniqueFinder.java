package zarovizsga3.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    public List<Character> uniqueChars(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word is null.");
        }
        List<Character> characters = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            if (!characters.contains(c)) {
                characters.add(c);
            }
        }
        return characters;
    }
}
