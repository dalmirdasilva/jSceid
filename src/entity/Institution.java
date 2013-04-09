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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "institution")
public class Institution implements SaveOrUpdateListener, Serializable {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institution")
    private Set<Medic> medics;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Avatar avatar;
    private String name;
    @Column(name = "web_page")
    private String webPage;
    private String phone;
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
    private boolean active;

    public Institution() {
        name = "";
        webPage = "";
        phone = "";
        active = true;
    }

    public Institution(Address address, Avatar avatar) {
        this();
        this.address = address;
        this.avatar = avatar;
    }

    public Institution(Address address, Avatar avatar, String name, String webPage, String phone) {
        this(address, avatar);
        this.name = name;
        this.webPage = webPage;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Medic> getMedics() {
        return medics;
    }

    public void setMedics(Set<Medic> medics) {
        this.medics = medics;
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

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "{name: " + name + ", web_page: " + webPage + ", phone: " + phone + ", address: " + address + "}";
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
        if (medics != null) {
            for (Medic m : getMedics()) {
                m.setInstitution(this);
            }
        }
    }
}
