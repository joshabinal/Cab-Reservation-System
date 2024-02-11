package cabreservationsystem;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Schedule extends javax.swing.JFrame {

    /**
     * Creates new form Schedule
     */
    public Schedule() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Connect();
        FillCabCombo();
        FillDriverCombo();
        DisplayRecord();
        initializedComponent();
        setTitle("Schedule");
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    
    public void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/crsdb", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializedComponent(){
        txtOrigin.setText("");
        txtDestination.setText("");
        txtDeparture.setText("");
        txtArrival.setText("");
        comboCab.setSelectedItem("");
        comboDriver.setSelectedItem("");
    }
    
    private boolean InputValidation(){
        if(txtOrigin.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please put an origin", "SAVE ERROR", JOptionPane.WARNING_MESSAGE);
            return false; 
        }else if(txtDestination.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please put a destination", "SAVE ERROR", JOptionPane.WARNING_MESSAGE);
            return false; 
        }else if(txtDeparture.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please put a departure", "SAVE ERROR", JOptionPane.WARNING_MESSAGE);
            return false; 
        }else if(txtArrival.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please put an arrival", "SAVE ERROR", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(comboCab.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please select a cab", "SAVE ERROR", JOptionPane.WARNING_MESSAGE);
            return false; 
        }else if(comboDriver.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Please select a driver", "SAVE ERROR", JOptionPane.WARNING_MESSAGE);
            return false; 
        }else{
            return true;
        }
    }
    
    private void FillCabCombo(){    
        try{
            String sql = "Select * from cab";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();    
            
            while(rs.next()){
                String model = rs.getString("cabBrand") + " " +rs.getString("cabModel");
                comboCab.addItem(model);   
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void FillDriverCombo(){       
        try{
            String sql = "Select * from driver";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String cbdriver = rs.getString("firstName") + " " +rs.getString("lastName");
                comboDriver.addItem(cbdriver);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void DisplayRecord(){
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTripNo5 = new javax.swing.JLabel();
        txtFirstName2 = new javax.swing.JTextField();
        navPanel = new javax.swing.JPanel();
        btnPassenger = new javax.swing.JButton();
        lblSchedule = new javax.swing.JLabel();
        btnDriver = new javax.swing.JButton();
        btnCab = new javax.swing.JButton();
        btnReservation = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        lblDriver = new javax.swing.JLabel();
        lblCab = new javax.swing.JLabel();
        comboDriver = new javax.swing.JComboBox<>();
        comboCab = new javax.swing.JComboBox<>();
        lblOrigin = new javax.swing.JLabel();
        lblDestination = new javax.swing.JLabel();
        lblDeparture = new javax.swing.JLabel();
        lblArrival = new javax.swing.JLabel();
        txtDestination = new javax.swing.JTextField();
        txtOrigin = new javax.swing.JTextField();
        txtDeparture = new javax.swing.JTextField();
        txtArrival = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblTripNo1 = new javax.swing.JLabel();

        lblTripNo5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTripNo5.setText("Trip No.");
        lblTripNo5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtFirstName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstName2ActionPerformed(evt);
            }
        });

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

        lblSchedule.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblSchedule.setForeground(new java.awt.Color(255, 255, 255));
        lblSchedule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSchedule.setText("Schedule");
        lblSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        btnReservation.setBackground(new java.awt.Color(0, 153, 153));
        btnReservation.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnReservation.setText("Reservation");
        btnReservation.setBorderPainted(false);
        btnReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservationActionPerformed(evt);
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
                .addComponent(btnCab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReservation)
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
                                    .addComponent(lblSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblDriver.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblDriver.setText("Driver:");
        lblDriver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCab.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCab.setText("Cab:");
        lblCab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDriverActionPerformed(evt);
            }
        });

        comboCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCabActionPerformed(evt);
            }
        });

        lblOrigin.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblOrigin.setText("Origin:");
        lblOrigin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblDestination.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblDestination.setText("Destination:");
        lblDestination.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblDeparture.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblDeparture.setText("Departure:");
        lblDeparture.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblArrival.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblArrival.setText("Arrival:");
        lblArrival.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinationActionPerformed(evt);
            }
        });

        txtOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOriginActionPerformed(evt);
            }
        });

        txtDeparture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartureActionPerformed(evt);
            }
        });

        txtArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArrivalActionPerformed(evt);
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
                "Trip No.", "Origin", "Destination", "Departure", "Arrival", "Cab", "Driver"
            }
        ));
        tblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblScheduleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSchedule);

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

        lblTripNo1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTripNo1.setText("Schedule Table");
        lblTripNo1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lblDriver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDestination)
                                    .addComponent(lblOrigin))
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTripNo1))
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDeparture)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(lblCab)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboCab, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblArrival)))))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addGap(12, 12, 12)
                .addComponent(btnDelete)
                .addGap(227, 227, 227))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDriver)
                    .addComponent(lblCab)
                    .addComponent(comboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrigin)
                    .addComponent(lblDeparture)
                    .addComponent(txtOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestination)
                    .addComponent(lblArrival)
                    .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(lblTripNo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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

    private void btnReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservationActionPerformed
        Reservation r = new Reservation();
        r.show();
        
        dispose();
    }//GEN-LAST:event_btnReservationActionPerformed

    private void comboDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDriverActionPerformed
        
    }//GEN-LAST:event_comboDriverActionPerformed

    private void comboCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCabActionPerformed

    private void txtDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinationActionPerformed

    private void txtOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOriginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOriginActionPerformed

    private void txtFirstName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstName2ActionPerformed

    private void txtDepartureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartureActionPerformed

    private void txtArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArrivalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArrivalActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        if(InputValidation()!=false){
            try{
            DefaultTableModel Df = (DefaultTableModel)tblSchedule.getModel();
            int selectedIndex = tblSchedule.getSelectedRow();
            
            int tripNo = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
                String origin = txtOrigin.getText().trim();
                String destination = txtDestination.getText().trim();
                String departure = txtDeparture.getText().trim();
                String arrival = txtArrival.getText().trim();
                String cab = comboCab.getSelectedItem().toString();
                String driver = comboDriver.getSelectedItem().toString();

                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost/crsdb", "root", "");
                pst = con.prepareStatement("UPDATE schedule SET origin=?, destination=?, departure=?, arrival=?, cab=?, driver=? WHERE tripNo=?");
                pst.setString(1, origin);
                pst.setString(2, destination);
                pst.setString(3, departure);
                pst.setString(4, arrival);           
                pst.setString(5, cab);
                pst.setString(6, driver);

                pst.setInt(7, tripNo);
                System.out.println(pst);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this,"Record Updated");
                DisplayRecord();
            
            }catch(SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if(InputValidation()!=false){  
            String origin = txtOrigin.getText();
            String destination = txtDestination.getText();
            String departure = txtDeparture.getText();
            String arrival = txtArrival.getText();
            
            String cab = comboCab.getSelectedItem().toString();
            String driver = comboDriver.getSelectedItem().toString();
            
            
            try {  
                pst = con.prepareStatement("INSERT INTO schedule(origin, destination, departure, arrival, cab, driver) VALUES(?,?,?,?,?,?)");
                pst.setString(1,origin);
                pst.setString(2,destination);
                pst.setString(3,departure);
                pst.setString(4,arrival);
     
                pst.setString(5, cab);
                pst.setString(6, driver);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record added successfully");
                txtOrigin.setText("");
                txtDestination.setText("");
                txtDeparture.setText("");
                txtArrival.setText("");
                
                comboDriver.setSelectedItem("");
                comboCab.setSelectedItem(""); 
                
                DisplayRecord();
            }else{
                JOptionPane.showMessageDialog(this, "Record failed to save");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel Df = (DefaultTableModel)tblSchedule.getModel();
            int selectedIndex = tblSchedule.getSelectedRow();

            try {
                    int tripNo = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
                    Class.forName("com.mysql.jdbc.Driver");

                    con = DriverManager.getConnection("jdbc:mysql://localhost/crsdb", "root", "");
                    pst = con.prepareStatement("DELETE FROM schedule WHERE tripNo=?");
                    pst.setInt(1, tripNo);
                    System.out.println(pst);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this,"Record Deleted");
                    DisplayRecord();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    private void tblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblScheduleMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel Df = (DefaultTableModel)tblSchedule.getModel();
        int selectedIndex = tblSchedule.getSelectedRow();
        
        txtOrigin.setText(Df.getValueAt(selectedIndex, 1).toString());
        txtDestination.setText(Df.getValueAt(selectedIndex, 2).toString());
        txtDeparture.setText(Df.getValueAt(selectedIndex, 3).toString());
        txtArrival.setText(Df.getValueAt(selectedIndex, 4).toString());
        comboCab.setSelectedItem(Df.getValueAt(selectedIndex, 5).toString());
        comboDriver.setSelectedItem(Df.getValueAt(selectedIndex, 6).toString());
    }//GEN-LAST:event_tblScheduleMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        HomePage hp = new HomePage();
        hp.show();

        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Schedule().setVisible(true);
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
    private javax.swing.JButton btnReservation;
    private javax.swing.JComboBox<String> comboCab;
    private javax.swing.JComboBox<String> comboDriver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArrival;
    private javax.swing.JLabel lblCab;
    private javax.swing.JLabel lblDeparture;
    private javax.swing.JLabel lblDestination;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblOrigin;
    private javax.swing.JLabel lblSchedule;
    private javax.swing.JLabel lblTripNo1;
    private javax.swing.JLabel lblTripNo5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JTable tblSchedule;
    private javax.swing.JTextField txtArrival;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtDestination;
    private javax.swing.JTextField txtFirstName2;
    private javax.swing.JTextField txtOrigin;
    // End of variables declaration//GEN-END:variables
}
