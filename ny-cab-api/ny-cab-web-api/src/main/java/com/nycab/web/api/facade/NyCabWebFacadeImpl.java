package com.nycab.web.api.facade;

import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.web.api.request.handlers.DbRequestHandlerIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NyCabWebFacadeImpl implements NyCabWebFacadeIntf {

    @Autowired
    private DbRequestHandlerIntf dbRequestHandlerIntf;

    @Override
    public List<CabTripDataResponse> getByMedallion(String medallion) {
        return dbRequestHandlerIntf.getByMedallion(medallion);
    }
}
