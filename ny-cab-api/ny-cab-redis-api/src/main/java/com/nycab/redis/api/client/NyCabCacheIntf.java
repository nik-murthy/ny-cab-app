package com.nycab.redis.api.client;

import com.nycab.commons.dto.CabTripDataResponse;

import java.util.List;

public interface NyCabCacheIntf {

    List<CabTripDataResponse> getByMedallionAndDate(String medallions, String date);
    boolean clearCache();
}
