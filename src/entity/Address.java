package entity;

import event.SaveOrUpdateListener;
import java.util.Date;

public class Address implements SaveOrUpdateListener {

    private long id;
    private String country = "";
    private String uf = "";
    private String city = "";
    private String street = "";
    private int number;
    private Date updatedAt;
    private Date createdAt;
    private boolean active = true;

    public Address() {
    }

    public Address(String country, String uf, String city, String street, int number) {
        this.country = country;
        this.uf = uf;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "{country: " + country + ", uf: " + uf + ", city: " + city + ", street: " + street + ", number: " + number + "}";
    }

    @Override
    public void onCreate() {
        createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}
