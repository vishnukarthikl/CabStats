package com.pslvk.cabstats.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long msisdn;
    private String street;
    private String area;
    private long pincode;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Travel> travelList = new ArrayList<Travel>();

    private Customer() {
    }

    public Customer(String name, long msisdn, String street, String area, long pincode) {
        this.name = name;
        this.msisdn = msisdn;
        this.street = street;
        this.area = area;
        this.pincode = pincode;
    }


    public List<Travel> getTravelList() {
        return travelList;
    }

    public void setTravelList(List<Travel> travelList) {
        this.travelList = travelList;
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

    public void addTravelDetails(Travel travel) {
        travelList.add(travel);
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public void update(Customer customerFromRequest) {
        this.setName(customerFromRequest.getName());
        this.setStreet(customerFromRequest.getStreet());
        this.setArea(customerFromRequest.getArea());
        this.setPincode(customerFromRequest.getPincode());
    }
}
