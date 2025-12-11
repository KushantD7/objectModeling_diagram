package object_modeling;

import java.util.*;

class Patient {
    String name;
    List<Doctor> doctors;

    Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }
}

class Doctor {
    String name;
    List<Patient> patients;

    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // maintain association both ways
        }
    }

    void consult(Patient patient) {
        if (patients.contains(patient)) {
            System.out.println(name + " is consulting patient " + patient.name);
        } else {
            System.out.println(name + " has no consultation with " + patient.name);
        }
    }

    void showPatients() {
        System.out.print(name + " has patients: ");
        for (Patient p : patients) {
            System.out.print(p.name + " ");
        }
        System.out.println();
    }
}

class Hospital {
    String name;
    List<Doctor> doctors;

    Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void showDoctors() {
        System.out.print("Doctors in " + name + ": ");
        for (Doctor d : doctors) {
            System.out.print(d.name + " ");
        }
        System.out.println();
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        // Create patients
        Patient john = new Patient("John");
        Patient alice = new Patient("Alice");

        // Create doctors
        Doctor drSmith = new Doctor("Dr. Smith");
        Doctor drJones = new Doctor("Dr. Jones");

        // Add doctors to hospital
        Hospital cityHospital = new Hospital("City Hospital");
        cityHospital.addDoctor(drSmith);
        cityHospital.addDoctor(drJones);

        // Show doctors in hospital
        cityHospital.showDoctors();

        // Associate doctors and patients (many-to-many)
        drSmith.addPatient(john);
        drSmith.addPatient(alice);
        drJones.addPatient(alice);

        // Show patients for each doctor
        drSmith.showPatients();
        drJones.showPatients();

        // Consultations
        drSmith.consult(john);   // valid consultation
        drJones.consult(john);   // no consultation
        drJones.consult(alice);  // valid consultation
    }
}
