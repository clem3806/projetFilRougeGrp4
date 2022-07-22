package com.example.demo.entities;

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
	private Integer id_User_Details;
	private String rue;
	private String ville;
	private String entreprise;
	private String code_postal;

	// liaison O to O entity UserDetails->User
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private User user = new User();

	public UserDetails() {
		super();
	}

	public UserDetails(Integer id_User_Details, String rue, String ville, String entreprise, String code_postal,
			User user) {
		super();
		this.id_User_Details = id_User_Details;
		this.rue = rue;
		this.ville = ville;
		this.entreprise = entreprise;
		this.code_postal = code_postal;
		this.user = user;
	}

	public Integer getId_User_Details() {
		return id_User_Details;
	}

	public void setId_User_Details(Integer id_User_Details) {
		this.id_User_Details = id_User_Details;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetails [id_User_Details=" + id_User_Details + ", rue=" + rue + ", ville=" + ville + ", entreprise="
				+ entreprise + ", code_postal=" + code_postal + ", user=" + user + "]";
	}

}
