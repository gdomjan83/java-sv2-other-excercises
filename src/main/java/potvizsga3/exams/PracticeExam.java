package potvizsga3.exams;

import java.util.List;

public class PracticeExam extends Exam {

    public PracticeExam(long studentId, String topic) {
        super(studentId, topic);
    }

    public PracticeExam(long studentId, String topic, List<Integer> pointsOfExcercise) {
        super(studentId, topic);
        int maxPoint = sumPoints(pointsOfExcercise);
        if (maxPoint < 10 || maxPoint > 150) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + maxPoint);
        }
        setMaxPoints(maxPoint);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        checkForPointException(actualPoints);
        double resultPercent = (double) actualPoints / getMaxPoints() * 100;
        if (resultPercent >= 76) {
            setExamResult(ExamResult.PERFECT);
        } else if (resultPercent >= 51) {
            setExamResult(ExamResult.OK);
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }

    private int sumPoints(List<Integer> pointsOfExcercise) {
        int result = 0;
        for (Integer actual : pointsOfExcercise) {
            result += actual;
        }
        return result;
    }
}
