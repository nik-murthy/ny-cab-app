package com.nycab.api.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cab_trip_data")
@XmlRootElement
public class CabTripData implements Serializable {

//    @EmbeddedId
//    private CabTripDataPK cabTripDataPK;

    @NotNull
    @Id
    @Column(name = "medallion")
    private String medallion;

    @NotNull
    @Column(name = "hack_license")
    private String hackLicense;

    @NotNull
    @Column(name = "pickup_datetime")
    private Date pickupDatetime;

    @NotNull
    @Column(name = "trip_distance")
    private Double tripDistance;

    @Column(name = "vendor_id")
    private String vendorId;

    @Column(name = "rate_code")
    private Integer rateCode;

    @Column(name = "store_and_fwd_flag")
    private String storeAndFwdFlag;

    @Column(name = "dropoff_datetime")
    private Date dropoffDatetime;

    @Column(name = "passenger_count")
    private Integer passengerCount;

    @Column(name = "trip_time_in_secs")
    private Integer tripTimeInSecs;

    @Column(name = "pickup_longitude")
    private Double pickupLongitude;

    @Column(name = "pickup_latitude")
    private Double pickupLatitude;

    @Column(name = "dropoff_longitude")
    private Double dropoffLongitude;

    @Column(name = "dropoff_latitude")
    private Double dropoffLatitude;

//    public CabTripDataPK getCabTripDataPK() {
//        return cabTripDataPK;
//    }
//
//    public void setCabTripDataPK(CabTripDataPK cabTripDataPK) {
//        this.cabTripDataPK = cabTripDataPK;
//    }

    public String getMedallion() {
        return medallion;
    }

    public void setMedallion(String medallion) {
        this.medallion = medallion;
    }

    public String getHackLicense() {
        return hackLicense;
    }

    public void setHackLicense(String hackLicense) {
        this.hackLicense = hackLicense;
    }

    public Date getPickupDatetime() {
        return pickupDatetime;
    }

    public void setPickupDatetime(Date pickupDatetime) {
        this.pickupDatetime = pickupDatetime;
    }

    public Double getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(Double tripDistance) {
        this.tripDistance = tripDistance;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getRateCode() {
        return rateCode;
    }

    public void setRateCode(Integer rateCode) {
        this.rateCode = rateCode;
    }

    public String getStoreAndFwdFlag() {
        return storeAndFwdFlag;
    }

    public void setStoreAndFwdFlag(String storeAndFwdFlag) {
        this.storeAndFwdFlag = storeAndFwdFlag;
    }

    public Date getDropoffDatetime() {
        return dropoffDatetime;
    }

    public void setDropoffDatetime(Date dropoffDatetime) {
        this.dropoffDatetime = dropoffDatetime;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Integer getTripTimeInSecs() {
        return tripTimeInSecs;
    }

    public void setTripTimeInSecs(Integer tripTimeInSecs) {
        this.tripTimeInSecs = tripTimeInSecs;
    }

    public Double getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(Double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public Double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(Double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public Double getDropoffLongitude() {
        return dropoffLongitude;
    }

    public void setDropoffLongitude(Double dropoffLongitude) {
        this.dropoffLongitude = dropoffLongitude;
    }

    public Double getDropoffLatitude() {
        return dropoffLatitude;
    }

    public void setDropoffLatitude(Double dropoffLatitude) {
        this.dropoffLatitude = dropoffLatitude;
    }
}
