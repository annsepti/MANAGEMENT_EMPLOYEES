/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.SQLException;
import java.util.List;
import models.Employee;

/**
 *
 * @author Ignatius
 */
public interface InterfaceDAO {
    public boolean saveOrUpdate(Object object);
    public boolean delete(Object object);
    public List<Object> getAll();
    public List<Object> search(String category, Object key);
    public Object getById(Object id);
    public Object getLastId();
    public Object getByLogin(Object model);
    public int addNewEmployee(Employee employee)throws SQLException;
    public List<Employee> getByManagerId(Object object);
    public int changePassword(String username, String password) throws SQLException;
}
