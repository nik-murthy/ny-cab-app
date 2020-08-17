package com.nycab.redis.api.controller;

import com.nycab.commons.constants.ApplicationConstants;
import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.redis.api.client.NyCabCacheIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NYCabRedisController {

    @Autowired
    private NyCabCacheIntf nyCabCacheIntf;

    @GetMapping(value = ApplicationConstants.CACHE_GET_BY_MEDALLIONS_AND_DATE)
    public List<CabTripDataResponse> getByMedallionAndDate(@RequestParam("medallions") String medallions,
                                                           @RequestParam("date") String date) {
        return nyCabCacheIntf.getByMedallionAndDate(medallions, date);
    }

    @PostMapping(value = ApplicationConstants.CACHE_FLUSH_CACHE)
    public Boolean clearCache() {
        return nyCabCacheIntf.clearCache();
    }
}
