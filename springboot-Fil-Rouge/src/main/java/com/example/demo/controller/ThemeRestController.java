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

public class ThemeRestController<F> {
	
	@Autowired
	private IService<F> utilisateurService;
	
	@Autowired
	private ThemeService themeService;

	// http://localhost:8080/formations
	@GetMapping(value = "/theme")
	public List<Theme> showAll() {
		return (List<Theme>) themeService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/themes")
	public Theme save(@RequestBody themeService th) {
		return themeService.saveOrUpdate(th);
	}

	@PutMapping(value = "/themes/{id}")
	public ResponseEntity<ThemetService> edit(@RequestBody Theme themeService,
			@PathVariable("id") Integer id) {
		themeService ThemeToUpdate = themeService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Theme is not found with id : " + id));

		themeToUpdate.setNom(theme.getNom());
		themeToUpdate.setPrenom(theme.getPrenom());
		themeToUpdate.setRole(theme.getRole());

		return new ResponseEntity<>(themeService.saveOrUpdate(Theme), HttpStatus.OK);
	}

	// http://localhost:8080/personnes/3
	@DeleteMapping("/themes/{id}")
	public String deleteById(@PathVariable Integer id) {
		themeService.deleteOneThemeById(id, id);
		return "Deleted successfully !";

	}

}


}
