package com.nycab.commons.dto;

import java.util.Date;

public class CabTripDataResponse {
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

    public static CabTripDataResponse of(final String medallion,
                                         final String hackLicense,
                                         final Date pickupDatetime,
                                         final Double tripDistance,
                                         final String vendorId,
                                         final Integer rateCode,
                                         final String storeAndFwdFlag,
                                         final Date dropoffDatetime,
                                         final Integer passengerCount,
                                         final Integer tripTimeInSecs,
                                         final Double pickupLongitude,
                                         final Double pickupLatitude,
                                         final Double dropoffLongitude,
                                         final Double dropoffLatitude) {

        CabTripDataResponse cabTripDataResponse = new CabTripDataResponse();

        cabTripDataResponse.setMedallion(medallion);
        cabTripDataResponse.setHackLicense(hackLicense);
        cabTripDataResponse.setVendorId(vendorId);
        cabTripDataResponse.setRateCode(rateCode);
        cabTripDataResponse.setStoreAndFwdFlag(storeAndFwdFlag);
        cabTripDataResponse.setPickupDatetime(pickupDatetime);
        cabTripDataResponse.setDropoffDatetime(dropoffDatetime);
        cabTripDataResponse.setPassengerCount(passengerCount);
        cabTripDataResponse.setTripTimeInSecs(tripTimeInSecs);
        cabTripDataResponse.setTripDistance(tripDistance);
        cabTripDataResponse.setPickupLongitude(pickupLongitude);
        cabTripDataResponse.setPickupLatitude(pickupLatitude);
        cabTripDataResponse.setDropoffLongitude(dropoffLongitude);
        cabTripDataResponse.setDropoffLatitude(dropoffLatitude);

        return cabTripDataResponse;
    }
}
