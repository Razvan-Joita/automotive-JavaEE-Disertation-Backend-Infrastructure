package com.automotive.javaee.dto;

public class EmployeeDTO extends BaseDTO {
    private String name;
    private String role;
    private String email;
    private String phone;

    private Long dealershipId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Long getDealershipId() { return dealershipId; }
    public void setDealershipId(Long dealershipId) { this.dealershipId = dealershipId; }

}