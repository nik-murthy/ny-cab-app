package com.nycab.web.api.controllers;

import com.nycab.commons.constants.ApplicationConstants;
import com.nycab.web.api.facade.NyCabWebFacadeIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class NyCabWebController {

    @Autowired
    private NyCabWebFacadeIntf nyCabWebFacadeIntf;

    @GetMapping(value = ApplicationConstants.WEB_GET_BY_MEDALLIONS_AND_DATE)
    public ResponseEntity getByMedallion(@PathVariable("medallions") List<String> medallions,
                                         @PathVariable("date") String date) {

        return ResponseEntity.ok(nyCabWebFacadeIntf.getByMedallionsAndDate(medallions, date));
    }

}
