/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controllers.RoleController;
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
public class RoleControllerTest {
    
    public RoleControllerTest() {
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
        RoleController rc = new RoleController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = rc.getAll();
        assertNotNull(result);
    }
    @Test
    public void testSearch() {
        System.out.println("search");
        String category = "roleName";
        Object value = "HR";
        RoleController rc = new RoleController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) rc.search(category, (String) value);
        assertNotNull(result);
    }
    @Test
    public void testGetById() {
        System.out.println("getById");
        String departmentId = "1";
        RoleController rc = new RoleController(tools.HibernateUtil.getSessionFactory());
        Object result = rc.getById(departmentId);
        assertNotNull(result);
    }
}
