/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import daos.GeneralDAO;
import daos.InterfaceDAO;
import java.util.List;
import javax.swing.JComboBox;
import models.Department;
import models.Site;
import org.hibernate.SessionFactory;
/**
 *
 * @author 680183
 */
public class SiteController {
    private final InterfaceDAO idao;
    private final DepartmentController controller;

    public SiteController(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, Site.class);
        controller = new DepartmentController(sessionFactory);
    }
    public List<Object> getAll(){
        return idao.getAll();
    }
    public Object search(String category, String value){
        return idao.search(category, value);
    }
    public Object getById(String siteId){
        return idao.getById(new Long(siteId));
    }
    public boolean saveOrUpdate(String idSite, String siteName,String address, String idDept ){
        Department department = new Department(idDept);
        Site site = new Site(new Long(idSite),siteName, address, department);
        return idao.saveOrUpdate(site);
    }
    
     public void loadCmb(JComboBox cmb) {
        List<Object> objects = (List<Object>) controller.getAll();
        for (Object object : objects) {
            Department department = (Department) object;
            cmb.addItem(department.getDepartmentName());
        }
    }
}
