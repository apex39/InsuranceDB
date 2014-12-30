package com.domain.model;

import java.util.Collection;
import java.util.Date;

public class Oc {
    //TODO:Change all domain's IDs from int to String
    private final String ocId;


    public Oc(String ocId) {
        this.ocId = ocId;
    }

    private Customer customer;
    private Vehicle vehicle;
    private Collection<Discount> discounts;
    private Zone zone;
    private String placeOfIssue;
    private Date dateOfIssue;
    private Date dateBegin;
    private Date dateFinish;
    private User insurer;
    private float premium;

    public String getOcId() {
        return ocId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Collection<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Collection<Discount> discounts) {
        this.discounts = discounts;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public User getInsurer() {
        return insurer;
    }

    public void setInsurer(User insurer) {
        this.insurer = insurer;
    }

    public float getPremium() {
        return premium;
    }

    public void setPremium(float premium) {
        this.premium = premium;
    }
}
