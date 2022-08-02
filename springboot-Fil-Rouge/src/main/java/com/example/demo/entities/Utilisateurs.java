package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class Utilisateurs.
 */
@Entity
public class Utilisateurs {

	/** The id user. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer id_user;
	
	/** The nom. */
	private String nom;
	
	/** The prenom. */
	private String prenom;
	
	/** The mdp. */
	private String mdp;
	
	/** The email. */
	private String email;

	/** The session. */
	// liaison M to M entity User->Session
	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Session> session = new ArrayList<Session>();

	/** The role. */
	// liaison M to M entity User->Role
	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Role> role = new ArrayList<Role>();

	/** The userdetails. */
	// liaison O to O entity User->userDetails
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private UtilisateursDetails userdetails = new UtilisateursDetails();

	/** The prerequis. */
	// liaison M to M entity Utilisateurs -> Prerequis
	@ManyToMany (cascade = { CascadeType.ALL })
	private List<Prerequis> prerequis = new ArrayList<Prerequis>();
	
	/**
	 * Instantiates a new utilisateurs.
	 */
	public Utilisateurs() {
		super();
	}

	/**
	 * Instantiates a new utilisateurs.
	 *
	 * @param id_user the id user
	 * @param nom the nom
	 * @param prenom the prenom
	 * @param mdp the mdp
	 * @param email the email
	 * @param session the session
	 * @param role the role
	 * @param userdetails the userdetails
	 */
	public Utilisateurs(Integer id_user, String nom, String prenom, String mdp, String email, List<Session> session,
			List<Role> role, UtilisateursDetails userdetails) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.email = email;
		this.session = session;
		this.role = role;
		this.userdetails = userdetails;
	}

	/**
	 * Gets the id user.
	 *
	 * @return the id user
	 */
	public Integer getId_user() {
		return id_user;
	}

	/**
	 * Sets the id user.
	 *
	 * @param id_user the new id user
	 */
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Sets the prenom.
	 *
	 * @param prenom the new prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Gets the mdp.
	 *
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Sets the mdp.
	 *
	 * @param mdp the new mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	public List<Session> getSession() {
		return session;
	}

	/**
	 * Sets the session.
	 *
	 * @param session the new session
	 */
	public void setSession(List<Session> session) {
		this.session = session;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public List<Role> getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(List<Role> role) {
		this.role = role;
	}

	/**
	 * Gets the userdetails.
	 *
	 * @return the userdetails
	 */
	public UtilisateursDetails getUserdetails() {
		return userdetails;
	}

	/**
	 * Sets the userdetails.
	 *
	 * @param userdetails the new userdetails
	 */
	public void setUserdetails(UtilisateursDetails userdetails) {
		this.userdetails = userdetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", mdp=" + mdp + ", email=" + email
				+ ", session=" + session + ", role=" + role + ", userdetails=" + userdetails + "]";
	}
}
	