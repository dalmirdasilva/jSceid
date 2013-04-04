
package entity;

import event.SaveOrUpdateListener;
import java.util.Date;

public class Clinical implements SaveOrUpdateListener {

    private long id;
    private long patientId;
    private boolean bloating;
    private boolean epigastricPain;
    private boolean slimming;
    private String palpableLymphonodes;
    private boolean anorexia;
    private boolean gastrointestinalBleeding;
    private String palpableMass;
    private boolean vomiting;
    private boolean hepatomegaly;
    private String rectalExamination;
    private boolean ascite;
    private boolean anemia;
    private Date updatedAt;
    private Date createdAt;
    private boolean active;

    public Clinical() {
    }

    public Clinical(long patientId, boolean bloating, boolean epigastricPain, boolean slimming, String palpableLymphonodes, boolean anorexia, boolean gastrointestinalBleeding, String palpableMass, boolean vomiting, boolean hepatomegaly, String rectalExamination, boolean ascite, boolean anemia, boolean active) {
        this.patientId = patientId;
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
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
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
    public void onCreate() {
        createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}

