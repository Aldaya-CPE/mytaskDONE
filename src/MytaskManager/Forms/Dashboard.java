package MytaskManager.Forms;

import MytaskManager.Components.Qoutes;
import MytaskManager.Database.Database;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class Dashboard extends javax.swing.JPanel {
      private Timer timer;
      PreparedStatement p;
    private String username;
    private String currentQuote;
    Timer t ;
    SimpleDateFormat st ;
    
    
    public Dashboard() {
        initComponents();
          try {
            Database.getInstance().ConnectToDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        setOpaque(false);
        jTextPane1.setBorder(null);
        jTextPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.setBorder(null);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());

        this.username = username;
        times();
        displayQoutes();

        updateDeadline();
        updateCompleted();
        updatetodo();
        username();
        userId.setVisible(false); 
         
         timer = new Timer(1000, (e) -> {
            populateTable();
            updateDeadline();
            updateCompleted();
            updatetodo();
            username();
            
        });
        timer.start();
        
        for (int i = 0; i < jTable5.getColumnCount(); i++) {
            jTable5.getColumnModel().getColumn(i).setCellRenderer(new WhiteTextSelectionRenderer());
        }
 
    }
    
          private class WhiteTextSelectionRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
                rendererComponent.setForeground(Color.WHITE);
            } else {
                rendererComponent.setForeground(table.getForeground());
            }
            return rendererComponent;
        }
    }
        
          public void updateDeadline(){
        try {
            String sql = "SELECT * FROM deadlinedata WHERE userId = ?";
            String sqlv1 = "SELECT COUNT(*) FROM deadlinedata WHERE userId = ?";
            p = Database.getInstance().getConnection().prepareStatement(sql);
           p = Database.getInstance().getConnection().prepareStatement(sqlv1);
          
            p.setString(1, userId.getText());
            ResultSet rsDeadline = p.executeQuery();
            rsDeadline.next();
            int deadlineCount = rsDeadline.getInt(1);
             jLabel4.setText("" + deadlineCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateCompleted(){
        try {
            String sql2 = "SELECT COUNT(*) FROM completed WHERE userId = ?";
            String sqlv2 = "SELECT COUNT(*) FROM completed WHERE userId = ?";
            p = Database.getInstance().getConnection().prepareStatement(sql2);
            p = Database.getInstance().getConnection().prepareStatement(sqlv2);
            p.setString(1, userId.getText());
            ResultSet rsCompleted = p.executeQuery();
            rsCompleted.next();
            int completedCount = rsCompleted.getInt(1);
            jLabel2.setText("" + completedCount);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public  void updatetodo(){
        try {
                        
            String sql3 = "SELECT COUNT(*) FROM todo WHERE userId = ?";
            String sqlv3 = "SELECT COUNT(*) FROM todo WHERE userId = ?";
            p = Database.getInstance().getConnection().prepareStatement(sql3);
            p = Database.getInstance().getConnection().prepareStatement(sqlv3);
            p.setString(1, userId.getText());
            ResultSet rsTodo = p.executeQuery();
            rsTodo.next();
            int todoCount = rsTodo.getInt(1);
            jLabel9.setText("" + todoCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 
public void username() {
    try {
       
        String sql = "SELECT userName FROM userdata WHERE userId = ?";
        p = Database.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, userId.getText());
        ResultSet rsUsername = p.executeQuery();
        
        if (rsUsername.next()) {
            String username = rsUsername.getString("userName");
            jLabel6.setText(username);
        } else {
            jLabel6.setText("User not found");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

          
     public void populateTable(){
        try {
           String sql = "SELECT * FROM todo WHERE userId = ?";
            PreparedStatement p = Database.getInstance().getConnection().prepareStatement(sql);
            p.setString(1,userId.getText());           
            ResultSet rs = p.executeQuery();
            
           
            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String task = rs.getString("task");
                
                model.addRow(new Object[]{task});
            }

            jTable5.setModel(model);
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    


public void displayQoutes() {
    Qoutes qoutes = new Qoutes();
    String randomQuote = qoutes.getRandomQuote();

    jTextPane1.setText(""); 

    long currentTimeMillis = System.currentTimeMillis();
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(currentTimeMillis);
    int currentHour = cal.get(Calendar.HOUR_OF_DAY);
    int currentMinute = cal.get(Calendar.MINUTE);
    int currentSecond = cal.get(Calendar.SECOND);

    if (currentHour == 0 && currentMinute == 0 && currentSecond == 0) {
        try {
            jTextPane1.getDocument().insertString(jTextPane1.getDocument().getLength(), randomQuote + "\n", null);

         
            FileWriter writer = new FileWriter("quote.txt");
            writer.write(randomQuote);
            writer.close();

         
            currentQuote = randomQuote;

        } catch (IOException | BadLocationException e) {
            e.printStackTrace();
        }
    } else {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("quote.txt"));
            String quote = reader.readLine();
            reader.close();

            jTextPane1.setText(quote);
            currentQuote = quote;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        try {
            FileWriter writer = new FileWriter("quote.txt");
            writer.write(currentQuote);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
});
  
        try {
        BufferedReader reader = new BufferedReader(new FileReader("quote.txt"));
        String quote = reader.readLine();
        reader.close();
        jTextPane1.setText(quote);
        currentQuote = quote;
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
            displayQoutes();

        }
   
        Date date = new Date();
        st = new SimpleDateFormat("hh:mm a");
        String currentTime = st.format(date);
        t_time.setText(currentTime);

       
        if (currentHour >= 0 && currentHour < 12) {
       
//            ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/morning.png"));
//            changeimage.setIcon(icon);
            dayGreetings.setText("Good Morning");
        } else if (currentHour >= 12 && currentHour < 18) {
           
//            ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/afternoon.png"));
//            changeimage.setIcon(icon);
            dayGreetings.setText("Good Afternoon");
        } else {
       
//            ImageIcon icon = new ImageIcon(getClass().getResource("/MytaskManager/icon/evening.png"));
//            changeimage.setIcon(icon);
            dayGreetings.setText("Good Evening");
        }
    });
    t.start();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new MytaskManager.Components.PanelRound();
        dayGreetings = new javax.swing.JLabel();
        t_time = new javax.swing.JLabel();
        changeimage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelRound4 = new MytaskManager.Components.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelRound7 = new MytaskManager.Components.PanelRound();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        panelRound2 = new MytaskManager.Components.PanelRound();
        Qoutes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        panelRound5 = new MytaskManager.Components.PanelRound();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        userId = new javax.swing.JLabel();

        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        dayGreetings.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dayGreetings.setForeground(new java.awt.Color(142, 117, 117));
        dayGreetings.setText("Good morning ");

        t_time.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        t_time.setForeground(new java.awt.Color(142, 117, 117));
        t_time.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_time.setText("0");
        t_time.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        changeimage.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        changeimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/girl2.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(dayGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeimage)
                        .addGap(12, 12, 12))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(dayGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(t_time, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(changeimage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38))))
        );

        panelRound4.setRoundBottomLeft(90);
        panelRound4.setRoundBottomRight(90);
        panelRound4.setRoundTopLeft(90);
        panelRound4.setRoundTopRight(90);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(142, 117, 117));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Statistics");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/circle3.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(117, 118, 116));
        jLabel5.setText("Completed");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/circle2.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(117, 118, 116));
        jLabel7.setText("Deadline");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(27, 27, 27))
        );

        panelRound7.setRoundBottomLeft(90);
        panelRound7.setRoundBottomRight(90);
        panelRound7.setRoundTopLeft(90);
        panelRound7.setRoundTopRight(90);

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelRound2.setRoundBottomLeft(90);
        panelRound2.setRoundBottomRight(90);
        panelRound2.setRoundTopLeft(90);
        panelRound2.setRoundTopRight(90);

        Qoutes.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        Qoutes.setForeground(new java.awt.Color(142, 117, 117));
        Qoutes.setText("Qoute of the Day");

        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Sylfaen", 1, 20)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(142, 117, 117));
        jTextPane1.setOpaque(false);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(Qoutes, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(Qoutes)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelRound5.setRoundBottomLeft(90);
        panelRound5.setRoundBottomRight(90);
        panelRound5.setRoundTopLeft(90);
        panelRound5.setRoundTopRight(90);

        jTable5.setBackground(new java.awt.Color(242, 242, 242));
        jTable5.setForeground(new java.awt.Color(117, 118, 116));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Task"
            }
        ));
        jTable5.setSelectionForeground(new java.awt.Color(117, 118, 116));
        jScrollPane3.setViewportView(jTable5);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(142, 117, 117));
        jLabel8.setText("Mytask");

        jLabel9.setForeground(new java.awt.Color(117, 118, 116));

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelRound5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        userId.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userId)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(userId)))
                        .addGap(18, 18, 18)
                        .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Qoutes;
    public javax.swing.JLabel changeimage;
    private javax.swing.JLabel dayGreetings;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextPane jTextPane1;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound2;
    private MytaskManager.Components.PanelRound panelRound4;
    private MytaskManager.Components.PanelRound panelRound5;
    private MytaskManager.Components.PanelRound panelRound7;
    private javax.swing.JLabel t_time;
    public javax.swing.JLabel userId;
    // End of variables declaration//GEN-END:variables
}
