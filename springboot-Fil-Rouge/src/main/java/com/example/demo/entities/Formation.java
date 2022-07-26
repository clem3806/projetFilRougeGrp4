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

// TODO: Auto-generated Javadoc
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
	
	/** The id theme. */
	private String id_theme;
	
	/** The id prerequis. */
	private String id_prerequis;
	
	/** The id contact. */
	private String id_contact;

	/** The contact. */
	// liaison O to O entity Formation->Contact
	@OneToOne(cascade = { CascadeType.ALL })
	private Contact contact = new Contact();

	/** The prerequis. */
	// liaison O to O entity Formation->Prerequis
	@OneToOne(cascade = { CascadeType.ALL })
	private Prerequis prerequis = new Prerequis();

	/** The session. */
	// liaison O to M entity Formation->Session
	@OneToMany(cascade = { CascadeType.ALL })
	private List<Session> session = new ArrayList<Session>();

	/** The theme. */
	// liaison M to O entity Formation->Theme
	@ManyToOne(cascade = { CascadeType.ALL })
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
	public Formation(String id_Formation, String libelle, String id_theme, String id_prerequis, String id_contact) {
		super();
		this.id_Formation = id_Formation;
		this.libelle = libelle;
		this.id_theme = id_theme;
		this.id_prerequis = id_prerequis;
		this.id_contact = id_contact;
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

	/**
	 * Gets the id theme.
	 *
	 * @return the id theme
	 */
	public String getId_theme() {
		return id_theme;
	}

	/**
	 * Sets the id theme.
	 *
	 * @param id_theme the new id theme
	 */
	public void setId_theme(String id_theme) {
		this.id_theme = id_theme;
	}

	/**
	 * Gets the id prerequis.
	 *
	 * @return the id prerequis
	 */
	public String getId_prerequis() {
		return id_prerequis;
	}

	/**
	 * Sets the id prerequis.
	 *
	 * @param id_prerequis the new id prerequis
	 */
	public void setId_prerequis(String id_prerequis) {
		this.id_prerequis = id_prerequis;
	}

	/**
	 * Gets the id contact.
	 *
	 * @return the id contact
	 */
	public String getId_contact() {
		return id_contact;
	}

	/**
	 * Sets the id contact.
	 *
	 * @param id_contact the new id contact
	 */
	public void setId_contact(String id_contact) {
		this.id_contact = id_contact;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Formation [id_Formation=" + id_Formation + ", libelle=" + libelle + ", id_theme=" + id_theme
				+ ", id_prerequis=" + id_prerequis + ", id_contact=" + id_contact + "]";
	}

}
