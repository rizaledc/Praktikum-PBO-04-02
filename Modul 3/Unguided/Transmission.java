/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum3.Guided;

/**
 *
 * @author rwp44
 */
public class Transmission {
    private int gear; // Menyimpan gigi saat ini
    private int maxGears; // Menentukan jumlah maksimal gigi

    // Konstruktor untuk menginisialisasi transmisi dengan jumlah gigi tertentu
    public Transmission(int maxGears) {
        this.maxGears = maxGears;
        this.gear = 0; // Awalnya di gigi netral
    }

    // Metode untuk mengganti gigi
    public void shiftGear(int gear) {
        if (gear >= 0 && gear <= maxGears) {
            this.gear = gear;
            System.out.println("Shifted to gear: " + gear);
        } else {
            System.out.println("Invalid gear!");
        }
    }
}