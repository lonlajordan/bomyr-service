package com.bkr.reporting.service.faces;

import com.bkr.reporting.model.FinancialReportForm;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

public interface FinancialReportService {

    ResponseEntity<ByteArrayResource> generateFinancialAnalysisReport(FinancialReportForm form);
}
