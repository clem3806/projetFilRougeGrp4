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

import com.example.demo.entities.Theme;
import com.example.demo.entities.Utilisateurs;
import com.example.demo.service.IService;
import com.example.demo.service.ThemeService;


// TODO: Auto-generated Javadoc
/**
 * The Class ThemeRestController.
 */
@RestController
@CrossOrigin(origins = "*")
public class ThemeRestController {

	/** The utilisateur service. */
	@Autowired
	private IService<Utilisateurs> utilisateurService;

	/** The theme service. */
	@Autowired
	private ThemeService themeService;

	/**
	 * Show all.
	 *
	 * @return the list
	 */
	// http://localhost:8080/formations
	@GetMapping(value = "/theme")
	public List<Theme> showAll() {
		return (List<Theme>) themeService.findAll();
	}

	/**
	 * Save.
	 *
	 * @param th the th
	 * @return the theme
	 */
	// http://localhost:8080/formations
	@PostMapping(value = "/themes")
	public Theme save(@RequestBody Theme th) {
		return themeService.saveOrUpdate(th);
	}

	/**
	 * Edits the.
	 *
	 * @param theme the theme
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping(value = "/themes/{id}")
	public ResponseEntity<Theme> edit(@RequestBody Theme theme, @PathVariable("id") Integer id) {
		Theme ThemeToUpdate = themeService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theme is not found with id : " + id));

		ThemeToUpdate.setId_theme(theme.getId_theme());
		ThemeToUpdate.setId_domaine(theme.getId_domaine());
		ThemeToUpdate.setLibelle(theme.getLibelle());

		return new ResponseEntity<>(themeService.saveOrUpdate(theme), HttpStatus.OK);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the string
	 */
	// http://localhost:8080/personnes/3
	@DeleteMapping("/themes/{id}")
	public String deleteById(@PathVariable Integer id) {
		themeService.delete(id);
		return "Deleted successfully !";

	}

}
