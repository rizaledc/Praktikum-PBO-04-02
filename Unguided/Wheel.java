/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum3.Guided;

/**
 *
 * @author rwp44
 */
public class Wheel {
    private int size; // Ukuran roda dalam inci
    private String type; // Jenis roda

    // Konstruktor untuk inisialisasi roda
    public Wheel(int size, String type) {
        this.size = size;
        this.type = type;
    }

    // Metode untuk memutar roda
    public void rotate() {
        System.out.println("Wheels of size " + size + " inch and type " + type + " are rotating.");
    }
}
