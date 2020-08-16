package com.nycab.db.api.controllers;

import com.nycab.commons.constants.ApplicationConstants;
import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.db.api.request.handlers.CabDataRequestHandlerIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class CabTripDataDbController {

    @Autowired
    private CabDataRequestHandlerIntf cabDataRequestHandlerIntf;

    @GetMapping(value = ApplicationConstants.DB_GET_BY_MEDALLIONS_AND_DATE)
    public ResponseEntity getByMedallion(@RequestParam("medallions") List<String> medallions,
                                         @RequestParam("date") String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date inputDate = simpleDateFormat.parse(date);
            return ResponseEntity.ok(cabDataRequestHandlerIntf.getByMedallionsAndDate(medallions, inputDate));
        } catch (ParseException exp) {
            return ResponseEntity.badRequest().body("Incorrect date format supplied");
        }
    }

}
