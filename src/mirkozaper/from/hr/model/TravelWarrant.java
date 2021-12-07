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
 * @author mirko
 */
@Entity
@Table(name = "TravelWarrant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TravelWarrant.findAll", query = "SELECT t FROM TravelWarrant t")
    , @NamedQuery(name = "TravelWarrant.findByIDTravelWarrant", query = "SELECT t FROM TravelWarrant t WHERE t.iDTravelWarrant = :iDTravelWarrant")
    , @NamedQuery(name = "TravelWarrant.findByWarrantStatus", query = "SELECT t FROM TravelWarrant t WHERE t.warrantStatus = :warrantStatus")})
public class TravelWarrant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTravelWarrant")
    private Integer iDTravelWarrant;
    @Column(name = "WarrantStatus")
    private String warrantStatus;
    @JoinColumn(name = "DriverID", referencedColumnName = "IDDriver")
    @ManyToOne
    private Driver driverID;
    @JoinColumn(name = "VehicleID", referencedColumnName = "IDVehicle")
    @ManyToOne
    private Vehicle vehicleID;
    @OneToMany(mappedBy = "travelWarrantID")
    private List<TWRoute> tWRouteList;

    public TravelWarrant() {
    }

    public TravelWarrant(Integer iDTravelWarrant) {
        this.iDTravelWarrant = iDTravelWarrant;
    }

    public Integer getIDTravelWarrant() {
        return iDTravelWarrant;
    }

    public void setIDTravelWarrant(Integer iDTravelWarrant) {
        this.iDTravelWarrant = iDTravelWarrant;
    }

    public String getWarrantStatus() {
        return warrantStatus;
    }

    public void setWarrantStatus(String warrantStatus) {
        this.warrantStatus = warrantStatus;
    }

    public Driver getDriverID() {
        return driverID;
    }

    public void setDriverID(Driver driverID) {
        this.driverID = driverID;
    }

    public Vehicle getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Vehicle vehicleID) {
        this.vehicleID = vehicleID;
    }

    @XmlTransient
    public List<TWRoute> getTWRouteList() {
        return tWRouteList;
    }

    public void setTWRouteList(List<TWRoute> tWRouteList) {
        this.tWRouteList = tWRouteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTravelWarrant != null ? iDTravelWarrant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TravelWarrant)) {
            return false;
        }
        TravelWarrant other = (TravelWarrant) object;
        if ((this.iDTravelWarrant == null && other.iDTravelWarrant != null) || (this.iDTravelWarrant != null && !this.iDTravelWarrant.equals(other.iDTravelWarrant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mirkozaper.from.hr.model.TravelWarrant[ iDTravelWarrant=" + iDTravelWarrant + " ]";
    }
    
}
