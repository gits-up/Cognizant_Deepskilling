package com.mockito.demo.service;

import com.mockito.demo.api.ExternalApi;
import com.mockito.demo.api.Notifier;

public class MyService {
    private final ExternalApi externalApi;
    private Notifier notifier;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public MyService(Notifier notifier) {
        this.externalApi = null;
        this.notifier = notifier;
    }

    public String fetchDataById(String id) {
        return externalApi.getDataById(id);
    }

    public void performAction(String message) {
        notifier.notifyUser(message);
    }
    
    public String fetchMultipleTimes(String id) {
        return externalApi.getDataById(id) + ", "
             + externalApi.getDataById(id) + ", "
             + externalApi.getDataById(id);
    }
    
    public String fetchSecureData(String token, String id) {
        externalApi.authenticate(token);
        return externalApi.getDataById(id);
    }
    
    public void triggerNotification(String message) {
        notifier.notifyUser(message);
    }

}
