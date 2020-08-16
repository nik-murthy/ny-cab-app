package com.nycab.web.api.request.handlers;

import com.nycab.commons.constants.ApplicationConstants;
import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.commons.request.UriRequest;
import com.nycab.commons.util.UriHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DbRequestHandlerImpl implements DbRequestHandlerIntf {

    @Autowired
    private UriHelper uriHelper;

    @Value("${db.api.url}")
    private String dbApiUrl;

    @Override
    public List<CabTripDataResponse> getByMedallionsAndDate(List<String> medallions, String date) {

        Map<String, Object> params = new HashMap<>();
        params.put("medallions", medallions);
        params.put("date", date);

        CabTripDataResponse[] trips = (CabTripDataResponse[]) uriHelper.getFromUri(
                UriRequest.of(dbApiUrl,
                ApplicationConstants.DB_GET_BY_MEDALLIONS_AND_DATE,
                CabTripDataResponse[].class,
                HttpMethod.GET,
                Optional.of(params))).getBody();

        return Arrays.asList(trips);

    }
}
