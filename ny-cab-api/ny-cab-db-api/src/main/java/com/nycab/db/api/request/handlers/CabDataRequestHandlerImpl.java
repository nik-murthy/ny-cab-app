package com.nycab.db.api.request.handlers;

import com.nycab.commons.dto.CabTripDataResponse;
import com.nycab.db.api.dao.CabDataRepository;
import com.nycab.db.api.entities.CabTripData;
import com.nycab.db.api.util.CabDataHelperIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CabDataRequestHandlerImpl implements CabDataRequestHandlerIntf {

    @Autowired
    private CabDataRepository cabDataRepository;

    @Autowired
    private CabDataHelperIntf cabDataHelperIntf;

    @Override
    public List<CabTripDataResponse> getByMedallionsAndDate(List<String> medallions, Date date) {

        Set<CabTripData> cabTripDataSet = cabDataRepository.findByMedallionsAndDate(medallions, date)
                .stream()
                .collect(Collectors.toSet());

        return cabTripDataSet.stream()
                .map(cabDataHelperIntf::mapToResponseObj)
                .collect(Collectors.toList());
    }
}
