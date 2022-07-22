package com.example.demo.models;

import javax.persistence.Entity;

@Entity
public class UserDetails {

	private Integer User;
	private Integer User_Details;
	private String rue;
	private String ville;
	private String entreprise;
	private String code_postal;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub

	}

	public UserDetails(Integer user, Integer user_Details, String rue, String ville, String entreprise,
			String code_postal) {
		super();
		User = user;
		User_Details = user_Details;
		this.rue = rue;
		this.ville = ville;
		this.entreprise = entreprise;
		this.code_postal = code_postal;
	}

	public Integer getUser() {
		return User;
	}

	public void setUser(Integer user) {
		User = user;
	}

	public Integer getUser_Details() {
		return User_Details;
	}

	public void setUser_Details(Integer user_Details) {
		User_Details = user_Details;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	@Override
	public String toString() {
		return "UserDetails [User=" + User + ", User_Details=" + User_Details + ", rue=" + rue + ", ville=" + ville
				+ ", entreprise=" + entreprise + ", code_postal=" + code_postal + "]";
	}

}
