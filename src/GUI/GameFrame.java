/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



package GUI;

import LengthOfWords.AllWords;
import LengthOfWords.EightLettersWords;
import LengthOfWords.FiveLettersWords;
import LengthOfWords.FourLettersWords;
import LengthOfWords.NineLettersWords;
import LengthOfWords.SevenLettersWords;
import LengthOfWords.SixLettersWords;
import LengthOfWords.TenLettersWords;
import java.util.ArrayList;
import java.util.List;
import Game.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author alise
 */
public class GameFrame extends javax.swing.JFrame {

    /**
     * Creates new form GameFrame
     */
    
    private Timer gameTimer;
    private Timer estimateTimer;
    
    private int questionIndex = 0;
    private List<AllWords> LengthOfWords=new ArrayList<>();
    private  Player player;
 int howManyGotLetter = 0;
    
    public GameFrame(Player player) throws IOException {
        
        initComponents();
       // jTextFieldAnswerField.setVisible(false);
        this.player=player;
        loadCategories();
        loadQuestionAndAnswer();
        startGameTimer();
        
        
    }
    
    private void startGameTimer() {
    gameTimer = new Timer(1000, e -> {
        player.getEngine().getTimeManager().tickTotal();

        jLabelTime.setText(
            "Time: " + player.getEngine().getTimeManager().getTotalTime()
        );

        if (player.getEngine().getTimeManager().isTimeOver()) {
            gameTimer.stop();
            try {
                endGame();
            } catch (IOException ex) {
                Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    gameTimer.start();
}
    
    
    private void startEstimateTimer() {

    gameTimer.stop(); // ANA SÜRE DURUR
    player.getEngine().getTimeManager().startEstimate();

    estimateTimer = new Timer(1000, e -> {
        player.getEngine().getTimeManager().tickEstimate();

        jLabelEstimateTime.setText(
            "Estimate: " + player.getEngine().getTimeManager().getEstimateTime()
        );

        if (player.getEngine().getTimeManager().isEstimateOver()) {
            estimateTimer.stop();
         player.getEngine().removeScore(howManyGotLetter);
            
            try {
                questionIndex++;
                loadQuestionAndAnswer();
                // buraya skordan düşcek ve sonraki soru 
            } catch (IOException ex) {
                Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            gameTimer.start();
            // geri oyuna
        }
    });

    estimateTimer.start();
}
    
     public void loadCategories() {
        LengthOfWords.add(new FourLettersWords());
        LengthOfWords.add(new FiveLettersWords());
        LengthOfWords.add(new SixLettersWords());
        LengthOfWords.add(new SevenLettersWords());
        LengthOfWords.add(new EightLettersWords());
        LengthOfWords.add(new NineLettersWords());
        LengthOfWords.add(new TenLettersWords());
    }
     public void loadQuestionAndAnswer() throws IOException{
        
     if(questionIndex<LengthOfWords.size()-3)    { 
         
         howManyGotLetter=0;
         
     String randomWord=LengthOfWords.get(questionIndex).getRandomWord().toLowerCase();
     String question=LengthOfWords.get(questionIndex).getQuestion();
     jTextAreaQuestion.setText(question);// !!!!!! jlabel oalrak değişçek
     
     player.getEngine().setNewWord(randomWord);
     String output="\n\n  "+player.getEngine().getPrintNoVisibleState();
     jTextAreaHiddenAnswer.setText(output);
     
     updateScreen();
     
     }else{
    // double finalScore = player.getEngine().getScore();

    JOptionPane.showMessageDialog(
        this,
        player.toString()
    );
    
   
    SkorFrame skorFrame = new SkorFrame(player);
    skorFrame.setVisible(true);
   //bunu skorframede yap sornasında 
    
        
       



    this.dispose(); // GameFrame kapanır
     }
     
     }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonPass = new javax.swing.JButton();
        jButtonTakeLetter = new javax.swing.JButton();
        jButtonEstimate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaHiddenAnswer = new javax.swing.JTextArea();
        jLabelScore = new javax.swing.JLabel();
        jLabelReachablePoint = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaQuestion = new javax.swing.JTextArea();
        jButtonExit = new javax.swing.JButton();
        jTextFieldAnswerField = new javax.swing.JTextField();
        jLabelEstimateTime = new javax.swing.JLabel();
        jButtonCheck = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPass.setText("Pass");
        jButtonPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPassActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 108, 33));

        jButtonTakeLetter.setText("Take Letter");
        jButtonTakeLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTakeLetterActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTakeLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 108, 35));

        jButtonEstimate.setText("Estimate");
        jButtonEstimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstimateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEstimate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 108, 35));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(20, 20));

        jTextAreaHiddenAnswer.setColumns(20);
        jTextAreaHiddenAnswer.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jTextAreaHiddenAnswer.setRows(5);
        jTextAreaHiddenAnswer.setText("\n\n                                 ");
        jScrollPane1.setViewportView(jTextAreaHiddenAnswer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 180, 90));

        jLabelScore.setText("Score :");
        jPanel1.add(jLabelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, -1));

        jLabelReachablePoint.setText("reachable point");
        jPanel1.add(jLabelReachablePoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, -1));

        jLabelTime.setText("can/süre");
        jPanel1.add(jLabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));

        jTextAreaQuestion.setColumns(20);
        jTextAreaQuestion.setRows(5);
        jTextAreaQuestion.setText("SORUSU geşcek buraya");
        jScrollPane2.setViewportView(jTextAreaQuestion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 240, 40));

        jButtonExit.setText("exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));
        jPanel1.add(jTextFieldAnswerField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 90, -1));

        jLabelEstimateTime.setText("jLabel1");
        jPanel1.add(jLabelEstimateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jButtonCheck.setText("check");
        jButtonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPassActionPerformed

    private void jButtonEstimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstimateActionPerformed
    
    jTextFieldAnswerField.setVisible(true);
    startEstimateTimer();
    
   
    
    /*
    String guess = jTextFieldAnswerField.getText();
    boolean correct = player.getEngine().performEstimate(guess);

    estimateTimer.stop();
    gameTimer.start();

    if (correct) {
        player.getEngine().addScore(howManyGotLetter);
        questionIndex++;

        Timer t = new Timer(1500, e -> {
            try {
                loadQuestionAndAnswer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        t.setRepeats(false);
        t.start();
    }

    updateScreen();

  */
    }//GEN-LAST:event_jButtonEstimateActionPerformed
    private void endGame() throws IOException  {

    if (gameTimer != null) gameTimer.stop();
    if (estimateTimer != null) estimateTimer.stop();

    int remainingTime = player.getEngine().getTimeManager().getTotalTime();

    JOptionPane.showMessageDialog(
        this,
        "Game Over!\nScore: " + player.getEngine().getScore()
        + "\nTime: " + remainingTime
    );

    
    
    
    
    SkorFrame sf = new SkorFrame(player);
    sf.setVisible(true);
    this.dispose();
}
    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonTakeLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTakeLetterActionPerformed
        howManyGotLetter++;
        player.getEngine().performTakingLetter();
        //jLabelReachablePoint.setText("Reachable Point2: "+player.getEngine().getReachableScore(howManyGotLetter));
        if(player.getEngine().isCompleted()){
        questionIndex++;
        
            try {
                loadQuestionAndAnswer();
            } catch (IOException ex) {
                Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          updateScreen();
      
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTakeLetterActionPerformed

    private void jButtonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckActionPerformed

 String guess = jTextFieldAnswerField.getText();
    boolean correct = player.getEngine().performEstimate(guess);

    estimateTimer.stop();
    gameTimer.start();

    if (correct) {
        player.getEngine().addScore(howManyGotLetter);
        questionIndex++;

        Timer t = new Timer(1500, e -> {
            try {
                loadQuestionAndAnswer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        t.setRepeats(false);
        t.start();
    }

    updateScreen();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCheckActionPerformed
    private void updateScreen() {
       //howManyGotLetter=0;
    jLabelTime.setText("Time: " + player.getEngine().getTimeManager().getTotalTime());
    jLabelScore.setText("Score: " + player.getEngine().getScore());
    jLabelReachablePoint.setText("Reachable Point: "+player.getEngine().getReachableScore(howManyGotLetter));
    jTextAreaHiddenAnswer.setText(
        new String(player.getEngine().getCurrent())
    );
    
    
}
    
    
    /**
     * @param args the command line arguments
     */
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCheck;
    private javax.swing.JButton jButtonEstimate;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonPass;
    private javax.swing.JButton jButtonTakeLetter;
    private javax.swing.JLabel jLabelEstimateTime;
    private javax.swing.JLabel jLabelReachablePoint;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaHiddenAnswer;
    private javax.swing.JTextArea jTextAreaQuestion;
    private javax.swing.JTextField jTextFieldAnswerField;
    // End of variables declaration//GEN-END:variables
}
