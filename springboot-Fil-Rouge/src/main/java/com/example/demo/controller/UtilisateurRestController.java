package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Utilisateurs;
import com.example.demo.service.FormationService;
import com.example.demo.service.IService;

/**
 * The Class UtilisateurRestController.
 */
@RestController
@CrossOrigin(origins = "*")
public class UtilisateurRestController {

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
	@GetMapping(value = "/utilisateur")
	public List<Utilisateurs> showAll() {
		return (List<Utilisateurs>) utilisateurService.findAll();
	}

	/**
	 * Save.
	 *
	 * @param u the u
	 * @return the utilisateurs
	 */
	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public Utilisateurs save(@RequestBody Utilisateurs u) {
		return utilisateurService.saveOrUpdate(u);
	}

	/**
	 * Gets the one.
	 *
	 * @param id the id
	 * @return the one
	 */
	// http://localhost:8080/utilisateurss/1
	@GetMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<Utilisateurs> getOne(@PathVariable("id") int id) {
		Utilisateurs u = utilisateurService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id"));
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

	/**
	 * Edits the.
	 *
	 * @param utilisateurs the utilisateurs
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<Utilisateurs> edit(@RequestBody Utilisateurs utilisateurs, @PathVariable("id") Integer id) {
		Utilisateurs utilisateurToUpdate = utilisateurService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person is not found with id : " + id));

		utilisateurToUpdate.setNom(utilisateurs.getNom());
		utilisateurToUpdate.setPrenom(utilisateurs.getPrenom());
		utilisateurToUpdate.setMdp(utilisateurs.getMdp());
		utilisateurToUpdate.setEmail(utilisateurs.getEmail());

		return new ResponseEntity<>(utilisateurService.saveOrUpdate(utilisateurs), HttpStatus.OK);
	}

}
