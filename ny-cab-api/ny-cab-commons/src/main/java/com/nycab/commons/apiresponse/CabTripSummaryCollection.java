package com.nycab.commons.apiresponse;

import java.util.List;

public class CabTripSummaryCollection {

    private List<CabTripSummary> cabTripSummaries;

    public List<CabTripSummary> getCabTripSummaries() {
        return cabTripSummaries;
    }

    private void setCabTripSummaries(List<CabTripSummary> cabTripSummaries) {
        this.cabTripSummaries = cabTripSummaries;
    }

    public static CabTripSummaryCollection of(List<CabTripSummary> cabTripSummaries) {
        CabTripSummaryCollection cabTripSummaryCollection = new CabTripSummaryCollection();
        cabTripSummaryCollection.setCabTripSummaries(cabTripSummaries);
        return cabTripSummaryCollection;
    }

    private CabTripSummaryCollection() {

    }
}
