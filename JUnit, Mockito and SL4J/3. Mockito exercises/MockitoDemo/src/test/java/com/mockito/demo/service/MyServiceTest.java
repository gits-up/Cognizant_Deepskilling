package com.mockito.demo.service;

import com.mockito.demo.api.ExternalApi;
import org.junit.jupiter.api.Test;
import com.mockito.demo.api.Notifier;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getDataById("001")).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchDataById("001");

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchDataById("001");

        verify(mockApi).getDataById("001");
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getDataById(anyString())).thenReturn("Matched Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchDataById("123");

        assertEquals("Matched Data", result);

        verify(mockApi).getDataById(eq("123"));
    }
    
    @Test
    public void testVoidMethodWithVerify() {
        Notifier mockNotifier = mock(Notifier.class);
        MyService service = new MyService(mockNotifier);

        service.performAction("Hello!");

        verify(mockNotifier).notifyUser("Hello!");
    }
    
    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getDataById("multi"))
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");

        MyService service = new MyService(mockApi);

        String result = service.fetchMultipleTimes("multi");

        assertEquals("First Call, Second Call, Third Call", result);
    }

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getDataById("001")).thenReturn("Secure Data");

        MyService service = new MyService(mockApi);
        service.fetchSecureData("valid-token", "001");

        // Ensure order: authenticate → getDataById
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).authenticate("valid-token");
        inOrder.verify(mockApi).getDataById("001");
    }
    
    @Test
    public void testVoidMethodThrowsException() {
        Notifier mockNotifier = mock(Notifier.class);

        doThrow(new IllegalArgumentException("Invalid message"))
            .when(mockNotifier).notifyUser("ERROR");

        MyService service = new MyService(mockNotifier);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.triggerNotification("ERROR");
        });

        assertEquals("Invalid message", exception.getMessage());
    }




}
