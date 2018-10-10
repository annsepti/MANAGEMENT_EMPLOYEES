/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import models.Departments;
import models.Employees;
import org.hibernate.SessionFactory;

/**
 *
 * @author 680183
 */
public class DepartmentController {
    private final InterfaceDAO idao;
    private final EmployeeController empController;
    
    public DepartmentController(SessionFactory sessionFactory) {  
        idao = new GeneralDAO(sessionFactory, Departments.class);
        empController = new EmployeeController(sessionFactory);
    }
    public List<Object> getAll(){
        return idao.getAll();
    }
    public Object search(String category, String value){
        return idao.search(category, value);
    }
    public Object getById(String departmentId){
        return idao.getById(new Short(departmentId));
    }
//    public boolean saveOrUpdate(String departmentId, String departmentName, String managerId){
//        Employees manager = new Employees(new Long(managerId.substring(0,3)));
//        Departments department = new Departments(new Long(departmentId), departmentName, manager);
//        return iDAO.saveOrUpdate(department);
//    }
}
