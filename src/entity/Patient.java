package entity;

import entity.nonpersistable.Gender;
import event.SaveOrUpdateListener;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "patient")
public class Patient implements SaveOrUpdateListener, Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Medic medic;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Avatar avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<ClinicalExam> clinicalExams;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<DiagnosticExam> diagnosticExams;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<PostOperatoryEndoscopy> postOperatoryEndoscopies;
    private String name;
    private int same;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String color;
    private String profession;
    @Column(name = "born_city")
    private String bornCity;
    private String phone;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
    private boolean active;

    public Patient() {
        name = "";
        same = 0;
        age = 0;
        gender = Gender.MALE;
        color = "";
        profession = "";
        bornCity = "";
        phone = "";
        active = true;
    }

    public Patient(String name, Address address, Avatar avatar) {
        this();
        this.avatar = avatar;
        this.name = name;
        this.address = address;
    }

    public Patient(Medic medic, String name, Address address, Avatar avatar) {
        this(name, address, avatar);
        this.medic = medic;
    }

    public Patient(Medic medic, String name, Address address, Avatar avatar, int same, int age, Gender gender, String color, String profession, String bornCity, String phone) {
        this(medic, name, address, avatar);
        this.same = same;
        this.age = age;
        this.gender = gender;
        this.color = color;
        this.profession = profession;
        this.bornCity = bornCity;
        this.phone = phone;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the medic
     */
    public Medic getMedic() {
        return medic;
    }

    /**
     * @param medic the medic to set
     */
    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Set<ClinicalExam> getClinicalExams() {
        return clinicalExams;
    }

    public void updateClinicalExams(Set<ClinicalExam> clinicalExams) {
        if (this.clinicalExams != null) {
            this.clinicalExams.clear();
            this.clinicalExams.addAll(clinicalExams);
        }
    }

    public void setClinicalExams(Set<ClinicalExam> clinicalExams) {
        this.clinicalExams = clinicalExams;
    }

    public Set<DiagnosticExam> getDiagnosticExams() {
        return diagnosticExams;
    }

    public void updateDiagnosticExams(Set<DiagnosticExam> diagnosticExams) {
        if (this.diagnosticExams != null) {
            this.diagnosticExams.clear();
            this.diagnosticExams.addAll(diagnosticExams);
        }
    }

    public void setPostOperatoryEndoscopies(Set<PostOperatoryEndoscopy> postOperatoryEndoscopies) {
        this.postOperatoryEndoscopies = postOperatoryEndoscopies;
    }

    public Set<PostOperatoryEndoscopy> getPostOperatoryEndoscopies() {
        return postOperatoryEndoscopies;
    }

    public void updatePostOperatoryEndoscopies(Set<PostOperatoryEndoscopy> postOperatoryEndoscopies) {
        if (this.postOperatoryEndoscopies != null) {
            this.postOperatoryEndoscopies.clear();
            this.postOperatoryEndoscopies.addAll(postOperatoryEndoscopies);
        }
    }

    public void setDiagnosticExams(Set<DiagnosticExam> diagnosticExams) {
        this.diagnosticExams = diagnosticExams;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the same
     */
    public int getSame() {
        return same;
    }

    /**
     * @param same the same to set
     */
    public void setSame(int same) {
        this.same = same;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public Gender isGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the bornCity
     */
    public String getBornCity() {
        return bornCity;
    }

    /**
     * @param bornCity the bornCity to set
     */
    public void setBornCity(String bornCity) {
        this.bornCity = bornCity;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", same: " + same + ", gender: " + gender + ", medic: " + medic + ", phone: " + phone + "}";
    }

    @Override
    public void onCreate() {
        this.createdAt = new Date();
        adoptChildren();
    }

    @Override
    public void onUpdate() {
        adoptChildren();
    }

    private void adoptChildren() {
        if (clinicalExams != null) {
            for (ClinicalExam o : getClinicalExams()) {
                o.setPatient(this);
            }
        }
        if (diagnosticExams != null) {
            for (DiagnosticExam o : getDiagnosticExams()) {
                o.setPatient(this);
            }
        }
        if (postOperatoryEndoscopies != null) {
            for (PostOperatoryEndoscopy o : getPostOperatoryEndoscopies()) {
                o.setPatient(this);
            }
        }
    }
}
