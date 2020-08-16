package com.nycab.web.api.request.handlers;

import com.nycab.commons.dto.CabTripDataResponse;

import java.util.Date;
import java.util.List;

public interface DbRequestHandlerIntf {

    List<CabTripDataResponse> getByMedallionsAndDate(List<String> medallions, String date);
}
