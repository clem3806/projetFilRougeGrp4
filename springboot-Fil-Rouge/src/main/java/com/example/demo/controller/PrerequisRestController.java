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

import com.example.demo.entities.Prerequis;
import com.example.demo.entities.Utilisateurs;
import com.example.demo.service.IService;
import com.example.demo.service.PrerequisService;


// TODO: Auto-generated Javadoc
/**
 * The Class PrerequisRestController.
 */
@RestController
@CrossOrigin(origins = "*")
public class PrerequisRestController {

	/** The utilisateur service. */
	@Autowired
	private IService<Utilisateurs> utilisateurService;

	/** The prerequis service. */
	@Autowired
	private PrerequisService prerequisService;

	/**
	 * Show all.
	 *
	 * @return the list
	 */
	// http://localhost:8080/formations
	@GetMapping(value = "/utilisateur")
	public List<Prerequis> showAll() {
		return (List<Prerequis>) prerequisService.findAll();
	}

	/**
	 * Save.
	 *
	 * @param p the p
	 * @return the prerequis
	 */
	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public Prerequis save(@RequestBody Prerequis p) {
		return prerequisService.saveOrUpdate(p);
	}

	/**
	 * Edits the.
	 *
	 * @param prerequis the prerequis
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<Prerequis> edit(@RequestBody Prerequis prerequis,@PathVariable("id") Integer id) {
		Prerequis prerequisToUpdate = prerequisService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prerequis is not found with id : " + id));

		prerequisToUpdate.setId_prerequis(prerequis.getId_prerequis());
		
		return new ResponseEntity<>(prerequisService.saveOrUpdate(prerequis), HttpStatus.OK);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the string
	 */
	// http://localhost:8080/personnes/3
	@DeleteMapping("/formations/{id}")
	public String deleteById(@PathVariable Integer id) {
		prerequisService.delete(id);
		return "Deleted successfully !";

	}

}
