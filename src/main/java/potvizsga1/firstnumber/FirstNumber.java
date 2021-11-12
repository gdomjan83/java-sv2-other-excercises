package potvizsga1.firstnumber;

public class FirstNumber {
    public char getFirstNumber(String s) {
        for (Character letter : s.toCharArray()) {
            if (letter >= '0' && letter <= '9') {
                return letter;
            }
        }
        return ' ';
    }
}
