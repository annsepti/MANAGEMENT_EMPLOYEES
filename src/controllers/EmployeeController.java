/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import java.util.Date;
import models.Departments;
import models.Employees;
import models.Jobs;
import models.Roles;
import models.Sites;
import org.hibernate.SessionFactory;

/**
 *
 * @author 680183
 */
public class EmployeeController {
   private InterfaceDAO idao;

    public EmployeeController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Employees.class);
    }
    public Object getAll(){
        return idao.getAll();
    }
    public Object getById(String employeeId){
        return idao.getById(new Long(employeeId));
    }
    public Object search(String category, String value){
        return idao.search(category, value);
    }
    public boolean saveOrUpdate(String employeeId, String firstName, String lastName, String e_nik, String uname, String pass, 
            String mail, String sal, String e_phone, String e_npwp, String e_skck, String departmentId, String siteId, String jobId,
            String managerId, String foto, String stat, String birthDate, String hireDate, String roleId, String e_bpjs){
        Departments department = new Departments(new Long(departmentId));
        Employees manager = new Employees(new Long(managerId));
        Jobs job = new Jobs(new Long(jobId));
        Sites site = new Sites(new Long(siteId));
        Roles role = new Roles(new Long(roleId));
            Employees employee = new Employees(new Long(employeeId), firstName, lastName, e_nik, uname, pass, 
             mail, new BigDecimal(sal), e_phone, e_npwp, e_skck, new Long(siteId),
             new Long(managerId), foto, stat, new Date(birthDate), new Date(hireDate), new Long(roleId), e_bpjs, 
                new BigDecimal(sal), department, manager, job, site, role);
        return idao.saveOrUpdate(employee);
    }
    
    public Object getNewId(){
        Employees employee =  (Employees) idao.getLastId();
        return employee.getEmployeeId() + 1;
    }
}
