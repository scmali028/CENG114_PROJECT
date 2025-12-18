                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerInformation;

/**
 *
 * @author aliemre
 */
import Game.Player;
import static java.awt.JobAttributes.DestinationType.FILE;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class Submit {
    //bura dolucak sonra
    //ID + Name + puan +süre/saat
    
    
  private Player player;  
 
  private final String FILE="Submit.txt";
    public Submit(Player player) {
        this.player = player;
    }
                    //all submit karışık sırada
   public  void writeOnScoreboard() throws IOException{
       
       // !! şuan submitse yazıor ona göre 
      
       try (FileWriter fw = new FileWriter(FILE, true)) {
            
            
            fw.write(player.getId() + "###" + player.getName() +"###"+player.getEngine().getScore()
                    +"###"+player.getEngine().getLife()+"\n");
            
            
        }
       
   }
   public  void writeOnLeaderboard() throws IOException{
        List<String >arr= MakeScoreBoard.fillArrayFromFile(FILE);
        try (FileWriter fw = new FileWriter("LeaderBoard.txt", false)) {
            int i=1;
            fw.write("NAME    SCORE    TIME \n");
            for (String string : arr) {
                fw.write((int)(i++)+"."+string+"\n");
            }
            
           
            
            
        }
        
            
       
       
   
   
   }

  
  
  
    
    
    
}
