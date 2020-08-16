package com.nycab.db.api.util;

import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.db.api.entities.CabTripData;
import org.springframework.stereotype.Component;

@Component
public class CabDataHelperImpl implements CabDataHelperIntf {
    @Override
    public CabTripDataResponse mapToResponseObj(CabTripData cabTripData) {
        return CabTripDataResponse.of(cabTripData.getMedallion(),
                cabTripData.getHackLicense(),
                cabTripData.getPickupDatetime(),
                cabTripData.getTripDistance(),
                cabTripData.getVendorId(),
                cabTripData.getRateCode(),
                cabTripData.getStoreAndFwdFlag(),
                cabTripData.getDropoffDatetime(),
                cabTripData.getPassengerCount(),
                cabTripData.getTripTimeInSecs(),
                cabTripData.getPickupLongitude(),
                cabTripData.getPickupLatitude(),
                cabTripData.getDropoffLongitude(),
                cabTripData.getDropoffLatitude());
    }
}
