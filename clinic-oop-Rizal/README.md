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
5. [Output](#output)
6. [Kesimpulan](#kesimpulan)

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

- Fungsi: Menyimpan dan mengelola data dokter.

- Encapsulation: Atribut name, specialization, dan doctorId bersifat private.

- Penggunaan: Objek Doctor dibuat ketika pengguna memasukkan data dokter di program utama.

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

- Fungsi: Menyimpan data pasien termasuk diagnosis yang sensitif.

- Encapsulation: Data diagnosis tidak langsung dapat diakses; harus menggunakan kunci melalui method getDiagnosis.

- Interaksi: Saat diagnosis diset, method setDiagnosis() juga mengupdate jumlah penggunaan diagnosis melalui DiagnosisCounter.

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

- Fungsi: Menghubungkan dokter dan pasien pada suatu waktu tertentu.

- Hubungan: Objek Appointment mengaitkan satu dokter dengan satu pasien.

- Penggunaan: Dibuat berdasarkan input pengguna, dimana dokter dan pasien dipilih dari daftar.

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

- Fungsi: Mengamankan data sensitif dan memastikan input valid.

- Penggunaan: Dipanggil oleh Patient untuk memverifikasi diagnosis dan mengatur akses menggunakan kunci ("secret").

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

- Fungsi: Melacak berapa kali setiap diagnosis digunakan.

- Interaksi: Dipanggil oleh Patient saat diagnosis di-set, sehingga data penggunaan diagnosis selalu ter-update.

- Output: Menampilkan statistik diagnosis di akhir program.

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

- Fungsi: Menjadi titik masuk program, mengatur alur interaksi dengan pengguna.

- Input: Menerima input dari user untuk membuat data dokter, pasien, dan appointment.

- Validasi: Melakukan validasi format tanggal dan waktu menggunakan loop while dan try-catch.

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

## Output

```
run:
How many doctors do you want to add? 3

Enter details for Doctor #1
Name: Patrick Kluivert
Specialization: COVID
Doctor ID: PKT101

Enter details for Doctor #2
Name: Danny Lanzat
Specialization: General
Doctor ID: DAL102

Enter details for Doctor #3
Name: Alex Pastoor
Specialization: Lifer
Doctor ID: APR103

How many patients do you want to add? 2

Enter details for Patient #1
Name: Rizal Wahyu Pratama
Age: 19
Diagnosis (leave blank if none): COVID

Enter details for Patient #2
Name: Malkan Khulika
Age: 35
Diagnosis (leave blank if none): Flu

How many appointments do you want to create? 2

Creating Appointment #1

List of Doctors:
0 - Patrick Kluivert (COVID)
1 - Danny Lanzat (General)
2 - Alex Pastoor (Lifer)
Select Doctor index: 0

List of Patients:
0 - Rizal Wahyu Pratama (Age: 19)
1 - Malkan Khulika (Age: 35)
Select Patient index: 1

Enter appointment date and time (yyyy-MM-dd HH:mm) 
Ex : 2025-04-18 10:30 
Enter yout time:2025-04-30 15:30

Creating Appointment #2

List of Doctors:
0 - Patrick Kluivert (COVID)
1 - Danny Lanzat (General)
2 - Alex Pastoor (Lifer)
Select Doctor index: 1

List of Patients:
0 - Rizal Wahyu Pratama (Age: 19)
1 - Malkan Khulika (Age: 35)
Select Patient index: 0

Enter appointment date and time (yyyy-MM-dd HH:mm) 
Ex : 2025-04-18 10:30 
Enter yout time:2025-05-01 20:30

=== ALL DOCTORS ===
Name: Patrick Kluivert, Specialization: COVID, ID: PKT101
Name: Danny Lanzat, Specialization: General, ID: DAL102
Name: Alex Pastoor, Specialization: Lifer, ID: APR103

=== ALL PATIENTS ===
Name: Rizal Wahyu Pratama, Age: 19
Name: Malkan Khulika, Age: 35

=== ALL APPOINTMENTS ===
Appointment #1:
  Doctor: Patrick Kluivert
  Patient: Malkan Khulika
  Date/Time: 2025-04-30T15:30
Appointment #2:
  Doctor: Danny Lanzat
  Patient: Rizal Wahyu Pratama
  Date/Time: 2025-05-01T20:30

Do you want to see a patient's diagnosis? (yes/no): yes
Enter the index of the patient you want to check: 0
Enter access key: secret
Diagnosis: COVID

=== DIAGNOSIS USAGE COUNT ===
Diagnosis Count:
COVID: 1
Flu: 1
BUILD SUCCESSFUL (total time: 3 minutes 25 seconds)
```

**Penjelasan:**

1. Pembuatan Data Dokter

- Input:
  Pengguna diminta memasukkan jumlah dokter yang ingin ditambahkan, yaitu 3 dokter.  
  - Dokter #1: 
    - Nama: Patrick Kluivert  
    - Spesialisasi: COVID  
    - Doctor ID: PKT101
  - Dokter #2:
    - Nama: Danny Lanzat  
    - Spesialisasi: General  
    - Doctor ID: DAL102
  - Dokter #3:
    - Nama: Alex Pastoor  
    - Spesialisasi: Lifer  
    - Doctor ID: APR103

- Proses:
  Setiap inputan tersebut dibuat menjadi objek Docto dan disimpan dalam list doctors.

2. Pembuatan Data Pasien

- Input:
  Pengguna diminta memasukkan jumlah pasien yang ingin ditambahkan, yaitu 2 pasien.  
  - Pasien #1: 
    - Nama: Rizal Wahyu Pratama  
    - Usia: 19  
    - Diagnosis: COVID  
  - Pasien #2:
    - Nama: Malkan Khulika  
    - Usia: 35  
    - Diagnosis: Flu

- Proses:
  Data pasien diinput dan objek Patient dibuat.  
  - Ketika diagnosis di-set, method setDiagnosis() melakukan validasi melalui kelas DataChecker dan juga mengupdate counter di DiagnosisCounter.

3. Pembuatan Data Appointment

- Input:
  Pengguna diminta memasukkan jumlah appointment, yaitu 2 appointment.

- Appointment #1:
  - Pemilihan Dokter:
    Ditampilkan daftar dokter dengan index. Pengguna memilih index 0, yang berarti dokter yang dipilih adalah Patrick Kluivert.
  - Pemilihan Pasien:
    Ditampilkan daftar pasien. Pengguna memilih index 1, yaitu pasien *Malkan Khulika*.
  - Input Waktu:
    Pengguna diminta memasukkan tanggal dan waktu dengan format yyyy-MM-dd HH:mm. Di sini dimasukkan: 2025-04-30 15:30.  
    - Kode menggunakan LocalDateTime.parse() dengan DateTimeFormatter untuk memverifikasi format dan menyimpan waktu appointment.
    
- Appointment #2:
  - Pemilihan Dokter: 
    Pengguna memilih index 1 sehingga dokter yang dipilih adalah Danny Lanzat.
  - Pemilihan Pasien: 
    Pengguna memilih index 0, yang berarti pasien yang dipilih adalah Rizal Wahyu Pratama.
  - Input Waktu: 
    Dimasukkan tanggal dan waktu 2025-05-01 20:30.

- Proses: 
  Objek Appointment dibuat dengan menghubungkan objek Doctor dan Patient berdasarkan pilihan, serta waktu appointment yang sudah di-parse.


4. Menampilkan Semua Data

Setelah data dimasukkan, program mencetak:

- Daftar Dokter:  
  Menampilkan setiap dokter beserta nama, spesialisasi, dan ID sesuai input.
  
- Daftar Pasien:
  Menampilkan nama dan usia dari masing-masing pasien.
  
- Daftar Appointment: 
  Menampilkan rincian appointment:
  - Appointment #1: 
    - Dokter: Patrick Kluivert  
    - Pasien: Malkan Khulika  
    - Tanggal/Waktu: Ditampilkan sebagai 2025-04-30T15:30 (format ISO 8601, karena tipe LocalDateTime akan dicetak seperti itu)
  - Appointment #2:
    - Dokter: Danny Lanzat  
    - Pasien: Rizal Wahyu Pratama  
    - Tanggal/Waktu: Ditampilkan sebagai 2025-05-01T20:30

5. Mengakses Diagnosis Pasien

- Input:
  Program menanyakan apakah pengguna ingin melihat diagnosis pasien.  
  - Pengguna menjawab "yes".
  - Program meminta index pasien yang ingin dicek, pengguna memasukkan index 0 (yang merupakan Rizal Wahyu Pratama).
  - Program kemudian meminta access key.  
    - Pengguna memasukkan **secret**

- Proses:  
  Method getDiagnosis(String key) di kelas Patient memeriksa apakah kunci yang dimasukkan sesuai dengan kunci rahasia di kelas DataChecker. Karena secret cocok, diagnosis pasien (yaitu "COVID") ditampilkan.

6. Menampilkan Statistik Diagnosis

- Output: 
  Di bagian akhir, program mencetak jumlah penggunaan setiap diagnosis berdasarkan objek DiagnosisCounter.  
  - "COVID: 1" karena hanya satu pasien (Rizal Wahyu Pratama) yang diinput dengan diagnosis "COVID".  
  - "Flu: 1" karena pasien Malkan Khulika diinput dengan diagnosis "Flu".

---

7. Kesimpulan Output

- **Input data** sesuai dengan perintah: 3 dokter, 2 pasien, dan 2 appointment.
- **Pemilihan indeks** menentukan dokter dan pasien yang terhubung dalam appointment.
- **Validasi tanggal/waktu** memastikan input sesuai format.
- **Akses data sensitif diagnosis** hanya dapat dilakukan dengan memasukkan kunci yang benar (default: **secret**).
- **Diagnosis Counter** mencatat setiap kali diagnosis di-set, sehingga menghasilkan statistik penggunaan diagnosis.

## Kesimpulan

Project ini merupakan implementasi OOP dalam bahasa Java yang berhasil mengelola data klinik secara terstruktur dan aman dengan menghubungkan objek Dokter, Pasien, dan Appointment, serta menerapkan encapsulation untuk mengamankan data sensitif seperti diagnosis melalui mekanisme kunci akses; selain itu, fitur validasi input dan penggunaan kelas utilitas seperti DiagnosisCounter memastikan integritas data dan memudahkan pengembangan serta pemeliharaan aplikasi di masa depan.
