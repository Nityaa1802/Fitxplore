package com.example.fitxplore.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
public class Client extends Subscriber{
    @ManyToOne
    Trainer trainer;

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "Client{" +
                "trainer=" + trainer +
                '}';
    }
}