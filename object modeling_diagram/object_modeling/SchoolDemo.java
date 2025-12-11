package object_modeling;

import java.util.*;

class Course {
    String name;
    List<Student> students;

    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this); // Maintain association both ways
        }
    }

    void showEnrolledStudents() {
        System.out.print("Students in " + name + ": ");
        for (Student s : students) {
            System.out.print(s.name + " ");
        }
        System.out.println();
    }
}

class Student {
    String name;
    List<Course> courses;

    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    void showCourses() {
        System.out.print(name + " is enrolled in: ");
        for (Course c : courses) {
            System.out.print(c.name + " ");
        }
        System.out.println();
    }
}

class School {
    String name;
    List<Student> students;

    School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void showStudents() {
        System.out.print("Students in " + name + ": ");
        for (Student s : students) {
            System.out.print(s.name + " ");
        }
        System.out.println();
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        // Create school
        School mySchool = new School("Sunrise High");

        // Create students
        Student john = new Student("John");
        Student alice = new Student("Alice");

        // Add students to school (aggregation)
        mySchool.addStudent(john);
        mySchool.addStudent(alice);

        // Create courses
        Course math = new Course("Math");
        Course science = new Course("Science");

        // Enroll students in courses (association)
        math.addStudent(john);
        science.addStudent(john);
        science.addStudent(alice);

        // Display school students
        mySchool.showStudents();

        // Display courses each student is enrolled in
        john.showCourses();
        alice.showCourses();

        // Display students in each course
        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}
