package potvizsga5.contentsite;

import java.util.ArrayList;
import java.util.List;

public class Podcast implements Content {
    private String title;
    private List<String> speakers;
    private List<User> clickedBy = new ArrayList<>();

    public Podcast(String title, List<String> speakers) {
        this.title = title;
        this.speakers = speakers;
    }

    public List<String> getSpeakers() {
        return new ArrayList<>(speakers);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void click(User user) {
        clickedBy.add(user);
    }

    @Override
    public boolean isPremiumContent() {
        return false;
    }

    @Override
    public List<User> clickedBy() {
        return new ArrayList<>(clickedBy);
    }
}
