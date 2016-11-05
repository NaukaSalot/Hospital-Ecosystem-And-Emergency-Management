/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReceptionistRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Mail.Mail;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Organization.ReceptionistOrganization;
//import Business.Person.MyStringVerifier;
import Business.RoomDetails.RoomDetails;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AmbulanceWorkRequest;
import Business.WorkQueue.CheckUpRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.PatientDetailsRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import com.sun.speech.freetts.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import userinterface.DoctorRole.DoctorWorkAreaJPanel;

/**
 *
 * @author Nauka Salot
 */
public class ReceptionistWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ReceptionistOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;
    private CheckUpRequest checkUpRequest;
    private RoomDetails roomDetails;
    String value = "\\d+";

    /**
     * Creates new form ReceptionistWorkAreaJPanel
     */
    public ReceptionistWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        btnemer.setEnabled(false);
        // btnspeak.setEnabled(false);

        this.userProcessContainer = userProcessContainer;
        this.organization = (ReceptionistOrganization) organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.system = business;
//         MyStringVerifier myStringVerifier= new MyStringVerifier();
//        //txtpatientname.setInputVerifier(myStringVerifier);
//        txtage.setInputVerifier(myStringVerifier);
//        //txtbloodgroup.setInputVerifier(myStringVerifier);
//        txtgender.setInputVerifier(myStringVerifier);
//        txtMessage.setInputVerifier(myStringVerifier);
        populateNPatients();
        populatepatient();
        populateNursreOrg();
        populateRequestTable();
        populateEmergency();

//To change body of generated methods, choose Tools | Templates.
    }

    public void populateEmergency() {
        DefaultTableModel model = (DefaultTableModel) tblemergency.getModel();
        model.setRowCount(0);
        for (Network n : system.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof HospitalEnterprise) {
                    for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                        if (o instanceof ReceptionistOrganization) {
                            txtcount.setText(String.valueOf(o.getWorkQueue().getWorkRequestList().size()));
                            // for (UserAccount ua: o.getUserAccountDirectory().getUserAccountList()){
                            for (WorkRequest wr : o.getWorkQueue().getWorkRequestList()) {
                                if (wr instanceof AmbulanceWorkRequest) {
                                    Object[] row = new Object[4];
                                    row[0] = wr;
                                    row[1] = wr.getReceiver();
                                    row[2] = wr.getSender();
                                    String name = ((AmbulanceWorkRequest) wr).getPersonName();
                                    row[3] = name;
                                    model.addRow(row);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        //  UserAccount account = null;
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            Employee patient = ((LabTestWorkRequest) request).getPatient();
            row[3] = patient;
//            String result =((LabTestWorkRequest)request).getTestResult() ;
//         row[3] =  result == null ? "Waiting" : result;

            model.addRow(row);
        }
    }

    public void populateNPatients() {

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization) {

                org = organization;
                break;
            }
        }
        if (org != null) {
            cmbDonor.removeAllItems();
            for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                cmbDonor.addItem(emp);
            }
        }
    }

    public void populateNursreOrg() {
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof DoctorOrganization) {

                org = organization;
                break;
            }
        }

        DefaultTableModel model = (DefaultTableModel) tbldoctor.getModel();

        model.setRowCount(0);
        for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {

            Object[] row = new Object[1];
            row[0] = ua;
            model.addRow(row);
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

        jLabel2 = new javax.swing.JLabel();
        cmbDonor = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldoctor = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpatient = new javax.swing.JTable();
        btnaddpatient = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        txtgender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnassignroom = new javax.swing.JButton();
        btninsurance = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtpatientname = new javax.swing.JTextField();
        txtbloodgroup = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblemergency = new javax.swing.JTable();
        btnemer = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtcount = new javax.swing.JTextField();
        btnspeak = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        btnassigntome = new javax.swing.JButton();

        jLabel2.setText("Patient Name");

        cmbDonor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDonorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Khmer UI", 1, 14)); // NOI18N
        jLabel1.setText("Welcome Patients");

        tbldoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbldoctor);

        jLabel4.setText("Message to Doctor");

        jLabel3.setText("Select Doctor");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/ReceptionistRole/1449545576_doctor.png"))); // NOI18N
        jButton3.setText("Send to Doctor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblpatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Name", "Patient ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblpatient);
        if (tblpatient.getColumnModel().getColumnCount() > 0) {
            tblpatient.getColumnModel().getColumn(0).setResizable(false);
            tblpatient.getColumnModel().getColumn(1).setResizable(false);
        }

        btnaddpatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/ReceptionistRole/add patient (2).png"))); // NOI18N
        btnaddpatient.setText("Add Patient");
        btnaddpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddpatientActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Patient Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(workRequestJTable);

        jLabel5.setText("Patient");

        btnassignroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/ReceptionistRole/assign room.png"))); // NOI18N
        btnassignroom.setText("Assign Room");
        btnassignroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnassignroomActionPerformed(evt);
            }
        });

        btninsurance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/ReceptionistRole/insurance.png"))); // NOI18N
        btninsurance.setText("Insurance");
        btninsurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsuranceActionPerformed(evt);
            }
        });

        jLabel6.setText("Patient Gender");

        jLabel7.setText("Blood Group");

        jLabel8.setText("Patient Age");

        txtage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtageActionPerformed(evt);
            }
        });

        tblemergency.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Reciever", "Sender", "Patient Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblemergency);

        btnemer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/ReceptionistRole/emergency.png"))); // NOI18N
        btnemer.setText("Add emergency");
        btnemer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnemerActionPerformed(evt);
            }
        });

        jLabel9.setText("Total emergency patients are ");

        txtcount.setEnabled(false);

        btnspeak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/ReceptionistRole/1449545323_juk.png"))); // NOI18N
        btnspeak.setText("Speak");
        btnspeak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnspeakActionPerformed(evt);
            }
        });

        jLabel10.setText("Date");

        txtdate.setEnabled(false);
        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });

        btnassigntome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/LabAssistantRole/assign to me.png"))); // NOI18N
        btnassigntome.setText("Assign to me");
        btnassigntome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnassigntomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(70, 70, 70)
                                .addComponent(btninsurance)
                                .addGap(65, 65, 65)
                                .addComponent(btnassignroom))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(228, 228, 228))
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbDonor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64)
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtgender, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtbloodgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(30, 30, 30)
                                .addComponent(txtcount, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(btnspeak, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(262, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtpatientname, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnaddpatient, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnassigntome, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(106, 106, 106))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnemer)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cmbDonor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnassigntome))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnaddpatient)
                        .addComponent(btnemer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpatientname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnspeak)
                        .addComponent(jLabel9)
                        .addComponent(txtbloodgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btninsurance)
                    .addComponent(btnassignroom))
                .addGap(368, 368, 368))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int selectedRow = tblpatient.getSelectedRow();
        int selectedRowNurse = tbldoctor.getSelectedRow();

        if (selectedRow < 0 || selectedRowNurse < 0) {
            JOptionPane.showMessageDialog(null, "Please select rows");
            return;
        }

        String message = txtMessage.getText();

        //    UserAccount nurseName=(UserAccount) cmbNurseOrg.getSelectedItem();
        if (message.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Message cannot be null");
            return;

        }

        CheckUpRequest request = new CheckUpRequest();
        UserAccount ua = (UserAccount) tbldoctor.getValueAt(selectedRowNurse, 0);
        Employee e = (Employee) tblpatient.getValueAt(selectedRow, 0);
        request.setMessage(message);
        request.setSender(userAccount);
        request.setPatient(e);
        request.setStatus("Sent to doctor");
        request.setReceiver(ua);
        e.getPdr().addRequest(request);

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof DoctorOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {
            // org.getUserAccountDirectory().getUserAccountList().add(ua);
            ua.getWorkQueue().getWorkRequestList().add(request);

            userAccount.getWorkQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null, "Request sent to doctor");
        }
        String[] to = {"nauka.salot2910@gmail.com", "naukasalot@yahoo.com"};

        try {
            if (Mail.sendMail("neucare12@gmail.com", "northeastern", "New Patient reported", to)) {
                System.out.println("sent");
            } else {
                System.out.println("serror");
            }

// TODO add your handling code here:
            // TODO add your handling code here:
        } catch (MessagingException ex) {
            Logger.getLogger(DoctorWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Email Sent!");

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnaddpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddpatientActionPerformed

        populateNPatients();//added today-12/4

        if (txtpatientname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter an appropriate Patient Name");
            return;
        } else if (!txtpatientname.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Enter an appropriate Patient Name");
            return;
        }
        if (txtgender.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter an appropriate Patient Gender");
            return;
        } else if (!txtgender.getText().matches("m|f|male|female|M|F|Male|Female")) {
            JOptionPane.showMessageDialog(null, "Enter an appropriate Patient Gender");
            return;
        }
        if (!txtage.getText().matches(value)) {
            JOptionPane.showMessageDialog(null, "Enter an appropriate Patient Age");
            return;
        } else if (txtage.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter an appropriate Patient Age");
            return;
        }
        if (txtbloodgroup.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter an appropriate Patient Blood Group");
            return;
        } else if (!txtbloodgroup.getText().matches("o|a|b|ab|'o+'|o-|a+|a-|b+|b-|ab+|ab-|O|A|B|AB")) {
            JOptionPane.showMessageDialog(null, "Enter an appropriate Patient Blood Group");
            return;
        }
        if (txtpatientname == null || txtbloodgroup == null || txtage == null || txtgender == null) {
            JOptionPane.showMessageDialog(null, "Enter all details");
            return;
        }

//        if(name1.trim().isEmpty()
//                || gender.trim().isEmpty()
//                || bg.trim().isEmpty()
//                )
//        {
//        JOptionPane.showMessageDialog(this,"Please fill all the fields.","Error",JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        if(txtage.getText().trim().isEmpty())
//        {
//                JOptionPane.showMessageDialog(this,"Please fill all the fields.","Error",JOptionPane.ERROR_MESSAGE);
//
//        }
        String name1 = txtpatientname.getText();
        String gender = txtgender.getText();
        String bg = txtbloodgroup.getText();
        int age = Integer.parseInt(txtage.getText());
        PatientDetailsRequest pdr = new PatientDetailsRequest();
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss"); //format it as per your requirement
        String dateNow = formatter.format(currentDate.getTime());
        txtdate.setText(dateNow);
        pdr.getPatientDetails().setPatientName(name1);
        pdr.getPatientDetails().setGender(gender);
        pdr.getPatientDetails().setBloodgroup(bg);
        pdr.getPatientDetails().setAge(age);
        pdr.getPatientDetails().setTodaydate(dateNow);
//       int i= pdr.getPatientDetails().getRoomDetails().getEmployee().getId();
//       pdr.setPatientDetails().setEmployee;
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization) {

                org = organization;
                break;
            }
        }

        if (org != null) {
            for (Employee e : org.getEmployeeDirectory().getEmployeeList()) {

                if (e.getName().equals(name1)) {
                    JOptionPane.showMessageDialog(null, "Patient already exists");
                    return;
                }

            }
            if (name1.trim().length() == 0) {

                JOptionPane.showMessageDialog(null, "Please enter details");
                return;
            }
            Employee emp1 = org.getEmployeeDirectory().createEmployee(name1);
            emp1.setPdr(pdr);
            JOptionPane.showMessageDialog(null, "Patient successfully created.");  //userAccount.getWorkQueue().getWorkRequestList().add(request);
            txtpatientname.setText(" ");
            txtage.setText(" ");
            txtbloodgroup.setText(" ");
            txtgender.setText(" ");
        }

        DefaultTableModel model = (DefaultTableModel) tblpatient.getModel();

        model.setRowCount(0);
        for (Employee e : org.getEmployeeDirectory().getEmployeeList()) {

            Object[] row = new Object[2];
            row[0] = e;
            row[1] = e.getId();

            model.addRow(row);
        }

        // TODO add your handling code h    ``````````````````````ere:
    }//GEN-LAST:event_btnaddpatientActionPerformed
    public void populatepatient() {
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization) {

                org = organization;
                break;
            }

        }
        DefaultTableModel model = (DefaultTableModel) tblpatient.getModel();

        model.setRowCount(0);
        for (Employee e : org.getEmployeeDirectory().getEmployeeList()) {

            Object[] row = new Object[2];
            row[0] = e;
            row[1] = e.getId();

            model.addRow(row);
        }
    }
    private void cmbDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDonorActionPerformed
        //populateNDonors();        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDonorActionPerformed

    private void btnassignroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnassignroomActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblpatient.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Employee employee = (Employee) tblpatient.getValueAt(selectedRow, 0);

        //    UserAccount nurseName=(UserAccount) cmbNurseOrg.getSelectedItem();
//        Date date= new Date();
//        date=new Timestamp(date.getTime());
        AssignRoom as = new AssignRoom(userProcessContainer, employee);
        userProcessContainer.add("AssignRoom", as);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);


    }//GEN-LAST:event_btnassignroomActionPerformed

    private void btninsuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsuranceActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblpatient.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Employee employee = (Employee) tblpatient.getValueAt(selectedRow, 0);
        InsuranceWorkArea ins = new InsuranceWorkArea(userProcessContainer, employee);
        userProcessContainer.add("Insurance", ins);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);


    }//GEN-LAST:event_btninsuranceActionPerformed

    int counter = 0;

    private void btnemerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnemerActionPerformed
  // txtcount.setText();
        // TODO add your handling code here:

        //int a=++counter;
//        Calendar currentDate = Calendar.getInstance(); //Get the current date
//SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss"); 
////format it as per your requirement
//String dateNow = formatter.format(currentDate.getTime());
////currentDate.setTime( );
//currentDate.add( Calendar.DATE, 1 );
//
//
////Date myDate = formatter.parse(dateNow);
//        txtdate.setText(dateNow);
//    ////////    Calendar currentDate = Calendar.getInstance(); //Get the current date
//SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss"); //format it as per your requirement
//String dateNow = formatter.format(currentDate.getTime());
//
//currentDate.add(Calendar.MINUTE,1);
//txtdate.setText(dateNow);
        Calendar currentDate = Calendar.getInstance();
        Calendar delayDate = Calendar.getInstance();
        SimpleDateFormat formatt = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        String dateNow = formatt.format(currentDate.getTime());
//        currentDate.add(Calendar.DATE, 1);
//        String dateTom =formatt.format(currentDate.getTime());

        txtdate.setText(dateNow);
        int selectedRow = tblemergency.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
//        if(tblemergency.getValueAt(selectedRow,1)!=null)
//{
//     JOptionPane.showMessageDialog(this,"The patient has been already attended!","Warning",JOptionPane.WARNING_MESSAGE);
//            return;
//}

        String name = (String) tblemergency.getValueAt(selectedRow, 3);
        txtpatientname.setText(name);
        txtpatientname.setEnabled(false);
        int a = ++counter;
        //txtcount.setText(String.valueOf(a));
//        if(!dateNow.matches(dateTom))
//        {
//            counter=0;
//            counter++;
//            txtcount.setText(String.valueOf(counter++));
//        }
        //btnspeak.setEnabled(true);
//    try {
//        // String delay= formatt.format(dateNow.add(Calendar.MINUTE, 1));
//        //formatt.format(currentDate.add(Calendar.MINUTE,1));
//       while(true){
//           //txtdate.setText(dateNow);
        // Thread.sleep(120000);
//       counter=0;}
//    } catch (InterruptedException ex) {
//        Logger.getLogger(ReceptionistWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
//    }

//String input = dateNow;
//DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "M/d/yyyy" );
//LocalDate localDate = LocalDate.parse ( input , formatter );
//LocalDate daylater=localDate.plusDays(1);
//String delay=daylater.toString();
//if(!dateNow.equalsIgnoreCase(delay))
//{
//    counter=0;
//}
//        if(dateNow=dateNow +1)
//        {
//        }
        //String pname = txtpatientname.getText();
//       // Employee employee=(Employee)tblemergency.getValueAt(selectedRow, 0);
//        String name1=txtpatientname.getText();
//        String gender=txtgender.getText();
//        String bg=txtbloodgroup.getText();
//        int age= Integer.parseInt(txtage.getText());
//        PatientDetailsRequest pdr=new PatientDetailsRequest();
//        pdr.getPatientDetails().setPatientName(name1);
//        pdr.getPatientDetails().setGender(gender);
//        pdr.getPatientDetails().setBloodgroup(bg);
//        pdr.getPatientDetails().setAge(age);
//        Organization org=null;
//        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
//            if (organization instanceof PatientOrganization){
//
//                org=organization;
//                break;
//            }
//        }
//
//        if (org!=null ){
//            for (Employee e : org.getEmployeeDirectory().getEmployeeList()){
//
//                if(e.getName().equals(name1)){
//                    JOptionPane.showMessageDialog(null,"Patient already exists");
//                    return;
//                }
//
//            }
//            if(name1.trim().length()==0){
//
//                JOptionPane.showMessageDialog(null,"Please enter details");
//                return;
//            }
//            Employee emp1=org.getEmployeeDirectory().createEmployee(name1);
//           emp1.setPdr(pdr);
//              JOptionPane.showMessageDialog(null,"Patient successfully created.");  //userAccount.getWorkQueue().getWorkRequestList().add(request);
//            txtpatientname.setText(" ");
//            txtage.setText(" ");
//            txtbloodgroup.setText(" ");
//          txtgender.setText(" ");
//        }
//
//
//
//            
//               DefaultTableModel model = (DefaultTableModel) tblpatient.getModel();
//
//        model.setRowCount(0);
//        for (Employee e : org.getEmployeeDirectory().getEmployeeList()){
//
//            Object[] row = new Object[2];
//            row[0] = e;
//            row[1] = e.getId();
//
//            model.addRow(row);
//        }
//        
////        if(pname.equalsIgnoreCase(pname))
////                {
////                    int a=counter++;
////
////                    
////                    txtcount.setText((a));
////                }
////    } catch (InterruptedException ex) {
////        Logger.getLogger(ReceptionistWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
////    }
    }//GEN-LAST:event_btnemerActionPerformed

    private void txtageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtageActionPerformed
    private static final String VOICENAME = "kevin16";
    private void btnspeakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnspeakActionPerformed
        // TODO add your handling code here:
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        try {
            voice.speak(jLabel9.getText());
            voice.speak(txtcount.getText());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnspeakActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void btnassigntomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnassigntomeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblemergency.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (tblemergency.getValueAt(selectedRow, 1) != null) {
            JOptionPane.showMessageDialog(this, "It has been already assigned!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (selectedRow >= 0) {
            AmbulanceWorkRequest request = (AmbulanceWorkRequest) tblemergency.getValueAt(selectedRow, 0);
//            if (request.getMessage().equalsIgnoreCase("Completed")) {
//                JOptionPane.showMessageDialog(null, "Request already processed.");
//                return;
//            } else {\
            request.setReceiver(userAccount);
            request.setStatus("Pending");
            btnemer.setEnabled(true);
            populateEmergency();

        } else {
            JOptionPane.showMessageDialog(null, "Choose a reuest to process.");
            return;
        }
    }//GEN-LAST:event_btnassigntomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddpatient;
    private javax.swing.JButton btnassignroom;
    private javax.swing.JButton btnassigntome;
    private javax.swing.JButton btnemer;
    private javax.swing.JButton btninsurance;
    private javax.swing.JButton btnspeak;
    private javax.swing.JComboBox cmbDonor;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbldoctor;
    private javax.swing.JTable tblemergency;
    private javax.swing.JTable tblpatient;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtbloodgroup;
    private javax.swing.JTextField txtcount;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtgender;
    private javax.swing.JTextField txtpatientname;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
