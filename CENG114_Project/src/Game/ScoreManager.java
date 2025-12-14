package Game;

public class ScoreManager {
 private double score = 0;
    
    
    public double addScore(String answer, int howManyGotLetter) {
       
        
        double eachLetterPoint = 100.0;
        score += eachLetterPoint * (answer.length() - howManyGotLetter);
        return score;
    }

    public double getScore() {
        return score;
    }
    
    public double canTakeScore(String answer,int howManyGotLetter){
    
    
    return 100*(answer.length()-howManyGotLetter);
    }
    
}