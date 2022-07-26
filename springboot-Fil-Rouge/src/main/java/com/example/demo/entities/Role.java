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
 * The Class Role.
 */
@Entity
public class Role {
	
	/** The id role. */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private String id_role;
	
	/** The title. */
	private String title;
	
	/** The user. */
	// liaison O to O entity Role->User
		@ManyToMany(cascade = { CascadeType.ALL })
		private List<Utilisateurs> user = new ArrayList<Utilisateurs>();


	/**
	 * Instantiates a new role.
	 */
	public Role() {
		super();
	}

	/**
	 * Instantiates a new role.
	 *
	 * @param id_role the id role
	 * @param title the title
	 */
	public Role(String id_role, String title) {
		super();
		this.id_role = id_role;
		this.title = title;
	}

	/**
	 * Gets the id role.
	 *
	 * @return the id role
	 */
	public String getId_role() {
		return id_role;
	}

	/**
	 * Sets the id role.
	 *
	 * @param id_role the new id role
	 */
	public void setId_role(String id_role) {
		this.id_role = id_role;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Role [id_role=" + id_role + ", title=" + title + "]";
	}

}
