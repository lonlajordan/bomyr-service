package com.bkr.reporting.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class FinancialReportForm {
    @NotBlank
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Company name", example = "CCA BANK")
    private String companyName;
    @NotNull
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Year", example = "2025")
    private Integer year;
    @NotNull
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "2025-06-30")
    private LocalDate date;

}
