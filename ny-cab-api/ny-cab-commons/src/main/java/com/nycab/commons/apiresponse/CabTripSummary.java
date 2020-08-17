package com.nycab.commons.apiresponse;

import com.nycab.commons.dto.CabTripDataResponse;

import java.util.List;

public class CabTripSummary {

    private String medallion;
    private Integer totalTrips;
    private List<CabTripDataResponse> cabTripDetails;

    public String getMedallion() {
        return medallion;
    }

    private void setMedallion(String medallion) {
        this.medallion = medallion;
    }

    public Integer getTotalTrips() {
        return totalTrips;
    }

    private void setTotalTrips(Integer totalTrips) {
        this.totalTrips = totalTrips;
    }

    public List<CabTripDataResponse> getCabTripDetails() {
        return cabTripDetails;
    }

    private void setCabTripDetails(List<CabTripDataResponse> cabTripDetails) {
        this.cabTripDetails = cabTripDetails;
    }

    private CabTripSummary() {

    }

    public static CabTripSummary of(String medallion, Integer totalTrips, List<CabTripDataResponse> cabTrips) {
        CabTripSummary cabTripSummary = new CabTripSummary();
        cabTripSummary.setMedallion(medallion);
        cabTripSummary.setTotalTrips(totalTrips);
        cabTripSummary.setCabTripDetails(cabTrips);
        return cabTripSummary;
    }
}
