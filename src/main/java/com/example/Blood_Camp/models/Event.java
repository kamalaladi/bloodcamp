package com.example.Blood_Camp.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Date;

@Entity

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=8, max= 70)
    private String location;

    @CreatedDate
    private String date;


    @Column(name = "start_time",columnDefinition = "TIME")
    @DateTimeFormat
    private LocalTime starttime;

    @Column(name = "end_time",columnDefinition = "TIME")
    private LocalTime endtime;

    @NotNull
    @Size(min=8 , max= 70)
    private String streetname;

    @NotNull
    @Size(min=5, max=20)
    private String city;

    @NotNull
    @Min(5)
    private int zipcode;

    public Event(){}

    public Event( String location, String date, LocalTime starttime, LocalTime endtime, String streetname, String city, int zipcode) {

        this.location = location;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
        this.streetname = streetname;
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}