/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author aliemre
 */
public class AdminSystem {
    // bunalrın hepsi admin panelinde olucak şeyler 

    private final static String USERS_WORDS_AND_QUESITONS_FILE = "UsersWordsAndQuestion.txt";
    private final static String WORDS_AND_QUESTION_FILE = "WordsAndQuestions.txt";
    private final static String SUBMITS_FILE = "Submits.txt";
    private final static String USERSNAMES_AND_PASSWORDS_FILE = "UsernameAndPasswords.txt";

    private static List<String> usersWordsAndQuestionsList;
    private static List<String> usernamesAndPasswordsList;
    private static List<String> wordsAndQuestionsList;
    private static List<String> submitsList;

    public AdminSystem() {
        usersWordsAndQuestionsList = fillArrayFromFile(USERS_WORDS_AND_QUESITONS_FILE);
        wordsAndQuestionsList = fillArrayFromFile(WORDS_AND_QUESTION_FILE);
        submitsList = fillArrayFromFile(SUBMITS_FILE);
        usernamesAndPasswordsList = fillArrayFromFile(USERSNAMES_AND_PASSWORDS_FILE);
    }

    public List<String> fillArrayFromFile(String file) {
        List<String> arrFile = new ArrayList<>();

        //sildim o basit kodu şimdi biraz arraylist yapcaz 
        // şimdi dosyları arraye dökmede 
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String decodeLine = "";
                String parts[] = line.split("###");
                for (int i = 0; i < parts.length; i++) {
                    decodeLine += parts[i] + ": ";
                }
                // sondaki ': 'gitti
                decodeLine = decodeLine.substring(0, decodeLine.length() - 2);
                arrFile.add(decodeLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrFile;
    }
    // submitin hepsini yani //unreverse ettim metdou yani 
    //normalde eklemeli gitse call stacten ters yazlcaktı

    public static String listOfAllPlayer(String output, int i) {
        if (i < submitsList.size()) {
            output += submitsList.get(i) + "\n";
            return listOfAllPlayer(output, i + 1);
        } else {
            return output;
        }

    }
    //Oynadıpı oyunalr ve puanalrı belki tarih eklenebilir

    public static String searchPlayer(String output, String name, int i) {
        if (i < submitsList.size()) {
            if (submitsList.get(i).contains(name)) {
                output += submitsList.get(i) + "\n";
                return searchPlayer(output, name, i + 1);
            } else {
                return searchPlayer(output, name, i + 1);
            }

        } else {
            return output;

        }

    }
    // oyuncualrın sorualrını listeleiyor

    public static String listOfPlayerQuestions(String output, int i) {
        if (i < usersWordsAndQuestionsList.size()) {
            output += usersWordsAndQuestionsList.get(i) + "\n";
            return listOfPlayerQuestions(output, i + 1);
        } else {
            return output;
        }

    }

    public static void deletePlayer(int Id) {
        String temp = "" + Id;
        int size1 = usernamesAndPasswordsList.size();
        int size2 = submitsList.size();
        int size3 = usersWordsAndQuestionsList.size();

        // neden böle burası çünkü abi direk baştan yapsan her sildiğinde 
        //indexler bir sağa kaydığı için sen aslında silerken bir tane elemana bakmadan geçicen 
        //diğer tur  ve aynı zmaanda da sizeda eksilcek nullexception riskide doğururabilir
        //
        for (int i = usernamesAndPasswordsList.size() - 1; i >= 0; i--) {
            if (usernamesAndPasswordsList.get(i).contains(temp)) {
                usernamesAndPasswordsList.remove(i);
            }
        }
        for (int i = usersWordsAndQuestionsList.size() - 1; i >= 0; i--) {
            if (usersWordsAndQuestionsList.get(i).contains(temp)) {
                usersWordsAndQuestionsList.remove(i);
            }
        }
        for (int i = submitsList.size() - 1; i >= 0; i--) {
            if (submitsList.get(i).contains(temp)) {
                submitsList.remove(i);
            }
        }

        System.out.println("oyuncu silindi");

    }

    public static void addUsersQuestion() throws IOException {

        try (FileWriter fw = new FileWriter(WORDS_AND_QUESTION_FILE, true)) {
            for (int i = 0; i < usersWordsAndQuestionsList.size(); i++) {
                fw.write(usersWordsAndQuestionsList.get(i));

            }

        }

    }
    
    public static void deleteSubmitsResult() throws IOException{
    try (FileWriter fw = new FileWriter(WORDS_AND_QUESTION_FILE,false)) {
            fw.write("Leaderboards for this week");

        }
    
    
    }

    /*
    geriye kalan metodalr 
    2-oyuncuunun oyununu listlesin(String name) return String yaptım
    3-oyunucları  sorularını listelsesin yaptım
    4uygunsuz soru avrsa delete idsini ayzdırdğın içiçn hangi oyuncu olduğu belldir onu silcen buton aynı hep  
    sonra oda her yerden silicek diğer sorualrınıda silicek
    7-sorualrı ekleme butonu yap
    
    6-deletePlayer (int Id) boolean 
    
     */
}
