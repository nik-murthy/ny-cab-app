package com.nycab.web.api.facade;

import com.nycab.commons.apiresponse.CabTripSummaryCollection;
import com.nycab.commons.dto.CabTripDataResponse;

import java.util.Date;
import java.util.List;

public interface NyCabWebFacadeIntf {

    CabTripSummaryCollection getCabTripsSummaryFromDb(List<String> medallions, String date);
    CabTripSummaryCollection getCabTripsSummary(List<String> medallions, String date);
}
