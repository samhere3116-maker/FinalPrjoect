package Gui;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import Models.Question;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import logic.MoodAnalyzer;
public class MoodFrame extends javax.swing.JFrame {   
    private final ArrayList<Question> selectedQuestions; 
    private BufferedImage bg;
    public MoodFrame() {
    try {
        bg = ImageIO.read(new File(System.getProperty("user.dir")
            .concat("//images//purple.jpg")));
    } catch (IOException ex) {
        System.out.println("image not found!");
    }

    initComponents();

    
    ImageIcon icon = new ImageIcon(
        new File("images/mindmate.png").getAbsolutePath());
    setIconImage(icon.getImage());
    setTitle("MIND MATE - Tell Us Your Mood");

   
    javax.swing.JRadioButton[] buttons = {
        q1A, q1B, q1C,
        q2A, q2B, q2C,
        q3A, q3B, q3C,
        q4A, q4B, q4C,
        q5A, q5B, q5C
    };
    for (javax.swing.JRadioButton btn : buttons) {
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new java.awt.Cursor(
            java.awt.Cursor.HAND_CURSOR));
    }

    // Panel colors with rounded borders
    jPanel1.setBackground(new java.awt.Color(100, 0, 0));
    jPanel2.setBackground(new java.awt.Color(0, 0, 120));
    jPanel3.setBackground(new java.awt.Color(80, 0, 80));
    jPanel4.setBackground(new java.awt.Color(0, 80, 80));
    jPanel5.setBackground(new java.awt.Color(60, 0, 100));

    // Rounded borders for panels
    jPanel1.setBorder(javax.swing.BorderFactory
        .createLineBorder(new java.awt.Color(255, 100, 100), 2));
    jPanel2.setBorder(javax.swing.BorderFactory
        .createLineBorder(new java.awt.Color(100, 100, 255), 2));
    jPanel3.setBorder(javax.swing.BorderFactory
        .createLineBorder(new java.awt.Color(200, 100, 255), 2));
    jPanel4.setBorder(javax.swing.BorderFactory
        .createLineBorder(new java.awt.Color(100, 200, 200), 2));
    jPanel5.setBorder(javax.swing.BorderFactory
        .createLineBorder(new java.awt.Color(150, 100, 255), 2));

    // Style Analyze Mood button
    jButton1.setBackground(new java.awt.Color(100, 0, 200));
    jButton1.setForeground(java.awt.Color.WHITE);
    jButton1.setCursor(new java.awt.Cursor(
        java.awt.Cursor.HAND_CURSOR));
    jButton1.setBorderPainted(false);
    jButton1.setFocusPainted(false);

    // Hover effect on Analyze button
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            jButton1.setBackground(new java.awt.Color(150, 0, 255));
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            jButton1.setBackground(new java.awt.Color(100, 0, 200));
        }
    });

    // Hover effects on all panels
    addPanelHover(jPanel1, new java.awt.Color(100, 0, 0),
        new java.awt.Color(130, 0, 0));
    addPanelHover(jPanel2, new java.awt.Color(0, 0, 120),
        new java.awt.Color(0, 0, 160));
    addPanelHover(jPanel3, new java.awt.Color(80, 0, 80),
        new java.awt.Color(110, 0, 110));
    addPanelHover(jPanel4, new java.awt.Color(0, 80, 80),
        new java.awt.Color(0, 110, 110));
    addPanelHover(jPanel5, new java.awt.Color(60, 0, 100),
        new java.awt.Color(80, 0, 130));

    // Load random questions
    Data.QuestionBank bank = new Data.QuestionBank();
    selectedQuestions = bank.getRandomQuestions();

    // Set question labels
    jLabel2.setText(selectedQuestions.get(0).getQuestionText());
    jLabel3.setText(selectedQuestions.get(1).getQuestionText());
    jLabel4.setText(selectedQuestions.get(2).getQuestionText());
    jLabel15.setText(selectedQuestions.get(3).getQuestionText());
    jLabel19.setText(selectedQuestions.get(4).getQuestionText());

    // Set radio button options
    q1A.setText(selectedQuestions.get(0).getOptionA());
    q1B.setText(selectedQuestions.get(0).getOptionB());
    q1C.setText(selectedQuestions.get(0).getOptionC());
    q2A.setText(selectedQuestions.get(1).getOptionA());
    q2B.setText(selectedQuestions.get(1).getOptionB());
    q2C.setText(selectedQuestions.get(1).getOptionC());
    q3A.setText(selectedQuestions.get(2).getOptionA());
    q3B.setText(selectedQuestions.get(2).getOptionB());
    q3C.setText(selectedQuestions.get(2).getOptionC());
    q4A.setText(selectedQuestions.get(3).getOptionA());
    q4B.setText(selectedQuestions.get(3).getOptionB());
    q4C.setText(selectedQuestions.get(3).getOptionC());
    q5A.setText(selectedQuestions.get(4).getOptionA());
    q5B.setText(selectedQuestions.get(4).getOptionB());
    q5C.setText(selectedQuestions.get(4).getOptionC());

    // Set MainPanel size
    MainPanel.setPreferredSize(new java.awt.Dimension(1050, 1150));

    // Styled ScrollPane
    javax.swing.JScrollPane scroller =
        new javax.swing.JScrollPane(MainPanel);
    scroller.setVerticalScrollBarPolicy(
        javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroller.setHorizontalScrollBarPolicy(
        javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroller.getVerticalScrollBar().setUnitIncrement(20);
    scroller.getVerticalScrollBar().setPreferredSize(
        new java.awt.Dimension(14, 0));
    scroller.getVerticalScrollBar().setBackground(
        new java.awt.Color(30, 0, 60));
    scroller.setBorder(null);
    scroller.setBackground(new java.awt.Color(10, 0, 30));

    setContentPane(scroller);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    pack();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
}

// Helper method for panel hover effect
private void addPanelHover(javax.swing.JPanel panel,
                            java.awt.Color normal,
                            java.awt.Color hover) {
    panel.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            panel.setBackground(hover);
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            panel.setBackground(normal);
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bg != null) {
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                }
            }
        }
        ;
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        q3A = new javax.swing.JRadioButton();
        q3B = new javax.swing.JRadioButton();
        q3C = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        q1A = new javax.swing.JRadioButton();
        q1B = new javax.swing.JRadioButton();
        q1C = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        q2A = new javax.swing.JRadioButton();
        q2B = new javax.swing.JRadioButton();
        q2C = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        q4A = new javax.swing.JRadioButton();
        q4B = new javax.swing.JRadioButton();
        q4C = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        q5A = new javax.swing.JRadioButton();
        q5B = new javax.swing.JRadioButton();
        q5C = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 5, 79));
        jLabel1.setText("Tell us your Mood");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 260, 0, 0);
        MainPanel.add(jLabel1, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup3.add(q3A);
        q3A.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        q3A.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup3.add(q3B);
        q3B.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        q3B.setForeground(new java.awt.Color(255, 255, 255));
        q3B.addActionListener(this::q3BActionPerformed);

        buttonGroup3.add(q3C);
        q3C.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        q3C.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(q3A, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(q3B, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(q3C, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(q3C, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(q3A))
                    .addComponent(q3B, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 160, 0, 236);
        MainPanel.add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(30, 179, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(q1A);
        q1A.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        q1A.setForeground(new java.awt.Color(255, 255, 255));
        q1A.addActionListener(this::q1AActionPerformed);

        buttonGroup1.add(q1B);
        q1B.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        q1B.setForeground(new java.awt.Color(255, 255, 255));
        q1B.addActionListener(this::q1BActionPerformed);

        buttonGroup1.add(q1C);
        q1C.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        q1C.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(q1A, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(q1B, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(q1C, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(q1A, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q1B, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q1C, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 160, 0, 236);
        MainPanel.add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(529, 123));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup2.add(q2A);
        q2A.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        q2A.setForeground(new java.awt.Color(255, 255, 255));
        q2A.addActionListener(this::q2AActionPerformed);

        buttonGroup2.add(q2B);
        q2B.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        q2B.setForeground(new java.awt.Color(255, 255, 255));
        q2B.addActionListener(this::q2BActionPerformed);

        buttonGroup2.add(q2C);
        q2C.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        q2C.setForeground(new java.awt.Color(255, 255, 255));
        q2C.addActionListener(this::q2CActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(q2A, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(q2B, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(q2C, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(q2C, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q2B, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(q2A, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 160, 0, 236);
        MainPanel.add(jPanel3, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Sitka Text", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 59, 254));
        jLabel6.setText("Your mood matters");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.ipady = -3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 300, 0, 0);
        MainPanel.add(jLabel6, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup4.add(q4A);
        q4A.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        q4A.setForeground(new java.awt.Color(255, 255, 255));
        q4A.addActionListener(this::q4AActionPerformed);

        buttonGroup4.add(q4B);
        q4B.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        q4B.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup4.add(q4C);
        q4C.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        q4C.setForeground(new java.awt.Color(255, 255, 255));
        q4C.addActionListener(this::q4CActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(q4C, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(q4A, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(q4B, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(q4C)
                    .addComponent(q4A)
                    .addComponent(q4B)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 160, 0, 236);
        MainPanel.add(jPanel4, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(3, 43, 90));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup5.add(q5A);
        q5A.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        q5A.setForeground(new java.awt.Color(255, 255, 255));
        q5A.addActionListener(this::q5AActionPerformed);

        buttonGroup5.add(q5B);
        q5B.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        q5B.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup5.add(q5C);
        q5C.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        q5C.setForeground(new java.awt.Color(255, 255, 255));
        q5C.addActionListener(this::q5CActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(q5A, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(q5B, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(q5C, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(q5C, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q5B, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(q5A, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 160, 0, 236);
        MainPanel.add(jPanel5, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(10, 16, 108));
        jButton1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Analyze Mood");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 310, 19, 0);
        MainPanel.add(jButton1, gridBagConstraints);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void q1AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1AActionPerformed

    private void q1BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1BActionPerformed

    private void q2BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q2BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q2BActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int[] answers = new int[5];
    
    if (q1A.isSelected()) answers[0] = 0;
    else if (q1B.isSelected()) answers[0] = 1;
    else if (q1C.isSelected()) answers[0] = 2;

    if (q2A.isSelected()) answers[1] = 0;
    else if (q2B.isSelected()) answers[1] = 1;
    else if (q2C.isSelected()) answers[1] = 2;

    if (q3A.isSelected()) answers[2] = 0;
    else if (q3B.isSelected()) answers[2] = 1;
    else if (q3C.isSelected()) answers[2] = 2;

    if (q4A.isSelected()) answers[3] = 0;
    else if (q4B.isSelected()) answers[3] = 1;
    else if (q4C.isSelected()) answers[3] = 2;

    if (q5A.isSelected()) answers[4] = 0;
    else if (q5B.isSelected()) answers[4] = 1;
    else if (q5C.isSelected()) answers[4] = 2;
    
    MoodAnalyzer analyzer = new MoodAnalyzer();
    String mood = analyzer.analyzeMood(answers, selectedQuestions);
    System.out.println("Raw mood from analyzer: '" + mood + "'");
    new RecommendationFrame(mood).setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void q4CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q4CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q4CActionPerformed

    private void q5CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q5CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q5CActionPerformed

    private void q4AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q4AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q4AActionPerformed

    private void q2AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q2AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q2AActionPerformed

    private void q5AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q5AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q5AActionPerformed

    private void q3BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q3BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q3BActionPerformed

    private void q2CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q2CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q2CActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MoodFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton q1A;
    private javax.swing.JRadioButton q1B;
    private javax.swing.JRadioButton q1C;
    private javax.swing.JRadioButton q2A;
    private javax.swing.JRadioButton q2B;
    private javax.swing.JRadioButton q2C;
    private javax.swing.JRadioButton q3A;
    private javax.swing.JRadioButton q3B;
    private javax.swing.JRadioButton q3C;
    private javax.swing.JRadioButton q4A;
    private javax.swing.JRadioButton q4B;
    private javax.swing.JRadioButton q4C;
    private javax.swing.JRadioButton q5A;
    private javax.swing.JRadioButton q5B;
    private javax.swing.JRadioButton q5C;
    // End of variables declaration//GEN-END:variables
}

