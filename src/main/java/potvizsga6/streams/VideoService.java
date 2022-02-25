package potvizsga6.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VideoService {
    private List<Video> videos = new ArrayList<>();

    public List<Video> getVideos() {
        return new ArrayList<>(videos);
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public List<Video> findVideosByTitle(String titlePart) {
        return videos.stream()
                .filter(v -> v.getTitle().contains(titlePart))
                .sorted(Comparator.comparing((Video v) -> v.getUploadDate()).reversed())
                .toList();
    }

    public long countVideosWithHashTag(String hashTag) {
        return videos.stream()
                .filter(v -> v.getHashTags().contains(hashTag))
                .count();
    }

    public Video firstVideoByDate() {
        return videos.stream()
                .sorted(Comparator.comparing((Video v) -> v.getUploadDate()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No videos in list!"));
    }

    public long sumOfVideoLengths() {
        return videos.stream()
                .mapToInt(Video::getLength)
                .sum();
    }
}
