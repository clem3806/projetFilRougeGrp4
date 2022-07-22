package com.example.demo.models;

import javax.persistence.Entity;

@Entity
public class Session {

	private String id_session;
	private String libelle;
	private String id_Formation;
	private Integer date;

	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Session(String id_session, String libelle, String id_Formation, Integer date) {
		super();
		this.id_session = id_session;
		this.libelle = libelle;
		this.id_Formation = id_Formation;
		this.date = date;
	}

	public String getId_session() {
		return id_session;
	}

	public void setId_session(String id_session) {
		this.id_session = id_session;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getId_Formation() {
		return id_Formation;
	}

	public void setId_Formation(String id_Formation) {
		this.id_Formation = id_Formation;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Session [id_session=" + id_session + ", libelle=" + libelle + ", id_Formation=" + id_Formation
				+ ", date=" + date + "]";
	}

}
