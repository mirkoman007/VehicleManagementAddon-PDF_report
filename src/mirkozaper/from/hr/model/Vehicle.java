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
@Table(name = "Vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findByIDVehicle", query = "SELECT v FROM Vehicle v WHERE v.iDVehicle = :iDVehicle")
    , @NamedQuery(name = "Vehicle.findByMake", query = "SELECT v FROM Vehicle v WHERE v.make = :make")
    , @NamedQuery(name = "Vehicle.findByVehicleType", query = "SELECT v FROM Vehicle v WHERE v.vehicleType = :vehicleType")
    , @NamedQuery(name = "Vehicle.findByFirstRegistration", query = "SELECT v FROM Vehicle v WHERE v.firstRegistration = :firstRegistration")
    , @NamedQuery(name = "Vehicle.findByMileage", query = "SELECT v FROM Vehicle v WHERE v.mileage = :mileage")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDVehicle")
    private Integer iDVehicle;
    @Column(name = "Make")
    private String make;
    @Column(name = "VehicleType")
    private String vehicleType;
    @Column(name = "FirstRegistration")
    private Integer firstRegistration;
    @Column(name = "Mileage")
    private Integer mileage;
    @OneToMany(mappedBy = "vehicleID")
    private List<TravelWarrant> travelWarrantList;

    public Vehicle() {
    }

    public Vehicle(Integer iDVehicle) {
        this.iDVehicle = iDVehicle;
    }

    public Integer getIDVehicle() {
        return iDVehicle;
    }

    public void setIDVehicle(Integer iDVehicle) {
        this.iDVehicle = iDVehicle;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(Integer firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
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
        hash += (iDVehicle != null ? iDVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.iDVehicle == null && other.iDVehicle != null) || (this.iDVehicle != null && !this.iDVehicle.equals(other.iDVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mirkozaper.from.hr.model.Vehicle[ iDVehicle=" + iDVehicle + " ]";
    }
    
}
