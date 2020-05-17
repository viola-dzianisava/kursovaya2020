package com.gym.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Purchase {
    private int idPurchase;
    private String name;
    private String phone;
    private String status;
    private String ticket;
    private Date start;

    public Purchase() {
    }

    public Purchase(int idPurchase, String name, String phone, String status, String ticket, Date start) {
        this.idPurchase = idPurchase;
        this.name = name;
        this.phone = phone;
        this.status = status;
        this.ticket = ticket;
        this.start = start;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
