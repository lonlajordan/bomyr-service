package com.cca.reporting.service;

import com.cca.reporting.model.*;
import com.cca.reporting.service.faces.AccountOpeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import static com.cca.reporting.util.FormUtils.generateReport;

@Service
@RequiredArgsConstructor
public class AccountOpeningServiceImpl implements AccountOpeningService {
    private final TemplateEngine templateEngine;

    @Override
    public ResponseEntity<ByteArrayResource> generateProductSubscriptionForm(ProductSubscriptionForm form) {
        return generateReport(templateEngine, "products-subscription/form", form);
    }

}
