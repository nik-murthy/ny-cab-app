package com.nycab.web.api.facade;

import com.nycab.commons.dto.CabTripDataResponse;

import java.util.Date;
import java.util.List;

public interface NyCabWebFacadeIntf {

    List<CabTripDataResponse> getByMedallionsAndDate(List<String> medallions, String date);
}
