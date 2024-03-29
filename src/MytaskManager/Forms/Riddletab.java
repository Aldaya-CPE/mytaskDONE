
package MytaskManager.Forms;



import MytaskManager.Components.Riddle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Riddletab extends javax.swing.JFrame {
     private Timer timer;
    Timer t ;
    SimpleDateFormat st ;
     private Riddle randomRiddle;
     private String currentRiddle;
       private static Riddletab instance = null;
    public Riddletab() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        
        initComponents();
        setLocationRelativeTo(null);
     
        jTextPane2.setBorder(null);
        jTextPane2.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane2.setBorder(null);
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        
        displayRiddle();
        loadCurrentRiddle();
        times();
    
    }
    
     public static Riddletab getInstance() {
        if (instance == null) {
            instance = new Riddletab();
        }
        return instance;
    }
    
    
    
 public void displayRiddle(){
   
        randomRiddle = Riddle.getRiddle();
        jTextPane2.setText(randomRiddle.getQuestion());   
        jTextField1.setVisible(true);
       
        saveCurrentRiddle();
      
    currentRiddle = randomRiddle.getQuestion(); 
    

 try {
        FileWriter writer = new FileWriter("riddle.txt");
        writer.write(randomRiddle.getQuestion());
        writer.close();
        currentRiddle = randomRiddle.getQuestion();
    } catch (IOException e) {
        e.printStackTrace();
    }

  
    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            try {
                FileWriter writer = new FileWriter("riddle.txt");
                writer.write(randomRiddle.getQuestion());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    );
    }

private void saveCurrentRiddle() {
    try {
        FileWriter writer = new FileWriter("riddle.txt");
        writer.write(randomRiddle.getQuestion());
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
private void loadCurrentRiddle() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("riddle.txt"));
        String riddle = reader.readLine();
        reader.close();
        if (riddle != null) {
            randomRiddle = Riddle.getRiddle();
            jTextPane2.setText(randomRiddle.getQuestion());
            jTextField1.setVisible(true);
            
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}




public void times() {
    t = new Timer(1000, (ActionEvent e) -> {
        Calendar cal = Calendar.getInstance();
        int currentHour = cal.get(Calendar.HOUR_OF_DAY);
        int currentMinute = cal.get(Calendar.MINUTE);
        int currentSecond = cal.get(Calendar.SECOND);

        
        
        if (currentHour == 0 && currentMinute == 0 && currentSecond == 0) {
            displayRiddle();
         
        }
   
        Date date = new Date();
        st = new SimpleDateFormat("HH:mm a");
        String currentTime = st.format(date);
      
        
    });
    t.start();
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new RoundedPanel(100, new Color(255,255,255));
        Riddlelabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setUndecorated(true);

        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setOpaque(false);

        Riddlelabel.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        Riddlelabel.setForeground(new java.awt.Color(142, 117, 117));
        Riddlelabel.setText("Riddle of the Day");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        jTextPane2.setBorder(null);
        jTextPane2.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        jTextPane2.setForeground(new java.awt.Color(153, 153, 153));
        jTextPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextPane2.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextPane2.setOpaque(false);
        jScrollPane2.setViewportView(jTextPane2);

        jTextField1.setOpaque(true);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(142, 117, 117));
        jLabel2.setText("Answer:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/done1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(Riddlelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Riddlelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String userAnswer = jTextField1.getText().trim().toLowerCase();
        String correctAnswer = randomRiddle.getAnswer().toLowerCase();

        if (userAnswer.isEmpty()) {

        } else if (userAnswer.equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "Amazing! You are a Genius", "Correct", JOptionPane.INFORMATION_MESSAGE);

            jTextField1.setVisible(false);
           
            jTextPane2.setText("Waiting for another riddle...");
            jTextField1.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Try again!", "Wrong!", JOptionPane.ERROR_MESSAGE);
            jTextField1.setText("");
        }

        jTextField1.selectAll();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setVisible(false);
     
    }//GEN-LAST:event_jLabel3MouseClicked

    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Riddle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Riddle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Riddle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Riddle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Riddlelabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
    class RoundedPanel extends JPanel
       {
           private Color backgroundColor;
           private int cornerRadius = 15;

           public RoundedPanel(LayoutManager layout, int radius) {
               super(layout);
               cornerRadius = radius;
           }

           public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
               super(layout);
               cornerRadius = radius;
               backgroundColor = bgColor;
           }

           public RoundedPanel(int radius) {
               super();
               cornerRadius = radius;
           }

           public RoundedPanel(int radius, Color bgColor) {
               super();
               cornerRadius = radius;
               backgroundColor = bgColor;
           }

           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               Dimension arcs = new Dimension(cornerRadius, cornerRadius);
               int width = getWidth();
               int height = getHeight();
               Graphics2D graphics = (Graphics2D) g;
               graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

               if (backgroundColor != null) {
                   graphics.setColor(backgroundColor);
               } else {
                   graphics.setColor(getBackground());
               }
               graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); 
               graphics.setColor(getForeground());
               graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); 
           }
       }
   }class RoundedPanel extends JPanel
       {
           private Color backgroundColor;
           private int cornerRadius = 15;

           public RoundedPanel(LayoutManager layout, int radius) {
               super(layout);
               cornerRadius = radius;
           }

           public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
               super(layout);
               cornerRadius = radius;
               backgroundColor = bgColor;
           }

           public RoundedPanel(int radius) {
               super();
               cornerRadius = radius;
           }

           public RoundedPanel(int radius, Color bgColor) {
               super();
               cornerRadius = radius;
               backgroundColor = bgColor;
           }

           @Override
           protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               Dimension arcs = new Dimension(cornerRadius, cornerRadius);
               int width = getWidth();
               int height = getHeight();
               Graphics2D graphics = (Graphics2D) g;
               graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

               if (backgroundColor != null) {
                   graphics.setColor(backgroundColor);
               } else {
                   graphics.setColor(getBackground());
               }
               graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); 
               graphics.setColor(getForeground());
               graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); 
           }

}
