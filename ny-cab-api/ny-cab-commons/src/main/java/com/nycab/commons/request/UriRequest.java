package com.nycab.commons.request;

import org.springframework.http.HttpMethod;

import java.util.Map;
import java.util.Optional;

public class UriRequest {
    private String url;
    private String uri;
    private Class responseType;
    private HttpMethod httpMethod;
    private Optional<Map<String, Object>> params;

    private UriRequest() {
    }

    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    private void setUri(String uri) {
        this.uri = uri;
    }

    public Class getResponseType() {
        return responseType;
    }

    private void setResponseType(Class responseType) {
        this.responseType = responseType;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    private void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Optional<Map<String, Object>> getParams() {
        return params;
    }

    private void setParams(Optional<Map<String, Object>> params) {
        this.params = params;
    }


    public static UriRequest of(final String url,
                                final String uri,
                                final Class responseType,
                                final HttpMethod httpMethod,
                                final Optional<Map<String, Object>> params) {

        UriRequest uriRequest = new UriRequest();

        uriRequest.setUrl(url);
        uriRequest.setUri(uri);
        uriRequest.setResponseType(responseType);
        uriRequest.setHttpMethod(httpMethod);
        uriRequest.setParams(params);

        return uriRequest;
    }
}
