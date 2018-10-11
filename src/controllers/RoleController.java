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
 * Deklarasi kelas RoleController dan instansiasi interfaceDAO
 * @author 680183
 */
public class RoleController {
    private final InterfaceDAO idao;
    /**
     * Method konstruktor dari kelas RoleController
     * @param sessionFactory dengan mengimport SessionFactory 
     */
    public RoleController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Role.class);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel Role
     * @return idao mengembalikan nilai List
     */
    public List<Object> getAll(){
        return idao.getAll();
    }
    /**
     * Method untuk melakukan pencarian data Role berdasarkan kategori dan kata kunci
     * @param category dengan tipe data String
     * @param value dengan tipe data String
     * @return idao mengembalikan nilai List
     */
    public Object search(String category, String value){
        return idao.search(category, value);
    }
    /**
     * Method untuk menampilkan data Role berdasarkan IDnya
     * @param roleId dengan tipe data String
     * @return idao mengembalikan nilai objek
     */
    public Object getById(String roleId){
        return idao.getById(new Long(roleId));
    }
}
