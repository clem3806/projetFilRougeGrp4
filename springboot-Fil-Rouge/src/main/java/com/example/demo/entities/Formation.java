package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * The Class formation.
 */
@Entity
public class Formation {

	/** The id formation. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_formation;
	
	/** The libelle. */
	private String libelle;
	
	/** The contact. */
	// liaison O to O entity formation->Contact
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_contact")
	private Contact contact = new Contact();

	/** The prerequis. */
	// liaison M to M entity formation->Prerequis
	@ManyToMany(cascade = {  CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE  })
	@JoinTable(name = "prerequis_formation", joinColumns = { @JoinColumn(name = "id_formation") }, inverseJoinColumns = { @JoinColumn(name = "id_prerequis") })
	private List<Prerequis> prerequis = new ArrayList<Prerequis>();

	/** The sessions. */
	// liaison O to M entity formation->Session
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formation")
	private List<Session> sessions = new ArrayList<Session>();

	/** The theme. */
	// liaison M to O entity formation->Theme
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_theme")
	private Theme theme = new Theme();

	/**
	 * Instantiates a new formation.
	 */
	public Formation() {
		super();
	}

	/**
	 * Instantiates a new formation.
	 *
	 * @param id_formation the id formation
	 * @param libelle the libelle
	 */
	public Formation(String id_formation, String libelle) {
		super();
		this.id_formation = id_formation;
		this.libelle = libelle;
	}

	/**
	 * Gets the id formation.
	 *
	 * @return the id formation
	 */
	public String getId_formation() {
		return id_formation;
	}

	/**
	 * Sets the id formation.
	 *
	 * @param id_formation the new id formation
	 */
	public void setId_formation(String id_formation) {
		this.id_formation = id_formation;
	}

	/**
	 * Gets the libelle.
	 *
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 *
	 * @param libelle the new libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "formation [id_formation=" + id_formation + ", libelle=" + libelle + "]";
	}

}
