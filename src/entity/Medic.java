package entity;

import event.SaveOrUpdateListener;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "medic")
public class Medic implements SaveOrUpdateListener, Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Institution institution;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Avatar avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medic")
    private Set<Patient> patients;
    private String name;
    private String phone;
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
    private boolean active;

    public Medic() {
        name = "";
        phone = "";
        email = "";
    }

    public Medic(Institution institution, Address address) {
        this();
        this.institution = institution;
        this.address = address;
    }

    public Medic(Institution institution, Address address, String name, String phone, String email, boolean active) {
        this(institution, address);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void updatePatients(Set<Patient> patients) {
        if (this.patients != null) {
            this.patients.clear();
            this.patients.addAll(patients);
        }
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "{name: " + name + ", phone: " + phone + ", email: " + email + ", institution: " + institution + "}";
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
        if (patients != null) {
            for (Patient o : getPatients()) {
                o.setMedic(this);
            }
        }
    }
}
