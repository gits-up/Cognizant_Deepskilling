package com.cognizant.billingservice.billing_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class BillingController {

    @GetMapping("/billing/info")
    public String getBillingInfo() {
        return "Billing Service: Billing Info";
    }
    
    @GetMapping
    public ResponseEntity<String> getInvoice() {
        return ResponseEntity.ok("Invoice details from Billing Service");
    }
}
