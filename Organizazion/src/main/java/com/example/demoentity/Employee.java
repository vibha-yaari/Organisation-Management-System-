package com.example.demoentity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity
@Table(name =" employee")
public class Employee {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
		private Long id;
	private String name;
	private String skills;
	private String designation;
	@JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING )
	private String dateOfJoin;
	public Employee() {
		
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
}
