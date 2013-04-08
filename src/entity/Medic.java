package entity;

import event.SaveOrUpdateListener;
import java.util.Date;
import java.util.Set;

public class Medic implements SaveOrUpdateListener {

    private long id;
    private Institution institution;
    private Set<Patient> patients;
    private Address address;
    private Avatar avatar;
    private String name = "";
    private String phone = "";
    private String email = "";
    private Date updatedAt;
    private Date createdAt;
    private boolean active;

    public Medic() {
    }

    public Medic(Institution institution, Address address) {
        this.institution = institution;
        this.address = address;
    }

    public Medic(Institution institution, Address address, String name, String phone, String email, boolean active) {
        this.address = address;
        this.institution = institution;
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
