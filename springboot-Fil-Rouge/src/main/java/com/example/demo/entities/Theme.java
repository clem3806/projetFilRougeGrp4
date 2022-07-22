package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Theme {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_theme;
	private String id_domaine;
	private String libelle;
	
	// liaison O to O entity Theme->Formation
		@OneToMany(cascade = { CascadeType.ALL })
		private List<Formation> formation = new ArrayList<Formation>();
		
		// liaison O to O entity Theme->Domaine
		@ManyToOne(cascade = { CascadeType.ALL })
		private List<Domaine> domaine = new ArrayList<Domaine>();


	public Theme() {
		super();
	}

	public Theme(String id_theme, String id_domaine, String libelle) {
		super();
		this.id_theme = id_theme;
		this.id_domaine = id_domaine;
		this.libelle = libelle;
	}

	public String getId_theme() {
		return id_theme;
	}

	public void setId_theme(String id_theme) {
		this.id_theme = id_theme;
	}

	public String getId_domaine() {
		return id_domaine;
	}

	public void setId_domaine(String id_domaine) {
		this.id_domaine = id_domaine;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Theme [id_theme=" + id_theme + ", id_domaine=" + id_domaine + ", libelle=" + libelle + "]";
	}

}
