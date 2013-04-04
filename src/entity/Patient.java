package entity;

import event.SaveOrUpdateListener;
import java.util.Date;

public class Patient implements SaveOrUpdateListener {

    private long id;
    private Medic medic;
    private String name;
    private int same;
    private int age;
    private boolean sex;
    private String color;
    private String profession;
    private String address;
    private String city;
    private String bornCity;
    private String phone;
    private Date updatedAt;
    private Date createdAt;
    private boolean active;

    public Patient() {
    }

    public Patient(Medic medic, String name, int same, int age, boolean sex, String color, String profession, String address, String city, String bornCity, String phone, boolean active) {
        this.medic = medic;
        this.name = name;
        this.same = same;
        this.age = age;
        this.sex = sex;
        this.color = color;
        this.profession = profession;
        this.address = address;
        this.city = city;
        this.bornCity = bornCity;
        this.phone = phone;
        this.active = active;
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

    /**
     * @return the sex
     */
    public boolean isSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(boolean sex) {
        this.sex = sex;
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
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
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
    public void onCreate() {
        createdAt = new Date();
    }

    @Override
    public void onUpdate() {
    }
}
