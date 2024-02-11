package cabreservationsystem;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Passenger extends javax.swing.JFrame {

    /**
     * Creates new form Passenger
     */
    public Passenger() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Connect();
        LoadPassengerNo();
        Fetch();
        setTitle("Passenger");
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
    
    public void LoadPassengerNo() {
        
        try {
            pst = con.prepareStatement("SELECT passengerID FROM passenger");
            rs = pst.executeQuery();
            comboPassengerID.removeAllItems();
            while (rs.next()){
            comboPassengerID.addItem(rs.getString(1));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }       
        }
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM passenger ");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)tblPassenger.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("passengerID"));
                    v2.add(rs.getString("firstName"));
                    v2.add(rs.getString("lastName"));
                    v2.add(rs.getString("contactNo"));
                    v2.add(rs.getString("barangay"));
                    v2.add(rs.getString("city"));
                    v2.add(rs.getString("province"));
                }
                df.addRow(v2);
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
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
        lblPassenger = new javax.swing.JLabel();
        btnDriver = new javax.swing.JButton();
        btnCab = new javax.swing.JButton();
        btnReservation = new javax.swing.JButton();
        btnSchedule = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        lblPassengerID = new javax.swing.JLabel();
        comboPassengerID = new javax.swing.JComboBox<>();
        lblFN = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLN = new javax.swing.JLabel();
        lblCN = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        lblBrgy = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblProvince = new javax.swing.JLabel();
        txtBarangay = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtProvince = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPassenger = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        navPanel.setBackground(new java.awt.Color(0, 153, 153));

        lblPassenger.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPassenger.setForeground(new java.awt.Color(255, 255, 255));
        lblPassenger.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassenger.setText("Passenger");
        lblPassenger.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
                .addComponent(lblPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDriver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSchedule)
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
                    .addComponent(lblPassenger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDriver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(navPanelLayout.createSequentialGroup()
                        .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCab, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblPassengerID.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPassengerID.setText("Passenger ID:");
        lblPassengerID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboPassengerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPassengerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPassengerIDActionPerformed(evt);
            }
        });

        lblFN.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblFN.setText("First Name:");
        lblFN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        lblLN.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblLN.setText("Last Name:");
        lblLN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCN.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCN.setText("Contact No.:");
        lblCN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        txtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactActionPerformed(evt);
            }
        });

        lblBrgy.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBrgy.setText("Barangay:");
        lblBrgy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCity.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCity.setText("City:");
        lblCity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblProvince.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblProvince.setText("Province:");
        lblProvince.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtBarangay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarangayActionPerformed(evt);
            }
        });

        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        txtProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinceActionPerformed(evt);
            }
        });

        tblPassenger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Passenger ID", "First Name", "Last Name", "Contact No.", "Barangay", "City", "Province"
            }
        ));
        jScrollPane1.setViewportView(tblPassenger);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit1.setText("Edit");
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(lblCN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtContact))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(lblLN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLastName))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(lblFN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(lblPassengerID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboPassengerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSearch)))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(19, 19, 19)
                                .addComponent(btnEdit1)
                                .addGap(11, 11, 11)))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(lblBrgy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(17, 17, 17)))
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBarangay, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtProvince, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnDelete))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassengerID)
                    .addComponent(comboPassengerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarangay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFN)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBrgy)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLN)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCN)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProvince)
                    .addComponent(txtProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit1)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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

    private void btnCabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCabActionPerformed
        Cab c = new Cab();
        c.show();
        
        dispose();
    }//GEN-LAST:event_btnCabActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtBarangayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarangayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarangayActionPerformed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

    private void txtProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvinceActionPerformed

    private void comboPassengerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPassengerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPassengerIDActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactActionPerformed

    private void btnDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDriverActionPerformed
        Driver d = new Driver();
        d.show();
        
        dispose();
    }//GEN-LAST:event_btnDriverActionPerformed

    private void btnReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservationActionPerformed
        Reservation r = new Reservation();
        r.show();
        
        dispose();
    }//GEN-LAST:event_btnReservationActionPerformed

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        Schedule s = new Schedule();
        s.show();
        
        dispose();
    }//GEN-LAST:event_btnScheduleActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        // TODO add your handling code here:
        if (txtFirstName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "First Name is required!!");
        }else if(txtLastName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Last Name is required!!");   
        }else if(txtContact.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Contact is required!!");   
        }else if(txtBarangay.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Barangay is required!!");   
        }else if(txtCity.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "City is required!!");   
        }else if(txtProvince.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Province is required!!");   
        }else{
        try {
            // TODO add your handling code here:
            
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String contactNo = txtContact.getText();
            String barangay = txtBarangay.getText();
            String city = txtCity.getText();
            String province = txtProvince.getText();
            String pid = comboPassengerID.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE passenger SET firstName=?, lastName=?, contactNo=?, barangay=?, city=?, province=? WHERE passengerID=?");
            
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, contactNo);
            pst.setString(4, barangay);
            pst.setString(5, city);
            pst.setString(6, province);
            pst.setString(7, pid);
            
            int k=pst.executeUpdate();
            if (k==1){
                JOptionPane.showMessageDialog(this, "Record has been successfully Updated!!");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtContact.setText("");
                txtBarangay.setText("");
                txtCity.setText("");
                txtProvince.setText("");
                txtFirstName.requestFocus();
                Fetch();
                LoadPassengerNo();             
            }        
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnEdit1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (txtFirstName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "First Name is required!!");
        }else if(txtLastName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Last Name is required!!");   
        }else if(txtContact.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Contact is required!!");   
        }else if(txtBarangay.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Barangay is required!!");   
        }else if(txtCity.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "City is required!!");   
        }else if(txtProvince.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Province is required!!");   
        }else{
        try {
            // TODO add your handling code here:
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String contactNo = txtContact.getText();
            String barangay = txtBarangay.getText();
            String city = txtCity.getText();
            String province = txtProvince.getText();
            
            pst = con.prepareStatement("INSERT INTO passenger (firstName,lastName,contactNo,barangay,city,province)VALUES(?,?,?,?,?,?)");
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, contactNo);
            pst.setString(4, barangay);
            pst.setString(5, city);
            pst.setString(6, province);
            
            int k = pst.executeUpdate();
            
            if(k==1) {
                JOptionPane.showMessageDialog(this, "Record added Successfully!!");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtContact.setText("");
                txtBarangay.setText("");
                txtCity.setText("");
                txtProvince.setText("");
                Fetch();
                LoadPassengerNo();
            }else{
                JOptionPane.showMessageDialog(this, "Record failed to saved!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            String pid = comboPassengerID.getSelectedItem().toString();
            pst=con.prepareStatement("DELETE FROM passenger WHERE passengerID=?");
            pst.setString(1, pid);
            
            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record has been Successfully Deleted!!");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtContact.setText("");
                txtBarangay.setText("");
                txtCity.setText("");
                txtProvince.setText("");
                Fetch();
                LoadPassengerNo();
            }else{
                JOptionPane.showMessageDialog(this, "Record failed to Delete!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        try {
            String pid = comboPassengerID.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM passenger WHERE passengerID=?");
            pst.setString(1,pid);
            rs=pst.executeQuery();
            
            if(rs.next()==true){
                txtFirstName.setText(rs.getString(2));
                txtLastName.setText(rs.getString(3));
                txtContact.setText(rs.getString(4));
                txtBarangay.setText(rs.getString(5));  
                txtCity.setText(rs.getString(6));
                txtProvince.setText(rs.getString(7));
                
                        
            }else{
                JOptionPane.showMessageDialog(this, " No Record found!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(Passenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Passenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Passenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Passenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Passenger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCab;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDriver;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReservation;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboPassengerID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrgy;
    private javax.swing.JLabel lblCN;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblFN;
    private javax.swing.JLabel lblLN;
    private javax.swing.JLabel lblPassenger;
    private javax.swing.JLabel lblPassengerID;
    private javax.swing.JLabel lblProvince;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JTable tblPassenger;
    private javax.swing.JTextField txtBarangay;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtProvince;
    // End of variables declaration//GEN-END:variables
}
