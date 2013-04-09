package entity;

import event.SaveOrUpdateListener;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "address")
public class Address implements SaveOrUpdateListener, Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String country;
    private String uf;
    private String city;    
    private String street;
    private int number;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
    private boolean active;

    public Address() {
        country = "";
        uf = "";
        city = "";
        street = "";
        number = 0;
        active = true;
    }

    public Address(String country, String uf, String city, String street, int number) {
        this();
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
