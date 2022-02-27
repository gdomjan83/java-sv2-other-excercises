package zarovizsga2.words;

public class Words {
    public boolean hasMoreDigits(String s) {
        if (s == null) {
            return false;
        }
        int digitCounter = 0;
        for (Character actual : s.toCharArray()) {
            if (Character.isDigit(actual)) {
                digitCounter++;
            }
        }
        return digitCounter > (s.length() - digitCounter);
    }
}
