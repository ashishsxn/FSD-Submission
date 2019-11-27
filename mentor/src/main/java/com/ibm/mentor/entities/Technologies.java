package com.ibm.mentor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Technologies {
	
	@Id
	@Column(length=50)
	private String id;
	private String technology;
	private float fee;
	
	@OneToOne(mappedBy="technologies")
	private Trainings trainings;
	
	
	
	public Technologies() {

	}


	public Technologies(String id, String technology, float fee) {
		super();
		this.id = id;
		this.technology = technology;
		this.fee = fee;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTechnology() {
		return technology;
	}


	public void setTechnology(String technology) {
		this.technology = technology;
	}


	public float getFee() {
		return fee;
	}


	public void setFee(float fee) {
		this.fee = fee;
	}
	
	
	
	

}
