package com.example.demo.models;

import javax.persistence.Entity;

@Entity
public class User {

	private Integer id_user;
	private String nom;
	private String prenom;
	private String mdp;
	private String email;
	private Integer id_user_details;

	public User() {
		super();
	}

	public User(Integer id_user, String nom, String prenom, String mdp, String email, Integer id_user_details) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.email = email;
		this.id_user_details = id_user_details;
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

	public Integer getId_user_details() {
		return id_user_details;
	}

	public void setId_user_details(Integer id_user_details) {
		this.id_user_details = id_user_details;
	}

}
