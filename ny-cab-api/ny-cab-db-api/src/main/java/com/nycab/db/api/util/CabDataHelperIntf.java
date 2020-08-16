package com.nycab.db.api.util;

import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.db.api.entities.CabTripData;

import java.util.List;

public interface CabDataHelperIntf {

    CabTripDataResponse mapToResponseObj(CabTripData cabTripData);
}
