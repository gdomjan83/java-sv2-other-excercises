package potvizsga7.newspaper;

import java.util.List;

public class YellowPressArticle extends Article {
    public static final int IMPORTANCE = 1;

    public YellowPressArticle(String author, Header header, List<String> paragraphs) {
        super(author, header, paragraphs);
        validateHeaderLevel(header);
    }

    private void validateHeaderLevel(Header header) {
        if (header.getLevel() > 5) {
            throw new IllegalArgumentException("Header size cannot be greater than 5!");
        }
    }

    @Override
    public int getImportance() {
        return IMPORTANCE;
    }
}
