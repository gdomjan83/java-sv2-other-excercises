package potvizsga6.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Video {
    private String title;
    private int length;
    private LocalDate uploadDate;
    private List<String> hashTags;

    public Video(String title, int length, LocalDate upload, List<String> hashtags) {
        this.title = title;
        this.length = length;
        this.uploadDate = upload;
        this.hashTags = hashtags;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public List<String> getHashTags() {
        return new ArrayList<>(hashTags);
    }
}
