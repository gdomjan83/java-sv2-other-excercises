package potvizsga7.students;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TeacherNotebook {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(createStudent(line));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file.", ioe);
        }
    }

    public List<String> findFailingStudents() {
        return students.stream()
                .filter(s -> s.getAverage() < 2)
                .map(s -> s.getName())
                .toList();
    }

    private Student createStudent(String line) {
        String[] data = line.split(";");
        String name = data[0];
        String className = data[1];
        Student student = new Student(name, className);
        for (int i = 2; i < data.length; i++) {
            student.addGrade(Integer.parseInt(data[i]));
        }
        return student;
    }
}
