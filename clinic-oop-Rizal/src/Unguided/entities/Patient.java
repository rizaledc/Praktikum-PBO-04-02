/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unguided.entities;

/**
 * @author Rizal Wahyu Pratama
 * Patient class to represent a Patient in the clinic system.
 * Encapsulates sensitive data (diagnosis) by keeping it private
 * and controlling its access through methods that check permissions.
 */
public class Patient {
    private String name;
    private int age;
    private String diagnosis; // Sensitive data

    // Constructor with diagnosis
    public Patient(String name, int age, String diagnosis) {
        this.name = name;
        this.age = age;
        setDiagnosis(diagnosis); // Use setter to ensure any checks or counters
    }

    // Constructor without diagnosis
    public Patient(String name, int age) {
        this(name, age, "");
    }

    // Getter for Patient's name
    public String getName() {
        return name;
    }

    // Setter for Patient's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Patient's age
    public int getAge() {
        return age;
    }

    // Setter for Patient's age
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method to safely retrieve diagnosis.
     * Only returns the actual diagnosis if the user has the correct key.
     */
    public String getDiagnosis(String key) {
        if (DataChecker.hasAccess(key)) {
            return diagnosis;
        } else {
            return "Access Denied: Invalid Key";
        }
    }

    /**
     * Setter for Patient's diagnosis.
     * Validates the diagnosis before setting it.
     * Also increments the diagnosis count in DiagnosisCounter.
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
