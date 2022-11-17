package com.example.fitxplore.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Subscriber  {
    @Id
    private String userName;
    private String FirstName;
    private String LastName;
    private String contactNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private Date dateOfBirth;
    private Date dateOfSubscription;
    private String sex;
    private String city;
    private String country;
    private String state;
    @Column(length = 500)
    private String address1;
    private String address2;
    private int zipCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfSubscription() {
        return dateOfSubscription;
    }

    public void setDateOfSubscription(Date dateOfSubscription) {
        this.dateOfSubscription = dateOfSubscription;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriber that)) return false;
        return getZipCode() == that.getZipCode() && Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getContactNumber(), that.getContactNumber()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getDateOfBirth(), that.getDateOfBirth()) && Objects.equals(getDateOfSubscription(), that.getDateOfSubscription()) && Objects.equals(getSex(), that.getSex()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getState(), that.getState()) && Objects.equals(getAddress1(), that.getAddress1()) && Objects.equals(getAddress2(), that.getAddress2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getFirstName(), getLastName(), getContactNumber(), getEmail(), getPassword(), getDateOfBirth(), getDateOfSubscription(), getSex(), getCity(), getCountry(), getState(), getAddress1(), getAddress2(), getZipCode());
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "userName='" + userName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfSubscription=" + dateOfSubscription +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
