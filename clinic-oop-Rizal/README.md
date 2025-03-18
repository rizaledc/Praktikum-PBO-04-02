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
**Kode:**

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
