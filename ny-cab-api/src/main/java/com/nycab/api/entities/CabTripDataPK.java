package com.nycab.api.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Embeddable
public class CabTripDataPK implements Serializable {

    @NotNull
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

    public CabTripDataPK(@NotNull String medallion,
                         @NotNull String hackLicense,
                         @NotNull Date pickupDatetime,
                         @NotNull Double tripDistance) {

        this.medallion = medallion;
        this.hackLicense = hackLicense;
        this.pickupDatetime = pickupDatetime;
        this.tripDistance = tripDistance;
    }

    public CabTripDataPK() {
    }

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
}
