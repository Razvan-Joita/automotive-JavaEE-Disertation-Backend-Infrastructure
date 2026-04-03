package com.automotive.javaee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealership_id")
    private Dealership dealership;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Dealership getDealership() { return dealership; }
    public void setDealership(Dealership dealership) { this.dealership = dealership; }

}