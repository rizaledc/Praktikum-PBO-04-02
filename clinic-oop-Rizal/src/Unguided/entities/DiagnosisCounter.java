/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unguided.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rizal Wahyu Pratama
 * DiagnosisCounter keeps track of how many times a particular diagnosis
 * has been used throughout the system.
 */
public class DiagnosisCounter {
    // A static Map to hold diagnosis counts
    private static Map<String, Integer> diagnosisMap = new HashMap<>();

    /**
     * Increment the usage count for a specific diagnosis.
     */
    public static void incrementDiagnosisCount(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            return;
        }
        diagnosisMap.put(diagnosis, diagnosisMap.getOrDefault(diagnosis, 0) + 1);
    }

    /**
     * Get the usage count for a specific diagnosis.
     */
    public static int getDiagnosisCount(String diagnosis) {
        return diagnosisMap.getOrDefault(diagnosis, 0);
    }

    /**
     * Print all stored diagnoses and their counts.
     */
    public static void printAllDiagnosisCounts() {
        System.out.println("Diagnosis Count:");
        for (Map.Entry<String, Integer> entry : diagnosisMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
