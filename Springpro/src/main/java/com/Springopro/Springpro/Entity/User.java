package com.Springopro.Springpro.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "student")
    private boolean student;
    @Column(name = "id_train")
    private int id_train;
    @Column(name = "id_seat")
    private int id_seat;

    @ManyToOne
    @JoinColumn(name = "id_train", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private Train train;

    public int getId() {
        return id;
    }

    public int getId_train() {
        return id_train;
    }

    public String getName() {
        return name;
    }

    public boolean isStudent() {
        return student;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_seat() {
        return id_seat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public void setId_train(int id_train) {
        this.id_train = id_train;
    }

    public void setId_seat(int id_seat) {
        this.id_seat = id_seat;
    }
}