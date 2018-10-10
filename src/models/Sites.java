/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "SITES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sites.findAll", query = "SELECT s FROM Sites s")
    , @NamedQuery(name = "Sites.findBySiteId", query = "SELECT s FROM Sites s WHERE s.siteId = :siteId")
    , @NamedQuery(name = "Sites.findBySiteName", query = "SELECT s FROM Sites s WHERE s.siteName = :siteName")
    , @NamedQuery(name = "Sites.findByAddress", query = "SELECT s FROM Sites s WHERE s.address = :address")})
public class Sites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SITE_ID")
    private Long siteId;
    @Basic(optional = false)
    @Column(name = "SITE_NAME")
    private String siteName;
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(mappedBy = "siteId", fetch = FetchType.LAZY)
    private List<Employees> employeesList;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departments departmentId;

    public Sites() {
    }

    public Sites(Long siteId) {
        this.siteId = siteId;
    }

    public Sites(Long siteId, String siteName) {
        this.siteId = siteId;
        this.siteName = siteName;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteId != null ? siteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sites)) {
            return false;
        }
        Sites other = (Sites) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Sites[ siteId=" + siteId + " ]";
    }
    
}
