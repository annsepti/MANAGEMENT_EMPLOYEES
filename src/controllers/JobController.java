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
 * Deklarasi kelas JobController dan instansiasi interfaceDAO
 * @author 680183
 */
public class JobController {
    private final InterfaceDAO idao;
    /**
     * Method konstruktor dari kelas JobController
     * @param sessionFactory dengan mengimport SessionFactory 
     */
    public JobController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Job.class);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel Job
     * @return idao mengembalikan nilai List
     */
    public List<Object> getAll(){
        return idao.getAll();
    }
    /**
     * Method untuk melakukan pencarian data Job berdasarkan kategori dan kata kunci
     * @param category dengan tipe data String
     * @param value dengan tipe data String
     * @return idao mengembalikan nilai List
     */
    public Object search(String category, String value){
        return idao.search(category, value);
    }
    /**
     * Method untuk menampilkan data Job berdasarkan IDnya
     * @param jobId dengan tipe data String
     * @return idao mengembalikan nilai objek
     */
    public Object getById(String jobId){
        return idao.getById(jobId);
    }
}
