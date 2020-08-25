package com.example.Blood_Camp.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Event {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private int id;

    @NotNull
    @Size(min=8, max= 70)
    private String location;

    @CreatedDate
    private String date;


    @Basic
    private String starttime;

    @Basic
    private String endtime;

    @NotNull
    @Size(min=8 , max= 70)
    private String streetname;

    @NotNull
    @Size(min=5, max=20)
    private String city;

    @NotNull
    @Min(5)
    private int zipcode;
    @OneToMany
    @JoinColumn(name="donor_id")
    private List<Donor> donors=new ArrayList<>();

    public List<Donor> getDonors() {
        return donors;
    }

    public void setDonors(List<Donor> donors) {
        this.donors = donors;
    }

    public Event(){}

    public Event( String location, String date, String starttime,String endtime, String streetname, String city, int zipcode) {

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


    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getCity() {
        return city;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public int getId() {
        return id;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
