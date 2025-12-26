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
      boolean firstLine=true;
       try (FileWriter fw = new FileWriter(FILE, true)) {
            
           
            
            fw.write(player.getName() +": "+player.getEngine().getScore()
                    +": "+player.getEngine().getTimeManager().getTotalTime()+" seconds \n");
            
           // System.out.println("writescore");
        }
       
   }
   
   public  String writeOnLeaderboard() throws IOException{
        List<String >arr= MakeScoreBoard.fillArrayFromFile(FILE);
       String output="";
        try (FileWriter fw = new FileWriter("LeaderBoard.txt", false)) {
            int i=1;
            
            
            for (String string : arr) {
                if(i>10)break;
                fw.write((int)(i)+"."+string+"\n");
                output+=(int)(i++)+"."+string+"\n";
            }
            
   
            
            
        }
        
            
               return output;
       
   
   
   }

  
  
  
    
    
    
}
