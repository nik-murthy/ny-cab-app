package com.nycab.api.request.handlers;

import com.nycab.api.dto.CabTripDataResponse;
import com.nycab.api.entities.CabTripData;

import java.util.List;

public interface CabDataRequestHandlerIntf {

    List<CabTripDataResponse> getByMedallion(String medallion);
}
