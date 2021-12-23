package com.arboleda.arboledapayments.dto;


import javax.validation.constraints.NotNull;

public class ListServicesDto {
    private Long companyId;
    private String currency;

    @NotNull
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
