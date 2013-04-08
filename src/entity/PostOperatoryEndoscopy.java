package entity;

import event.SaveOrUpdateListener;
import java.util.Date;

public class PostOperatoryEndoscopy implements SaveOrUpdateListener {

    private long id;
    private Patient patient;
    private String description = "";
    private Date date;
    private Date updatedAt;
    private Date createdAt;
    private boolean active = true;

    public PostOperatoryEndoscopy() {
    }

    public PostOperatoryEndoscopy(Date date) {
        this.date = date;
    }

    public PostOperatoryEndoscopy(Patient patient, String description, Date date) {
        this.patient = patient;
        this.description = description;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return "{patient: " + patient + ", description: " + description + ", date: " + date + "}";
    }

    @Override
    public void onCreate() {
        this.createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}
