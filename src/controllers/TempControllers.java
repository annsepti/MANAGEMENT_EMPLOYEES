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
 *
 * @author 680183
 */
public class TempControllers {

    private final InterfaceDAO idao;

    public TempControllers(SessionFactory sessionFactory) {
        idao = new GeneralDAO(sessionFactory, EmployeeTemp.class);

    }

    public List<Object> getAll() {
        return idao.getAll();
    }

    public boolean saveOrUpdate(String idTemp, String idEmp, String mail, String pass, String hp, String t_npwp,
            String t_skck, String foto, String e_bpjs) {
        Employee employee = new Employee(new Long(idEmp));
        EmployeeTemp temp = new EmployeeTemp(new Long(idTemp), mail, pass, hp, t_npwp, t_skck, foto,
                e_bpjs, employee);
        return false;
    }

    public Object delete(String idTemp) {
        TempControllers temp = (TempControllers) getById(idTemp);
        return idao.delete(temp);
    }

    public Object getById(String idTemp) {
        return idao.getById(idTemp);
    }
}
