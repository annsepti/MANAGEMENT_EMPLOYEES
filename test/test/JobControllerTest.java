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
 *
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
    public void testGetAll() {
        System.out.println("getAll");
        JobController jc = new JobController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = jc.getAll();
        assertNotNull(result);
    }
    @Test
    public void testSearch() {
        System.out.println("search");
        String category = "jobTitle";
        Object value = "PRESIDENT";
        JobController jc = new JobController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) jc.search(category, (String) value);
        assertNotNull(result);
    }
    @Test
    public void testGetById() {
        System.out.println("getById");
        String departmentId = "PRES";
        JobController jc = new JobController(tools.HibernateUtil.getSessionFactory());
        Object result = jc.getById(departmentId);
        assertNotNull(result);
    }
}
