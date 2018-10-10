/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author 680183
 */
@Entity
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmployeeId", query = "SELECT e FROM Employees e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employees.findByNik", query = "SELECT e FROM Employees e WHERE e.nik = :nik")
    , @NamedQuery(name = "Employees.findByUsername", query = "SELECT e FROM Employees e WHERE e.username = :username")
    , @NamedQuery(name = "Employees.findByPassword", query = "SELECT e FROM Employees e WHERE e.password = :password")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")
    , @NamedQuery(name = "Employees.findBySalary", query = "SELECT e FROM Employees e WHERE e.salary = :salary")
    , @NamedQuery(name = "Employees.findByPhone", query = "SELECT e FROM Employees e WHERE e.phone = :phone")
    , @NamedQuery(name = "Employees.findByNpwp", query = "SELECT e FROM Employees e WHERE e.npwp = :npwp")
    , @NamedQuery(name = "Employees.findBySkck", query = "SELECT e FROM Employees e WHERE e.skck = :skck")
    , @NamedQuery(name = "Employees.findByPhoto", query = "SELECT e FROM Employees e WHERE e.photo = :photo")
    , @NamedQuery(name = "Employees.findByStatus", query = "SELECT e FROM Employees e WHERE e.status = :status")
    , @NamedQuery(name = "Employees.findByBirthDate", query = "SELECT e FROM Employees e WHERE e.birthDate = :birthDate")
    , @NamedQuery(name = "Employees.findByHireDate", query = "SELECT e FROM Employees e WHERE e.hireDate = :hireDate")
    , @NamedQuery(name = "Employees.findByBpjs", query = "SELECT e FROM Employees e WHERE e.bpjs = :bpjs")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private BigDecimal salary;
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
    private Departments departmentId;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Employees> employeesList;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employees managerId;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jobs jobId;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roles roleId;
    @JoinColumn(name = "SITE_ID", referencedColumnName = "SITE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sites siteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Departments> departmentsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<EmployeeTemp> employeeTempList;

    public Employees() {
    }

    public Employees(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Employees(Long employeeId, String lastName, String nik, String email, Character status, Date hireDate) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.nik = nik;
        this.email = email;
        this.status = status;
        this.hireDate = hireDate;
    }

    public Employees(Long aLong, String firstName, String lastName, String e_nik, String uname, String pass, String mail, BigDecimal bigDecimal, String e_phone, String e_npwp, String e_skck, Long aLong0, Long aLong1, String foto, String stat, Date date, Date date0, Long aLong2, String e_bpjs, BigDecimal bigDecimal0, Departments department, Employees manager, Jobs job, Sites site, Roles role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
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

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    @XmlTransient
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(Employees managerId) {
        this.managerId = managerId;
    }

    public Jobs getJobId() {
        return jobId;
    }

    public void setJobId(Jobs jobId) {
        this.jobId = jobId;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    public Sites getSiteId() {
        return siteId;
    }

    public void setSiteId(Sites siteId) {
        this.siteId = siteId;
    }

    @XmlTransient
    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
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
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Employees[ employeeId=" + employeeId + " ]";
    }
    
}
