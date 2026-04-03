package com.automotive.javaee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity {
    @Column(name = "amount")
    private Double amount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_record_id", unique = true)
    private ServiceRecord serviceRecord;

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public ServiceRecord getServiceRecord() { return serviceRecord; }
    public void setServiceRecord(ServiceRecord serviceRecord) { this.serviceRecord = serviceRecord; }

}