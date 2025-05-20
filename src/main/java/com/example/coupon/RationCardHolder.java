package com.example.coupon;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("ration_card_holder")
public class RationCardHolder {
    @Id
    private Long id;
    private String rationCardNumber;
    private String name;
    private String city;
    private LocalDate lastCouponDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRationCardNumber() { return rationCardNumber; }
    public void setRationCardNumber(String rationCardNumber) { this.rationCardNumber = rationCardNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public LocalDate getLastCouponDate() { return lastCouponDate; }
    public void setLastCouponDate(LocalDate lastCouponDate) { this.lastCouponDate = lastCouponDate; }
}
