package com.bkr.reporting.controller;

import com.bkr.reporting.model.FinancialReportForm;
import com.bkr.reporting.service.faces.FinancialReportService;
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
    private final FinancialReportService financialReportService;

    @Operation(summary = "Download financial analysis report")
    @PostMapping(value = "financial/analysis", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<ByteArrayResource> financialAnalysis(@RequestBody @Valid FinancialReportForm form) {
        return financialReportService.generateFinancialAnalysisReport(form);
    }
}
