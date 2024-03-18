package com.Springopro.Springpro.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "train")
@NoArgsConstructor
@AllArgsConstructor
public class Train {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "departure_time")
    private Time departure_time;
    @Column(name = "arrival_time")
    private Time arrival_time;
    @Column(name = "price_ticket")
    private int price_ticket;
    @Column(name = "day")
    private int day;
    @Column(name = "month")
    private int month;
    @Column(name = "nr_seats")
    private int nr_seats;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<User> usersList;

    public int getId() {
        return id;
    }

    public int getNr_seats() {
        return nr_seats;
    }

    public void setNr_seats(int nr_seats) {
        this.nr_seats = nr_seats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public Time getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Time departure_time) {
        this.departure_time = departure_time;
    }

    public Time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getPrice_ticket() {
        return price_ticket;
    }

    public void setPrice_ticket(int price_ticket) {
        this.price_ticket = price_ticket;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}