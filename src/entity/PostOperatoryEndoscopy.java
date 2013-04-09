package entity;

import event.SaveOrUpdateListener;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "post_operatory_endoscopy")
public class PostOperatoryEndoscopy implements SaveOrUpdateListener, Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Patient patient;
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "endoscopy_date")
    private Date endoscopyDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
    private boolean active = true;

    public PostOperatoryEndoscopy() {
        description = "";
    }

    public PostOperatoryEndoscopy(Date endoscopyDate) {
        this();
        this.endoscopyDate = endoscopyDate;
    }

    public PostOperatoryEndoscopy(Patient patient, String description, Date endoscopyDate) {
        this(endoscopyDate);
        this.patient = patient;
        this.description = description;
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

    public Date getEndoscopyDate() {
        return endoscopyDate;
    }

    public void setEndoscopyDate(Date endoscopyDate) {
        this.endoscopyDate = endoscopyDate;
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
        return "{patient: " + patient + ", description: " + description + ", date: " + endoscopyDate + "}";
    }

    @Override
    public void onCreate() {
        this.createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}
