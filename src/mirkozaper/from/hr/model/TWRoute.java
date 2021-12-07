/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mirkozaper.from.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mirko
 */
@Entity
@Table(name = "TWRoute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TWRoute.findAll", query = "SELECT t FROM TWRoute t")
    , @NamedQuery(name = "TWRoute.findByIDTWRoute", query = "SELECT t FROM TWRoute t WHERE t.iDTWRoute = :iDTWRoute")
    , @NamedQuery(name = "TWRoute.findByDuration", query = "SELECT t FROM TWRoute t WHERE t.duration = :duration")
    , @NamedQuery(name = "TWRoute.findByStartX", query = "SELECT t FROM TWRoute t WHERE t.startX = :startX")
    , @NamedQuery(name = "TWRoute.findByStartY", query = "SELECT t FROM TWRoute t WHERE t.startY = :startY")
    , @NamedQuery(name = "TWRoute.findByStopX", query = "SELECT t FROM TWRoute t WHERE t.stopX = :stopX")
    , @NamedQuery(name = "TWRoute.findByStopY", query = "SELECT t FROM TWRoute t WHERE t.stopY = :stopY")
    , @NamedQuery(name = "TWRoute.findByMileage", query = "SELECT t FROM TWRoute t WHERE t.mileage = :mileage")
    , @NamedQuery(name = "TWRoute.findByAverageSpeed", query = "SELECT t FROM TWRoute t WHERE t.averageSpeed = :averageSpeed")
    , @NamedQuery(name = "TWRoute.findByFuelConsumption", query = "SELECT t FROM TWRoute t WHERE t.fuelConsumption = :fuelConsumption")})
public class TWRoute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTWRoute")
    private Integer iDTWRoute;
    @Column(name = "Duration")
    private Integer duration;
    @Column(name = "StartX")
    private Integer startX;
    @Column(name = "StartY")
    private Integer startY;
    @Column(name = "StopX")
    private Integer stopX;
    @Column(name = "StopY")
    private Integer stopY;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Mileage")
    private Double mileage;
    @Column(name = "AverageSpeed")
    private Integer averageSpeed;
    @Column(name = "FuelConsumption")
    private Integer fuelConsumption;
    @JoinColumn(name = "TravelWarrantID", referencedColumnName = "IDTravelWarrant")
    @ManyToOne
    private TravelWarrant travelWarrantID;

    public TWRoute() {
    }

    public TWRoute(Integer iDTWRoute) {
        this.iDTWRoute = iDTWRoute;
    }

    public Integer getIDTWRoute() {
        return iDTWRoute;
    }

    public void setIDTWRoute(Integer iDTWRoute) {
        this.iDTWRoute = iDTWRoute;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getStartX() {
        return startX;
    }

    public void setStartX(Integer startX) {
        this.startX = startX;
    }

    public Integer getStartY() {
        return startY;
    }

    public void setStartY(Integer startY) {
        this.startY = startY;
    }

    public Integer getStopX() {
        return stopX;
    }

    public void setStopX(Integer stopX) {
        this.stopX = stopX;
    }

    public Integer getStopY() {
        return stopY;
    }

    public void setStopY(Integer stopY) {
        this.stopY = stopY;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Integer getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Integer averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Integer getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Integer fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public TravelWarrant getTravelWarrantID() {
        return travelWarrantID;
    }

    public void setTravelWarrantID(TravelWarrant travelWarrantID) {
        this.travelWarrantID = travelWarrantID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTWRoute != null ? iDTWRoute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TWRoute)) {
            return false;
        }
        TWRoute other = (TWRoute) object;
        if ((this.iDTWRoute == null && other.iDTWRoute != null) || (this.iDTWRoute != null && !this.iDTWRoute.equals(other.iDTWRoute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mirkozaper.from.hr.model.TWRoute[ iDTWRoute=" + iDTWRoute + " ]";
    }
    
}
