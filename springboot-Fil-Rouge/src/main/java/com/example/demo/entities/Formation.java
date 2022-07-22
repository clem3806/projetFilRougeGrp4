package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_Formation;
	private String libelle;
	private String id_theme;
	private String id_prerequis;
	private String id_contact;

	// liaison O to O entity Formation->Contact
	@OneToOne(cascade = { CascadeType.ALL })
	private List<Contact> contact = new ArrayList<Contact>();

	// liaison O to O entity Formation->Prerequis
	@OneToOne(cascade = { CascadeType.ALL })
	private List<Prerequis> prerequis = new ArrayList<Prerequis>();

	// liaison O to O entity Formation->Session
	@OneToMany(cascade = { CascadeType.ALL })
	private List<Session> session = new ArrayList<Session>();

	// liaison O to O entity Formation->Theme
	@OneToMany(cascade = { CascadeType.ALL })
	private List<Theme> theme = new ArrayList<Theme>();

	public Formation() {
		super();
	}

	public Formation(String id_Formation, String libelle, String id_theme, String id_prerequis, String id_contact) {
		super();
		this.id_Formation = id_Formation;
		this.libelle = libelle;
		this.id_theme = id_theme;
		this.id_prerequis = id_prerequis;
		this.id_contact = id_contact;
	}

	public String getId_Formation() {
		return id_Formation;
	}

	public void setId_Formation(String id_Formation) {
		this.id_Formation = id_Formation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getId_theme() {
		return id_theme;
	}

	public void setId_theme(String id_theme) {
		this.id_theme = id_theme;
	}

	public String getId_prerequis() {
		return id_prerequis;
	}

	public void setId_prerequis(String id_prerequis) {
		this.id_prerequis = id_prerequis;
	}

	public String getId_contact() {
		return id_contact;
	}

	public void setId_contact(String id_contact) {
		this.id_contact = id_contact;
	}

	@Override
	public String toString() {
		return "Formation [id_Formation=" + id_Formation + ", libelle=" + libelle + ", id_theme=" + id_theme
				+ ", id_prerequis=" + id_prerequis + ", id_contact=" + id_contact + "]";
	}

}
