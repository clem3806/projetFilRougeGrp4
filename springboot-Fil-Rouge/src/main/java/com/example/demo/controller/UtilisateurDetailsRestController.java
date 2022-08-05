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

import com.example.demo.entities.Utilisateurs;
import com.example.demo.entities.UtilisateursDetails;
import com.example.demo.service.IService;
import com.example.demo.service.UtilisateursDetailsService;

/**
 * The Class UtilisateurDetailsRestController.
 */
@RestController
@CrossOrigin(origins = "*")
public class UtilisateurDetailsRestController {

	/** The utilisateur service. */
	@Autowired
	private IService<Utilisateurs> utilisateurService;

	/** The utilisateurdetails service. */
	@Autowired
	private UtilisateursDetailsService utilisateurdetailsService;

	/**
	 * Show all.
	 *
	 * @return the list
	 */
	// http://localhost:8080/formations
	@GetMapping(value = "/utilisateur")
	public List<UtilisateursDetails> showAll() {
		return (List<UtilisateursDetails>) utilisateurdetailsService.findAll();
	}

	/**
	 * Save.
	 *
	 * @param p the p
	 * @return the utilisateurs details
	 */
	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public UtilisateursDetails save(@RequestBody UtilisateursDetails p) {
		return utilisateurdetailsService.saveOrUpdate(p);
	}

	/**
	 * Edits the.
	 *
	 * @param utilisateursDetails the utilisateurs details
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<UtilisateursDetails> edit(@RequestBody UtilisateursDetails utilisateursDetails,
			@PathVariable("id") Integer id) {
		UtilisateursDetails utilisateursDetailsToUpdate = utilisateurdetailsService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"UtilisateursDetails is not found with id : " + id));

		utilisateursDetailsToUpdate.setId_User_Details(utilisateursDetails.getId_User_Details());
		utilisateursDetailsToUpdate.setRue(utilisateursDetails.getRue());
		utilisateursDetailsToUpdate.setVille(utilisateursDetails.getVille());
		utilisateursDetailsToUpdate.setEntreprise(utilisateursDetails.getEntreprise());
		utilisateursDetailsToUpdate.setCode_postal(utilisateursDetails.getCode_postal());

		return new ResponseEntity<>(utilisateurdetailsService.saveOrUpdate(utilisateursDetails), HttpStatus.OK);
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
		utilisateurdetailsService.delete(id);
		return "Deleted successfully !";

	}

}
