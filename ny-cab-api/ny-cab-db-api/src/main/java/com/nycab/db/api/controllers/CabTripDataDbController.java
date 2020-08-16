package com.nycab.db.api.controllers;

import com.nycab.commons.constants.ApplicationConstants;
import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.db.api.request.handlers.CabDataRequestHandlerIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CabTripDataDbController {

    @Autowired
    private CabDataRequestHandlerIntf cabDataRequestHandlerIntf;

    @GetMapping(value = ApplicationConstants.DB_GET_BY_MEDALLION)
    public ResponseEntity<List<CabTripDataResponse>> getByMedallion(@RequestParam String medallion) {
        return ResponseEntity.ok(cabDataRequestHandlerIntf.getByMedallion(medallion));
    }

    @RequestMapping(value = ApplicationConstants.WEB_GET_BY_MEDALLION_AND_DATE)
    public ResponseEntity<List<CabTripDataResponse>> getByMedallionAndDate(@PathVariable String medallion,
                                                                           @PathVariable
                                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                   Date date) {
        System.out.println("medallion = " + medallion);
        System.out.println("date = " + date);
        return ResponseEntity.ok(cabDataRequestHandlerIntf.getByMedallionAndDate(medallion, date));
    }
}
