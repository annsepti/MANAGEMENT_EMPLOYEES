/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import models.Employee;
import models.EmployeeTemp;
import org.hibernate.SessionFactory;

/**
 * Deklarasi kelas TempController dan instansiasi InterfaceDAO 
 * @author 680183
 */
public class TempControllers {

    private final InterfaceDAO idao;
    /**
     * Method konstruktor dari kelas TempController
     * @param sessionFactory dengan mengimport SessionFactory 
     */
    public TempControllers(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, EmployeeTemp.class);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel employee_temp
     * @return idao mengembalikan nilai List
     */
    public List<Object> getAll() {
        return idao.getAll();
    }
    /**
     * Method untuk melakukan penyimpanan data baru atau update data
     * @param idTemp dengan tipe data String
     * @param phone dengan tipe data String
     * @param npwp dengan tipe data String
     * @param skck dengan tipe data String
     * @param bpjs dengan tipe data String
     * @param mail dengan tipe data String
     * @param idEmp dengan tipe data String
     * @return mengembalikan nilai boolean apakah proses save/update berhasil dilakukan
     */
    public boolean saveOrUpdate(String idTemp, String mail,String phone, String npwp,String skck, String bpjs, String idEmp) {
        Employee employee = new Employee(new Long(idEmp));
        EmployeeTemp temp = new EmployeeTemp(new Long(idTemp), mail, phone, npwp, skck, bpjs, employee);
        return idao.saveOrUpdate(temp);
    }
    /**
     * Method untuk menghapus temp
     * @param idTemp dengan tipe data String
     * @return idao  mengembalikan nilai objek
     */
    public boolean delete(String idTemp) {
        EmployeeTemp temp =  (EmployeeTemp) getById(idTemp);
        return idao.delete(temp);
    }
    /**
     * Method untuk menampilkan data Temp berdasarkan IDnya
     * @param idTemp dengan tipe data String
     * @return idao mengembalikan nilai objek
     */
    public Object getById(String idTemp) {
        return idao.getTempById(idTemp);
    }
    /**
     * Method untuk mendapatkan id employee temporary baru
     * @return EmployeeTemp mengembalikan nilai objek
     */
    public Object getNewId() {
        EmployeeTemp employee = (EmployeeTemp) idao.getLastId();
        return Integer.parseInt(employee.getTempId()+ "") + 1;
    }
    /**
     * Method untuk melakukan search berdasarkan kategori dan kata kunci
     * @param category tipe data String
     * @param value tipe data String
     * @return idao mengembalikan nilai object
     */
    public Object search(String category, String value) {
        return idao.search(category, new Employee(new Long(value)));
    }
}
