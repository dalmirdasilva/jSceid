package entity;

import entity.nonpersistable.Consistency;
import entity.nonpersistable.Intensity;
import entity.nonpersistable.Periodicity;
import event.SaveOrUpdateListener;
import java.util.Date;

public class PostOperatoryAvaliation implements SaveOrUpdateListener {

    private long id;
    private Patient patient;
    private int numberOfMeals = 0;
    private int timeBetweenMeals = 0;
    private Consistency consistency = Consistency.NORMAL;
    private Periodicity ingestionCapacity = Periodicity.NORMAL;
    private Intensity appetite = Intensity.UNCHANGED;
    private Intensity weight = Intensity.UNCHANGED;
    private Periodicity dysphagia = Periodicity.NORMAL;
    private Periodicity pyrosis = Periodicity.NORMAL;
    private Periodicity diarrhea = Periodicity.NORMAL;
    private Periodicity abdominalPain = Periodicity.NORMAL;
    private Periodicity vomit = Periodicity.NORMAL;
    private Periodicity fulness = Periodicity.NORMAL;
    private Periodicity dumping = Periodicity.NORMAL;
    private int totalScore = 0;
    private String comments = "";
    private Date updatedAt;
    private Date createdAt;
    private boolean active = true;

    public PostOperatoryAvaliation() {
    }

    public PostOperatoryAvaliation(Patient patient) {
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
