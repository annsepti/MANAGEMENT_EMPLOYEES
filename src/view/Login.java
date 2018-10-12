/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import viewemp.EmployeeView;
import org.hibernate.SessionFactory;
import tools.Tools;
import controllers.EmployeeController;
import java.awt.BorderLayout;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import models.Employee;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import report.ReportView;
import tools.HibernateUtil;

/**
 * Deklarasi kelas Login
 * @author USER
 */
public class Login extends javax.swing.JInternalFrame {

    private SessionFactory sessionFactory;
    Tools tool;
    EmployeeController controller;
//    Connection connection;

    /**
     * Method konstruktor
     * @param sessionFactory tipe data SessionFactory
     */
    public Login(SessionFactory sessionFactory) {
        initComponents();
        this.sessionFactory = sessionFactory;
        tool = new Tools();
        controller = new EmployeeController(HibernateUtil.getSessionFactory());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        pfPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setTitle("LOGIN");

        jLabel1.setText("Username : ");

        jLabel2.setText("Password :");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pfPassword)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnLogin)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Method untuk memanggil fungsi login
     * @param evt merupakan sebuah event
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
//         try {
//            String NamaFile = "./src/report/EmployeeListReport.jasper";
//            Connection connection = sessionFactory.getSessionFactoryOptions().getServiceRegistry().
//                    getService(ConnectionProvider.class).getConnection();
//            HashMap hash = new HashMap();
//            hash.put("listReport", txtUsername.getText());
//            JasperPrint jasperPrint = JasperFillManager.fillReport(NamaFile, hash, connection);
//            JasperViewer.viewReport(jasperPrint);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
        
        login();
    }//GEN-LAST:event_btnLoginActionPerformed
    /**
     * Method untuk melakukan login
     */
    private void login() {
        Employee employee = new Employee(txtUsername.getText(), new String(pfPassword.getPassword()));

        if (tool.checkNumberFormat(employee.getPassword())) {
            employee = (Employee) controller.firstLogin(employee.getUsername(), employee.getPassword());
            ChangePasswordView changePasswordView = new ChangePasswordView(sessionFactory, employee);
            this.getParent().add(changePasswordView);
            changePasswordView.setVisible(true);
            this.setVisible(false);
        } else {
            employee = controller.login(txtUsername.getText(), new String(pfPassword.getPassword()));
            if (employee != null) {
                if (employee.getRoleId().getRoleName().equals("Employee")) {
                    EmployeeView employeeView = new EmployeeView(sessionFactory, employee);
                    this.getParent().add(employeeView);
                    employeeView.setVisible(true);
                } else if (employee.getRoleId().getRoleName().equals("HR")) {
                    HrView hrView = new HrView(sessionFactory, employee);
                    this.getParent().add(hrView);
                    hrView.setVisible(true);
                } else {
                    ManagerView managerView = new ManagerView(sessionFactory, employee);
                    this.getParent().add(managerView);
                    managerView.setVisible(true);
                }
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
