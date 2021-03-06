package com.nycab.db.api.request.handlers;

import com.nycab.commons.dto.CabTripDataResponse;

import java.util.Date;
import java.util.List;

public interface CabDataRequestHandlerIntf {

    List<CabTripDataResponse> getByMedallionsAndDate(List<String> medallions, Date date);

    //List<CabTripDataResponse> getByMedallionAndDate(String medallion, Date date);
}
