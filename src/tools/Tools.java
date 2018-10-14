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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.Employee;

/**
 *
 * @author Nande
 */
public class Tools {

    private EmployeeController controller;
    private Setting setting;
    private Employee hr;
    private String reason;

    public Tools() {
        controller = new EmployeeController(HibernateUtil.getSessionFactory());
    }

    public Tools(Employee hr, String reason) {
        controller = new EmployeeController(HibernateUtil.getSessionFactory());
        setting = new Setting();
        this.hr = hr;
        this.reason = reason;
    }

    public boolean checkEmail(String email) {
        boolean hasil = false;
        String emailRegex = "^([a-z0-9\\+_\\-]+)(\\.[a-z0-9\\+_\\-]+)*@([a-z0-9\\-]+\\.)+[a-z]{2,6}$";
        if (email.matches(emailRegex)) {
            hasil = true;
        }
        return hasil;
    }

    public boolean checkNewPassword(String newPassword) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&+-]).{8,}$";
        return newPassword.matches(passwordRegex);
    }

    public boolean checkNumberFormat(String number) {
        String numberRegex = "\\d+";
        return number.matches(numberRegex);
    }

    public boolean checkAlfabetOnly(String word) {
        String wordRegex = "\\D+";
        return word.matches(wordRegex);
    }

    public String dateToString(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
        return formater.format(date);
    }

    public Date stringToDate(String sdate) throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
        return formater.parse(sdate);
    }

    public String generatePassword(Employee employee) {
        String birthdate = dateToString(employee.getBirthDate());
        String[] bdate = birthdate.split("/");
        return employee.getEmployeeId() + bdate[1] + bdate[0] + bdate[2].substring(2, 4);
    }

    public String generateUsername(Employee employee) {
        return employee.getFirstName().toLowerCase() + "." + employee.getLastName().toLowerCase();
    }

    /**
     * 
     * @param employee
     * @param code 1 for send username and pasword, 2 for reason disaproove, 3
     * @return 
     */
    public boolean sendMessage(Employee employee, int code) {
        boolean hasil = false;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(setting.getEmail(), setting.getPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(setting.getEmail()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(employee.getEmail()));
            message = setMessage(code, message, employee);
            Transport.send(message);
            hasil = true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    /**
     *
     * @param code 1 for send username and pasword, 2 for reason disaproove, 3
     * for approove
     * @param message
     * @param employee
     * @return
     * @throws AddressException
     * @throws MessagingException
     */
    private Message setMessage(int code, Message message, Employee employee) throws AddressException, MessagingException {
        switch (code) {
            case 1:
                message.setSubject("Employee User Account");
                message.setText("Dear " + employee.getFirstName() + " " + employee.getLastName() + ","
                        + "\n\nHere is your account:\n\nUsername\t: "
                        + employee.getUsername() + "\nPassword\t: "
                        + employee.getPassword() + "\n\nRegards,\n\n" + hr.getFirstName() + " " + hr.getLastName());
            case 2:
                message.setSubject("Approvement Result");
                message.setText("Dear " + employee.getFirstName() + " " + employee.getLastName() + ",\n\n" + reason
                        + "\n\nRegards,\n\n" + hr.getFirstName() + " " + hr.getLastName());
        }
        return message;
    }
}
