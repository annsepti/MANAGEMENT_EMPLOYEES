/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controllers.JobController;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Deklarasi kelas JobControllerTest
 * @author 680183
 */
public class JobControllerTest {
    
    public JobControllerTest() {
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

//     @Test
    public void testGetAll() {
        System.out.println("Test: getAll");
        JobController jc = new JobController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = jc.getAll();
        assertNotNull(result);
        assertTrue(result.size()>0);
        assertFalse(result.size()==0);
    }
//    @Test
    public void testSearch() {
        System.out.println("Test: search");
        String category = "jobTitle";
        Object value = "PRESIDENT";
        JobController jc = new JobController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) jc.search(category, (String) value);
        assertNotNull(result);
        assertTrue(result.size()>0);
        assertFalse(result.size()==0);
    }
//    @Test
    public void testGetById() {
        System.out.println("Test: getById");
        String departmentId = "PRES";
        JobController jc = new JobController(tools.HibernateUtil.getSessionFactory());
        Object result = jc.getById(departmentId);
        assertNotNull(result);
    }
    @Test
    public void testGetById2() {
        System.out.println("Test: getById");
        String departmentId = "PR";
        JobController jc = new JobController(tools.HibernateUtil.getSessionFactory());
        Object result = jc.getById(departmentId);
        assertNull(result);
    }
}
