/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 680183
 */
@Entity
@Table(name = "DEPARTMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d")
    , @NamedQuery(name = "Departments.findByDepartmentId", query = "SELECT d FROM Departments d WHERE d.departmentId = :departmentId")
    , @NamedQuery(name = "Departments.findByDepartmentName", query = "SELECT d FROM Departments d WHERE d.departmentName = :departmentName")})
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;
    @Basic(optional = false)
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @OneToMany(mappedBy = "departmentId", fetch = FetchType.LAZY)
    private List<Employees> employeesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId", fetch = FetchType.LAZY)
    private List<Sites> sitesList;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employees managerId;

    public Departments() {
    }

    public Departments(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Departments(Long departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @XmlTransient
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    @XmlTransient
    public List<Sites> getSitesList() {
        return sitesList;
    }

    public void setSitesList(List<Sites> sitesList) {
        this.sitesList = sitesList;
    }

    public Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(Employees managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Departments[ departmentId=" + departmentId + " ]";
    }
    
}