package com.nycab.api.dto;

import com.nycab.api.entities.CabTripData;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class CabTripDataResponse implements Serializable {

    private String medallion;

    private String hackLicense;

    private Date pickupDatetime;

    private Double tripDistance;

    private String vendorId;

    private Integer rateCode;

    private String storeAndFwdFlag;

    private Date dropoffDatetime;

    private Integer passengerCount;

    private Integer tripTimeInSecs;

    private Double pickupLongitude;

    private Double pickupLatitude;

    private Double dropoffLongitude;

    private Double dropoffLatitude;

    public static CabTripDataResponse mapToResponseEntity(CabTripData cabTripData) {
        CabTripDataResponse cabTripDataResponse = new CabTripDataResponse();

        cabTripDataResponse.setMedallion(cabTripData.getMedallion());
        cabTripDataResponse.setHackLicense(cabTripData.getHackLicense());
        cabTripDataResponse.setVendorId(cabTripData.getVendorId());
        cabTripDataResponse.setRateCode(cabTripData.getRateCode());
        cabTripDataResponse.setStoreAndFwdFlag(cabTripData.getStoreAndFwdFlag());
        cabTripDataResponse.setPickupDatetime(cabTripData.getPickupDatetime());
        cabTripDataResponse.setDropoffDatetime(cabTripData.getDropoffDatetime());
        cabTripDataResponse.setPassengerCount(cabTripData.getPassengerCount());
        cabTripDataResponse.setTripTimeInSecs(cabTripData.getTripTimeInSecs());
        cabTripDataResponse.setTripDistance(cabTripData.getTripDistance());
        cabTripDataResponse.setPickupLongitude(cabTripData.getPickupLongitude());
        cabTripDataResponse.setPickupLatitude(cabTripData.getPickupLatitude());
        cabTripDataResponse.setDropoffLongitude(cabTripData.getDropoffLongitude());
        cabTripDataResponse.setDropoffLatitude(cabTripData.getDropoffLatitude());

        return cabTripDataResponse;
    }

    private CabTripDataResponse() {
    }

    public String getMedallion() {
        return medallion;
    }

    private void setMedallion(String medallion) {
        this.medallion = medallion;
    }

    public String getHackLicense() {
        return hackLicense;
    }

    private void setHackLicense(String hackLicense) {
        this.hackLicense = hackLicense;
    }

    public Date getPickupDatetime() {
        return pickupDatetime;
    }

    private void setPickupDatetime(Date pickupDatetime) {
        this.pickupDatetime = pickupDatetime;
    }

    public Double getTripDistance() {
        return tripDistance;
    }

    private void setTripDistance(Double tripDistance) {
        this.tripDistance = tripDistance;
    }

    public String getVendorId() {
        return vendorId;
    }

    private void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getRateCode() {
        return rateCode;
    }

    private void setRateCode(Integer rateCode) {
        this.rateCode = rateCode;
    }

    public String getStoreAndFwdFlag() {
        return storeAndFwdFlag;
    }

    private void setStoreAndFwdFlag(String storeAndFwdFlag) {
        this.storeAndFwdFlag = storeAndFwdFlag;
    }

    public Date getDropoffDatetime() {
        return dropoffDatetime;
    }

    private void setDropoffDatetime(Date dropoffDatetime) {
        this.dropoffDatetime = dropoffDatetime;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    private void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Integer getTripTimeInSecs() {
        return tripTimeInSecs;
    }

    private void setTripTimeInSecs(Integer tripTimeInSecs) {
        this.tripTimeInSecs = tripTimeInSecs;
    }

    public Double getPickupLongitude() {
        return pickupLongitude;
    }

    private void setPickupLongitude(Double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public Double getPickupLatitude() {
        return pickupLatitude;
    }

    private void setPickupLatitude(Double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public Double getDropoffLongitude() {
        return dropoffLongitude;
    }

    private void setDropoffLongitude(Double dropoffLongitude) {
        this.dropoffLongitude = dropoffLongitude;
    }

    public Double getDropoffLatitude() {
        return dropoffLatitude;
    }

    private void setDropoffLatitude(Double dropoffLatitude) {
        this.dropoffLatitude = dropoffLatitude;
    }
}
