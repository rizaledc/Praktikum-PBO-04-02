/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unguided.entities;

/**
 * @author Rizal Wahyu Pratama
 * Doctor class to represent a Doctor in the clinic system.
 * Demonstrates encapsulation by making all fields private,
 * and provides getters and setters to access/modify them.
 */
public class Doctor {
    private String name;
    private String specialization;
    private String doctorId;

    // Constructor
    public Doctor(String name, String specialization, String doctorId) {
        this.name = name;
        this.specialization = specialization;
        this.doctorId = doctorId;
    }

    // Getter for Doctor's name
    public String getName() {
        return name;
    }

    // Setter for Doctor's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Doctor's specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter for Doctor's specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Getter for Doctor's ID
    public String getDoctorId() {
        return doctorId;
    }

    // Setter for Doctor's ID
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
