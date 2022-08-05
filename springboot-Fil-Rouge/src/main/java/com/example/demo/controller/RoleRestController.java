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

import com.example.demo.entities.Role;
import com.example.demo.entities.Utilisateurs;
import com.example.demo.service.IService;
import com.example.demo.service.RoleService;


/**
 * The Class RoleRestController.
 */
@RestController
@CrossOrigin(origins = "*")
public class RoleRestController {

	/** The utilisateur service. */
	@Autowired
	private IService<Utilisateurs> utilisateurService;

	/** The role service. */
	@Autowired
	private RoleService roleService;

	/**
	 * Show all.
	 *
	 * @return the list
	 */
	// http://localhost:8080/formations
	@GetMapping(value = "/role")
	public List<Role> showAll() {
		return (List<Role>) roleService.findAll();
	}

	/**
	 * Save.
	 *
	 * @param r the r
	 * @return the role
	 */
	// http://localhost:8080/formations
	@PostMapping(value = "/roles")
	public Role save(@RequestBody Role r) {
		return roleService.saveOrUpdate(r);
	}

	/**
	 * Edits the.
	 *
	 * @param role the role
	 * @param id the id
	 * @return the response entity
	 */
	@PutMapping(value = "/roles/{id}")
	public ResponseEntity<Role> edit(@RequestBody Role role, @PathVariable("id") Integer id) {
		Role RoleToUpdate = roleService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role is not found with id : " + id));

		RoleToUpdate.setId_role(role.getId_role());
		RoleToUpdate.setTitle(role.getTitle());

		return new ResponseEntity<>(roleService.saveOrUpdate(role), HttpStatus.OK);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the string
	 */
	// http://localhost:8080/personnes/3
	@DeleteMapping("/roles/{id}")
	public String deleteById(@PathVariable Integer id) {
		roleService.delete(id);
		return "Deleted successfully !";

	}
}
