package com.automotive.javaee.dto;

public class DealershipDTO extends BaseDTO {
    private String name;
    private String location;


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

}