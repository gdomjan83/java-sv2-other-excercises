package potvizsga3.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {
    private List<String> sentences = new ArrayList<>();
    private String closingCharacter = ".?!";

    public List<String> getSentences() {
        return sentences;
    }

    public void addSentence(String sentence) {
        char first = sentence.toCharArray()[0];
        char last = sentence.toCharArray()[sentence.length() - 1];
        checkFirstAndLastCharacter(first, last);
        sentences.add(sentence);
    }

    public String findLongestSentence() {
        checkEmptyList(sentences);
        String longest = sentences.get(0);
        for (String actual : sentences) {
            if (actual.length() > longest.length()) {
                longest = actual;
            }
        }
        return longest;
    }

    private boolean isFirstUppercase(char first) {
        return Character.isUpperCase(first);
    }

    private boolean hasEndingMark(char last) {
        return closingCharacter.contains(String.valueOf(last));
    }

    private void checkEmptyList(List<String> sentences) {
        if (sentences == null || sentences.size() == 0) {
            throw new IllegalStateException("The input list is null or empty.");
        }
    }

    private void checkFirstAndLastCharacter(char first, char last) {
        if (!isFirstUppercase(first)) {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        if (!hasEndingMark(last)) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
    }
}
