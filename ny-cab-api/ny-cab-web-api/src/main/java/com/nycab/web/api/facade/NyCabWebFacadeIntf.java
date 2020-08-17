package com.nycab.web.api.facade;

import com.nycab.commons.apiresponse.CabTripSummaryCollection;

import java.util.List;

public interface NyCabWebFacadeIntf {

    CabTripSummaryCollection getCabTripsSummaryFromDb(List<String> medallions, String date);
    CabTripSummaryCollection getCabTripsSummary(List<String> medallions, String date);
    Boolean flushCache();
}
