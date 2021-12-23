package potvizsga3.exams;

public class MultipleChoiceExam extends Exam {

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        checkForPointException(actualPoints);
        double resultPercent = (double) actualPoints / getMaxPoints() * 100;
        setExamResult(resultPercent >= 51 ? ExamResult.PASSED : ExamResult.NOT_PASSED);
    }
}
