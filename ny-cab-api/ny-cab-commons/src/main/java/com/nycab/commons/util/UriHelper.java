package com.nycab.commons.util;

import com.nycab.commons.request.UriRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * This class defines a common way to access REST endpoints that
 * can be reused in other modules in the project
 */
@Component
public class UriHelper {

    public ResponseEntity<?> getFromUri(final UriRequest uriRequest) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(uriRequest.getUrl() + uriRequest.getUri());

        if (uriRequest.getParams().isPresent()) {
            populateParams(builder, uriRequest.getParams().get());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(builder.toUriString(),
                uriRequest.getHttpMethod(),
                entity,
                uriRequest.getResponseType());
    }

    public ResponseEntity<?> postToUri(final UriRequest uriRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriRequest.getUrl() +uriRequest.getUri());
        if (uriRequest.getParams().isPresent()) {
            populateParams(builder, uriRequest.getParams().get());
        }
        return restTemplate.exchange(builder.toUriString(),
                uriRequest.getHttpMethod(),
                entity,
                uriRequest.getResponseType());
    }

    private void populateParams(final UriComponentsBuilder builder, final Map<String, Object> params) {
        params.forEach((paramName, paramValue) -> builder.queryParam(paramName, paramValue));
    }
}
