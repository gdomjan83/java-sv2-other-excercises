package potvizsga3.exams;

public abstract class Exam {
    private long studentId;
    private String topic;
    private int maxPoints;
    private ExamResult examResult;

    public Exam(long studentId, String topic) {
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = 100;
    }

    public Exam(long studentId, String topic, int maxPoints) {
        this(studentId, topic);
        this.maxPoints = maxPoints;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getTopic() {
        return topic;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public ExamResult getExamResult() {
        return examResult;
    }

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public abstract void calculateExamResult(int actualPoints);

    public void checkForPointException(int actualPoints) {
        if (actualPoints < 0 || actualPoints > getMaxPoints()) {
            throw new IllegalArgumentException("Actual points must be between 0 and the maximum point.");
        }
    }
}
