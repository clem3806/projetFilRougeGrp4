package com.example.demo.service;

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

import antlr.collections.List;

@RestController
@CrossOrigin(origins = "*")
public class ContactRestController<F> {

	@Autowired
	private IService<F> utilisateurService;

	@Autowired
	private ContactService contactService;

	// http://localhost:8080/formations
	@GetMapping(value = "/utilisateur")
	public List<Contact> showAll() {
		return (List<Contact>) contactService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public contact save(@RequestBody contactService ud) {
		return contactService.saveOrUpdate(ud);
	}

	@PutMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<contactService> edit(@RequestBody Contact contactService, @PathVariable("id") Integer id) {
		contactService contactToUpdate = contactService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found with id : " + id));

		contactToUpdate.setNom(contact.getNom());
		contactToUpdate.setPrenom(contact.getPrenom());
		contactToUpdate.setRole(contact.getRole());

		return new ResponseEntity<>(contactService.saveOrUpdate(contact), HttpStatus.OK);
	}

	// http://localhost:8080/personnes/3
	@DeleteMapping("/formations/{id}")
	public String deleteById(@PathVariable Integer id) {
		contactService.deleteOneContactById(id, id);
		return "Deleted successfully !";

	}

}
