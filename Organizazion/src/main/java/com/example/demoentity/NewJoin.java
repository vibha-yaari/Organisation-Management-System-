package com.example.demoentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.geo.Shape;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="newJoin")
public class NewJoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String skills;

  @JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING )
    private String dateOfJoin;
    private String designation;

    public NewJoin() {
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

    public String getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}