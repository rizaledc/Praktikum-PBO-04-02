/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unguided.entities;

import java.time.LocalDateTime;

/**
 * Appointment class to link a Doctor and a Patient at a specific date/time.
 * Demonstrates how we can relate two different classes (Doctor & Patient).
 */
public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime appointmentDateTime;

    // Constructor
    public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentDateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDateTime = appointmentDateTime;
    }

    // Getter for Doctor
    public Doctor getDoctor() {
        return doctor;
    }

    // Setter for Doctor
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    // Getter for Patient
    public Patient getPatient() {
        return patient;
    }

    // Setter for Patient
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Getter for Appointment Date/Time
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    // Setter for Appointment Date/Time
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
}
