/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controllers.DepartmentController;
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
public class DepartmentControllerTest {
    
    public DepartmentControllerTest() {
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
        String idDept = "AAA";
        String deptName = "coba";
        String idMng = "18001";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        boolean result = dc.saveOrUpdate(idDept, deptName, idMng);
        assertTrue(result);
    }
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = dc.getAll();
        assertNotNull(result);
    }
    @Test
    public void testSearch() {
        System.out.println("search");
        String category = "departmentId";
        Object value = "MSBU";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) dc.search(category, (String) value);
        assertNotNull(result);
    }
    @Test
    public void testGetById() {
        System.out.println("getById");
        String departmentId = "MSAD";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        Object result = dc.getById(departmentId);
        assertNotNull(result);
    }
}
