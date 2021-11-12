package potvizsga1.reversedorder;

public class ReversedOrder {
    public String getWordsInReversedOrder(String[] words) {
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(", ");
            }
        }
        return new String(sb);
    }
}
