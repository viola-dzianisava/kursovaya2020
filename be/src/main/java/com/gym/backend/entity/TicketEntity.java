package com.gym.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket", schema = "gym")
public class TicketEntity {
    private int idTicket;
    private int cost;
    private String duration;
    private String visits;
    private String name;

    @Id
    @Column(name = "id_ticket")
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Basic
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "visits")
    public String getVisits() {
        return visits;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (idTicket != that.idTicket) return false;
        if (cost != that.cost) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (visits != null ? !visits.equals(that.visits) : that.visits != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTicket;
        result = 31 * result + cost;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (visits != null ? visits.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
