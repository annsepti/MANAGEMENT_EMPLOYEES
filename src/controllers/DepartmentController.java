/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import models.Department;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 * Deklarasi kelas DepartmentController dan instansiasi InterfaceDAO
 * @author 680183
 */
public class DepartmentController {

    private final InterfaceDAO idao;
    /**
     * Method konstruktor dari kelas DepartmentController
     * @param sessionFactory dengan mengimport SessionFactory 
     */
    public DepartmentController(SessionFactory sessionFactory) {  
        idao = new GeneralDAO(sessionFactory, Department.class);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel Department
     * @return idao mengembalikan nilai List
     */
    public List<Object> getAll() {
        return idao.getAll();
    }
     /**
     * Method untuk melakukan pencarian data Department berdasarkan kategori dan kata kunci
     * @param category dengan tipe data String
     * @param value dengan tipe data String
     * @return idao mengembalikan nilai List
     */
    public Object search(String category, String value) {
        return idao.search(category, value);
    }
    /**
     * Method untuk menampilkan data Department berdasarkan IDnya
     * @param departmentId dengan tipe data String
     * @return iDAO mengembalikan nilai objek
     */
    public Object getById(String departmentId){
        return idao.getById(departmentId);
    }
    /**
     * Method untuk melakukan penyimpanan data baru atau update data
     * @param idDept dengan tipe data String
     * @param deptName dengan tipe data String
     * @param idMng dengan tipe data String
     * @return mengembalikan nilai boolean apakah proses save/update berhasil dilakukan
     */
    public boolean saveOrUpdate(String idDept, String deptName, String idMng) {
        Employee manager = new Employee(new Long(idMng));
        Department department = new Department(idDept, deptName, manager);
        return idao.saveOrUpdate(department);
    }
    
}
