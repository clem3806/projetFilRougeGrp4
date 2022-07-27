package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class Contact.
 */
public class Contact {

	/** The id contact. */
	private String id_contact ;
	
	/** The formation. */
	// liaison O to O entity Contact->Formation
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
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
	public Contact(String id_contact) {
		super();
		this.id_contact = id_contact;
	}

	/**
	 * Gets the id contact.
	 *
	 * @return the id contact
	 */
	public String getId_contact() {
		return id_contact;
	}

	/**
	 * Sets the id contact.
	 *
	 * @param id_contact the new id contact
	 */
	public void setId_contact(String id_contact) {
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
