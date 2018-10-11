/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import controllers.EmployeeController;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
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
        String hireDate = "11/02/2017";
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
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) ec.getAll();
        assertNotNull(result);
    }
    @Test
    public void testSearch() {
        System.out.println("search");
        String category = "lastName";
        Object value = "Sani";
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) ec.search(category, (String) value);
        assertNotNull(result);
    }
    @Test
    public void testGetById() {
        System.out.println("getById");
        String departmentId = "18001";
        EmployeeController ec = new EmployeeController(tools.HibernateUtil.getSessionFactory());
        Object result = ec.getById(departmentId);
        assertNotNull(result);
    }
}
