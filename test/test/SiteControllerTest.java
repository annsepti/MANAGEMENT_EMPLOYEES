/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import controllers.SiteController;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Deklarasi kelas SiteControllerTest 
 * @author 680183
 */
public class SiteControllerTest {
    
    public SiteControllerTest() {
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
        String idSite = "7";
        String siteName = "Toyota";
        String address = "Tebet";
        String idDept= "MSBU";
        SiteController sc = new SiteController(tools.HibernateUtil.getSessionFactory());
        boolean result = sc.saveOrUpdate(idSite, siteName, address, idDept);
        assertTrue(result);
    }
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        SiteController sc = new SiteController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = sc.getAll();
        assertNotNull(result);
    }
    @Test
    public void testSearch() {
        System.out.println("search");
        String category = "siteName";
        Object value = "Toyota";
        SiteController sc = new SiteController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) sc.search(category, (String) value);
        assertNotNull(result);
    }
    @Test
    public void testGetById() {
        System.out.println("getById");
        String departmentId = "1";
        SiteController sc = new SiteController(tools.HibernateUtil.getSessionFactory());
        Object result = sc.getById(departmentId);
        assertNotNull(result);
    }
}
