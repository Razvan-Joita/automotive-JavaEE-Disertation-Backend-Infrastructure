package com.automotive.javaee.dto;

import java.time.LocalDate;
import java.util.List;

public class ServiceRecordDTO extends BaseDTO {
    private String description;
    private LocalDate date;

    private Long vehicleId;
    private Long mechanicId;
    private List<Long> partIds;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public Long getMechanicId() { return mechanicId; }
    public void setMechanicId(Long mechanicId) { this.mechanicId = mechanicId; }

    public List<Long> getPartIds() { return partIds; }
    public void setPartIds(List<Long> partIds) { this.partIds = partIds; }

}