package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 * The Class UtilisateursDetails.
 */
@Entity
public class UtilisateursDetails {

	/** The id user details. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer id_User_Details;
	
	/** The rue. */
	private String rue;
	
	/** The ville. */
	private String ville;
	
	/** The entreprise. */
	private String entreprise;
	
	/** The code postal. */
	private String code_postal;

	/** The user. */
	// liaison O to O entity UserDetails->User
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "id_user")
	private Utilisateurs user = new Utilisateurs();

	/**
	 * Instantiates a new utilisateurs details.
	 */
	public UtilisateursDetails() {
		super();
	}

	/**
	 * Instantiates a new utilisateurs details.
	 *
	 * @param id_User_Details the id user details
	 * @param rue the rue
	 * @param ville the ville
	 * @param entreprise the entreprise
	 * @param code_postal the code postal
	 * @param user the user
	 */
	public UtilisateursDetails(Integer id_User_Details, String rue, String ville, String entreprise, String code_postal,
			Utilisateurs user) {
		super();
		this.id_User_Details = id_User_Details;
		this.rue = rue;
		this.ville = ville;
		this.entreprise = entreprise;
		this.code_postal = code_postal;
		this.user = user;
	}

	/**
	 * Gets the id user details.
	 *
	 * @return the id user details
	 */
	public Integer getId_User_Details() {
		return id_User_Details;
	}

	/**
	 * Sets the id user details.
	 *
	 * @param id_User_Details the new id user details
	 */
	public void setId_User_Details(Integer id_User_Details) {
		this.id_User_Details = id_User_Details;
	}

	/**
	 * Gets the rue.
	 *
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Sets the rue.
	 *
	 * @param rue the new rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Gets the ville.
	 *
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Sets the ville.
	 *
	 * @param ville the new ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Gets the entreprise.
	 *
	 * @return the entreprise
	 */
	public String getEntreprise() {
		return entreprise;
	}

	/**
	 * Sets the entreprise.
	 *
	 * @param entreprise the new entreprise
	 */
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	/**
	 * Gets the code postal.
	 *
	 * @return the code postal
	 */
	public String getCode_postal() {
		return code_postal;
	}

	/**
	 * Sets the code postal.
	 *
	 * @param code_postal the new code postal
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public Utilisateurs getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(Utilisateurs user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "UserDetails [id_User_Details=" + id_User_Details + ", rue=" + rue + ", ville=" + ville + ", entreprise="
				+ entreprise + ", code_postal=" + code_postal + "]";
	}

}
