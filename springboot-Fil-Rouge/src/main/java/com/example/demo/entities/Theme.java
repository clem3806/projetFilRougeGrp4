package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
	
	
	/** The libelle. */
	private String libelle;
	
		/** The formation. */
		// liaison O to M entity Theme->Formation
		@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "theme")
		private List<Formation> formation = new ArrayList<Formation>();

		/** The domaine. */
		// liaison M to O entity Theme->Domaine
		@ManyToOne(cascade = { CascadeType.ALL })
		@JoinColumn(name = "theme")
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
	 * @param libelle the libelle
	 */
	public Theme(String id_theme, String libelle) {
		super();
		this.id_theme = id_theme;
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
		return "Theme [id_theme=" + id_theme + ", libelle=" + libelle + "]";
	}

}
