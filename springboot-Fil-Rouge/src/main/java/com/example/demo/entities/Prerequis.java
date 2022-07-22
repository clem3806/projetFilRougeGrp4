package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class Prerequis {

	private String id_prerequis ;
	
	// liaison O to O entity Prerequis ->Formation
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Formation formation = new Formation();

	public Prerequis() {
		super();
	}

	public Prerequis(String id_prerequis) {
		super();
		this.id_prerequis = id_prerequis;
	}

	public String getId_prerequis() {
		return id_prerequis;
	}

	public void setId_prerequis(String id_prerequis) {
		this.id_prerequis = id_prerequis;
	}

	@Override
	public String toString() {
		return "Prerequis [id_prerequis=" + id_prerequis + "]";
	}
	
	
}
