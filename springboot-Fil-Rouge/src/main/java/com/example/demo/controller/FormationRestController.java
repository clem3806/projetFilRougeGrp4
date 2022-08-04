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
import com.example.demo.models.Formation;
import com.example.demo.service.FormationService;
import com.example.demo.service.IService;

@RestController
@CrossOrigin(origins = "*")
public class FormationRestController<F> {

	@Autowired
	private IService<F> utilisateurService;

	@Autowired
	private FormationService formationService;

	// http://localhost:8080/formations
	@GetMapping(value = "/formations")
	public List<Formation> showAll() {
		return formationService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public Formation save(@RequestBody Formation f) {
		return formationService.saveOrUpdate(f);
	}

//	@GetMapping("/themes/{themeId}/formations")
//	public ResponseEntity<List<Theme>> getFormationByTheme(@PathVariable(value = "id_formation") Integer id_formation) {
//		utilisateurService.findById(theme_id).orElseThrow(
//				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Formation not found with id : " + id_formation));
//		List<Formation> formation = formationService.getFormationById(id_formation);
//		return new ResponseEntity<>(formation, HttpStatus.OK);
//	}
//	@PostMapping("/themes/{themeId}/formations")
//    public ResponseEntity<Formation> addformationByTheme(@PathVariable(value = "id_theme") Integer id_theme, @RequestBody Formation formation){
//       Formation formationToSave = formationService.saveOneFormationById(id_theme, id_formation).orElseThrow(
//               () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Formation not found with id : " + id_formation));
//       return new ResponseEntity<>(formationToSave, HttpStatus.CREATED);
//    }
	@GetMapping(value = "/formations/{id}")
	public ResponseEntity<Formation> getOne(@PathVariable("id") int id) {
		Formation p = ((Formation) formationService.findById(id))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "formation not found with id"));
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	// http://localhost:8080/personnes/3
	@DeleteMapping("/formations/{id}")
	public String deleteById(@PathVariable Integer id) {
		formationService.deleteOneFormationById(id, id);
		return "Deleted successfully !";
	}

}
