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
     * @param idEmp dengan tipe data String
     * @param mail dengan tipe data String
     * @param pass dengan tipe data String
     * @param hp dengan tipe data String
     * @param t_npwp dengan tipe data String
     * @param t_skck dengan tipe data String
     * @param foto dengan tipe data String
     * @param e_bpjs dengan tipe data String
     * @return mengembalikan nilai boolean apakah proses save/update berhasil dilakukan
     */
    public boolean saveOrUpdate(String idTemp, String idEmp, String mail, String pass, String hp, String t_npwp,
            String t_skck, String foto, String e_bpjs) {
        Employee employee = new Employee(new Long(idEmp));
        EmployeeTemp temp = new EmployeeTemp(new Long(idTemp), mail, pass, hp, t_npwp, t_skck, foto,
                e_bpjs, employee);
        return false;
    }
    /**
     * Method untuk menghapus temp
     * @param idTemp dengan tipe data String
     * @return idao  mengembalikan nilai objek
     */
    public Object delete(String idTemp) {
        TempControllers temp = (TempControllers) getById(idTemp);
        return idao.delete(temp);
    }
    /**
     * Method untuk menampilkan data Temp berdasarkan IDnya
     * @param idTemp dengan tipe data String
     * @return idao mengembalikan nilai objek
     */
    public Object getById(String idTemp) {
        return idao.getById(idTemp);
    }
}
