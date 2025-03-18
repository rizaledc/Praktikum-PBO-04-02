/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Guided.Driver;

import Guided.HargaBuku.KelasHarga;
import Guided.HargaToken.KelasToken;

/**
 *
 * @author rwp44
 */
public class TestPackages {
    public static void main(String[] args) {
        KelasToken token = new KelasToken();
        KelasHarga harga = new KelasHarga();
        token.info();
        harga.info();
    }
}