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
public class Domaine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_domaine;
	private String libelle;
	
	// liaison O to O entity Domaine->Theme
		@OneToMany(cascade = { CascadeType.ALL })
		private List<Theme> theme = new ArrayList<Theme>();


	public Domaine() {
		super();
	}

	public Domaine(String id_domaine, String libelle) {
		super();
		this.id_domaine = id_domaine;
		this.libelle = libelle;
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
		return "Domaine [id_domaine=" + id_domaine + ", libelle=" + libelle + "]";
	}

}
