package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Contact;
import com.example.demo.service.ContactService;
import com.example.demo.service.IService;

/**
 * The Class ContactRestController.
 *
 * @param <F> the generic type
 */
@RestController
@CrossOrigin(origins = "*")
public class ContactRestController<F> {

	/** The utilisateur service. */
	@Autowired
	private IService<F> utilisateurService;

	/** The contact service. */
	@Autowired
	private ContactService contactService;

	/**
	 * Show all.
	 *
	 * @return the list
	 */
	// http://localhost:8080/formations
	@GetMapping(value = "/contact")
	public List<Contact> showAll() {
		return (List<Contact>) contactService.findAll();
	}

	/**
	 * Save.
	 *
	 * @param c the c
	 * @return the contact
	 */
	// http://localhost:8080/formations
	@PostMapping(value = "/contact")
	public Contact save(@RequestBody Contact c) {
		return contactService.saveOrUpdate(c);
	}

	/**
	 * Edits the.
	 *
	 * @param contact the contact
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping(value = "/contacts/{id}")
	public ResponseEntity<Contact> edit(@RequestBody Contact contact, @PathVariable("id") Integer id) {
		Contact contactToUpdate = contactService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found with id : " + id));

		contactToUpdate.setId_contact(contact.getId_contact());

		return new ResponseEntity<>(contactService.saveOrUpdate(contact), HttpStatus.OK);
	}
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the string
	 */
	// http://localhost:8080/personnes/3
	@DeleteMapping("/contact/{id}")
	public String deleteById(@PathVariable Integer id) {
		contactService.delete(id);
		return "Deleted successfully !";

	}

}
