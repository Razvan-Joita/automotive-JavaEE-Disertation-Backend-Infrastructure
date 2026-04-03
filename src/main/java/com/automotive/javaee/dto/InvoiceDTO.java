package com.automotive.javaee.dto;

public class InvoiceDTO extends BaseDTO {
    private Double amount;

    private Long serviceRecordId;

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Long getServiceRecordId() { return serviceRecordId; }
    public void setServiceRecordId(Long serviceRecordId) { this.serviceRecordId = serviceRecordId; }

}