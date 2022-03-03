package potvizsga7.numbers;

public class ArmstrongNumbers {
    public boolean isArmstrongNumber(int number) {
        validateNumber(number);
        String input = String.valueOf(number);
        return number == digitPower(input, input.length());
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number can't be negative: " + number);
        }
    }

    private double digitPower(String input, int length) {
        int sum = 0;
        for (char digit : input.toCharArray()) {
            sum += Math.pow(Integer.parseInt(Character.toString(digit)), length);
        }
        return sum;
    }
}
