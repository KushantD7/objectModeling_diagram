package object_modeling;

import java.util.*;

class Course {
    String name;
    Professor professor;
    List<Student> students;

    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this); // maintain association
    }

    void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enrollCourse(this); // maintain association
        }
    }

    void showCourseDetails() {
        System.out.print("Course: " + name + ", Professor: " + (professor != null ? professor.name : "None") + ", Students: ");
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

    void enrollCourse(Course course) {
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

class Professor {
    String name;
    List<Course> courses;

    Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    void showCourses() {
        System.out.print(name + " teaches: ");
        for (Course c : courses) {
            System.out.print(c.name + " ");
        }
        System.out.println();
    }
}

public class UniversityManagementDemo {
    public static void main(String[] args) {
        // Create professors
        Professor profSmith = new Professor("Prof. Smith");
        Professor profJones = new Professor("Prof. Jones");

        // Create courses
        Course math = new Course("Math");
        Course physics = new Course("Physics");

        // Assign professors to courses
        math.assignProfessor(profSmith);
        physics.assignProfessor(profJones);

        // Create students
        Student alice = new Student("Alice");
        Student john = new Student("John");

        // Enroll students in courses
        math.addStudent(alice);
        math.addStudent(john);
        physics.addStudent(alice);

        // Display course details
        math.showCourseDetails();
        physics.showCourseDetails();

        // Display professor's courses
        profSmith.showCourses();
        profJones.showCourses();

        // Display student's courses
        alice.showCourses();
        john.showCourses();
    }
}

