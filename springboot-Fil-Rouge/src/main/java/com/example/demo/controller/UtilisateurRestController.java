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

import com.example.demo.entities.Formation;
import com.example.demo.entities.Utilisateurs;
import com.example.demo.service.FormationService;
import com.example.demo.service.IService;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurRestController<U, F> {

	@Autowired
	private IService<F> utilisateurService;

	@Autowired
	private FormationService formationService;

	// http://localhost:8080/formations
	@GetMapping(value = "/utilisateur")
	public List<Utilisateurs> showAll() {
		return (List<Utilisateurs>) utilisateurService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public Utilisateurs save(@RequestBody Utilisateurs u) {
		return formationService.saveOrUpdate(u);
	}

	// http://localhost:8080/utilisateurss/1
	@GetMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<Utilisateurs> getOne(@PathVariable("id") int id) {
		Utilisateurs u = utilisateurService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id"));
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@PutMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<Utilisateurs> edit(@RequestBody Utilisateurs utilisateurs, @PathVariable("id") Integer id) {
		Utilisateurs personToUpdate = utilisateurService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person is not found with id : " + id));

		personToUpdate.setNom(utilisateurs.getNom());
		personToUpdate.setPrenom(utilisateurs.getPrenom());
		personToUpdate.setRole(utilisateurs.getRole());

		return new ResponseEntity<>(utilisateurService.saveOrUpdate(utilisateurs), HttpStatus.OK);
	}

}
