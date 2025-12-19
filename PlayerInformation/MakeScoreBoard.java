/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerInformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author aliemre
 */
public class MakeScoreBoard {
    // dosyayı alsın Sorted array olarak yollasın

    private final static String SUBMITS_FILE = "Submit.txt";

    private static List<String> submitsList;

    public static List<String> fillArrayFromFile(String file) {
        List<String> arrFile = new ArrayList<>();

        //sildim o basit kodu şimdi biraz arraylist yapcaz 
        // şimdi dosyları arraye dökmede 
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // arraye düzgün şekilde ekledik
            while ((line = reader.readLine()) != null) {
                String decodeLine = "";
                String parts[] = line.split(": ");

                for (int i = 0; i < parts.length - 1; i++) {
                    decodeLine += parts[i + 1] + " : ";

                }

                if (!decodeLine.isEmpty()) {
                    // sondaki ' : 'goturdum bu sayaede
                    decodeLine = decodeLine.substring(0, decodeLine.length() - 3);
                    arrFile.add(decodeLine);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortingScore(arrFile);

        return arrFile;
    }

    private static List< String> sortingScore(List<String> ls) {
        // burada dehşetül vahşet ii kod var 
        Collections.sort(ls, (a, b) -> {
            
            int ScoreA = (int)Double.parseDouble(a.split(" : ")[1]);
            int ScoreB = (int)Double.parseDouble(b.split(" : ")[1]);
            // burayı ters yazıyorum çünkü olay şöyle ilk parametre x diğeri y olsun x>y olsaydı 
            // + değer dönecekti x<y olsaydı negatif değer dönücekti 
            // compare(x,y)
            // bunun  llayı - ve + ya göre x ve y yi sıralamak 
            // eğer - olursa   yani   x geçsin der 
            // eğer + olursa yani  bu sefer y geçer 
            //  böle yazımda küçükten büyüğe elde edersin
            // normal yazımda 

            //x      y
            return Integer.compare(ScoreB, ScoreA);  //12 2 
        });                    //(scoreA,ScoreB)  2 12 21 32 küçten büyüğe

        return ls;
    }

    // mesela  bruada şey avr aynı corsa nasıl sıralancak 
    /*
     private static List<String> sortingScore(List<String> ls) {

    Collections.sort(ls, (a, b) -> {
        int scoreA = Integer.parseInt(a.split(":")[1]);
        int scoreB = Integer.parseInt(b.split(":")[1]);

        // NEGATİF → a öne geçer
        return Integer.compare(scoreB, scoreA); // büyükten küçüğe
    });

    return ls;
}Collections.sort(ls, (a, b) -> {
    String[] pa = a.split(":");
    String[] pb = b.split(":");

    int scoreA = Integer.parseInt(pa[1]);
    int scoreB = Integer.parseInt(pb[1]);

    // 1️⃣ Önce score (büyükten küçüğe)
    int scoreCompare = Integer.compare(scoreB, scoreA);
    if (scoreCompare != 0) {
        return scoreCompare;
    }

    // 2️⃣ Score eşitse isim (A → Z)
    return pa[0].compareTo(pb[0]);
});
     
     
     
     */
}
