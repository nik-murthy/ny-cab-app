package com.nycab.web.api.facade;

import com.nycab.commons.dto.CabTripDataResponse;

import java.util.List;

public interface NyCabWebFacadeIntf {

    List<CabTripDataResponse> getByMedallion(String medallion);
}
