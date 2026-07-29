/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Utils.Session;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class RecommendationFrame extends javax.swing.JFrame {
    private String currentMood;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RecommendationFrame.class.getName());
    BufferedImage bg;
    private String selectedGameName = "";
    public RecommendationFrame(String mood) {
      try{
            bg=ImageIO.read(new File(System.getProperty("user.dir").concat("//images//purple.jpg")));      
        }catch (IOException ex){
            System.getLogger(WelcomeFrame.class.getName()).log(System.Logger.Level.ERROR,(String) null, ex);
        }
        initComponents();
         ImageIcon icon = new ImageIcon(new File("images/mindmate.png").getAbsolutePath());
           
    setIconImage(icon.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
         setTitle("IZZA AJMAL");
    System.out.println("Mood received in RecommendationFrame: '" + mood + "'");
    this.currentMood = mood;    
    // Save mood to history
    Session.userData.addMood(mood);    
    // Show detected mood
    jLabel2.setText("Detected Mood: " + mood);   
    // Show recommended game based on mood
    String gameName = getGameName(mood);
    jLabel3.setText("Recommended Game: " + gameName);   
    // Save game to history
    Session.userData.addGame(gameName);
    this.selectedGameName = gameName;
        setMoodImage(mood);
}

private String getGameName(String mood) {
    switch (mood) {
        case "ANGRY":    return "Stress Release Clicker";
        case "ACTIVE":   return "Speed Challenge Clicker";
        case "STRESSED": return "Breathing Calm Clicker";
        case "CALM":     return "Relaxing Memory Game";
        case "SAD":      return "Cheerful Memory Game";
        case "HAPPY":    return "Fun Memory Game";
        case "FOCUSED":  return "Brain Quiz Game";
        default:         return "Memory Game";
    }
    }
private int getLevel(String mood) {
    switch (mood.toUpperCase()) {
        case "STRESSED":
        case "SAD":
        case "CALM":
            return 1;
        case "FOCUSED":
        case "HAPPY":
            return 2;
        case "ACTIVE":
        case "ANGRY":
            return 3;
        default:
            return 1;
    }
}
private void setMoodImage(String mood) {
    String imagePath = "";
    switch (mood.toUpperCase()) {
        case "ANGRY":
            imagePath = "images/angry.png";
            break;

        case "ACTIVE":
            imagePath = "images/active.png";
            break;

        case "STRESSED":
            imagePath = "images/stressed.png";
            break;

        case "CALM":
            imagePath = "images/calm.png";
            break;

        case "SAD":
            imagePath = "images/sad.png";
            break;

        case "HAPPY":
            imagePath = "images/happy.png";
            break;

        case "FOCUSED":
            imagePath = "images/focused.png";
            break;

        default:
            imagePath = "images/default.png";
    }
    javax.swing.ImageIcon icon =new javax.swing.ImageIcon(System.getProperty("user.dir") + "/" + imagePath);
    java.awt.Image img =
        icon.getImage().getScaledInstance(
            jButton3.getWidth(),
            jButton3.getHeight(),
            java.awt.Image.SCALE_SMOOTH
        );
    jButton3.setIcon(new javax.swing.ImageIcon(img));
    // remove text
    jButton3.setText("");
    // optional styling
    jButton3.setBorderPainted(false);
    jButton3.setContentAreaFilled(false);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 76));
        jLabel1.setText("Game Recommendation ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(312, 175, 611, 97);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(83, 169, 249));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(293, 275, 630, 40);

        jLabel3.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(83, 169, 249));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(293, 335, 630, 40);

        jButton1.setBackground(new java.awt.Color(19, 49, 195));
        jButton1.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\samhe\\Downloads\\play-button-arrowhead.png")); // NOI18N
        jButton1.setText("PLAY");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1);
        jButton1.setBounds(532, 413, 120, 40);

        jButton2.setBackground(new java.awt.Color(110, 0, 43));
        jButton2.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BACK");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2);
        jButton2.setBounds(532, 483, 120, 40);

        jButton3.setBackground(new java.awt.Color(20, 5, 46));
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jButton3);
        jButton3.setBounds(150, 380, 200, 180);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 currentMood = currentMood.toUpperCase();
    
    try {
        String jarFile = "";
        
        if (currentMood.equals("ANGRY") ||
            currentMood.equals("ACTIVE") ||
            currentMood.equals("STRESSED")) {
            jarFile = "ClickerGame.jar";
        }
        else if (currentMood.equals("CALM") ||
                 currentMood.equals("SAD") ||
                 currentMood.equals("HAPPY")) {
            jarFile = "Memory_Game.jar";
        }
        else if (currentMood.equals("FOCUSED")) {
            jarFile = "QuizGame.jar";
        }
        
        // Build path
        String gamesPath = System.getProperty("user.dir") + "\\Games\\" + jarFile;
        System.out.println("Full path: " + gamesPath);
        
        // Get level based on mood
        int level = getLevel(currentMood);
        System.out.println("Level: " + level);
        
        // Launch game with mood AND level
        String[] command = {"java", "-jar", gamesPath, currentMood, String.valueOf(level)};
        Process gameProcess = new ProcessBuilder(command).start();
        
        // Hide frame
        this.setVisible(false);
        
        // Wait for game then open feedback
        new Thread(() -> {
            try {
                gameProcess.waitFor();
                javax.swing.SwingUtilities.invokeLater(() -> {
                    new FeedbackFrame(currentMood, selectedGameName).setVisible(true);
                    this.dispose();
                });
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }).start();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Error: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new MoodFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new RecommendationFrame("CALM").setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
