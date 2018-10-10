/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nande
 */
@Entity
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee.findByNik", query = "SELECT e FROM Employee e WHERE e.nik = :nik")
    , @NamedQuery(name = "Employee.findByUsername", query = "SELECT e FROM Employee e WHERE e.username = :username")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary")
    , @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone")
    , @NamedQuery(name = "Employee.findByNpwp", query = "SELECT e FROM Employee e WHERE e.npwp = :npwp")
    , @NamedQuery(name = "Employee.findBySkck", query = "SELECT e FROM Employee e WHERE e.skck = :skck")
    , @NamedQuery(name = "Employee.findByPhoto", query = "SELECT e FROM Employee e WHERE e.photo = :photo")
    , @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status")
    , @NamedQuery(name = "Employee.findByBirthDate", query = "SELECT e FROM Employee e WHERE e.birthDate = :birthDate")
    , @NamedQuery(name = "Employee.findByHireDate", query = "SELECT e FROM Employee e WHERE e.hireDate = :hireDate")
    , @NamedQuery(name = "Employee.findByBpjs", query = "SELECT e FROM Employee e WHERE e.bpjs = :bpjs")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private BigDecimal employeeId;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "NIK")
    private String nik;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SALARY")
    private BigInteger salary;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "NPWP")
    private String npwp;
    @Column(name = "SKCK")
    private String skck;
    @Column(name = "PHOTO")
    private String photo;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    @Column(name = "BPJS")
    private String bpjs;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department departmentId;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee managerId;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Job jobId;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role roleId;
    @JoinColumn(name = "SITE_ID", referencedColumnName = "SITE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Site siteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Department> departmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<EmployeeTemp> employeeTempList;

    public Employee() {
    }

    public Employee(BigDecimal employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(BigDecimal employeeId, String lastName, String nik, String email, Character status, Date hireDate) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.nik = nik;
        this.email = email;
        this.status = status;
        this.hireDate = hireDate;
    }

    public Employee(BigDecimal employeeId, String lastName, String firstName
            , String nik, String username, String password, String email
            , BigInteger salary, String phone, String npwp, String skck
            , String photo, Character status, Date birthDate, Date hireDate
            , String bpjs, Department departmentId, Employee managerId, Job jobId
            , Role roleId, Site siteId) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.nik = nik;
        this.username = username;
        this.password = password;
        this.email = email;
        this.salary = salary;
        this.phone = phone;
        this.npwp = npwp;
        this.skck = skck;
        this.photo = photo;
        this.status = status;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.bpjs = bpjs;
        this.departmentId = departmentId;
        this.managerId = managerId;
        this.jobId = jobId;
        this.roleId = roleId;
        this.siteId = siteId;
    }

    public BigDecimal getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(BigDecimal employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getSkck() {
        return skck;
    }

    public void setSkck(String skck) {
        this.skck = skck;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getBpjs() {
        return bpjs;
    }

    public void setBpjs(String bpjs) {
        this.bpjs = bpjs;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getManagerId() {
        return managerId;
    }

    public void setManagerId(Employee managerId) {
        this.managerId = managerId;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Site getSiteId() {
        return siteId;
    }

    public void setSiteId(Site siteId) {
        this.siteId = siteId;
    }

    @XmlTransient
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @XmlTransient
    public List<EmployeeTemp> getEmployeeTempList() {
        return employeeTempList;
    }

    public void setEmployeeTempList(List<EmployeeTemp> employeeTempList) {
        this.employeeTempList = employeeTempList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Employee[ employeeId=" + employeeId + " ]";
    }
    
}
