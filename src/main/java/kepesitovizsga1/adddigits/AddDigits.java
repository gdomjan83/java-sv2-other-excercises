package kepesitovizsga1.adddigits;

public class AddDigits {
    public int addDigits(String input) {
        int sum = 0;
        if (!stringIsEmptyOrNull(input)) {
            sum = sumDigits(input);
        } else {
            sum = -1;
        }
        return sum;
    }

    private boolean stringIsEmptyOrNull(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private int sumDigits(String input) {
        int total = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                total += Integer.parseInt(String.valueOf(c));
            }
        }
        return total;
    }
}
