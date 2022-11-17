package com.example.fitxplore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_DETAILS")
public class Client extends Subscriber{
    private double weight;
    private double heigth;
    private int age;
    private boolean medications;
    @Column(length = 1000)
    private String aboutMedications;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMedications() {
        return medications;
    }

    public void setMedications(boolean medications) {
        this.medications = medications;
    }

    public String getAboutMedications() {
        return aboutMedications;
    }

    public void setAboutMedications(String aboutMedications) {
        this.aboutMedications = aboutMedications;
    }

    @Override
    public String toString() {
        return "Client{" + "userName='" + getUserName()+ '\'' +
                ", FirstName='" + getFirstName() + '\'' +
                ", LastName='" + getLastName() + '\'' +
                ", contactNumber='" + getContactNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", sex='" + getSex() + '\'' +
                ", city='" + getCity() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", state='" + getState() + '\'' +
                ", address1='" + getAddress1() + '\'' +
                ", address2='" + getAddress2() + '\'' +
                ", zipCode=" + getZipCode() +
                 "weight=" + weight +
                ", heigth=" + heigth +
                ", age=" + age +
                ", medications=" + medications +
                ", aboutMedications='" + aboutMedications + '\'' +
                '}';
    }
}
