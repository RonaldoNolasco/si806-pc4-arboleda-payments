package com.arboleda.arboledapayments.dto;

import javax.validation.constraints.NotNull;

public class ListPendingPaymentsDto {
    private Long serviceId;
    private String clientServiceCode;

    @NotNull
    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    @NotNull
    public String getClientServiceCode() {
        return clientServiceCode;
    }

    public void setClientServiceCode(String clientServiceCode) {
        this.clientServiceCode = clientServiceCode;
    }
}
