/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import models.EmployeeTemp;
import org.hibernate.SessionFactory;

/**
 *
 * @author 680183
 */
public class TempControllers {
    private final InterfaceDAO idao;

    public TempControllers(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, EmployeeTemp.class);
    }
    public List<Object> getAll(){
        return idao.getAll();
    }
    
}
