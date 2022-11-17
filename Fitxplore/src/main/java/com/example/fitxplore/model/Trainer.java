package com.example.fitxplore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TRAINER_DETAILS")
public class Trainer extends Subscriber {
    private String image;
    private String workoutType;
    private String achievementFile;
    @Column(length = 1802)
    private String description;
    private int workExperience;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public String getAchievementFile() {
        return achievementFile;
    }

    public void setAchievementFile(String file) {
        this.achievementFile = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer trainer)) return false;
        if (!super.equals(o)) return false;
        return getWorkExperience() == trainer.getWorkExperience() && Objects.equals(getImage(), trainer.getImage()) && Objects.equals(getWorkoutType(), trainer.getWorkoutType()) && Objects.equals(getAchievementFile(), trainer.getAchievementFile()) && Objects.equals(getDescription(), trainer.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getImage(), getWorkoutType(), getAchievementFile(), getDescription(), getWorkExperience());
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "userName='" + getUserName()+ '\'' +
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
                "image='" + image + '\'' +
                ", workoutType='" + workoutType + '\'' +
                ", achievementsFile='" + achievementFile + '\'' +
                ", description='" + description + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }
}
