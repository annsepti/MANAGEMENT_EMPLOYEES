/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.InterfaceDAO;
import java.util.List;

/**
 *
 * @author 680183
 */
public class JobController {
    private final InterfaceDAO idao;

    public JobController(InterfaceDAO idao) {
        this.idao = idao;
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
}
