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
@Table(name = "clinical_exam")
public class ClinicalExam implements SaveOrUpdateListener, Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Patient patient;
    private boolean bloating;
    @Column(name = "epigastric_pain")
    private boolean epigastricPain;
    private boolean slimming;
    @Column(name = "palpable_lymphonodes")
    private String palpableLymphonodes;
    private boolean anorexia;
    @Column(name = "gastrointestinal_bleeding")
    private boolean gastrointestinalBleeding;
    @Column(name = "palpable_mass")
    private String palpableMass;
    private boolean vomiting;
    private boolean hepatomegaly;
    @Column(name = "rectal_examination")
    private String rectalExamination;
    private boolean ascite;
    private boolean anemia;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
    private boolean active;

    public ClinicalExam() {
        bloating = false;
        epigastricPain = false;
        slimming = false;
        palpableLymphonodes = "0";
        anorexia = false;
        gastrointestinalBleeding = false;
        palpableMass = "0";
        vomiting = false;
        hepatomegaly = false;
        rectalExamination = "0";
        ascite = false;
        anemia = false;
        active = true;
    }

    public ClinicalExam(Patient patient) {
        this();
        this.patient = patient;
    }

    public ClinicalExam(Patient patient, boolean bloating, boolean epigastricPain, boolean slimming, String palpableLymphonodes, boolean anorexia, boolean gastrointestinalBleeding, String palpableMass, boolean vomiting, boolean hepatomegaly, String rectalExamination, boolean ascite, boolean anemia) {
        this(patient);
        this.bloating = bloating;
        this.epigastricPain = epigastricPain;
        this.slimming = slimming;
        this.palpableLymphonodes = palpableLymphonodes;
        this.anorexia = anorexia;
        this.gastrointestinalBleeding = gastrointestinalBleeding;
        this.palpableMass = palpableMass;
        this.vomiting = vomiting;
        this.hepatomegaly = hepatomegaly;
        this.rectalExamination = rectalExamination;
        this.ascite = ascite;
        this.anemia = anemia;
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

    public boolean isBloating() {
        return bloating;
    }

    public void setBloating(boolean bloating) {
        this.bloating = bloating;
    }

    public boolean isEpigastricPain() {
        return epigastricPain;
    }

    public void setEpigastricPain(boolean epigastricPain) {
        this.epigastricPain = epigastricPain;
    }

    public boolean isSlimming() {
        return slimming;
    }

    public void setSlimming(boolean slimming) {
        this.slimming = slimming;
    }

    public String getPalpableLymphonodes() {
        return palpableLymphonodes;
    }

    public void setPalpableLymphonodes(String palpableLymphonodes) {
        this.palpableLymphonodes = palpableLymphonodes;
    }

    public boolean isAnorexia() {
        return anorexia;
    }

    public void setAnorexia(boolean anorexia) {
        this.anorexia = anorexia;
    }

    public boolean isGastrointestinalBleeding() {
        return gastrointestinalBleeding;
    }

    public void setGastrointestinalBleeding(boolean gastrointestinalBleeding) {
        this.gastrointestinalBleeding = gastrointestinalBleeding;
    }

    public String getPalpableMass() {
        return palpableMass;
    }

    public void setPalpableMass(String palpableMass) {
        this.palpableMass = palpableMass;
    }

    public boolean isVomiting() {
        return vomiting;
    }

    public void setVomiting(boolean vomiting) {
        this.vomiting = vomiting;
    }

    public boolean isHepatomegaly() {
        return hepatomegaly;
    }

    public void setHepatomegaly(boolean hepatomegaly) {
        this.hepatomegaly = hepatomegaly;
    }

    public String getRectalExamination() {
        return rectalExamination;
    }

    public void setRectalExamination(String rectalExamination) {
        this.rectalExamination = rectalExamination;
    }

    public boolean isAscite() {
        return ascite;
    }

    public void setAscite(boolean ascite) {
        this.ascite = ascite;
    }

    public boolean isAnemia() {
        return anemia;
    }

    public void setAnemia(boolean anemia) {
        this.anemia = anemia;
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
        return "{patient: " + patient + ", bloating: " + bloating + ", epigastricPain: " + epigastricPain + ", slimming: " + slimming + ", palpableLymphonodes: " + palpableLymphonodes + "}";
    }

    @Override
    public void onCreate() {
        createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}
