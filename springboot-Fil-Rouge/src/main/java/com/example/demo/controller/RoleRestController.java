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
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Role;
import com.example.demo.service.IService;

import antlr.collections.List;

@RestController
@CrossOrigin(origins = "*")
public class RoleRestController {
	@Autowired
	private IService<F> utilisateurService;

	@Autowired
	private RoleService roleService;

	// http://localhost:8080/formations
	@GetMapping(value = "/role")
	public List<Role> showAll() {
		return (List<Role>) roleService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/roles")
	public Role save(@RequestBody roleService th) {
		return roleService.saveOrUpdate(th);
	}

	@PutMapping(value = "/roles/{id}")
	public ResponseEntity<RoletService> edit(@RequestBody Role roleService, @PathVariable("id") Integer id) {
		roleService RoleToUpdate = roleService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role is not found with id : " + id));

		roleToUpdate.setNom(role.getNom());
		roleToUpdate.setPrenom(role.getPrenom());
		roleToUpdate.setRole(role.getRole());

		return new ResponseEntity<>(roleService.saveOrUpdate(Role), HttpStatus.OK);
	}

	// http://localhost:8080/personnes/3
	@DeleteMapping("/roles/{id}")
	public String deleteById(@PathVariable Integer id) {
		roleService.deleteOneroleById(id, id);
		return "Deleted successfully !";

	}
}
