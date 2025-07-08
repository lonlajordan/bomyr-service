package com.bkr.reporting.service;

import com.bkr.reporting.model.FinancialReportForm;
import com.bkr.reporting.service.faces.FinancialReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import static com.bkr.reporting.util.FormUtils.generateReport;

@Service
@RequiredArgsConstructor
public class FinancialReportServiceImpl implements FinancialReportService {
    private final TemplateEngine templateEngine;

    @Override
    public ResponseEntity<ByteArrayResource> generateFinancialAnalysisReport(FinancialReportForm form) {
        return generateReport(templateEngine, "report", form);
    }

}
