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

