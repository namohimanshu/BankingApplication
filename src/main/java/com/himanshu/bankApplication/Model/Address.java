package com.himanshu.bankApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;
    private String city;
    private long pincode;
    private String landmark;
    private String district;
    private String state;
    private String country;
/**
    public Address(String city, long pincode, String landmark, String district, String state, String country) {
        this.city = city;
        this.pincode = pincode;
        this.landmark = landmark;
        this.district = district;
        this.state = state;
        this.country = country;
    }
 **/
/**
    public String getCity() {
        return city;
    }

    public long getPincode() {
        return pincode;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", pincode=" + pincode +
                ", landmark='" + landmark + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
    */
}
