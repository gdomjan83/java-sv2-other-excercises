package potvizsga3.exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {
    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoints) {
        exam.calculateExamResult(actualPoints);
        exams.add(exam);
    }

    public  List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public int countPassedExams() {
        if (exams.size() == 0) {
            throw new IllegalStateException("There are no exam results in the system.");
        }
        int count = 0;
        for (Exam actual : exams) {
            if (actual.getExamResult() != ExamResult.NOT_PASSED) {
                count++;
            }
        }
        return count;
    }

    public List<Exam> findById(long studentId) {
        List<Exam> examsOfStudent = new ArrayList<>();
        for (Exam actual : exams) {
            if (studentId == actual.getStudentId()) {
                examsOfStudent.add(actual);
            }
        }
        return examsOfStudent;
    }

    public List<String> findTopicByPrefix(String prefix) {
        List<String> topics = new ArrayList<>();
        for (Exam actual : exams) {
            if (actual.getTopic().startsWith(prefix) && !checkIfInList(topics, actual)) {
                topics.add(actual.getTopic());
            }
        }
        return topics;
    }

    private boolean checkIfInList(List<String> topics, Exam exam) {
        for (String actual : topics) {
            if (exam.getTopic().equals(actual)) {
                return true;
            }
        }
        return false;
    }
}
