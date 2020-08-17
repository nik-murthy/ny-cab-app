package com.nycab.web.api.facade;

import com.nycab.commons.apiresponse.CabTripSummary;
import com.nycab.commons.apiresponse.CabTripSummaryCollection;
import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.web.api.request.handlers.CacheRequestHandlerIntf;
import com.nycab.web.api.request.handlers.DbRequestHandlerIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class NyCabWebFacadeImpl implements NyCabWebFacadeIntf {

    @Autowired
    private DbRequestHandlerIntf dbRequestHandlerIntf;

    @Autowired
    private CacheRequestHandlerIntf cacheRequestHandlerIntf;

    @Override
    public CabTripSummaryCollection getCabTripsSummaryFromDb(List<String> medallions, String date) {
        return createResponseObj(dbRequestHandlerIntf.getByMedallionsAndDate(medallions, date));
    }

    @Override
    public CabTripSummaryCollection getCabTripsSummary(List<String> medallions, String date) {
        return createResponseObj(cacheRequestHandlerIntf.getByMedallionsAndDate(medallions, date));
    }

    private CabTripSummaryCollection createResponseObj(List<CabTripDataResponse> cabTripDataResponses) {
        Map<String, List<CabTripDataResponse>> cabTripMap = cabTripDataResponses.stream()
                .collect(Collectors.groupingBy(CabTripDataResponse::getMedallion));

        List<CabTripSummary> cabTripSummaries = new ArrayList<>();
        for(String medallion : cabTripMap.keySet()) {
            cabTripSummaries.add(CabTripSummary.of(medallion,
                    cabTripMap.get(medallion).size(),
                    cabTripMap.get(medallion)));
        }
        return CabTripSummaryCollection.of(cabTripSummaries);
    }
}
