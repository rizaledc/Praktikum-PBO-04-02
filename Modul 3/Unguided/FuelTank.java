/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum3.Guided;

/**
 *
 * @author rwp44
 */
public class FuelTank {
    private double fuelLevel; // Level bahan bakar dalam liter

    // Konstruktor untuk menginisialisasi level bahan bakar
    public FuelTank(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    // Metode untuk mengecek level bahan bakar
    public void checkFuelLevel() {
        System.out.println("Fuel level: " + fuelLevel + " liters");
    }

    // Metode untuk mengecek apakah masih ada bahan bakar
    public boolean hasFuel() {
        return fuelLevel > 0;
    }
}