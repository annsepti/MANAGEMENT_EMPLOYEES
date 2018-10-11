/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author 680183
 */
public class JobController {
    private final InterfaceDAO idao;

    public JobController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Job.class);
    }
    public List<Object> getAll(){
        return idao.getAll();
    }
    public Object search(String category, String value){
        return idao.search(category, value);
    }
    public Object getById(String jobId){
        return idao.getById(jobId);
    }
}
