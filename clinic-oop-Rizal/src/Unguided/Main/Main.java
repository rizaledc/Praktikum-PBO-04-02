package Unguided.Main;

import Unguided.entities.Appointment;
import Unguided.entities.DiagnosisCounter;
import Unguided.entities.Doctor;
import Unguided.entities.Patient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rizal Wahyu Pratama
 * Main class to run the application.
 * Demonstrates creation of Doctors, Patients, and Appointments
 * by accepting user input, as well as accessing protected data (diagnosis).
 */
public class Main {
    public static void main(String[] args) {
        // Prepare lists to store Doctors, Patients, and Appointments
        try (Scanner scanner = new Scanner(System.in)) {
            List<Doctor> doctors = new ArrayList<>();
            List<Patient> patients = new ArrayList<>();
            List<Appointment> appointments = new ArrayList<>();

            // ============ CREATE DOCTORS ============
            System.out.print("How many doctors do you want to add? ");
            int numDoctors = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numDoctors; i++) {
                System.out.println("\nEnter details for Doctor #" + (i + 1));
                System.out.print("Name: ");
                String docName = scanner.nextLine();

                System.out.print("Specialization: ");
                String docSpec = scanner.nextLine();

                System.out.print("Doctor ID: ");
                String docId = scanner.nextLine();

                // Create and add Doctor to the list
                Doctor doctor = new Doctor(docName, docSpec, docId);
                doctors.add(doctor);
            }

            // ============ CREATE PATIENTS ============
            System.out.print("\nHow many patients do you want to add? ");
            int numPatients = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numPatients; i++) {
                System.out.println("\nEnter details for Patient #" + (i + 1));
                System.out.print("Name: ");
                String patName = scanner.nextLine();

                System.out.print("Age: ");
                int patAge = Integer.parseInt(scanner.nextLine());

                System.out.print("Diagnosis (leave blank if none): ");
                String patDiagnosis = scanner.nextLine();

                // Create and add Patient to the list
                if (patDiagnosis.trim().isEmpty()) {
                    // No diagnosis given
                    patients.add(new Patient(patName, patAge));
                } else {
                    patients.add(new Patient(patName, patAge, patDiagnosis));
                }
            }

            // ============ CREATE APPOINTMENTS ============
            System.out.print("\nHow many appointments do you want to create? ");
            int numAppointments = Integer.parseInt(scanner.nextLine());

            // Formatter untuk date-time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            for (int i = 0; i < numAppointments; i++) {
                System.out.println("\nCreating Appointment #" + (i + 1));

                // List doctors
                System.out.println("\nList of Doctors:");
                for (int d = 0; d < doctors.size(); d++) {
                    System.out.println(d + " - " + doctors.get(d).getName()
                            + " (" + doctors.get(d).getSpecialization() + ")");
                }
                System.out.print("Select Doctor index: ");
                int doctorIndex = Integer.parseInt(scanner.nextLine());
                Doctor selectedDoctor = doctors.get(doctorIndex);

                // List patients
                System.out.println("\nList of Patients:");
                for (int p = 0; p < patients.size(); p++) {
                    System.out.println(p + " - " + patients.get(p).getName()
                            + " (Age: " + patients.get(p).getAge() + ")");
                }
                System.out.print("Select Patient index: ");
                int patientIndex = Integer.parseInt(scanner.nextLine());
                Patient selectedPatient = patients.get(patientIndex);

                // Minta date/time dengan format yang benar
                LocalDateTime appointmentDateTime = null;
                boolean validDateTime = false;

                while (!validDateTime) {
                    System.out.print("\nEnter appointment date and time (yyyy-MM-dd HH:mm) ");
                    System.out.print("\nEx : 2025-04-18 10:30 \nEnter yout time:");
                    String dateTimeStr = scanner.nextLine();

                    try {
                        appointmentDateTime = LocalDateTime.parse(dateTimeStr, dtf);
                        validDateTime = true;  // Keluar dari while jika sukses parse
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid format. Please use yyyy-MM-dd HH:mm (e.g., 2019-04-18 10:00).");
                    }
                }

                // Create and add Appointment
                Appointment appointment = new Appointment(selectedDoctor, selectedPatient, appointmentDateTime);
                appointments.add(appointment);
            }

            // ============ PRINT ALL DATA ============
            System.out.println("\n=== ALL DOCTORS ===");
            for (Doctor doc : doctors) {
                System.out.println("Name: " + doc.getName()
                        + ", Specialization: " + doc.getSpecialization()
                        + ", ID: " + doc.getDoctorId());
            }

            System.out.println("\n=== ALL PATIENTS ===");
            for (Patient pat : patients) {
                System.out.println("Name: " + pat.getName()
                        + ", Age: " + pat.getAge());
            }

            System.out.println("\n=== ALL APPOINTMENTS ===");
            for (int i = 0; i < appointments.size(); i++) {
                Appointment app = appointments.get(i);
                System.out.println("Appointment #" + (i + 1) + ":");
                System.out.println("  Doctor: " + app.getDoctor().getName());
                System.out.println("  Patient: " + app.getPatient().getName());
                System.out.println("  Date/Time: " + app.getAppointmentDateTime());
            }

            // ============ CHECK DIAGNOSIS WITH ACCESS KEY ============
            System.out.print("\nDo you want to see a patient's diagnosis? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.print("Enter the index of the patient you want to check: ");
                int patientIndex = Integer.parseInt(scanner.nextLine());
                if (patientIndex >= 0 && patientIndex < patients.size()) {
                    Patient p = patients.get(patientIndex);
                    System.out.print("Enter access key: ");
                    String key = scanner.nextLine();
                    System.out.println("Diagnosis: " + p.getDiagnosis(key));
                } else {
                    System.out.println("Invalid patient index.");
                }
            }

            // ============ PRINT DIAGNOSIS COUNTS ============
            System.out.println("\n=== DIAGNOSIS USAGE COUNT ===");
            DiagnosisCounter.printAllDiagnosisCounts();
        }
    }
}
