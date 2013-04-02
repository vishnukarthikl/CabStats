package com.pslvk.cabstats.request;

public class CustomerRegistrationRequest {
    private String name;
    private long msisdn;
    private String area;
    private String street;
    private long pincode;

    private CustomerRegistrationRequest() {
    }

    public CustomerRegistrationRequest(String name, long msisdn, String area, String street, long pincode) {
        this.name = name;
        this.msisdn = msisdn;
        this.area = area;
        this.street = street;
        this.pincode = pincode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }
}
