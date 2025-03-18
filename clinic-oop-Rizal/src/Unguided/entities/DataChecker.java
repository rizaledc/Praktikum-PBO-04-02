/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unguided.entities;

/**
 * @author Rizal Wahyu Pratama
 * DataChecker is a utility class for validating data inputs
 * and controlling access to sensitive fields.
 */
public class DataChecker {
    // A simple key for demonstration purposes
    private static final String SECRET_KEY = "secret";

    /**
     * Checks if the provided key matches the SECRET_KEY.
     * If true, grants access to sensitive data.
     */
    public static boolean hasAccess(String key) {
        return SECRET_KEY.equals(key);
    }

    /**
     * Validates if a diagnosis is acceptable.
     * For example, a diagnosis should not be null or empty.
     */
    public static boolean validateDiagnosis(String diagnosis) {
        return diagnosis != null && !diagnosis.trim().isEmpty();
    }

    /**
     * Additional methods can be added for name or age validation.
     */
    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean validateAge(int age) {
        return age > 0;
    }
}

