package entity;

import entity.nonpersistable.LaurenClassification;
import event.SaveOrUpdateListener;
import java.util.Date;

public class DiagnosticExam implements SaveOrUpdateListener {

    private long id;
    private Patient patient;
    private String digestiveEndoscopy = "";
    private Date endoscopyDate;
    private LaurenClassification laurenClassification = LaurenClassification.DIFFUSE;
    private int biopsiesCount = 0;
    private String xRayEED = "";
    private Date xRayDate;
    private String CA724 = "";
    private String CEA = "";
    private String CA199 = "";
    private Date updatedAt;
    private Date createdAt;
    private boolean active = true;

    public DiagnosticExam(Patient patient) {
        this.patient = patient;
    }

    public DiagnosticExam(Patient patient, String digestiveEndoscopy, Date endoscopyDate, LaurenClassification laurenClassification, int biopsiesCount, String xRayEED, Date xRayDate, String CA724, String CEA, String CA199, Date updatedAt, Date createdAt, boolean active) {
        this.patient = patient;
        this.digestiveEndoscopy = digestiveEndoscopy;
        this.endoscopyDate = endoscopyDate;
        this.laurenClassification = laurenClassification;
        this.biopsiesCount = biopsiesCount;
        this.xRayEED = xRayEED;
        this.xRayDate = xRayDate;
        this.CA724 = CA724;
        this.CEA = CEA;
        this.CA199 = CA199;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.active = active;
    }

    public DiagnosticExam() {
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

    public String getDigestiveEndoscopy() {
        return digestiveEndoscopy;
    }

    public void setDigestiveEndoscopy(String digestiveEndoscopy) {
        this.digestiveEndoscopy = digestiveEndoscopy;
    }

    public Date getEndoscopyDate() {
        return endoscopyDate;
    }

    public void setEndoscopyDate(Date endoscopyDate) {
        this.endoscopyDate = endoscopyDate;
    }

    public LaurenClassification getLaurenClassification() {
        return laurenClassification;
    }

    public void setLaurenClassification(LaurenClassification laurenClassification) {
        this.laurenClassification = laurenClassification;
    }

    public int getBiopsiesCount() {
        return biopsiesCount;
    }

    public void setBiopsiesCount(int biopsiesCount) {
        this.biopsiesCount = biopsiesCount;
    }

    public String getxRayEED() {
        return xRayEED;
    }

    public void setxRayEED(String xRayEED) {
        this.xRayEED = xRayEED;
    }

    public Date getxRayDate() {
        return xRayDate;
    }

    public void setxRayDate(Date xRayDate) {
        this.xRayDate = xRayDate;
    }

    public String getCA724() {
        return CA724;
    }

    public void setCA724(String CA724) {
        this.CA724 = CA724;
    }

    public String getCEA() {
        return CEA;
    }

    public void setCEA(String CEA) {
        this.CEA = CEA;
    }

    public String getCA199() {
        return CA199;
    }

    public void setCA199(String CA199) {
        this.CA199 = CA199;
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
        return "{patient: " + patient + ", digestiveEndoscopy: " + digestiveEndoscopy + ", laurenClassification: " + laurenClassification + ", biopsiesCount: " + biopsiesCount + "}";
    }

    @Override
    public void onCreate() {
        createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}
