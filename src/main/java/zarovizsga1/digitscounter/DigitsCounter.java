package zarovizsga1.digitscounter;

import java.util.HashSet;

public class DigitsCounter {
    public int getCountOfDigits(String s) {
        if (s == null) {
            return 0;
        }
        HashSet<Character> digits = new HashSet();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            }
        }
        return digits.size();
    }
}
