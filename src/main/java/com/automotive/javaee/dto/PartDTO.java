package com.automotive.javaee.dto;

import java.math.BigDecimal;
import java.util.List;

public class PartDTO extends BaseDTO {
    private String name;
    private String partNumber;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    private List<Long> serviceRecordIds;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPartNumber() { return partNumber; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public List<Long> getServiceRecordIds() { return serviceRecordIds; }
    public void setServiceRecordIds(List<Long> serviceRecordIds) { this.serviceRecordIds = serviceRecordIds; }

}