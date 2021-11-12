package potvizsga1.sumofdigits;

public class SumOfDigits {
    public int getSumOfDigits(int number) {
        int sum = 0;

        for (char digit : String.valueOf(number).toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }
}
