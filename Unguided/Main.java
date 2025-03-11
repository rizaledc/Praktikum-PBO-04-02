/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum3.Guided;

/**
 *
 * @author rwp44
 */
public class Main {
    public static void main(String[] args) {
        // Membuat objek mesin dengan tenaga 150 HP
        Engine engine = new Engine(150);
        // Membuat objek transmisi dengan maksimal 6 gigi
        Transmission transmission = new Transmission(6);
        // Membuat objek oil pan dengan level oli 4.0 liter
        OilPan oilPan = new OilPan(4.0);
        // Membuat objek CVT
        CVT cvt = new CVT();
        // Membuat empat roda dengan ukuran 16 inci dan tipe All-Terrain
        Wheel[] wheels = { new Wheel(16, "All-Terrain"), new Wheel(16, "All-Terrain"), new Wheel(16, "All-Terrain"), new Wheel(16, "All-Terrain") };
        // Membuat tangki bahan bakar dengan 50 liter
        FuelTank fuelTank = new FuelTank(50);
        // Membuat objek mobil dengan semua komponen di atas
        Car car = new Car(engine, transmission, oilPan, cvt, wheels, fuelTank);
        
        // Menyalakan mobil
        car.startCar();
        // Mempercepat putaran mesin
        engine.revEngine();
        // Mematikan mobil
        car.stopCar();
    }
}