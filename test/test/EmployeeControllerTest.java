/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import controllers.EmployeeController;
import java.util.List;
import javax.swing.JComboBox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Deklarasi kelas EmployeeControllerTest
 * @author 680183
 */
public class EmployeeControllerTest {
    
    public EmployeeControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) ec.getAll();
        assertNotNull(result);
        assertTrue(result.size()>0);
        assertFalse(result.size()==0);
    }
    @Test
    public void testSearch() {
        System.out.println("search");
        String category = "lastName";
        Object value = "Sani";
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) ec.search(category, (String) value);
        assertNotNull(result);
        assertTrue(result.size()>0);
        assertFalse(result.size()==0);
    }
    @Test
    public void testGetById() {
        System.out.println("getById");
        String departmentId = "18001";
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        Object result = ec.getById(departmentId);
        assertNotNull(result);
    }
    @Test
    public void testGetById1() {
        System.out.println("getById");
        String departmentId = "18001";
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        Object result = ec.getById(departmentId);
        assertNull(result);
    }
    @Test
    public void testGetNewId() {
        System.out.println("Test: getNewId");
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        Object result = ec.getNewId();
        assertNotNull(result);
    }
    @Test
    public void testLoadCmbDepartment() {
        System.out.println("Test: loadCmbDepartment");
        JComboBox cmb = new JComboBox();
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        ec.loadCmbDepartment(cmb);
        assertNotNull(ec);
    }
    @Test
    public void testLoadCmbSite() {
        System.out.println("Test: loadCmbSite");
        JComboBox cmb = new JComboBox();
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        ec.loadCmbSite(cmb);
        assertNotNull(ec);
    }
    @Test
    public void testLoadCmbJob() {
        System.out.println("Test: loadCmbJob");
        JComboBox cmb = new JComboBox();
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        ec.loadCmbJob(cmb);
        assertNotNull(ec);
    }
    @Test
    public void testLoadCmbManager() {
        System.out.println("Test: loadCmbManager");
        JComboBox cmb = new JComboBox();
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        ec.loadCmbManager(cmb);
        assertNotNull(ec);
    }
//    @Test
    public void testSaveOrUpdate() {
        System.out.println("Try saveOrUpdate");
        String employeeId = "18008";
        String lastName = "Adams";
        String firstName = "Amy";
        String nik = "3201075709950555";
        String username = "";
        String password = "";
        String email = "amy.adams@gmail.com";
        String salary = "";
        String phone = "";
        String npwp = "";
        String skck = "";
        String photo = "";
        String status = "A";
        String birthDate = "";
        String hireDate = "";
        String bpjs = "";
        String departmentId = "MSAD";
        String managerId = "18002";
        String jobId = "ACC";
        String roleId = "1";
        String siteId = "3";
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        boolean result = ec.saveOrUpdate(employeeId, lastName, firstName, nik, username, password,
                email, salary, phone, npwp, skck, photo, status, birthDate, hireDate, bpjs,
                departmentId, managerId, jobId, roleId, siteId);
        assertTrue(result);
    }
//    @Test
    public void testSaveOrUpdate1() {
        System.out.println("Try saveOrUpdate");
        String employeeId = "18008";
        String lastName = "Adams";
        String firstName = "Amy";
        String nik = "3201075709950555";
        String username = "";
        String password = "";
        String email = "amy.adams@gmail.com";
        String salary = "";
        String phone = "";
        String npwp = "";
        String skck = "";
        String photo = "";
        String status = "A";
        String birthDate = "";
        String hireDate = "";
        String bpjs = "";
        String departmentId = "MSAD";
        String managerId = "18002";
        String jobId = "ACC";
        String roleId = "";
        String siteId = "3";
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        boolean result = ec.saveOrUpdate(employeeId, lastName, firstName, nik, username, password,
                email, salary, phone, npwp, skck, photo, status, birthDate, hireDate, bpjs,
                departmentId, managerId, jobId, roleId, siteId);
        assertFalse(result);
    }
}
