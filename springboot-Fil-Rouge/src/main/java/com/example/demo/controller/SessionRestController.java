package com.example.demo.controller;

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

import com.example.demo.entities.Session;
import com.example.demo.service.IService;

import antlr.collections.List;

@RestController
@CrossOrigin(origins = "*")
public class SessionRestController<F> {

	
	Autowired
	private IService<F> utilisateurService;

	@Autowired
	private SessionService sessionService;

	// http://localhost:8080/formations
	@GetMapping(value = "/session")
	public List<Session> showAll() {
		return (List<Session>) sessionService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/sessions")
	public Session save(@RequestBody sessionService th) {
		return sessionService.saveOrUpdate(th);
	}

	@PutMapping(value = "/sessions/{id}")
	public ResponseEntity<SessiontService> edit(@RequestBody Session sessionService, @PathVariable("id") Integer id) {
		sessionService SessionToUpdate = sessionService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session is not found with id : " + id));

		sessionToUpdate.setNom(session.getNom());
		sessionToUpdate.setPrenom(session.getPrenom());
		sessionToUpdate.setsession(session.getSession());

		return new ResponseEntity<>(sessionService.saveOrUpdate(Session), HttpStatus.OK);
	}

	// http://localhost:8080/personnes/3
	@DeleteMapping("/sessions/{id}")
	public String deleteById(@PathVariable Integer id) {
		sessionService.deleteOnesessionById(id, id);
		return "Deleted successfully !";

	}
}
