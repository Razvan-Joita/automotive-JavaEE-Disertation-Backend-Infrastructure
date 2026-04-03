package com.automotive.javaee.dto;

import java.time.LocalDate;

public class WarrantyDTO extends BaseDTO {
    private LocalDate startDate;
    private LocalDate endDate;

    private Long vehicleId;

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

}