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
 * Deklarasi kelas DepartmentControllerTest
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
    
    //    @Test
    public void testGetAll() {
        System.out.println("Test: getAll");
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = dc.getAll();
        assertNotNull(result);
        assertTrue(result.size()>0);
        assertFalse(result.size()==0);
        
    }
    //    @Test
    public void testSearch1() {
        System.out.println("Test: search");
        String category = "departmentId";
        Object value = "MSBU";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        List<Object> result = (List<Object>) dc.search(category, (String) value);
        assertNotNull(result);
        assertTrue(result.size()==1);
        assertFalse(result.size()==0);
    }
    //    @Test
    public void testGetById() {
        System.out.println("Test: getById");
        String departmentId = "MSAD";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        Object result = dc.getById(departmentId);
        assertNotNull(result);
    }
//    @Test
    public void testGetById1() {
        System.out.println("Test: getById");
        String departmentId = "MS";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        Object result = dc.getById(departmentId);
        assertNull(result);
    }
    @Test
    public void testGetById2() {
        System.out.println("Test: getById");
        String departmentId = "MS";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        Object result = dc.getById(departmentId);
        assertNull(result);
    }
//    @Test
    public void testSaveOrUpdate() {
        System.out.println("Test: saveOrUpdate");
        String idDept = "AAA";
        String deptName = "coba";
        String idMng = "18001";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        boolean result = dc.saveOrUpdate(idDept, deptName, idMng);
        assertTrue(result);
    }
//    @Test
    public void testSaveOrUpdateFalse() {
        System.out.println("Test: saveOrUpdate");
        String idDept = "BBB";
        String deptName = "";
        String idMng = "aa";
        DepartmentController dc = new DepartmentController(tools.HibernateUtil.getSessionFactory());
        boolean result = dc.saveOrUpdate(idDept, deptName, idMng);
        assertFalse(result);
    }


}
