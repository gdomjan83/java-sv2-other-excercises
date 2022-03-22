package kepesitovizsga3.numberofdigits;

public class NumberOfDigits {
    public int getNumberOfDigits(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            sb.append(i);
        }
        return sb.toString().length();
    }
}
