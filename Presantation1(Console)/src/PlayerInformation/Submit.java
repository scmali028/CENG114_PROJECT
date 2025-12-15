                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerInformation;

/**
 *
 * @author aliemre
 */
import Hangman.Player;
import static java.awt.JobAttributes.DestinationType.FILE;
import java.io.FileWriter;
import java.io.IOException;
public class Submit {
    //bura dolucak sonra
    //ID + Name + puan +süre/saat
    
    
  private Player player;  
  
  private final String FILE="Submit.txt";
    public Submit(Player player) {
        this.player = player;
    }
    
   public  void writeOnScoreboard() throws IOException{
       try (FileWriter fw = new FileWriter(FILE, true)) {
            
            
            fw.write(player.getId() + "###" + player.getName() +"###"+player.getEngine().getScore()
                    +"###"+player.getEngine().getLife()+"\n");
        }
       
       
       
   
   
   }

  
  
  
    
    
    
}
