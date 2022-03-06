package potvizsga8.numbers;

import java.util.List;

public class RisingNumbers {
    public int getNumberOfSixDigitRisingNumbers(List<Integer> numbers) {
        int count = 0;
        checkEmptyListOrNull(numbers);
        List<Integer> sixDigits = numbers.stream().filter(n -> String.valueOf(n).length() == 6).toList();
        for (Integer i : sixDigits) {
            if (isRising(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isRising(Integer number) {
        char[] num = String.valueOf(number).toCharArray();
        for (int i = 0; i < 5; i++) {
            if (Integer.parseInt(String.valueOf(num[i])) >= Integer.parseInt(String.valueOf(num[i + 1]))) {
                return false;
            }
        }
        return true;
    }

    private void checkEmptyListOrNull(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("There are no numbers!");
        }
    }
}
