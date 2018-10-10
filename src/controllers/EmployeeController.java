/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import models.Department;
import models.Employee;
import models.Job;
import models.Role;
import models.Site;
import org.hibernate.SessionFactory;

/**
 *
 * @author 680183
 */
public class EmployeeController {

    private InterfaceDAO idao;

    public EmployeeController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Employee.class);
    }

    public Object getAll() {
        return idao.getAll();
    }

    public Object getById(String employeeId) {
        return idao.getById(new Long(employeeId));
    }

    public Object search(String category, String value) {
        return idao.search(category, value);
    }

    public boolean saveOrUpdate(String employeeId, String firstName, String lastName, String e_nik, String uname, String pass,
            String mail, String sal, String e_phone, String e_npwp, String e_skck, String departmentId, String siteId, String jobId,
            String managerId, String foto, String stat, String birthDate, String hireDate, String roleId, String e_bpjs) {
        Department department = new Department(new BigDecimal(departmentId));
        Employee manager = new Employee(new BigDecimal(managerId));
        Job job = new Job(new BigDecimal(jobId));
        Site site = new Site(new BigDecimal(siteId));
        Role role = new Role(new BigDecimal(roleId));

        Employee employee = new Employee(new BigDecimal(employeeId), lastName, firstName, e_nik, uname, pass,
                mail, new BigInteger(sal), e_phone, e_npwp, e_skck, foto, stat.charAt(0),
                new Date(birthDate), new Date(hireDate), e_bpjs,
                department, manager, job, role, site);
        return idao.saveOrUpdate(employee);
    }

    public Object getNewId() {
        Employee employee = (Employee) idao.getLastId();
        return Integer.parseInt(employee.getEmployeeId() + "") + 1;
    }
}
