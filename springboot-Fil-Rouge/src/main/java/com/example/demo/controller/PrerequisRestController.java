package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.service.IService;

import antlr.collections.List;

public class PrerequisRestController<F> {
	

	@Autowired
	private IService<F> utilisateurService;
	
	@Autowired
	private PrerequisService prerequisService;

	// http://localhost:8080/formations
	@GetMapping(value = "/utilisateur")
	public List<Prerequis> showAll() {
		return (List<Prerequis>) prerequisService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public prerequis save(@RequestBody prerequisService ud) {
		return prerequisService.saveOrUpdate(ud);
	}

	@PutMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<prerequistService> edit(@RequestBody Prerequis prerequisService,
			@PathVariable("id") Integer id) {
		prerequisService prerequisToUpdate = prerequisService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prerequis is not found with id : " + id));

		prerequisToUpdate.setNom(prerequis.getNom());
		prerequisToUpdate.setPrenom(prerequis.getPrenom());
		prerequisToUpdate.setRole(prerequis.getRole());

		return new ResponseEntity<>(prerequisService.saveOrUpdate(prerequis), HttpStatus.OK);
	}

	// http://localhost:8080/personnes/3
	@DeleteMapping("/formations/{id}")
	public String deleteById(@PathVariable Integer id) {
		prerequisService.deleteOnePrerequisById(id, id);
		return "Deleted successfully !";

	}

}
