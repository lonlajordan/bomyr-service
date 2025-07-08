package com.cca.reporting.service.faces;

import com.cca.reporting.model.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

public interface AccountOpeningService {

    ResponseEntity<ByteArrayResource> generateProductSubscriptionForm(ProductSubscriptionForm form);
}
