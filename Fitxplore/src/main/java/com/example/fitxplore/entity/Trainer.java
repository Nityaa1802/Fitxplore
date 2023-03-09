package com.example.fitxplore.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TRAINER_DETAILS")
public class Trainer extends Subscriber {
    private String image;
    private String workoutType;

    private int workExperience;

    private String file;

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

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer trainer)) return false;
        return getWorkExperience() == trainer.getWorkExperience() && Objects.equals(getImage(), trainer.getImage()) && Objects.equals(getWorkoutType(), trainer.getWorkoutType()) && Objects.equals(getFile(), trainer.getFile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImage(), getWorkoutType(), getWorkExperience(), getFile());
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "image='" + image + '\'' +
                ", workoutType='" + workoutType + '\'' +
                ", workExperience=" + workExperience +
                ", file='" + file + '\'' +
                '}';
    }
}