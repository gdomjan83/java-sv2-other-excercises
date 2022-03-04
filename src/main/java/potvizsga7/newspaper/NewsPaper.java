package potvizsga7.newspaper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NewsPaper {
    private String name;
    private Set<Article> articles = new TreeSet<>();

    public NewsPaper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return new TreeSet<>(articles);
    }

    public void addArticle(Article article) {
        if (article != null) {
            articles.add(article);
        }
    }

    public List<Article> findArticlesByAuthor(String author) {
        return articles.stream()
                .filter(a -> author.equals(a.getAuthor()))
                .toList();
    }

    public List<Article> findArticleByParagraphPart(String searched) {
        List<Article> result = new ArrayList<>();
        for (Article actual : articles) {
            checkIfArticleContainsLine(actual, result, searched);
        }
        return result;
    }

    private void checkIfArticleContainsLine(Article article, List<Article> result, String searched) {
        for (String line : article.getParagraphs()) {
            if (line.contains(searched) && !result.contains(article)) {
                result.add(article);
            }
        }
    }
}
