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

// TODO: Auto-generated Javadoc
/**
 * The Class Theme.
 */
@Entity
public class Theme {

	/** The id theme. */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_theme;
	
	/** The id domaine. */
	private String id_domaine;
	
	/** The libelle. */
	private String libelle;
	
		/** The formation. */
		// liaison O to M entity Theme->Formation
		@OneToMany(cascade = { CascadeType.ALL })
		private List<Formation> formation = new ArrayList<Formation>();

		/** The domaine. */
		// liaison M to O entity Theme->Domaine
		@ManyToOne(cascade = { CascadeType.ALL })
		private Domaine domaine = new Domaine();


	/**
	 * Instantiates a new theme.
	 */
	public Theme() {
		super();
	}

	/**
	 * Instantiates a new theme.
	 *
	 * @param id_theme the id theme
	 * @param id_domaine the id domaine
	 * @param libelle the libelle
	 */
	public Theme(String id_theme, String id_domaine, String libelle) {
		super();
		this.id_theme = id_theme;
		this.id_domaine = id_domaine;
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
		return "Theme [id_theme=" + id_theme + ", id_domaine=" + id_domaine + ", libelle=" + libelle + "]";
	}

}
