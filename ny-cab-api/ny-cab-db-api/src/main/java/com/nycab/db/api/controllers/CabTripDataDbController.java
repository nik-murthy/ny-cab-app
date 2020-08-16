package com.nycab.db.api.controllers;

import com.nycab.commons.constants.ApplicationConstants;
import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.db.api.request.handlers.CabDataRequestHandlerIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController 
public class CabTripDataDbController {

    @Autowired
    private CabDataRequestHandlerIntf cabDataRequestHandlerIntf;

    @RequestMapping(value = ApplicationConstants.GET_BY_MEDALLION_MAPPING)
    public ResponseEntity<List<CabTripDataResponse>> getByMedallion(@PathVariable String medallion) {
        return ResponseEntity.ok(cabDataRequestHandlerIntf.getByMedallion(medallion));
    }

    @RequestMapping(value = ApplicationConstants.GET_BY_MEDALLION_AND_DATE_MAPPING)
    public ResponseEntity<List<CabTripDataResponse>> getByMedallionAndDate(@PathVariable String medallion,
                                                                           @PathVariable
                                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                   Date date) {
        System.out.println("medallion = " + medallion);
        System.out.println("date = " + date);
        return ResponseEntity.ok(cabDataRequestHandlerIntf.getByMedallionAndDate(medallion, date));
    }
}
