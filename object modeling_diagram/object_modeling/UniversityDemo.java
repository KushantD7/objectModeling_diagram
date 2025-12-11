package object_modeling;

import java.util.*;

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class University {
    String name;
    List<Department> departments;

    University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void showDepartments() {
        System.out.print("Departments in " + name + ": ");
        for (Department d : departments) {
            System.out.print(d.name + " ");
        }
        System.out.println();
    }

    // Simulate deleting the University (Composition)
    void deleteUniversity() {
        System.out.println("Deleting university: " + name + " and all its departments.");
        departments.clear(); // departments are deleted
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        // Create Faculty members (Aggregation: exist independently)
        Faculty profSmith = new Faculty("Prof. Smith");
        Faculty profJones = new Faculty("Prof. Jones");

        // Create University
        University uni = new University("Global University");

        // Add Departments (Composition)
        Department csDept = new Department("Computer Science");
        Department mathDept = new Department("Mathematics");

        uni.addDepartment(csDept);
        uni.addDepartment(mathDept);

        // Display departments
        uni.showDepartments();

        // Faculty can exist independently of University/Department
        System.out.println(profSmith.name + " is a faculty member and exists independently.");
        System.out.println(profJones.name + " is a faculty member and exists independently.");

        // Delete University (Departments are deleted)
        uni.deleteUniversity();

        // Verify departments are deleted
        uni.showDepartments();
    }
}

