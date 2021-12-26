package potvizsga4.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWords(String word1, String... otherWords) {
       words.add(word1);
       for (String actual : otherWords) {
           words.add(actual);
       }
    }


    public List<String> findWordsOccursOnes() {
        List<String> result = new ArrayList<>();
        for (String actual : words) {
            if (countOccurences(actual) == 1) {
                result.add(actual);
            }
        }
        return result;
    }

    private int countOccurences(String word) {
        int count = 0;
        for (String actual : words) {
            if (word.equals(actual)) {
                count++;
            }
        }
        return count;
    }
}
