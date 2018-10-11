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
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
    , @NamedQuery(name = "Site.findBySiteId", query = "SELECT s FROM Site s WHERE s.siteId = :siteId")
    , @NamedQuery(name = "Site.findBySiteName", query = "SELECT s FROM Site s WHERE s.siteName = :siteName")
    , @NamedQuery(name = "Site.findByAddress", query = "SELECT s FROM Site s WHERE s.address = :address")})
public class Site implements Serializable {

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
    private List<Employee> employeeList;
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department departmentId;

    public Site() {
    }

    public Site(Long siteId) {
        this.siteId = siteId;
    }

    public Site(Long siteId, String siteName) {
        this.siteId = siteId;
        this.siteName = siteName;
    }
    public Site(Long siteId, String siteName, String address, Department idDept) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.address = address;
        this.departmentId = idDept;
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
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
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
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Site[ siteId=" + siteId + " ]";
    }
    
}
