package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * The Class Contact.
 */
public class Contact {

	/** The id contact. */
	private Integer id_contact ;
	
	/** The formation. */
	// liaison O to O entity Contact->Formation
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_formation")
	private Formation formation = new Formation();

	/**
	 * Instantiates a new contact.
	 */
	public Contact() {
		super();
	}

	/**
	 * Instantiates a new contact.
	 *
	 * @param id_contact the id contact
	 */
	public Contact(Integer id_contact) {
		super();
		this.id_contact = id_contact;
	}

	/**
	 * Gets the id contact.
	 *
	 * @return the id contact
	 */
	public Integer getId_contact() {
		return id_contact;
	}

	/**
	 * Sets the id contact.
	 *
	 * @param id_contact the new id contact
	 */
	public void setId_contact(Integer id_contact) {
		this.id_contact = id_contact;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Contact [id_contact=" + id_contact + "]";
	}
	
}
