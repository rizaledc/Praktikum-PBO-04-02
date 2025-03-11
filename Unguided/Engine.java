/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum3.Guided;

/**
 *
 * @author rwp44
 */
public class Engine {
    private boolean running; // Menyimpan status apakah mesin menyala atau tidak
    private int horsepower; // Daya mesin dalam satuan tenaga kuda (HP)
    private int rpm; // Menyimpan kecepatan putaran mesin dalam satuan RPM

    // Konstruktor untuk menginisialisasi mesin dengan tenaga kuda tertentu
    public Engine(int horsepower) {
        this.horsepower = horsepower;
        this.rpm = 0; // Awalnya mesin tidak berputar
    }

    // Metode untuk menyalakan mesin
    public void start() {
        running = true;
        rpm = 1000; // RPM awal setelah dinyalakan
        System.out.println("Engine started with " + horsepower + " HP, RPM: " + rpm);
    }

    // Metode untuk mematikan mesin
    public void stop() {
        running = false;
        rpm = 0; // RPM menjadi 0 karena mesin mati
        System.out.println("Engine stopped.");
    }

    // Metode untuk menaikkan RPM mesin
    public void revEngine() {
        if (running) {
            rpm += 2000;
            System.out.println("Revving engine... RPM: " + rpm);
        } else {
            System.out.println("Engine is off, cannot rev.");
        }
    }
}

