package com.nycab.db.api.request.handlers;

import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.db.api.dao.CabDataRepository;
import com.nycab.db.api.util.CabDataHelperIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CabDataRequestHandlerImpl implements CabDataRequestHandlerIntf {

    @Autowired
    private CabDataRepository cabDataRepository;

    @Autowired
    private CabDataHelperIntf cabDataHelperIntf;

    @Override
    public List<CabTripDataResponse> getByMedallion(String medallion) {
        return cabDataRepository.findByMedallion(medallion)
                .stream()
                .map(cabDataHelperIntf::mapToResponseObj)
                .collect(Collectors.toList());
    }

    @Override
    public List<CabTripDataResponse> getByMedallionAndDate(String medallion, Date date) {
        return cabDataRepository.findByMedallionAndDate(medallion, date)
                .stream()
                .map(cabDataHelperIntf::mapToResponseObj)
                .collect(Collectors.toList());
    }
}
