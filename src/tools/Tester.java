/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import daos.GeneralDAO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import models.Department;
import models.Employee;
import models.Job;
import models.Role;
import models.Site;

/**
 *
 * @author Nande
 */
public class Tester {

    public static void main(String[] args) throws SQLException {
        Tools tools = new Tools();
        System.out.println(tools.checkEmail("windingz@gmail.com"));
        System.out.println(tools.checkNewPassword("Annisa7-"));
        System.out.println(tools.checkNumberFormat("5000"));
        System.out.println(tools.checkAlfabetOnly("Aku rapopo1"));

//
        EmployeeController controller = new EmployeeController(HibernateUtil.getSessionFactory());
//        Department department = new Department("MSBU", "Managed Service Business Unit");
//        Employee manager = new Employee(18001L);
//        Job job = new Job("J_PRG");
//        Role role = new Role(3L);
//        Site site = new Site();
//        GeneralDAO gdao = new GeneralDAO(HibernateUtil.getSessionFactory(), Employee.class);
//        Employee employee = new Employee(null, "Monk", "Beast", "42342", "", ""
//                , "annisa.septiana.sani@gmail.com", new BigDecimal(3500),"", "", "", ""
//                ,'A', new Date("1995/09/17"), new Date("2018/09/01"), "",
//                department, manager, job, role, site);
//        
//        System.out.println(gdao.addNewEmployee(employee));
        
        
        Employee employee = controller.firstLogin("kurnia.nugraha", "18001250695");
        if (employee.getEmployeeId() != null) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        
        

//        Employee employee = (Employee) controller.getById("18002");
//        System.out.println(tools.generatePassword(employee));

    }
}
