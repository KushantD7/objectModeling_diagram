import java.util.*;

class Subject {
    String name;
    int marks;

    Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

class Student {
    String name;
    List<Subject> subjects;

    Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    void addSubject(Subject subject) {
        subjects.add(subject);
    }
}

class GradeCalculator {
    void calculateGrade(Student student) {
        int total = 0;
        for (Subject s : student.subjects) {
            total += s.marks;
        }
        double average = total / (double) student.subjects.size();
        String grade;
        if (average >= 90) grade = "A";
        else if (average >= 80) grade = "B";
        else if (average >= 70) grade = "C";
        else grade = "D";

        System.out.println(student.name + "'s Grade: " + grade);
    }
}

public class SchoolResultsDemo {
    public static void main(String[] args) {
        // Create student and subjects
        Student john = new Student("John");
        john.addSubject(new Subject("Maths", 90));
        john.addSubject(new Subject("Science", 85));

        // Grade calculation
        GradeCalculator calculator = new GradeCalculator();
        calculator.calculateGrade(john);
    }
}
