package com.nycab.api.controllers;

import com.nycab.api.Constants.ApplicationConstants;
import com.nycab.api.dto.CabTripDataResponse;
import com.nycab.api.request.handlers.CabDataRequestHandlerIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CabTripDataController {

    @Autowired
    private CabDataRequestHandlerIntf cabDataRequestHandlerIntf;

    @RequestMapping(value = ApplicationConstants.GET_BY_MEDALLION_MAPPING)
    public ResponseEntity<List<CabTripDataResponse>> getByMedallion(@PathVariable String medallion) {
        return ResponseEntity.ok(cabDataRequestHandlerIntf.getByMedallion(medallion));
    }
}
