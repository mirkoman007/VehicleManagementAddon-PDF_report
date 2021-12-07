/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirkozaper.from.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mirko
 */
@Entity
@Table(name = "Driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d")
    , @NamedQuery(name = "Driver.findByIDDriver", query = "SELECT d FROM Driver d WHERE d.iDDriver = :iDDriver")
    , @NamedQuery(name = "Driver.findByFirstName", query = "SELECT d FROM Driver d WHERE d.firstName = :firstName")
    , @NamedQuery(name = "Driver.findByLastName", query = "SELECT d FROM Driver d WHERE d.lastName = :lastName")
    , @NamedQuery(name = "Driver.findByMobileNumber", query = "SELECT d FROM Driver d WHERE d.mobileNumber = :mobileNumber")
    , @NamedQuery(name = "Driver.findByDriverLicenseNumber", query = "SELECT d FROM Driver d WHERE d.driverLicenseNumber = :driverLicenseNumber")})
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDDriver")
    private Integer iDDriver;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "MobileNumber")
    private String mobileNumber;
    @Column(name = "DriverLicenseNumber")
    private String driverLicenseNumber;
    @OneToMany(mappedBy = "driverID")
    private List<TravelWarrant> travelWarrantList;

    public Driver() {
    }

    public Driver(Integer iDDriver) {
        this.iDDriver = iDDriver;
    }

    public Integer getIDDriver() {
        return iDDriver;
    }

    public void setIDDriver(Integer iDDriver) {
        this.iDDriver = iDDriver;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    @XmlTransient
    public List<TravelWarrant> getTravelWarrantList() {
        return travelWarrantList;
    }

    public void setTravelWarrantList(List<TravelWarrant> travelWarrantList) {
        this.travelWarrantList = travelWarrantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDriver != null ? iDDriver.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.iDDriver == null && other.iDDriver != null) || (this.iDDriver != null && !this.iDDriver.equals(other.iDDriver))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mirkozaper.from.hr.model.Driver[ iDDriver=" + iDDriver + " ]";
    }
    
}
