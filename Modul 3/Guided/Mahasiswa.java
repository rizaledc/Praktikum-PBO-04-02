/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum3.Guided;

/**
 *
 * @author rwp44
 */
public class Mahasiswa {
     private String nim;
 private String nama;
 protected int nilai;
 public void setNama(String nama){
 this.nama = nama;
 }
 public void setNim(String nim){
 this.nim = nim;
 }
 public String getNama(){
 return this.nama;
 }
 public String getNim(){
    return this.nim;
    }
public void setNilai(int nilai){
 this.nilai = nilai;
 }
 public int getNilai(){
 return this.nilai;
 }
}