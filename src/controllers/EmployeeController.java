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
import javax.swing.JComboBox;
import models.Department;
import models.Employee;
import models.Job;
import models.Role;
import models.Site;
import org.hibernate.SessionFactory;
import tools.BCrypt;

/**
 * Deklarasi kelas EmployeeController dan instansiasi InterfaceDAO
 * @author 680183
 */
public class EmployeeController {
    private final InterfaceDAO idao;
    private final DepartmentController departmentController;
    private final JobController jobController;
    private final SiteController siteController;
    /**
     * Method konstruktor dari kelas EmployeeController
     * @param sessionFactory dengan mengimport SessionFactory 
     */
    public EmployeeController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Employee.class);
        departmentController = new DepartmentController(sessionFactory);
        jobController = new JobController(sessionFactory);
        siteController = new SiteController(sessionFactory);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel Employees
     * @return idao mengembalikan nilai List
     */
    public Object getAll() {
        return idao.getAll();
    }
    /**
     * Method untuk menampilkan data Employee berdasarkan IDnya
     * @param employeeId dengan tipe data String
     * @return idao mengembalikan nilai objek
     */
    public Object getById(String employeeId) {
        return idao.getById(new Long(employeeId));
    }
     /**
     * Method untuk melakukan pencarian data Department berdasarkan kategori dan kata kunci
     * @param category dengan tipe data String
     * @param value dengan tipe data String
     * @return idao mengembalikan nilai List
     */
    public Object search(String category, String value) {
        return idao.search(category, value);
    }
    /**
     * Method untuk melakukan penyimpanan data baru atau update data
     * @param employeeId dengan tipe data String
     * @param firstName dengan tipe data String
     * @param lastName dengan tipe data String
     * @param e_nik dengan tipe data String
     * @param uname dengan tipe data String
     * @param pass dengan tipe data String
     * @param mail dengan tipe data String
     * @param sal dengan tipe data String
     * @param e_phone dengan tipe data String
     * @param e_npwp dengan tipe data String
     * @param e_skck dengan tipe data String
     * @param departmentId dengan tipe data String
     * @param siteId dengan tipe data String
     * @param jobId dengan tipe data String
     * @param managerId dengan tipe data String
     * @param foto dengan tipe data String
     * @param stat dengan tipe data String
     * @param birthDate dengan tipe data String
     * @param hireDate dengan tipe data String
     * @param roleId dengan tipe data String
     * @param e_bpjs dengan tipe data String
     * @return mengembalikan nilai boolean apakah proses save/update berhasil dilakukan
     */
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
    
    /**
     * Method untuk membuat id baru secara increment
     * @return idao mengembalikan nilai employeeId
     */
    public Object getNewId() {
        Employee employee = (Employee) idao.getLastId();
        return Integer.parseInt(employee.getEmployeeId() + "") + 1;
    }
    
    /**
     * Untuk melakukan login setelah password diubah
     * @param username username
     * @param password password
     * @return data employee
     */
    public Employee login(String username, String password){
        List<Employee> employees = (List<Employee>) search("username", username);
        Employee employee = employees.get(0);
        if(!BCrypt.checkpw(password, employee.getPassword())) employee = null;
        return employee;
    }

    /**
     * Untuk melakukan login pertama kali setelah akun employee dibuat
     * @param username username
     * @param password password
     * @return data employee
     */
    public Employee firstLogin(String username, String password) {
        Employee employee = new Employee(username, password);
        return (Employee) idao.getByLogin(employee);
    }

    /**
     * Untuk menambahkan employee baru
     * @param employee data employee
     * @return int
     * @throws SQLException penangkap error
     */
    public int addNewEmployee(Employee employee) throws SQLException{
        return idao.addNewEmployee(employee);
    }
    
    /**
     * Method untuk mendapatkan managerId
     * @param manager dengan tipe data employee
     * @return idao mengembalikan nilai List
     */
    public List<Employee> getByManagerId(Employee manager){
       return idao.getByManagerId(manager);
    }
    
    /**
     * Untuk mengubah password
     * @param username username
     * @param password password
     * @return int 
     * @throws SQLException penangkap error
     */
    public int changePassword(String username, String password) throws SQLException{
        return idao.changePassword(username, password);
    }
    
    public void loadCmbDepartment(JComboBox cmb) {
        List<Object> objects = (List<Object>) departmentController.getAll();
        for (Object object : objects) {
            Department department = (Department) object;
            cmb.addItem(department.getDepartmentName());
        }
    }
    
    public void loadCmbSite(JComboBox cmb) {
        List<Object> objects = (List<Object>) siteController.getAll();
        for (Object object : objects) {
            Site site = (Site) object;
            cmb.addItem(site.getSiteName());
        }
    }
    
    public void loadCmbJob(JComboBox cmb) {
        List<Object> objects = (List<Object>) jobController.getAll();
        for (Object object : objects) {
            Job job = (Job) object;
            cmb.addItem(job.getJobTitle());
        }
    }
    
    public void loadCmbManager(JComboBox cmb) {
        List<Object> objects = (List<Object>) getAll();
        for (Object object : objects) {
            Employee employee = (Employee) object;
            cmb.addItem(employee.getEmployeeId());
        }
    }
    
}
