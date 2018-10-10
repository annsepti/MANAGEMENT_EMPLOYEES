/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nande
 */
@Entity
@Table(name = "EMPLOYEE_TEMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeTemp.findAll", query = "SELECT e FROM EmployeeTemp e")
    , @NamedQuery(name = "EmployeeTemp.findByTempId", query = "SELECT e FROM EmployeeTemp e WHERE e.tempId = :tempId")
    , @NamedQuery(name = "EmployeeTemp.findByEmail", query = "SELECT e FROM EmployeeTemp e WHERE e.email = :email")
    , @NamedQuery(name = "EmployeeTemp.findByPassword", query = "SELECT e FROM EmployeeTemp e WHERE e.password = :password")
    , @NamedQuery(name = "EmployeeTemp.findByPhone", query = "SELECT e FROM EmployeeTemp e WHERE e.phone = :phone")
    , @NamedQuery(name = "EmployeeTemp.findByNpwp", query = "SELECT e FROM EmployeeTemp e WHERE e.npwp = :npwp")
    , @NamedQuery(name = "EmployeeTemp.findBySkck", query = "SELECT e FROM EmployeeTemp e WHERE e.skck = :skck")
    , @NamedQuery(name = "EmployeeTemp.findByPhoto", query = "SELECT e FROM EmployeeTemp e WHERE e.photo = :photo")
    , @NamedQuery(name = "EmployeeTemp.findByBpjs", query = "SELECT e FROM EmployeeTemp e WHERE e.bpjs = :bpjs")})
public class EmployeeTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TEMP_ID")
    private BigDecimal tempId;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "NPWP")
    private String npwp;
    @Column(name = "SKCK")
    private String skck;
    @Column(name = "PHOTO")
    private String photo;
    @Column(name = "BPJS")
    private String bpjs;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeId;

    public EmployeeTemp() {
    }

    public EmployeeTemp(BigDecimal tempId) {
        this.tempId = tempId;
    }

    public BigDecimal getTempId() {
        return tempId;
    }

    public void setTempId(BigDecimal tempId) {
        this.tempId = tempId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getBpjs() {
        return bpjs;
    }

    public void setBpjs(String bpjs) {
        this.bpjs = bpjs;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tempId != null ? tempId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeTemp)) {
            return false;
        }
        EmployeeTemp other = (EmployeeTemp) object;
        if ((this.tempId == null && other.tempId != null) || (this.tempId != null && !this.tempId.equals(other.tempId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.EmployeeTemp[ tempId=" + tempId + " ]";
    }
    
}
