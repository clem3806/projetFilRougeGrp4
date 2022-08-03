package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
 * The Class Formation.
 */
@Entity
public class Formation {

	/** The id formation. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_Formation;
	
	/** The libelle. */
	private String libelle;
	
	/** The contact. */
	// liaison O to O entity Formation->Contact
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_contact")
	private Contact contact = new Contact();

	/** The prerequis. */
	// liaison M to M entity Formation->Prerequis
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "prerequis_formation", joinColumns = { @JoinColumn(name = "id_Formation") }, inverseJoinColumns = { @JoinColumn(name = "id_prerequis") })
	private List<Prerequis> prerequis = new ArrayList<Prerequis>();

	/** The session. */
	// liaison O to M entity Formation->Session
	@OneToMany(cascade = { CascadeType.ALL })
	private List<Session> session = new ArrayList<Session>();

	/** The theme. */
	// liaison M to O entity Formation->Theme
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
	 * @param id_Formation the id formation
	 * @param libelle the libelle
	 * @param id_theme the id theme
	 * @param id_prerequis the id prerequis
	 * @param id_contact the id contact
	 */
	public Formation(String id_Formation, String libelle) {
		super();
		this.id_Formation = id_Formation;
		this.libelle = libelle;
	}

	/**
	 * Gets the id formation.
	 *
	 * @return the id formation
	 */
	public String getId_Formation() {
		return id_Formation;
	}

	/**
	 * Sets the id formation.
	 *
	 * @param id_Formation the new id formation
	 */
	public void setId_Formation(String id_Formation) {
		this.id_Formation = id_Formation;
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
		return "Formation [id_Formation=" + id_Formation + ", libelle=" + libelle + "]";
	}

}
