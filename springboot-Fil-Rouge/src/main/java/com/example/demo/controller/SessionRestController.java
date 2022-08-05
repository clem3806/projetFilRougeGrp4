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

import com.example.demo.entities.Session;
import com.example.demo.entities.Utilisateurs;
import com.example.demo.service.IService;
import com.example.demo.service.SessionService;


/**
 * The Class SessionRestController.
 */
@RestController
@CrossOrigin(origins = "*")
public class SessionRestController {

	
	/** The utilisateur service. */
	@Autowired
	private IService<Utilisateurs> utilisateurService;

	/** The session service. */
	@Autowired
	private SessionService sessionService;

	/**
	 * Show all.
	 *
	 * @return the list
	 */
	// http://localhost:8080/formations
	@GetMapping(value = "/session")
	public List<Session> showAll() {
		return (List<Session>) sessionService.findAll();
	}

	/**
	 * Save.
	 *
	 * @param s the s
	 * @return the session
	 */
	// http://localhost:8080/formations
	@PostMapping(value = "/sessions")
	public Session save(@RequestBody Session s) {
		return sessionService.saveOrUpdate(s);
	}

	/**
	 * Edits the.
	 *
	 * @param session the session
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping(value = "/sessions/{id}")
	public ResponseEntity<Session> edit(@RequestBody Session session, @PathVariable("id") Integer id) {
		Session SessionToUpdate = sessionService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session is not found with id : " + id));

		SessionToUpdate.setId_session(session.getId_session());
		SessionToUpdate.setLibelle(session.getLibelle());
		SessionToUpdate.setId_Formation(session.getId_Formation());
		SessionToUpdate.setDate(session.getDate());


		return new ResponseEntity<>(sessionService.saveOrUpdate(session), HttpStatus.OK);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the string
	 */
	// http://localhost:8080/personnes/3
	@DeleteMapping("/sessions/{id}")
	public String deleteById(@PathVariable Integer id) {
		sessionService.delete(id);
		return "Deleted successfully !";

	}
}
