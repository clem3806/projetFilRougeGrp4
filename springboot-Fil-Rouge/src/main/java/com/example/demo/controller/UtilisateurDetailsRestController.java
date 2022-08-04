package com.example.demo.service;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurDetailsRestController {

	@Autowired
	private IService<F> utilisateursDetailsService;

	@Autowired
	private FormationService formationService;

	// http://localhost:8080/formations
	@GetMapping(value = "/utilisateur")
	public List<UtilisateursDetails> showAll() {
		return (List<UtilisateursDetails>) utilisateursDetailsService.findAll();
	}

	// http://localhost:8080/formations
	@PostMapping(value = "/formations")
	public utilisateursDetailsService save(@RequestBody utilisateursDetailsService ud) {
		return utilisateursDetailsService.saveOrUpdate(ud);
	}

	@PutMapping(value = "/utilisateurss/{id}")
	public ResponseEntity<utilisateursDetailsService> edit(@RequestBody UtilisateursDetails utilisateursdetails,
			@PathVariable("id") Integer id) {
		utilisateursDetailsService personToUpdate = utilisateursDetailsService.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person is not found with id : " + id));

		personToUpdate.setNom(utilisateurs.getNom());
		personToUpdate.setPrenom(utilisateurs.getPrenom());
		personToUpdate.setRole(utilisateurs.getRole());

		return new ResponseEntity<>(utilisateursDetailsService.saveOrUpdate(utilisateurs), HttpStatus.OK);
	}

	// http://localhost:8080/personnes/3
	@DeleteMapping("/formations/{id}")
		public String deleteById(@PathVariable Integer id) {
			utilisateursDetailsService.deleteOneUtilisateursDetailsById(id, id);
			return "Deleted successfully !";

	
}
