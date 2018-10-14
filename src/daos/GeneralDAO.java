/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import tools.BCrypt;
import tools.Tools;

/**
 *
 * @author Ignatius
 */
public class GeneralDAO implements InterfaceDAO {

    private final FunctionDAO gdao;
    private final Class type;
    EntityManager entityManager;
    EntityManagerFactory emf;
    Session session;
    SessionFactory sf;

    public GeneralDAO(SessionFactory sessionFactory, Class type) {
        this.gdao = new FunctionDAO(sessionFactory);
        this.type = type;
        sf = sessionFactory;
    }

    @Override
    public boolean saveOrUpdate(Object object) {
        return (boolean) gdao.execute(0, object, type, null, null);
    }

    @Override
    public boolean delete(Object object) {
        return (boolean) gdao.execute(1, object, type, null, null);
    }

    @Override
    public List<Object> getAll() {
        return (List<Object>) gdao.execute(99, null, type, null, null);
    }

    @Override
    public List<Object> search(String category, Object key) {
        return (List<Object>) gdao.execute(3, null, type, category, key);
    }

    @Override
    public Object getById(Object id) {
        return gdao.execute(2, null, type, type.getSimpleName().toLowerCase() + "Id", id);
    }

    @Override
    public Object getLastId() {
        return gdao.execute(4, null, type, null, null);
    }

    @Override
    public Object getByLogin(Object model) {
        return gdao.execute(5, null, type, null, model);
    }
    
    @Override
    public Object getTempById(Object id){
        return gdao.execute(2, null, type, "tempId", new Long(id+""));
    }
    
    @Override
    public int addNewEmployee(Employee employee) throws SQLException{
        Connection con = sf.getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();
        Tools tools = new Tools();
        Employee e = (Employee) getLastId();
        employee.setEmployeeId(e.getEmployeeId() + 1);
        String username = employee.getFirstName().toLowerCase() + "." + employee.getLastName().toLowerCase();
        String birthdate = tools.dateToString(employee.getBirthDate());
        String hireDate = tools.dateToString(employee.getHireDate());
        String[] bdate = birthdate.split("/");
        String[] hdate = hireDate.split("/");
        String password = employee.getEmployeeId() + bdate[1] + bdate[0] + bdate[2].substring(2, 4);
        birthdate = bdate[1] + "/" + bdate[0] + "/" + bdate[2];
        hireDate = hdate[1] + "/" + hdate[0] + "/" + hdate[2];
        employee.setUsername(username);
        employee.setPassword(password);
        CallableStatement callableStatement = 
                con.prepareCall("{call emp_data.saveEmployee(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        callableStatement.setString(1, employee.getLastName());
        callableStatement.setString(2, employee.getFirstName());
        callableStatement.setString(3, employee.getNik());
        callableStatement.setString(4, username);
        callableStatement.setString(5, password);
        callableStatement.setString(6, employee.getEmail());
        callableStatement.setBigDecimal(7, employee.getSalary());
        callableStatement.setString(8, employee.getPhone());
        callableStatement.setString(9, employee.getNpwp());
        callableStatement.setString(10, employee.getSkck());
        callableStatement.setString(11, employee.getDepartmentId().getDepartmentId());
        callableStatement.setString(12, employee.getJobId().getJobId());
        callableStatement.setLong(13, employee.getManagerId().getEmployeeId());
        callableStatement.setString(14, employee.getPhoto());
        callableStatement.setString(15, employee.getStatus()+"");
        callableStatement.setString(16,  birthdate);
        callableStatement.setString(17,  hireDate);
        callableStatement.setLong(18, employee.getRoleId().getRoleId());
        callableStatement.setString(19, employee.getBpjs());
        callableStatement.registerOutParameter(20, Types.INTEGER);
        callableStatement.execute();
        tools.sendMessage(employee, 1);
        return callableStatement.getInt(20);
    }
    
    @Override
    public int changePassword(String username, String password) throws SQLException{
        Connection con = sf.getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();
        String pass = BCrypt.hashpw(password, BCrypt.gensalt());
        CallableStatement callableStatement = con.prepareCall("{call emp_data.updateUserPass(?,?,?)}");
        callableStatement.setString(1, username);
        callableStatement.setString(2, pass);
        callableStatement.registerOutParameter(3, Types.INTEGER);
        callableStatement.execute();
        return callableStatement.getInt(3);
    }

    @Override
    public List<Employee> getByManagerId(Object object) {
        return (List<Employee>) gdao.execute(6, null, type, "managerId", object);
    }
}
