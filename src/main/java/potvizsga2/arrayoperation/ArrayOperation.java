package potvizsga2.arrayoperation;

public class ArrayOperation {

    public String getWordsBackwards(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (i != words.length - 1) {
                sb.append(", ");
            }
            sb.append(words[i]);
        }
        return new String(sb);
    }
}
