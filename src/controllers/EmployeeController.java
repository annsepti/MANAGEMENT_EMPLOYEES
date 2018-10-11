/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;
import models.Role;
import models.Site;
import org.hibernate.SessionFactory;
import tools.BCrypt;

/**
 *
 * @author 680183
 */
public class EmployeeController {

    private final InterfaceDAO idao;

    public EmployeeController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Employee.class);
    }

    public Object getAll() {
        return idao.getAll();
    }

    public Object getById(String employeeId) {
        return idao.getById(new BigDecimal(employeeId));
    }

    public Object search(String category, String value) {
        return idao.search(category, value);
    }

    public boolean saveOrUpdate(String employeeId, String firstName, String lastName, String e_nik, String uname, String pass,
            String mail, String sal, String e_phone, String e_npwp, String e_skck, String departmentId, String siteId, String jobId,
            String managerId, String foto, String stat, String birthDate, String hireDate, String roleId, String e_bpjs) {
        Department department = new Department(departmentId);
        Employee manager = new Employee(new Long(managerId));
        Job job = new Job(jobId);
        Site site = new Site(new Long(siteId));
        Role role = new Role(new Long(roleId));
        String password = BCrypt.hashpw(pass, BCrypt.gensalt());
        Employee employee = new Employee(new Long(employeeId), lastName, firstName, e_nik, uname, password,
                mail, new BigDecimal(sal), e_phone, e_npwp, e_skck, foto, stat.charAt(0),
                new Date(birthDate), new Date(hireDate), e_bpjs,
                department, manager, job, role, site);
        return idao.saveOrUpdate(employee);
    }

    public Object getNewId() {
        Employee employee = (Employee) idao.getLastId();
        return Integer.parseInt(employee.getEmployeeId() + "") + 1;
    }
    
    public Employee login(String username, String password){
        List<Employee> employees = (List<Employee>) search("username", username);
        Employee employee = employees.get(0);
        if(!BCrypt.checkpw(password, employee.getPassword())) employee = null;
        return employee;
    }

    public Employee firstLogin(String username, String password) {
        Employee employee = new Employee(username, password);
        return (Employee) idao.getByLogin(employee);
    }

    public Employee nextLogin(String username, String password) {
        Employee employee = (Employee) search("username", username);
        if (BCrypt.checkpw(password, employee.getPassword()) == false) {
            employee = null;
        }
        return employee;
    }
    
    public int addNewEmployee(Employee employee) throws SQLException{
        return idao.addNewEmployee(employee);
    }
    public int changePassword(String username, String password) throws SQLException{
        return idao.changePassword(username, password);
    }
}
