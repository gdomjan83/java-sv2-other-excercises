package potvizsga2.everysecond;

public class EverySecond {

    public String getEverySecondLetter(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        return new String(sb);
    }
}
