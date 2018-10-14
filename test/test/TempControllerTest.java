/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controllers.TempControllers;
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
public class TempControllerTest {
    
    public TempControllerTest() {
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
        TempControllers tc = new TempControllers(tools.HibernateUtil.getSessionFactory());
        List <Object> result = tc.getAll();
        assertNotNull(result);
        assertTrue(result.size()>0);
        assertFalse(result.size()==0);
    }

    @Test
    public void testGetById() {
        System.out.println("getById");
        String tempId = "100";
        TempControllers tc = new TempControllers(tools.HibernateUtil.getSessionFactory());
        Object result = tc.getById(tempId);
        assertNotNull(result);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        TempControllers tc = new TempControllers(tools.HibernateUtil.getSessionFactory());
        Object result = tc.delete("18002");
        assertNotNull(result);
    }

//    @Test
//    public void testSaveOrUpdate() {
//        System.out.println("saveOrUpdate");
//        String tempId = "1";
//        String email = "haha";
//        String password = "";
//        String phone = "222180";
//        String npwp = "";
//        String skck = "";
//        String foto= "";
//        String bpjs = "";
//        String employeeId = "1";
//        TempControllers tc = new TempControllers(tools.HibernateUtil.getSessionFactory());
//        boolean result = tc.saveOrUpdate(tempId, email, password, phone, npwp, skck, foto, bpjs, employeeId);
//        assertTrue(result);
//    }
}
