# NightFall Clinic OOP Project

Proyek ini merupakan implementasi konsep Object-Oriented Programming (OOP) dalam bahasa Java untuk mengelola data klinik secara terstruktur. Proyek ini fokus pada pengamanan data sensitif (misalnya diagnosis pasien) melalui mekanisme encapsulation serta pengaturan hubungan antar class (dokter, pasien, dan appointment).

---

## Identitas
- **Nama:** Rizal Wahyu Pratama  
- **NIM:** 2311110029  
- **Tugas:** clinic-oop

---

## Daftar Isi
1. [Overview](#overview)
2. [Struktur Proyek](#struktur-proyek)
3. [Penjelasan Kode per Kelas](#penjelasan-kode-per-kelas)
   - [Doctor.java](#1-doktorjava)
   - [Patient.java](#2-patientjava)
   - [Appointment.java](#3-appointmentjava)
   - [DataChecker.java](#4-datacheckerjava)
   - [DiagnosisCounter.java](#5-diagnosiscounterjava)
   - [Main.java](#6-mainjava)
4. [Hubungan Antar Class](#hubungan-antar-class)
5. [Package yang Digunakan](#package-yang-digunakan)
6. [Cara Menjalankan Aplikasi](#cara-menjalankan-aplikasi)
7. [Perbaikan di Masa Depan](#perbaikan-di-masa-depan)
8. [License](#license)

---

## Overview
Proyek ini dibuat untuk mensimulasikan sistem manajemen klinik dengan tujuan:
- **Mengamankan data sensitif:** Diagnosis pasien hanya dapat diakses dengan kunci yang benar.
- **Mengorganisir data klinik:** Mencatat data dokter, pasien, dan janji temu.
- **Memudahkan pengembangan:** Kode yang terstruktur dan terdokumentasi dengan baik agar pengembang di masa depan dapat dengan mudah memelihara atau mengembangkannya.

---

## Struktur Proyek
```
clinic-oop-Rizal/
├── src/
│   └── Guided/
│       └── Driver/
│           ├── TestPackages.java
│       └── HargaBuku/
│           ├── KelasHarga.java
│       └── HargaToken/
│           ├── KelasToken.java
│       └── Animal.java
│       └── Cat.java
│       └── DriverLB.java
│       └── LibraryBook.java
│   └── Unguided/           # Root package (REQUIRED)
│       └── entities/       # Core classes
│           ├── Appointment.java
│           ├── DataChecker.java
│           ├── DiagnosisCounter.java
│           ├── Doctor.java
│           └── Patient.java
│       └── Main/
|           ├── Main.java
└── README.md  (Detailed Project Explanations)
```

Setiap file memiliki peran khusus untuk memastikan data klinik dikelola dengan benar dan aman.

---

## Penjelasan Kode per Kelas

### 1. Doctor.java

```java
package Unguided.entities;

/**
 * Kelas Doctor merepresentasikan seorang dokter dengan atribut nama,
 * spesialisasi, dan ID dokter. Data disimpan secara privat dan dapat diakses
 * menggunakan method getter dan setter.
 */
public class Doctor {
    private String name;
    private String specialization;
    private String doctorId;

    // Konstruktor untuk menginisialisasi object Doctor
    public Doctor(String name, String specialization, String doctorId) {
        this.name = name;
        this.specialization = specialization;
        this.doctorId = doctorId;
    }

    // Getter dan Setter untuk nama dokter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk spesialisasi dokter
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Getter dan Setter untuk ID dokter
    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
```
Penjelasan Berjalannya Kode:

Fungsi: Menyimpan dan mengelola data dokter.

Encapsulation: Atribut name, specialization, dan doctorId bersifat private.

Penggunaan: Objek Doctor dibuat ketika pengguna memasukkan data dokter di program utama.

### 2. Patient.java

```
package Unguided.entities;

/**
 * Kelas Patient merepresentasikan seorang pasien dengan atribut nama, usia,
 * dan diagnosis. Data diagnosis bersifat sensitif dan hanya dapat diakses dengan
 * kunci tertentu melalui metode getDiagnosis().
 */
public class Patient {
    private String name;
    private int age;
    private String diagnosis; // Data sensitif

    // Konstruktor dengan diagnosis
    public Patient(String name, int age, String diagnosis) {
        this.name = name;
        this.age = age;
        setDiagnosis(diagnosis);
    }

    // Konstruktor tanpa diagnosis
    public Patient(String name, int age) {
        this(name, age, "");
    }

    // Getter dan Setter untuk nama pasien
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk usia pasien
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Mengembalikan diagnosis jika kunci akses benar.
     */
    public String getDiagnosis(String key) {
        if (DataChecker.hasAccess(key)) {
            return diagnosis;
        } else {
            return "Access Denied: Invalid Key";
        }
    }

    /**
     * Mengatur diagnosis pasien setelah divalidasi.
     * Juga mengupdate counter diagnosis.
     */
    public void setDiagnosis(String diagnosis) {
        if (DataChecker.validateDiagnosis(diagnosis)) {
            this.diagnosis = diagnosis;
            DiagnosisCounter.incrementDiagnosisCount(diagnosis);
        } else {
            this.diagnosis = "Undefined";
        }
    }
}
```
Penjelasan Berjalannya Kode:

Fungsi: Menyimpan data pasien termasuk diagnosis yang sensitif.

Encapsulation: Data diagnosis tidak langsung dapat diakses; harus menggunakan kunci melalui method getDiagnosis.

Interaksi: Saat diagnosis diset, method setDiagnosis() juga mengupdate jumlah penggunaan diagnosis melalui DiagnosisCounter.

### 3. Appointment.java

```
package Unguided.entities;

import java.time.LocalDateTime;

/**
 * Kelas Appointment menghubungkan antara Doctor dan Patient pada waktu tertentu.
 * Objek appointment menyimpan referensi ke objek Doctor dan Patient serta waktu appointment.
 */
public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime appointmentDateTime;

    // Konstruktor untuk membuat Appointment
    public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentDateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDateTime = appointmentDateTime;
    }

    // Getter dan Setter untuk dokter, pasien, dan waktu appointment
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
}
```

Penjelasan Berjalannya Kode:

Fungsi: Menghubungkan dokter dan pasien pada suatu waktu tertentu.

Hubungan: Objek Appointment mengaitkan satu dokter dengan satu pasien.

Penggunaan: Dibuat berdasarkan input pengguna, dimana dokter dan pasien dipilih dari daftar.

### 4. DataChecker.java

```
package Unguided.entities;

/**
 * Kelas DataChecker menyediakan metode untuk validasi input dan pengamanan akses data sensitif.
 */
public class DataChecker {
    // Kunci rahasia untuk mengakses data sensitif
    private static final String SECRET_KEY = "secret";

    /**
     * Memeriksa apakah kunci yang diberikan sesuai dengan kunci rahasia.
     */
    public static boolean hasAccess(String key) {
        return SECRET_KEY.equals(key);
    }

    /**
     * Memvalidasi apakah diagnosis tidak kosong atau null.
     */
    public static boolean validateDiagnosis(String diagnosis) {
        return diagnosis != null && !diagnosis.trim().isEmpty();
    }

    // Metode validasi tambahan untuk nama dan usia
    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }
    public static boolean validateAge(int age) {
        return age > 0;
    }
}
```

Penjelasan Berjalannya Kode:

Fungsi: Mengamankan data sensitif dan memastikan input valid.

Penggunaan: Dipanggil oleh Patient untuk memverifikasi diagnosis dan mengatur akses menggunakan kunci ("secret").

### 5.DiagnosisCounter.java

```
package Unguided.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Kelas DiagnosisCounter menghitung jumlah penggunaan setiap diagnosis dalam sistem.
 */
public class DiagnosisCounter {
    // Map statis untuk menyimpan jumlah diagnosis
    private static Map<String, Integer> diagnosisMap = new HashMap<>();

    /**
     * Menambahkan jumlah penggunaan diagnosis setiap kali diagnosis ditetapkan.
     */
    public static void incrementDiagnosisCount(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            return;
        }
        diagnosisMap.put(diagnosis, diagnosisMap.getOrDefault(diagnosis, 0) + 1);
    }

    /**
     * Mengembalikan jumlah penggunaan diagnosis tertentu.
     */
    public static int getDiagnosisCount(String diagnosis) {
        return diagnosisMap.getOrDefault(diagnosis, 0);
    }

    /**
     * Mencetak seluruh diagnosis beserta jumlah penggunaannya.
     */
    public static void printAllDiagnosisCounts() {
        System.out.println("Diagnosis Count:");
        for (Map.Entry<String, Integer> entry : diagnosisMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```

Penjelasan Berjalannya Kode:

Fungsi: Melacak berapa kali setiap diagnosis digunakan.

Interaksi: Dipanggil oleh Patient saat diagnosis di-set, sehingga data penggunaan diagnosis selalu ter-update.

Output: Menampilkan statistik diagnosis di akhir program.

### 6. Main.java

```
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
```

Penjelasan Berjalannya Kode:

Fungsi: Menjadi titik masuk program, mengatur alur interaksi dengan pengguna.

Input: Menerima input dari user untuk membuat data dokter, pasien, dan appointment.

Validasi: Melakukan validasi format tanggal dan waktu menggunakan loop while dan try-catch.

Output: Menampilkan data lengkap yang telah diinput dan menyediakan opsi untuk melihat diagnosis pasien jika kunci yang benar dimasukkan.

## Hubungan Antar Class

-Doctor & Appointment:
Objek Appointment mengaitkan seorang dokter (Doctor) dengan pasien (Patient) pada waktu tertentu.

-Patient & Appointment:
Setiap appointment dikaitkan dengan data pasien yang sudah didaftarkan.

-Patient & DiagnosisCounter:
Saat diagnosis diatur di kelas Patient, secara otomatis jumlah penggunaan diagnosis tersebut diperbarui di kelas DiagnosisCounter.

-DataChecker:
Kelas ini berperan sebagai validator dan pengaman, digunakan oleh Patient untuk memastikan diagnosis valid dan hanya dapat diakses jika kunci yang benar digunakan.
