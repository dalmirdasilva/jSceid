package entity;

import event.SaveOrUpdateListener;
import java.util.Date;
import java.util.Set;

public class Medic implements SaveOrUpdateListener {

    private long id;
    private Institution institution;
    private Set<Patient> patients;
    private String name;
    private String phone;
    private String email;
    private String city;
    private Date updatedAt;
    private Date createdAt;
    private boolean active;

    public Medic() {
    }

    public Medic(Institution institution, String name, String phone, String email, String city, boolean active) {
        this.institution = institution;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.city = city;
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
    
    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        this.createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}
