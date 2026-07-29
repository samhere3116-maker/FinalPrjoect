package Gui;
import Data.UserFileHandler;
import Utils.Session;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class WelcomeFrame extends JFrame {    
    private BufferedImage bg;
    public WelcomeFrame() {
        try{
            bg=ImageIO.read(new File(System.getProperty("user.dir").concat("//images//purple.jpg")));      
        }catch (IOException ex){
            System.getLogger(WelcomeFrame.class.getName()).log(System.Logger.Level.ERROR,(String) null, ex);
        }
        setSize(900, 600);
        initComponents();
        ImageIcon icon = new ImageIcon(new File("images/mindmate.png").getAbsolutePath());
        setIconImage(icon.getImage());
        setTitle("SAMAN RASHID");
String fullText = "Mood Game Recommender! This system analyzes your current mood and recommends the most suitable game for you to play. Answer honestly for best results!";
int[] position = {0};
javax.swing.Timer scrollTimer = new javax.swing.Timer(100, null);
scrollTimer.addActionListener(e -> {
    String display = "";
    for (int i = 0; i < 60; i++) {
        display += fullText.charAt((position[0] + i) % fullText.length());
    }
    jLabel18.setText(display);
    position[0] = (position[0] + 1) % fullText.length();
});
scrollTimer.start();
       
addHoverEffect(jButton5, 
    new java.awt.Color(22, 6, 45),  
    new java.awt.Color(45, 13, 89));   

addHoverEffect(jButton7,
    new java.awt.Color(22, 6, 45),     
    new java.awt.Color(45, 13, 89));    
addHoverEffect(jButton6,
    new java.awt.Color(22, 6, 45),     
    new java.awt.Color(45, 13, 89));   
        jLabel5.setText(Session.getCurrentUser());
      setExtendedState(JFrame.MAXIMIZED_BOTH);
     
    }
  
private void addHoverEffect(JButton button, 
                             java.awt.Color normalColor, 
                             java.awt.Color hoverColor) {
    button.setBackground(normalColor);
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            button.setBackground(hoverColor);
            button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            button.setBackground(normalColor);
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel()
        {
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(bg,0,0,getWidth(), getHeight(),null);

            }
        }
        ;
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MIND MATE ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(510, 50, 281, 70);

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html> Your <font color='#D8B4FE'>Mood</font>,  Your <font color='purple'>Game</font>,  Your <font color='#FF69B4''>Moment</font> </html>");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(500, 110, 300, 20);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(490, 220, 340, 50);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 0, 0);

        jButton5.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/game (1).gif"))); // NOI18N
        jButton5.setText("START JOURNEY ");
        jButton5.setBorder(null);
        jButton5.addActionListener(this::jButton5ActionPerformed);
        jPanel1.add(jButton5);
        jButton5.setBounds(490, 330, 300, 43);

        jLabel10.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Let’s find the perfect game for your mood! ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(450, 480, 390, 30);

        jButton7.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Exit");
        jButton7.setBorder(null);
        jButton7.addActionListener(this::jButton7ActionPerformed);
        jPanel1.add(jButton7);
        jButton7.setBounds(490, 430, 300, 40);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 0, 0, 0);

        jSeparator1.setForeground(new java.awt.Color(102, 0, 102));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(230, 160, 838, 16);

        jButton6.setFont(new java.awt.Font("Stencil", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("View History");
        jButton6.setBorder(null);
        jButton6.addActionListener(this::jButton6ActionPerformed);
        jPanel1.add(jButton6);
        jButton6.setBounds(490, 380, 300, 43);

        jLabel18.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Mood Game Recommender! This system analyzes your current mood through ");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(290, 280, 840, 30);

        jLabel19.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 0, 102));
        jLabel19.setText("Welcome");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(580, 180, 140, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    new MoodFrame().setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0);  
    }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 String username = Session.getCurrentUser();
    String lastHistory = UserFileHandler.getLastHistory(username);
    if (lastHistory == null) {
        JOptionPane.showMessageDialog(this,"No history found!\nPlay a game first.","History",JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    String[] parts = lastHistory.split(",");
    JOptionPane.showMessageDialog(this,
        "👤 User: " + parts[0] + "\n\n" +
        "😊 Last Mood: " + parts[1] + "\n" +
        "🎮 Last Game: " + parts[2] + "\n" +
        "👍 Feedback:  " + parts[3] + "\n" +
        "📅 Date:      " + parts[4] + "\n" +
        "🕐 Time:      " + parts[5],
        "Your Last Session",
        JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton6ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new WelcomeFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
