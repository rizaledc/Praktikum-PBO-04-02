/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum3.Guided;

/**
 *
 * @author rwp44
 */
public class OilPan {
    private double oilLevel; // Menyimpan level oli dalam liter

    // Konstruktor untuk menginisialisasi level oli
    public OilPan(double oilLevel) {
        this.oilLevel = oilLevel;
    }

    // Metode untuk mengecek level oli
    public void checkOilLevel() {
        System.out.println("Oil level: " + oilLevel + " liters");
    }
}

