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

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer id_user;
	private String nom;
	private String prenom;
	private String mdp;
	private String email;

	// liaison M to M entity User->Session
	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Session> session = new ArrayList<Session>();

	// liaison M to M entity User->Role
	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Role> role = new ArrayList<Role>();

	// liaison O to O entity User->userDetails
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private UserDetails userdetails = new UserDetails();

	public User() {
		super();
	}

	public User(Integer id_user, String nom, String prenom, String mdp, String email, List<Session> session,
			List<Role> role, UserDetails userdetails) {
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

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Session> getSession() {
		return session;
	}

	public void setSession(List<Session> session) {
		this.session = session;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", mdp=" + mdp + ", email=" + email
				+ ", session=" + session + ", role=" + role + ", userdetails=" + userdetails + "]";
	}
}
	