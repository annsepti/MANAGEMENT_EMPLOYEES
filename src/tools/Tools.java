/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.Employee;

/**
 *
 * @author Nande
 */
public class Tools {

    private final String username = "7nandemonai@gmail.com";
    private final String password = "Annisa7-";
    private EmployeeController controller;
    public Tools() {
        controller = new EmployeeController(HibernateUtil.getSessionFactory());
    }

    public boolean checkEmail(String email) {
        boolean hasil = false;
        String emailRegex = "^([a-z0-9\\+_\\-]+)(\\.[a-z0-9\\+_\\-]+)*@([a-z0-9\\-]+\\.)+[a-z]{2,6}$";
        if (email.matches(emailRegex)) {
            hasil = true;
        }
        return hasil;
    }

    public boolean checkNewPassword(String newPassword){
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&+-]).{8,}$";
        return newPassword.matches(passwordRegex);
    }
    
    public boolean checkNumberFormat(String number){
        String numberRegex = "\\d+";
        return number.matches(numberRegex);
    }
    
    public boolean checkAlfabetOnly(String word){
        String wordRegex = "\\D+";
        return word.matches(wordRegex);
    }
    
    public String dateToString(Date date){
        SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
        return formater.format(date);
    }
    
    public Date stringToDate(String sdate) throws ParseException{
        SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
        return formater.parse(sdate);
    }
    
    public Employee generatePassword(){
        return null;
    }
    
    
    
    public boolean sendUsernamePassword(Employee employee) {
        boolean hasil = false;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(employee.getEmail()));
            message.setSubject("Employee User Account");
            message.setText("Dear " + employee.getFirstName()+ " " +employee.getLastName() + ","
                    + "\n\nHere is your account:\n\nUsername\t: "
                    + employee.getUsername() + "\nPassword\t: "
                    + employee.getPassword());

            Transport.send(message);
            hasil = true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }
}
