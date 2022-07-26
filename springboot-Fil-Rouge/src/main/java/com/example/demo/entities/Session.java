package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class Session.
 */
@Entity
public class Session {

	/** The id session. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_session;
	
	/** The libelle. */
	private String libelle;
	
	/** The id formation. */
	private String id_Formation;
	
	/** The date. */
	private Integer date;

	/** The formation. */
	// liaison O to O entity Session->Formation
	@ManyToOne(cascade = { CascadeType.ALL })
	private List<Formation> formation = new ArrayList<Formation>();
	
	/** The user. */
	// liaison O to O entity Session->User
	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Utilisateurs> user = new ArrayList<Utilisateurs>();

	/**
	 * Instantiates a new session.
	 */
	public Session() {
		super();
	}

	/**
	 * Instantiates a new session.
	 *
	 * @param id_session the id session
	 * @param libelle the libelle
	 * @param id_Formation the id formation
	 * @param date the date
	 */
	public Session(String id_session, String libelle, String id_Formation, Integer date) {
		super();
		this.id_session = id_session;
		this.libelle = libelle;
		this.id_Formation = id_Formation;
		this.date = date;
	}

	/**
	 * Gets the id session.
	 *
	 * @return the id session
	 */
	public String getId_session() {
		return id_session;
	}

	/**
	 * Sets the id session.
	 *
	 * @param id_session the new id session
	 */
	public void setId_session(String id_session) {
		this.id_session = id_session;
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
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Integer getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Integer date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Session [id_session=" + id_session + ", libelle=" + libelle + ", id_Formation=" + id_Formation
				+ ", date=" + date + "]";
	}

}
