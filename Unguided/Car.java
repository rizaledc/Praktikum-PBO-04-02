/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum3.Guided;

/**
 *
 * @author rwp44
 */
public class Car {
    private Engine engine;
    private Transmission transmission;
    private OilPan oilPan;
    private CVT cvt;
    private Wheel[] wheels;
    private FuelTank fuelTank;

    // Konstruktor untuk inisialisasi mobil dengan komponennya
    public Car(Engine engine, Transmission transmission, OilPan oilPan, CVT cvt, Wheel[] wheels, FuelTank fuelTank) {
        this.engine = engine;
        this.transmission = transmission;
        this.oilPan = oilPan;
        this.cvt = cvt;
        this.wheels = wheels;
        this.fuelTank = fuelTank;
    }

    // Metode untuk menyalakan mobil
    public void startCar() {
        if (fuelTank.hasFuel()) {
            System.out.println("Starting the car...");
            oilPan.checkOilLevel();
            fuelTank.checkFuelLevel();
            engine.start();
            transmission.shiftGear(1);
            cvt.adjustRatio();
            for (Wheel wheel : wheels) {
                wheel.rotate();
            }
        } else {
            System.out.println("Cannot start the car, fuel tank is empty!");
        }
    }

    // Metode untuk mematikan mobil
    public void stopCar() {
        System.out.println("Stopping the car...");
        transmission.shiftGear(0);
        engine.stop();
    }
}

