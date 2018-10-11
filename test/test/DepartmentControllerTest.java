/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controllers.DepartmentController;
import org.hibernate.SessionFactory;
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
    
//    DepartmentController controller = new DepartmentController(SessionFactory sessionFactory);
    
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
        System.out.println("saveDepartment");
//        Employee employee = new Employee(100);
//        Department department = new Department("Marketing", employee);
       // boolean expResult = true;
//        boolean result = controller.saveOrUpdate(department);
        //assertEquals(expResult, result);
//        assertTrue(result);
    }
}
