/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cengsınıfnotlistesi;

/**
 *
 * @author alise
 */
public class Ogrenci {

    String ogrenciNo;
    String ad, soyad;
    String quiz1 = " ", quiz2 = " ";

    public Ogrenci(String ogrenciNo, String ad, String soyad) {
        this.ogrenciNo = ogrenciNo;
        this.ad = ad;
        this.soyad = soyad;
    }

    @Override
    public String toString() {
        return ogrenciNo + " " + ad + " " + soyad + " " + quiz1 + " " + quiz2;
    }
}
