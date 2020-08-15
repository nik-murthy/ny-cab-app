package com.nycab.api.request.handlers;

import com.nycab.api.dao.CabDataRepository;
import com.nycab.api.dto.CabTripDataResponse;
import com.nycab.api.entities.CabTripData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CabDataRequestHandlerImpl implements CabDataRequestHandlerIntf {

    @Autowired
    private CabDataRepository cabDataRepository;

    @Override
    public List<CabTripDataResponse> getByMedallion(String medallion) {
        return cabDataRepository.findByMedallion(medallion)
                .stream()
                .map(CabTripDataResponse::mapToResponseEntity)
                .collect(Collectors.toList());
    }
}
