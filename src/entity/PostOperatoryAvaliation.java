package entity;

import entity.nonpersistable.Consistency;
import entity.nonpersistable.Intensity;
import entity.nonpersistable.Periodicity;
import event.SaveOrUpdateListener;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "post_operatory_avaliation")
public class PostOperatoryAvaliation implements SaveOrUpdateListener, Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Patient patient;
    @Column(name = "time_of_meals")
    private int numberOfMeals;
    @Column(name = "time_between_meals")
    private int timeBetweenMeals;
    @Enumerated(EnumType.STRING)
    private Consistency consistency;
    @Enumerated(EnumType.STRING)
    @Column(name = "ingestion_capacity")
    private Periodicity ingestionCapacity;
    @Enumerated(EnumType.STRING)
    private Intensity appetite;
    @Enumerated(EnumType.STRING)
    private Intensity weight;
    @Enumerated(EnumType.STRING)
    private Periodicity dysphagia;
    @Enumerated(EnumType.STRING)
    private Periodicity pyrosis;
    @Enumerated(EnumType.STRING)
    private Periodicity diarrhea;
    @Enumerated(EnumType.STRING)
    @Column(name = "abdominal_pain")
    private Periodicity abdominalPain;
    @Enumerated(EnumType.STRING)
    private Periodicity vomit;
    @Enumerated(EnumType.STRING)
    private Periodicity fulness;
    @Enumerated(EnumType.STRING)
    private Periodicity dumping;
    @Column(name = "total_score")
    private int totalScore;
    private String comments;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
    private boolean active = true;

    public PostOperatoryAvaliation() {
        consistency = Consistency.NORMAL;
        ingestionCapacity = Periodicity.NORMAL;
        appetite = Intensity.UNCHANGED;
        weight = Intensity.UNCHANGED;
        dysphagia = Periodicity.NORMAL;
        pyrosis = Periodicity.NORMAL;
        diarrhea = Periodicity.NORMAL;
        abdominalPain = Periodicity.NORMAL;
        vomit = Periodicity.NORMAL;
        fulness = Periodicity.NORMAL;
        dumping = Periodicity.NORMAL;
        totalScore = 0;
        comments = "";
    }

    public PostOperatoryAvaliation(Patient patient) {
        this();
        this.patient = patient;
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

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    public int getTimeBetweenMeals() {
        return timeBetweenMeals;
    }

    public void setTimeBetweenMeals(int timeBetweenMeals) {
        this.timeBetweenMeals = timeBetweenMeals;
    }

    public Consistency getConsistency() {
        return consistency;
    }

    public void setConsistency(Consistency consistency) {
        this.consistency = consistency;
    }

    public Periodicity getIngestionCapacity() {
        return ingestionCapacity;
    }

    public void setIngestionCapacity(Periodicity ingestionCapacity) {
        this.ingestionCapacity = ingestionCapacity;
    }

    public Intensity getAppetite() {
        return appetite;
    }

    public void setAppetite(Intensity appetite) {
        this.appetite = appetite;
    }

    public Intensity getWeight() {
        return weight;
    }

    public void setWeight(Intensity weight) {
        this.weight = weight;
    }

    public Periodicity getDysphagia() {
        return dysphagia;
    }

    public void setDysphagia(Periodicity dysphagia) {
        this.dysphagia = dysphagia;
    }

    public Periodicity getPyrosis() {
        return pyrosis;
    }

    public void setPyrosis(Periodicity pyrosis) {
        this.pyrosis = pyrosis;
    }

    public Periodicity getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(Periodicity diarrhea) {
        this.diarrhea = diarrhea;
    }

    public Periodicity getAbdominalPain() {
        return abdominalPain;
    }

    public void setAbdominalPain(Periodicity abdominalPain) {
        this.abdominalPain = abdominalPain;
    }

    public Periodicity getVomit() {
        return vomit;
    }

    public void setVomit(Periodicity vomit) {
        this.vomit = vomit;
    }

    public Periodicity getFulness() {
        return fulness;
    }

    public void setFulness(Periodicity fulness) {
        this.fulness = fulness;
    }

    public Periodicity getDumping() {
        return dumping;
    }

    public void setDumping(Periodicity dumping) {
        this.dumping = dumping;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
        return "{"
                + "patient: " + patient + ", "
                + "numberOfMeals: " + numberOfMeals + ", "
                + "timeBetweenMeals: " + timeBetweenMeals + ", "
                + "consistency: " + consistency + ", "
                + "ingestionCapacity: " + ingestionCapacity + ""
                + "}";
    }

    @Override
    public void onCreate() {
        this.createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}
