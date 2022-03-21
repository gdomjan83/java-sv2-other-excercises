package kepesitovizsga2.lettermultiplier;

public class LetterMultiplier {
    public String multiply(String input, int number) {
        validateInput(input, number);
        StringBuilder sb = new StringBuilder();
        for (Character c : input.toCharArray()) {
            sb.append(c.toString().repeat(number));
        }
        return sb.toString();
    }

    private void validateInput(String input, int number) {
        if (input == null || input.isBlank() || number < 0) {
            throw new IllegalArgumentException("Input is invalid.");
        }
    }

}
