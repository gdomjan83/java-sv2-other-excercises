package potvizsga7.newspaper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Article implements Comparable<Article> {
    private String author;
    private Header header;
    private List<String> paragraphs;

    public Article(String author, Header header, List<String> paragraphs) {
        this.author = author;
        this.header = header;
        this.paragraphs = paragraphs;
    }

    public String getAuthor() {
        return author;
    }

    public Header getHeader() {
        return new Header(header.getContent(), header.getLevel());
    }

    public List<String> getParagraphs() {
        return new ArrayList<>(paragraphs);
    }

    public abstract int getImportance();

    @Override
    public int compareTo(Article other)  {
        return other.getImportance() - getImportance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return header.getContent().equals(article.header.getContent()) && paragraphs.equals(article.paragraphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, paragraphs);
    }
}
