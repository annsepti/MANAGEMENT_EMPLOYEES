/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import models.Role;
import org.hibernate.SessionFactory;

/**
 *
 * @author 680183
 */
public class RoleController {
    private final InterfaceDAO idao;

    public RoleController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Role.class);
    }
    public List<Object> getAll(){
        return idao.getAll();
    }
    public Object search(String category, String value){
        return idao.search(category, value);
    }
    public Object getById(String roleId){
        return idao.getById(new Long(roleId));
    }
}
