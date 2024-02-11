/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cabreservationsystem;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Reservation extends javax.swing.JFrame {

    /**
     * Creates new form Reservation
     */
    public Reservation() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Connect();
        FillPassengerCombo();
        DisplayRecord();
        FetchScheduleTable();
        setTitle("Reservation");
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/crsdb", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializedComponent(){
        txtSeatNo.setText("");
        txtCost.setText("");
        txtTrip.setText("");
        txtRoute.setText("");
        txtTime.setText("");
        txtCab.setText("");
        txtDriver.setText("");
        comboPassenger.setSelectedItem("");
    }
    
    private void FillPassengerCombo(){    
        try{
            String sql = "Select * from passenger";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();    
            
            while(rs.next()){
                String model = rs.getString("firstName") + " " +rs.getString("lastName");
                comboPassenger.addItem(model);   
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void FetchScheduleTable(){
        int columnNum;
            
            try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/crsdb", "root", "");
            pst = con.prepareStatement("SELECT * FROM schedule");
            
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData Res = rs.getMetaData();
            columnNum = Res.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)tblSchedule.getModel();
            
            Df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                
                for(int i = 0; i<columnNum; i++){
                    v2.add(rs.getString("tripNo"));
                    v2.add(rs.getString("origin"));
                    v2.add(rs.getString("destination"));
                    v2.add(rs.getString("departure"));
                    v2.add(rs.getString("arrival"));
                    v2.add(rs.getString("cab"));
                    v2.add(rs.getString("driver"));
                }
                Df.addRow(v2);
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private void DisplayRecord(){
        int columnNum;
            
            try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/crsdb", "root", "");
            pst = con.prepareStatement("SELECT * FROM reservation");
          
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData Res = rs.getMetaData();
            columnNum = Res.getColumnCount();
            
            DefaultTableModel Df = (DefaultTableModel)tblReservation.getModel();
            
            Df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                
                for(int i = 0; i<columnNum; i++){
                    v2.add(rs.getString("ticketID"));
//                    v2.add(rs.getString("tripNo"));

                    v2.add(rs.getString("seatNo"));
                    v2.add(rs.getString("cost"));
                    v2.add(rs.getString("passenger"));
                    v2.add(rs.getString("tripNo"));
                    v2.add(rs.getString("route"));
                    v2.add(rs.getString("scheduledTime"));
                    v2.add(rs.getString("cabFetch"));
                    v2.add(rs.getString("driverFetch"));
               
                }
                Df.addRow(v2);
            }
              
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navPanel = new javax.swing.JPanel();
        btnPassenger = new javax.swing.JButton();
        lblReservation = new javax.swing.JLabel();
        btnDriver = new javax.swing.JButton();
        btnCab = new javax.swing.JButton();
        btnSchedule = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        lblTripNo = new javax.swing.JLabel();
        lblPassenger = new javax.swing.JLabel();
        comboPassenger = new javax.swing.JComboBox<>();
        lblSeatNo = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        txtSeatNo = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservation = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        txtTrip = new javax.swing.JTextField();
        txtRoute = new javax.swing.JTextField();
        txtTime = new javax.swing.JTextField();
        txtCab = new javax.swing.JTextField();
        txtDriver = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        navPanel.setBackground(new java.awt.Color(0, 153, 153));

        btnPassenger.setBackground(new java.awt.Color(0, 153, 153));
        btnPassenger.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnPassenger.setText("Passenger");
        btnPassenger.setBorderPainted(false);
        btnPassenger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassengerActionPerformed(evt);
            }
        });

        lblReservation.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblReservation.setForeground(new java.awt.Color(255, 255, 255));
        lblReservation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReservation.setText("Reservation");
        lblReservation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnDriver.setBackground(new java.awt.Color(0, 153, 153));
        btnDriver.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDriver.setText("Driver");
        btnDriver.setBorderPainted(false);
        btnDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDriverActionPerformed(evt);
            }
        });

        btnCab.setBackground(new java.awt.Color(0, 153, 153));
        btnCab.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnCab.setText("Cab");
        btnCab.setBorderPainted(false);
        btnCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabActionPerformed(evt);
            }
        });

        btnSchedule.setBackground(new java.awt.Color(0, 153, 153));
        btnSchedule.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnSchedule.setText("Schedule");
        btnSchedule.setBorderPainted(false);
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(0, 153, 153));
        btnExit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 51));
        btnExit.setText("Exit");
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPassenger)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDriver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCab, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSchedule)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navPanelLayout.createSequentialGroup()
                        .addComponent(btnDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(navPanelLayout.createSequentialGroup()
                        .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPassenger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(navPanelLayout.createSequentialGroup()
                                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCab, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblTripNo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTripNo.setText("Trip No.");
        lblTripNo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblPassenger.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPassenger.setText("Passenger");
        lblPassenger.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboPassenger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPassengerActionPerformed(evt);
            }
        });

        lblSeatNo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSeatNo.setText("Seat No.");
        lblSeatNo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCost.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCost.setText("Cost");
        lblCost.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtSeatNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeatNoActionPerformed(evt);
            }
        });

        txtCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostActionPerformed(evt);
            }
        });

        tblReservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ticket No.", "Seat No.", "Cost", "Passenger", "Trip No.", "Route", "Scheduled Time", "Cab", "Driver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReservation);
        if (tblReservation.getColumnModel().getColumnCount() > 0) {
            tblReservation.getColumnModel().getColumn(0).setMaxWidth(70);
            tblReservation.getColumnModel().getColumn(1).setMaxWidth(70);
            tblReservation.getColumnModel().getColumn(2).setMaxWidth(75);
            tblReservation.getColumnModel().getColumn(3).setMaxWidth(120);
            tblReservation.getColumnModel().getColumn(6).setResizable(false);
        }

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Trip No", "Origin", "Destination", "Departure", "Arrival", "Cab", "Driver"
            }
        ));
        tblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblScheduleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblScheduleMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tblSchedule);

        txtTrip.setEditable(false);
        txtTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTripActionPerformed(evt);
            }
        });

        txtRoute.setEditable(false);
        txtRoute.setVisible(false);
        txtRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRouteActionPerformed(evt);
            }
        });

        txtTime.setEditable(false);
        txtTime.setVisible(false);
        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });

        txtCab.setEditable(false);
        txtCab.setVisible(false);
        txtCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCabActionPerformed(evt);
            }
        });

        txtDriver.setEditable(false);
        txtDriver.setVisible(false);
        txtDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDriverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(lblTripNo)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(txtTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCab, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(lblPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSeatNo)
                                    .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSeatNo)
                                    .addComponent(txtCost))))
                        .addGap(156, 156, 156)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTripNo)
                    .addComponent(txtTrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassenger)
                            .addComponent(comboPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSeatNo)
                            .addComponent(txtSeatNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCost)
                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDriverActionPerformed
        Driver d = new Driver();
        d.show();
        
        dispose();
    }//GEN-LAST:event_btnDriverActionPerformed

    private void btnCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCabActionPerformed
        Cab c = new Cab();
        c.show();
        
        dispose();
    }//GEN-LAST:event_btnCabActionPerformed

    private void btnPassengerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassengerActionPerformed
        Passenger p = new Passenger();
        p.show();
        
        dispose();
    }//GEN-LAST:event_btnPassengerActionPerformed

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        Schedule s = new Schedule();
        s.show();
        
        dispose();
    }//GEN-LAST:event_btnScheduleActionPerformed

    private void comboPassengerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPassengerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPassengerActionPerformed

    private void txtSeatNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeatNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeatNoActionPerformed

    private void txtCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        
      	try{
            DefaultTableModel Df = (DefaultTableModel)tblReservation.getModel();
            int selectedIndex = tblReservation.getSelectedRow();
            
            int ticketID = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
                String seatNo = txtSeatNo.getText().trim();
                String cost = txtCost.getText().trim();
                String passenger = comboPassenger.getSelectedItem().toString();
                String tripNo = txtTrip.getText().trim();
                String route = txtRoute.getText().trim();
                String scheduledTime = txtTime.getText().trim();
                String cabFetch = txtCab.getText().trim();
                String driverFetch = txtDriver.getText().trim();


                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost/crsdb", "root", "");
                pst = con.prepareStatement("UPDATE reservation SET seatNo=?, cost=?, passenger=?, tripNo=?, route=?, scheduledTime=?, cabFetch=?, driverFetch=? WHERE ticketID=?");
                pst.setString(1, seatNo);
                pst.setString(2, cost);
                pst.setString(3, passenger);
                pst.setString(4, tripNo);
                pst.setString(5, route);
                pst.setString(6, scheduledTime);
                pst.setString(7, cabFetch);
                pst.setString(8, driverFetch);

                pst.setInt(9, ticketID);
                System.out.println(pst);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this,"Record Updated");
                DisplayRecord();
            
            }catch(SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
    	String seatNo = txtSeatNo.getText();
        String cost = txtCost.getText();
        String passenger = comboPassenger.getSelectedItem().toString();
        String tripNo = txtTrip.getText();
        String route = txtRoute.getText();
        String scheduledTime = txtTime.getText();
        String cabFetch = txtCab.getText();
        String driverfetch = txtDriver.getText();
  	 try {
			pst = con.prepareStatement("INSERT INTO reservation (seatNo,cost,passenger,tripNo,route,scheduledTime,cabFetch,driverFetch)VALUES(?,?,?,?,?,?,?,?)");
                        pst.setString(1,seatNo);
			pst.setString(2,cost);
                        pst.setString(3,passenger);
                        pst.setString(4,tripNo);
                        pst.setString(5,route);
                        pst.setString(6,scheduledTime);
                        pst.setString(7,cabFetch);
                        pst.setString(8,driverfetch);
                       
			int k = pst.executeUpdate();
			
			if(k==1) {
				 JOptionPane.showMessageDialog(this, "Data is added successfully.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				 txtSeatNo.setText("");
				 txtCost.setText("");
                                 comboPassenger.setSelectedItem("");
                                 txtTrip.setText("");
                                 txtRoute.setText("");
                                 txtTime.setText("");
                                 txtCab.setText("");
                                 txtDriver.setText("");
				 DisplayRecord();
				 	
			}else {
				JOptionPane.showMessageDialog(this, "Data is not added successfully.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
		}         
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
          DefaultTableModel Df = (DefaultTableModel)tblReservation.getModel();
            int selectedIndex = tblReservation.getSelectedRow();

            try {
                    int ticketID = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost/crsdb", "root", "");
                    pst = con.prepareStatement("DELETE FROM reservation WHERE ticketID=?");
                    pst.setInt(1, ticketID);
                    System.out.println(pst);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this,"Record Deleted");
                    DisplayRecord();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
                }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservationMouseClicked
        // TODO add your handling code here:
        DefaultTableModel Df = (DefaultTableModel)tblReservation.getModel();
        int selectedIndex = tblReservation.getSelectedRow();
        
        txtSeatNo.setText(Df.getValueAt(selectedIndex, 1).toString());
        txtCost.setText(Df.getValueAt(selectedIndex, 2).toString());
        comboPassenger.setSelectedItem(Df.getValueAt(selectedIndex, 3).toString());
        txtTrip.setText(Df.getValueAt(selectedIndex, 4).toString());
        txtRoute.setText(Df.getValueAt(selectedIndex, 5).toString());
        txtTime.setText(Df.getValueAt(selectedIndex, 6).toString());
        txtCab.setText(Df.getValueAt(selectedIndex, 7).toString());
        txtDriver.setText(Df.getValueAt(selectedIndex, 8).toString());
    }//GEN-LAST:event_tblReservationMouseClicked

    private void tblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMouseClicked

try{ 
        int selectedRow= tblSchedule.getSelectedRow(); 
        DefaultTableModel model = (DefaultTableModel)tblSchedule.getModel();
        txtTrip.setText(model.getValueAt(selectedRow, 0).toString());
        txtRoute.setText(model.getValueAt(selectedRow, 1).toString() + " to " + model.getValueAt(selectedRow, 2).toString());
        txtTime.setText(model.getValueAt(selectedRow, 3).toString() + " to " + model.getValueAt(selectedRow, 4).toString());
        txtCab.setText(model.getValueAt(selectedRow, 5).toString());
        txtDriver.setText(model.getValueAt(selectedRow, 6).toString());
       
        
        }catch(Exception ex){ JOptionPane.showMessageDialog(this,ex); }
       
    }//GEN-LAST:event_tblScheduleMouseClicked

    private void tblScheduleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblScheduleMouseEntered

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        HomePage hp = new HomePage();
        hp.show();

        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTripActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTripActionPerformed

    private void txtRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRouteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRouteActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    private void txtCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCabActionPerformed

    private void txtDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDriverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDriverActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCab;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDriver;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPassenger;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JComboBox<String> comboPassenger;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblPassenger;
    private javax.swing.JLabel lblReservation;
    private javax.swing.JLabel lblSeatNo;
    private javax.swing.JLabel lblTripNo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JTable tblReservation;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTextField txtCab;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDriver;
    private javax.swing.JTextField txtRoute;
    private javax.swing.JTextField txtSeatNo;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTrip;
    // End of variables declaration//GEN-END:variables
}
