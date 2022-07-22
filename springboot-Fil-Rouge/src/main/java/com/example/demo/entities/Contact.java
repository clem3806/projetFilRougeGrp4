package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Contact {

	private String id_contact ;
	
	// liaison O to O entity Contact->Formation
	@OneToOne(cascade = { CascadeType.ALL })
	private List<Formation> formation = new ArrayList<Formation>();

	public Contact() {
		super();
	}

	public Contact(String id_contact) {
		super();
		this.id_contact = id_contact;
	}

	public String getId_contact() {
		return id_contact;
	}

	public void setId_contact(String id_contact) {
		this.id_contact = id_contact;
	}

	@Override
	public String toString() {
		return "Contact [id_contact=" + id_contact + "]";
	}
	
}
