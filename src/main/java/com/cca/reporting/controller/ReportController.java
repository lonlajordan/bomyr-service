package com.cca.reporting.controller;

import com.cca.reporting.model.*;
import com.cca.reporting.service.faces.AccountOpeningService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("${endpoints.base.url}")
public class ReportController {
    private final AccountOpeningService accountOpeningService;

    @Operation(summary = "Download products subscription form")
    @PostMapping(value = "products/subscription", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<ByteArrayResource> productSubscription(@RequestBody @Valid ProductSubscriptionForm form) {
        return accountOpeningService.generateProductSubscriptionForm(form);
    }
}
