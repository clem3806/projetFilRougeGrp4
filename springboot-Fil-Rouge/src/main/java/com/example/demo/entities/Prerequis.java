package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

/**
 * The Class Prerequis.
 */
public class Prerequis {

	// on va avoir besoin de modifier ce bordel *énormément*
	/** The id prerequis. */
	private String id_prerequis ;
	/** The id prerequis. */
	private String question ;
	/** The id prerequis. */
	private String reponse ;
	/** The id prerequis. */
	private Boolean resultat ;
	
	/** The formation. */
	// liaison M to M entity Prerequis ->Formation
	@ManyToMany (mappedBy = "prerequis")
	private List<Formation> formations = new ArrayList<Formation>();

	/** The users. */
	// liaison M to M entity Prerequis -> Utilisateurs
	@ManyToMany (mappedBy = "prerequis")
	private List<Formation> users = new ArrayList<Formation>();
	
	/**
	 * Instantiates a new prerequis.
	 */
	public Prerequis() {
		super();
	}

	/**
	 * Instantiates a new prerequis.
	 *
	 * @param id_prerequis the id prerequis
	 */
	public Prerequis(String id_prerequis, Boolean resultat, String reponse, String question) {
		super();
		this.id_prerequis = id_prerequis;
		this.resultat = resultat;
		this.reponse = reponse;
		this.question = question;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Prerequis [id_prerequis=" + id_prerequis + "]";
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Boolean getResultat() {
		return resultat;
	}

	public void setResultat(Boolean resultat) {
		this.resultat = resultat;
	}
	
	
}
