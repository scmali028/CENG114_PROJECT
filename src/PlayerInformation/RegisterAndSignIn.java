package PlayerInformation;

import Game.NormalPlayer;
import java.io.IOException;
import java.util.Scanner;

public class RegisterAndSignIn {

    private String userName;
   // private final Scanner input;
    private final ReaderAndWriterFileProcess fileProcess;
   
    
    
    
    
    
    
    public RegisterAndSignIn() {
        
       
        this.fileProcess = new ReaderAndWriterFileProcess();
    }

    public String getUserName() {
        return userName;
    }

    public boolean register(String username,String pass1,String pass2) throws IOException {
        //System.out.print("Username: ");
        //String username = input.next();

        if (!fileProcess.isUserAvailable(username)) {
            System.out.println("Bu kullanıcı exist.");
            return false;
        }
/*
        System.out.print("Password: ");
        String pass1 = input.next();
        System.out.print("Passwordenetr  again: ");
        String pass2 = input.next();
*/
        if (!pass1.equals(pass2)) {
            System.out.println("notequals");
            return false;
        }

        fileProcess.writeUser(username, pass1);
        this.userName = username;
        System.out.println("Register başarılı.");
        
        
        
        return true;
    }

    public int signIn(String username,String password) throws IOException {
        System.out.print("Username: ");
       // String username = input.next();
        
        
        System.out.print("Password: ");
        //String password = input.next();
        if(username.equals("Admin")   && password.equals("admin")){
            //System.out.println("buraya gşriior eğer ");
        this.userName=username;
        return 0;
        }
        if (fileProcess.checkUserInformation(username, password)) {
            this.userName = username;
            return 1;
        }

        //System.out.println("Giriş başarısız.");
        return -1;
    }
}
