package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Prerequis.
 */
public class Prerequis {

	/** The id prerequis. */
	private String id_prerequis ;
	
	/** The formation. */
	// liaison O to O entity Prerequis ->Formation
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Formation formation = new Formation();

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
	public Prerequis(String id_prerequis) {
		super();
		this.id_prerequis = id_prerequis;
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
	
	
}
