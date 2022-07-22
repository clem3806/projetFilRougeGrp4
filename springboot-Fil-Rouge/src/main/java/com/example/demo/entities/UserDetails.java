package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer User;
	private Integer id_User_Details;
	private String rue;
	private String ville;
	private String entreprise;
	private String code_postal;

	// liaison O to O entity UserDetails->User
	@OneToOne(cascade = { CascadeType.ALL })
	private List<User> user = new ArrayList<User>();

	public UserDetails() {
		super();
	}

	public UserDetails(Integer user, Integer user_Details, String rue, String ville, String entreprise,
			String code_postal) {
		super();
		User = user;
		id_User_Details = user_Details;
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
		return id_User_Details;
	}

	public void setUser_Details(Integer user_Details) {
		id_User_Details = user_Details;
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
		return "UserDetails [User=" + User + ", User_Details=" + id_User_Details + ", rue=" + rue + ", ville=" + ville
				+ ", entreprise=" + entreprise + ", code_postal=" + code_postal + "]";
	}

}
