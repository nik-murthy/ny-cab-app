package com.nycab.web.api.request.handlers;

import com.nycab.commons.dto.CabTripDataResponse;

import java.util.List;

public interface CacheRequestHandlerIntf {

    List<CabTripDataResponse> getByMedallionsAndDate(List<String> medallions, String date);

}
