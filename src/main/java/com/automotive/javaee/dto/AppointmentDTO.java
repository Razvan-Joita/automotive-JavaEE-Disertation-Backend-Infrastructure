package com.automotive.javaee.dto;

import java.time.LocalDate;

public class AppointmentDTO extends BaseDTO {
    private LocalDate date;

    private Long vehicleId;

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

}