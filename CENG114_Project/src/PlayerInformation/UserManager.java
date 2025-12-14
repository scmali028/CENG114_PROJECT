/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerInformation;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alise
 */
public class UserManager {
    
    private ArrayList<User> users = new ArrayList<>();
    private final String fileName = "users.txt";

    public UserManager() throws FileNotFoundException {
        loadFromFile();
    }

    // FILE OKUMA
    private void loadFromFile() throws FileNotFoundException {

        try (Scanner sc = new Scanner(new File(fileName))) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");

                users.add(new User(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2])
                ));
            }

        }
        // Dosya yoksa ilk çalışmada sorun değil
            }

    // KULLANICI VAR MI? (recursive search olabilir ama şimdilik sade)
    public User findUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    // CASE 1: REGISTER
    public User register(String username, String password) {

        if (findUser(username) != null) {
            return null; // username dolu
        }

        User newUser = new User(username, password, 0);
        users.add(newUser);
        saveToFile();
        return newUser;
    }

    // CASE 2: LOGIN
    public User login(String username, String password) {

        User u = findUser(username);

        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    // DOSYAYA YAZ
    public void saveToFile() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {

            for (User u : users) {
                pw.println(u);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}