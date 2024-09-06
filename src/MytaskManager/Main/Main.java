package MytaskManager.Main;
import MytaskManager.Database.Database;
import MytaskManager.Forms.Calendar;
import MytaskManager.Forms.Completed;
import MytaskManager.Forms.Dashboard;
import MytaskManager.Forms.Deadline;
import MytaskManager.Forms.Statistic;
import MytaskManager.Forms.Todo;
import MytaskManager.Forms.Riddletab;
import MytaskManager.Forms.addTask;
import MytaskManager.LoginPage.Login;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import swing.DataSearch;
import swing.EventClick;
import swing.PanelSearch;
import MytaskManager.Database.Database;

public class Main extends javax.swing.JFrame {
    Connection MyCon;
     PreparedStatement p;
     ResultSet r;
    private Dashboard dashboard;
    private Todo todo;
    private Deadline deadline;
    private Completed completed;
    private Calendar calendar;
    private Statistic statistic;
    private addTask addtask;
    private Riddletab riddle;
    private static Riddletab instance;
    private JPopupMenu menu;
    private PanelSearch search;
    
    private static class ButtonCursorHandler {
        public static void setHandCursor(JButton button) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    button.setCursor(Cursor.getDefaultCursor());
                }
            });
        }
        public static void setHandCursors(JButton... buttons) {
            for (JButton button : buttons) {
                setHandCursor(button);
            }
        }
    }
    public Main() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        deadline = new Deadline();
        todo = new Todo();
        dashboard = new Dashboard(); 
        completed = new Completed();
        calendar = new Calendar();
        statistic = new Statistic();
        addtask = new addTask();
    
 
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                txtSearch.setText(data.getText());
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
        
         JButton[] buttonsToApplyHandCursor = {jButton1, jButton2,jButton7,jButton6,jButton4,jButton3,jButton11,
             jButton5, jButton9, jButton8, jButton10};
        
        ButtonCursorHandler.setHandCursors(buttonsToApplyHandCursor);

       
       jButton1.setToolTipText("Search");
       jButton5.setToolTipText("View Riddle");
       jButton9.setToolTipText("Close");
       jButton8.setToolTipText("Minimize");
       jButton10.setToolTipText("Restore Pange");
       
      
        showForm(dashboard);
         idtext();
        MainID.setVisible(false);
        initMoving(this);
       
    }
    
    private int x;
    private int y;
    
     public void idtext(){
         SwingUtilities.invokeLater(() -> {
         dashboard.userId.removeAll();
         dashboard.userId.repaint();
         dashboard.userId.revalidate();
         dashboard.userId.setText(MainID.getText());         
        });
         SwingUtilities.invokeLater(() -> {
         statistic.statid.removeAll();
         statistic.statid.repaint();
         statistic.statid.revalidate();
         statistic.statid.setText(MainID.getText());         
        }); 
         SwingUtilities.invokeLater(() -> {
         deadline.deadid.removeAll();
         deadline.deadid.repaint();
         deadline.deadid.revalidate();
         deadline.deadid.setText(MainID.getText());         
        }); 
         SwingUtilities.invokeLater(() -> {
         completed.compid.removeAll();
         completed.compid.repaint();
         completed.compid.revalidate();
         completed.compid.setText(MainID.getText());         
        }); 
         SwingUtilities.invokeLater(() -> {
         todo.todoid.removeAll();
         todo.todoid.repaint();
         todo.todoid.revalidate();
         todo.todoid.setText(MainID.getText());         
        });
    }

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
    
    private void showForm(Component com){
        changeForm.removeAll();
        changeForm.add(com);
        repaint();
        revalidate();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        panelRound1 = new MytaskManager.Components.PanelRound();
        panelGradient2 = new MytaskManager.Components.PanelGradient();
        panelRound3 = new MytaskManager.Components.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        MainID = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        panelRound2 = new MytaskManager.Components.PanelRound();
        txtSearch = new swing.MyTextField();
        jButton1 = new javax.swing.JButton();
        changeForm = new MytaskManager.Components.PanelGradient0();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(90);
        panelRound1.setRoundBottomRight(90);
        panelRound1.setRoundTopLeft(90);
        panelRound1.setRoundTopRight(90);

        panelGradient2.setBackground(new java.awt.Color(255, 255, 255));

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(90);
        panelRound3.setRoundBottomRight(90);
        panelRound3.setRoundTopLeft(90);
        panelRound3.setRoundTopRight(90);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(245, 166, 148));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/my task (1).png"))); // NOI18N
        jLabel3.setText("My Task");
        jLabel3.setIconTextGap(3);

        jButton2.setBackground(new java.awt.Color(253, 253, 253));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(142, 117, 117));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/dashboardicon.png"))); // NOI18N
        jButton2.setText("Dashboard");
        jButton2.setBorder(null);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setIconTextGap(5);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(253, 253, 253));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(142, 117, 117));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/icons8-log-out-50 (1).png"))); // NOI18N
        jButton7.setText("Log Out");
        jButton7.setBorder(null);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(253, 253, 253));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(142, 117, 117));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/statisticicon.png"))); // NOI18N
        jButton6.setText("Statistic");
        jButton6.setBorder(null);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(253, 253, 253));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(142, 117, 117));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/completedicon.png"))); // NOI18N
        jButton4.setText("Completed");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(253, 253, 253));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(142, 117, 117));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/deadlineicon.png"))); // NOI18N
        jButton3.setText("Deadline");
        jButton3.setBorder(null);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(253, 253, 253));
        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(142, 117, 117));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/todolisticon (1).png"))); // NOI18N
        jButton11.setText("To-Do List");
        jButton11.setBorder(null);
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        MainID.setText("jLabel1");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MytaskManager/Icon/riddle1.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(MainID)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(MainID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton5)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(60);
        panelRound2.setRoundBottomRight(60);
        panelRound2.setRoundTopLeft(60);
        panelRound2.setRoundTopRight(60);

        txtSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        changeForm.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelGradient2Layout = new javax.swing.GroupLayout(panelGradient2);
        panelGradient2.setLayout(panelGradient2Layout);
        panelGradient2Layout.setHorizontalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        panelGradient2Layout.setVerticalGroup(
            panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient2Layout.createSequentialGroup()
                .addGroup(panelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGradient2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelGradient2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(changeForm, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );

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

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addGap(13, 13, 13)))
                .addGap(28, 28, 28))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (this.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
            this.setExtendedState(JFrame.NORMAL); 
        } else {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showForm(dashboard);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Login l = new Login();
        this.setVisible(false);
        l.setVisible(true);   
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        showForm(statistic);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        showForm(completed);     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showForm(deadline);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        showForm(todo);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

        
    }//GEN-LAST:event_formComponentResized

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (riddle == null) {
        riddle = new Riddletab(); 
      }
        riddle.setVisible(true); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
            search.clearSelected();
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search.getSelectedText();
            txtSearch.setText(text);
            menu.setVisible(false);
            showForm(todo);
            performSearch(text);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
           if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = txtSearch.getText().trim().toLowerCase();
            search.setData(search(text));
            if (search.getItemSize() > 0) {
                menu.show(txtSearch, 0, txtSearch.getHeight());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       showForm(todo);
        DefaultTableModel model = (DefaultTableModel) todo.jTable1.getModel();
    boolean taskFound = false;
    String query = txtSearch.getText(); 
    
    for (int i = 0; i < model.getRowCount(); i++) {
        String task = model.getValueAt(i, 0).toString(); 
        String date = model.getValueAt(i, 1).toString(); 
        String deadline = model.getValueAt(i, 2).toString(); 
        String time = model.getValueAt(i, 3).toString(); 
        if (task.contains(query) || date.contains(query) || deadline.contains(query) || time.contains(query)) {
            taskFound = true;
            JOptionPane.showMessageDialog(this, "Task found: " + task + "\nDate: " + date + "\nDeadline: "
            + deadline + "\nTime: " + time);
         
            todo.jTable1.setRowSelectionInterval(i, i);
            todo.jTable1.scrollRectToVisible(todo.jTable1.getCellRect(i, 0, true));
            break; 
        }
    }
    if (!taskFound) {
        JOptionPane.showMessageDialog(this, "Task not found!");
    }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void performSearch(String query) {
    DefaultTableModel model = (DefaultTableModel) todo.jTable1.getModel();
    boolean taskFound = false;

    for (int i = 0; i < model.getRowCount(); i++) {
        String task = model.getValueAt(i, 0).toString(); 
        String date = model.getValueAt(i, 1).toString(); 
        String deadline = model.getValueAt(i, 2).toString(); 
        String time = model.getValueAt(i, 3).toString(); 
        if (task.contains(query) || date.contains(query) || deadline.contains(query) || time.contains(query)) {
            taskFound = true;
            JOptionPane.showMessageDialog(this, "Task found: " + task + "\nDate: " + date + "\nDeadline: "
            + deadline + "\nTime: " + time);

            todo.jTable1.setRowSelectionInterval(i, i);
            todo.jTable1.scrollRectToVisible(todo.jTable1.getCellRect(i, 0, true));
            break; 
        }
    }

    if (!taskFound) {
        JOptionPane.showMessageDialog(this, "Task not found!");
    }
}
    
    private List<DataSearch> search(String search) {
    List<DataSearch> list = new ArrayList<>();
    try {
       String sql = "SELECT DISTINCT task FROM todo WHERE userId = ? AND task LIKE ? ORDER BY task LIMIT 7";
        p = Database.getInstance().getConnection().prepareStatement(sql); 
        p.setString(1, MainID.getText());  
        p.setString(2, "%" + search + "%");
        
        ResultSet r = p.executeQuery(); 
        while (r.next()) {
            String text = r.getString(1);
            boolean story = false;
            list.add(new DataSearch(text, story));
        }
        r.close();
        p.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    
    
        private void removeHistory(String text) {
    try {
       String sql ="DELETE FROM todo WHERE task = ? LIMIT 1";
        p = Database.getInstance().getConnection().prepareStatement(sql); 
        p.setString(1, text);
        p.execute();
        p.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    private void addStory(String text) {
}
    private void setWhiteBorder(JTextField textField) {
    Border border = BorderFactory.createLineBorder(Color.WHITE);
    textField.setBorder(border);
}
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel MainID;
    private MytaskManager.Components.PanelGradient0 changeForm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    public javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private MytaskManager.Components.PanelGradient panelGradient2;
    private MytaskManager.Components.PanelRound panelRound1;
    private MytaskManager.Components.PanelRound panelRound2;
    private MytaskManager.Components.PanelRound panelRound3;
    private swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
