package potvizsga7.students;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String className;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, String classRoom) {
        this.name = name;
        this.className = classRoom;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void addGrade(int grade) {
        if (grade >= 1 && grade <= 5) {
            grades.add(grade);
        } else {
            throw new IllegalArgumentException("Invalid grade.");
        }
    }

    public double getAverage() {
        return grades.stream()
                .mapToInt(a -> a)
                .average()
                .orElseThrow(() -> new IllegalStateException("Average can not be calculated."));
    }
}
