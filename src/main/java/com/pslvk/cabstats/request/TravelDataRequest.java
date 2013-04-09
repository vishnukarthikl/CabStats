package com.pslvk.cabstats.request;

public class TravelDataRequest {
    private long msisdn;
    private double distance;
    private int amount;
    private String date;
    private String time;
    private CustomerRegistrationRequest customerRegistrationRequest;

    public TravelDataRequest(long msisdn, double distance, int amount, String date, String time, CustomerRegistrationRequest customerRegistrationRequest) {
        this.msisdn = msisdn;
        this.distance = distance;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.customerRegistrationRequest = customerRegistrationRequest;
    }

    public TravelDataRequest() {
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }

    public CustomerRegistrationRequest getCustomerRegistrationRequest() {
        return customerRegistrationRequest;
    }

    public void setCustomerRegistrationRequest(CustomerRegistrationRequest customerRegistrationRequest) {
        this.customerRegistrationRequest = customerRegistrationRequest;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
