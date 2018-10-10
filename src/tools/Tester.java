/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import models.Employee;

/**
 *
 * @author Nande
 */
public class Tester {
    public static void main(String[] args) {
        Tools tools = new Tools();
        System.out.println(tools.checkEmail("windingz@gmail.com"));
        System.out.println(tools.checkNewPassword("Annisa7-"));
        System.out.println(tools.checkNumberFormat("5000"));
        System.out.println(tools.checkAlfabetOnly("Aku rapopo1"));
//        EmployeeController controller = new EmployeeController(HibernateUtil.getSessionFactory());
//        Employee employee = (Employee) controller.getById("18002");
//        System.out.println(tools.generatePassword(employee));
        
    }
}
