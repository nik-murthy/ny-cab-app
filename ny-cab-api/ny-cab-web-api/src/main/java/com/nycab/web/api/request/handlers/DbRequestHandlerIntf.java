package com.nycab.web.api.request.handlers;

import com.nycab.commons.dto.CabTripDataResponse;

import java.util.List;

public interface DbRequestHandlerIntf {

    List<CabTripDataResponse> getByMedallion(String medallion);
}
