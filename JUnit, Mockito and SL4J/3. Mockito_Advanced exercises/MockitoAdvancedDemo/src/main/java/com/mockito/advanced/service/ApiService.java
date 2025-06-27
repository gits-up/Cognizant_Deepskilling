package com.mockito.advanced.service;

import com.mockito.advanced.api.RestClient;

public class ApiService {
    private final RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String fetchData() {
        String response = restClient.getResponse();
        return "Fetched " + response;
    }
}
