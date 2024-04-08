
package MytaskManager.LoginPage;

import MytaskManager.Controller.userController;
import MytaskManager.Main.Main;
import MytaskManager.Model.ModelUser;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        initMoving(this);
        userid.setVisible(false);
        
        
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/close.png"))); 
       jButton9.setBorder(null);
       jButton9.setToolTipText("Close");
       jButton9.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jButton9ActionPerformed(evt);
         }
     });
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/minimize.png"))); 
       jButton8.setBorder(null);
       jButton8.setToolTipText("Minimize");
       jButton8.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jButton8ActionPerformed(evt);
         }
     });
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/retore.png"))); 
       jButton10.setBorder(null);
       jButton10.setToolTipText("Restore Pange");
       jButton10.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             jButton10ActionPerformed(evt);
         }
     });
        
    }
 private int x;
    private int y;

    public void initMoving(JFrame frame){
        panelRound1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                
                x = e.getX();
                y = e.getY();
            }
            
        });
        panelRound1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
             frame.setLocation(e.getXOnScreen()-x, e.getYOnScreen()-y);
                
                
            }
        });
    }
     private static String generateUID(){
        int userId = 6;
        Random random = new Random();
        StringBuilder userBuilder = new StringBuilder();
        for (int i = 0; i < userId; i++) {
            userBuilder.append(random.nextInt(10));
        }
        String uID = userBuilder.toString();
        return uID;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new MytaskManager.Components.PanelRound();
        panelGradient1 = new MytaskManager.Components.PanelGradient();
        panelRound2 = new MytaskManager.Components.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        ass = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        as = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        userid = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        panelGradient1.setBackground(new java.awt.Color(255, 255, 255));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(90);
        panelRound2.setRoundBottomRight(90);
        panelRound2.setRoundTopLeft(90);
        panelRound2.setRoundTopRight(90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/418729337_1025829478509921_6072428735755224544_n-removebg-preview (1).png"))); // NOI18N

        ass.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ass.setForeground(new java.awt.Color(142, 117, 117));
        ass.setText("Username:");

        username.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(142, 117, 117)));

        as.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        as.setForeground(new java.awt.Color(142, 117, 117));
        as.setText("Password:");

        password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(142, 117, 117)));

        jButton1.setBackground(new java.awt.Color(237, 195, 195));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setText("Log in");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("I don't have an account:");

        jButton2.setBackground(new java.awt.Color(214, 239, 194));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Sign Up");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        userid.setText("jLabel3");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(as)
                                    .addComponent(username)
                                    .addComponent(ass)
                                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(userid))))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1)))
                .addGap(21, 21, 21))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(ass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(as)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(166, 166, 166))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(102, 102, 102))
        );

        jButton9.setBackground(new java.awt.Color(253, 253, 253));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 0, 0));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/close.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(253, 253, 253));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/retore.png"))); // NOI18N
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(253, 253, 253));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/minimize.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
      

        String adminUsername = "admin";
        String adminPassword = "admin"; 

        String enteredUsername = username.getText();
        char[] enteredPassword = password.getPassword();
        if (enteredUsername.equals(adminUsername) && Arrays.equals(enteredPassword, adminPassword.toCharArray())) {
           Preferences prefs = Preferences.userNodeForPackage(Login.class);
            prefs.putBoolean("isLoggedIn", true);
            JOptionPane.showMessageDialog(this, "Admin login successful!");

            Main m = new Main();
            m.MainID.setText("Admin"); 
            m.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            m.setVisible(true);
            setVisible(false);
        } else {

            Main m = new Main();
            userController controller = new userController();
            ModelUser login = new ModelUser();


            if (enteredUsername != null && enteredPassword != null) {
                login.setUserName(enteredUsername);
                login.setPassWord(enteredPassword);

                ModelUser result = controller.Login(login);
                if (result != null) {
                    Preferences prefs = Preferences.userNodeForPackage(Login.class);
                    prefs.putBoolean("isLoggedIn", true);
                    
                    m.MainID.setText(result.getUserId());
                    m.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    m.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect Username or Password, please Try again!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username or Password cannot be empty!");
            }
        }




    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (this.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
            this.setExtendedState(JFrame.NORMAL); // Restores window size
        } else {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes window
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        signUp s = new signUp();
        this.setVisible(false);
        s.setVisible(true);
        s.genId.setText(generateUID());
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel as;
    private javax.swing.JLabel ass;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private MytaskManager.Components.PanelGradient panelGradient1;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound2;
    private javax.swing.JPasswordField password;
    public javax.swing.JLabel userid;
    public javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
