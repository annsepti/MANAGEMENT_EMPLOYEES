/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JComboBox;
import models.Department;
import models.Site;
import org.hibernate.SessionFactory;
/**
 * Deklarasi kelas SiteController dan instansiasi InterfaceDAO dan DepartmentController
 * @author 680183
 */
public class SiteController {
    private final InterfaceDAO idao;
    private final DepartmentController departmentController;
    /**
     * Method konstruktor dari kelas SiteController
     * @param sessionFactory dengan mengimport SessionFactory 
     */
    public SiteController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Site.class);
        departmentController = new DepartmentController(sessionFactory);
    }
    /**
     * Method untuk mengambil semua data yang ada pada tabel Site
     * @return idao mengembalikan nilai List
     */
    public List<Object> getAll(){
        return idao.getAll();
    }
    /**
     * Method untuk melakukan pencarian data Site berdasarkan kategori dan kata kunci
     * @param category dengan tipe data String
     * @param value dengan tipe data String
     * @return idao mengembalikan nilai List
     */
    public Object search(String category, String value){
        return idao.search(category, value);
    }
    /**
     * Method untuk menampilkan data Site berdasarkan IDnya
     * @param siteId dengan tipe data String
     * @return idao mengembalikan nilai objek
     */
    public Object getById(String siteId){
        return idao.getById(new Long(siteId));
    }
    /**
     * Method untuk melakukan penyimpanan data baru atau update data
     * @param idSite dengan tipe data String
     * @param siteName dengan tipe data String
     * @param address dengan tipe data String
     * @param idDept dengan tipe data String
     * @return mengembalikan nilai boolean apakah proses save/update berhasil dilakukan
     */
    public boolean saveOrUpdate(String idSite, String siteName,String address, String idDept ){
        Department department = new Department(idDept);
        Site site = new Site(new Long(idSite),siteName, address, department);
        return idao.saveOrUpdate(site);
    }
    /**
     * Method untuk membuat id baru secara increment +1
     * @return iDAO mengembalikan nilai object
     */
    public Object getAutoId(){
        Site site =  (Site) idao.getLastId();
        return site.getSiteId()+1;
    }
    /**
     * Menthod untuk loadCmb
     * @param cmb dengan tipe data JComboBox
     */
    public void loadCmb(JComboBox cmb) {
        List<Object> objects = (List<Object>) departmentController.getAll();
        for (Object object : objects) {
            Department department = (Department) object;
            cmb.addItem(department.getDepartmentName());
        }
    }
     
}
