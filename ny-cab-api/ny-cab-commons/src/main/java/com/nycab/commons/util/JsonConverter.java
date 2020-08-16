package com.nycab.commons.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nycab.commons.dto.CabTripDataResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class JsonConverter {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public String getString(List<CabTripDataResponse> cabTripDataResponses) throws JsonProcessingException {
        return objectMapper.writeValueAsString(cabTripDataResponses);
    }

    public List<CabTripDataResponse> getJson(String cabTripDataResponses) throws JsonProcessingException {
        return Arrays.asList(objectMapper.readValue(cabTripDataResponses, CabTripDataResponse[].class));
    }
}
