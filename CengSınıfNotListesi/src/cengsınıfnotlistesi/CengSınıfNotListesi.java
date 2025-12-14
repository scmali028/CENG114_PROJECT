/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cengsınıfnotlistesi;

import cengsınıfnotlistesi.Ogrenci;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author alise
 */
public class CengSınıfNotListesi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File isimDosyasi = new File("isimler.txt");
        List<Ogrenci> ogrenciListesi = new ArrayList<>();
        try {
            Scanner inp = new Scanner(isimDosyasi);
            while (inp.hasNext()) {
                String satir = inp.nextLine();
                String[] parcalar = satir.split(" ");
                if (parcalar.length >= 3) {
                    String no = parcalar[0];
                    String soyad = parcalar[parcalar.length - 1];

                    String ad = "";
                    for (int i = 1; i < parcalar.length - 1; i++) {
                        ad += parcalar[i] + " ";
                    }
                    ogrenciListesi.add(new Ogrenci(no, ad.trim(), soyad));
                }
            }
            System.out.println("isim listesi yüklendi"
                    + ", kişi sayisi: " + ogrenciListesi.size());
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return;
        }
        File notDosyasi = new File("notlar.txt");
        try (Scanner inp = new Scanner(notDosyasi)) {
            while (inp.hasNext()) {
                String satir = inp.nextLine();
                if (satir.trim().isEmpty()) {
                    continue;
                }
                String[] parcalar = satir.trim().split(" ");
                if (parcalar.length >= 2) {
                    Ogrenci ogrenci = ogrenciBul(ogrenciListesi, parcalar[0]);

                    if (ogrenci != null) {
                        ogrenci.quiz1 = parcalar[1];
                        if (parcalar.length>2) {
                            
                        
                        ogrenci.quiz2 = parcalar[2];
                    }}
                }
            }

            System.out.println("Notlar eşlendi");

        } catch (FileNotFoundException e) {
            System.out.println("Hata dosya bulunamadı");
        }
        File sonucDosyasi = new File("sonuc.txt");

        try (PrintWriter yazici = new PrintWriter(sonucDosyasi)) {
            System.out.println("-------------merged-----------------");
            for (Ogrenci ogrenci : ogrenciListesi) {
                yazici.print(ogrenci.toString());
                System.out.println(ogrenci);
            }
            System.out.println("işlem tamam --sonuc dosyasi");

        } catch (FileNotFoundException e) {
            System.out.println("Dosya oluşturma hatası " + e);
        }
    }

    public static Ogrenci ogrenciBul(List<Ogrenci> liste, String arananNo) {
        for (Ogrenci ogrenci : liste) {
            if (ogrenci.ogrenciNo.equals(arananNo)) {
                return ogrenci;
            }
        }
        return null;
    }

}
