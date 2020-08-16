package com.nycab.web.api.controllers;

import com.nycab.commons.constants.ApplicationConstants;
import com.nycab.web.api.facade.NyCabWebFacadeIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NyCabWebController {

    @Autowired
    private NyCabWebFacadeIntf nyCabWebFacadeIntf;

    @GetMapping(value = ApplicationConstants.WEB_GET_BY_MEDALLION)
    public ResponseEntity getByMedallion(@PathVariable("medallion") String medallion) {
        return ResponseEntity.ok(nyCabWebFacadeIntf.getByMedallion(medallion));
    }

}
