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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Formation;
import com.example.demo.entities.Utilisateurs;
import com.example.demo.service.FormationService;
import com.example.demo.service.IService;

// TODO: Auto-generated Javadoc
/**
 * The Class FormationRestController.
 */
@RestController
@CrossOrigin(origins = "*")
public class FormationRestController {

	/** The utilisateur service. */
	@Autowired
	private IService<Utilisateurs> utilisateurService;

	/** The formation service. */
	@Autowired
	private FormationService formationService;

	/**
	 * Show all.
	 *
	 * @return the list
	 */
	// http://localhost:8080/formations
	@GetMapping(value = "/formations")
	public List<Formation> showAll() {
		return formationService.findAll();
	}

	/**
	 * Save.
	 *
	 * @param f the f
	 * @return the formation
	 */
	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public Formation save(@RequestBody Formation f) {
		return formationService.saveOrUpdate(f);
	}

	/**
	 * Gets the one.
	 *
	 * @param id the id
	 * @return the one
	 */
	@GetMapping(value = "/formations/{id}")
	public ResponseEntity<Formation> getOne(@PathVariable("id") int id) {
		Formation f = formationService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "formation not found with id"));
		return new ResponseEntity<>(f, HttpStatus.OK);
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
		formationService.delete(id);
		return "Deleted successfully !";
	}

}
