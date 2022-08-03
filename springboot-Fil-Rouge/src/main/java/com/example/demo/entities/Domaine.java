package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * The Class Domaine.
 */
@Entity
public class Domaine {
	
	/** The id domaine. */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_domaine;
	
	/** The libelle. */
	private String libelle;
	
	/** The theme. */
	// liaison O to M entity Domaine->Theme
		@OneToMany(cascade = { CascadeType.ALL })
		private Theme theme = new Theme();


	/**
	 * Instantiates a new domaine.
	 */
	public Domaine() {
		super();
	}

	/**
	 * Instantiates a new domaine.
	 *
	 * @param id_domaine the id domaine
	 * @param libelle the libelle
	 */
	public Domaine(String id_domaine, String libelle) {
		super();
		this.id_domaine = id_domaine;
		this.libelle = libelle;
	}

	/**
	 * Gets the id domaine.
	 *
	 * @return the id domaine
	 */
	public String getId_domaine() {
		return id_domaine;
	}

	/**
	 * Sets the id domaine.
	 *
	 * @param id_domaine the new id domaine
	 */
	public void setId_domaine(String id_domaine) {
		this.id_domaine = id_domaine;
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
		return "Domaine [id_domaine=" + id_domaine + ", libelle=" + libelle + "]";
	}

}
