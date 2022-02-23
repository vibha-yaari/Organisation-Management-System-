package com.example.demoentity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
@Table(name="LeaNextMon")
public class LeaNextMon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String skills;
    @JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING )
    private String dateOfLeave;
    private String designation;

    public LeaNextMon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDateOfLeave() {
        return dateOfLeave;
    }

    public void setDateOfLeave(String dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

