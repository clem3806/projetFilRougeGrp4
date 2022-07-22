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
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_role;
	private String title;
	
	// liaison O to O entity Role->User
		@ManyToMany(cascade = { CascadeType.ALL })
		private List<User> user = new ArrayList<User>();


	public Role() {
		super();
	}

	public Role(String id_role, String title) {
		super();
		this.id_role = id_role;
		this.title = title;
	}

	public String getId_role() {
		return id_role;
	}

	public void setId_role(String id_role) {
		this.id_role = id_role;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Role [id_role=" + id_role + ", title=" + title + "]";
	}

}
