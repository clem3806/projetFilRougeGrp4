package com.example.demo.controller;

import com.example.demo.entities.Formation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	public String home(ModelMap model) {
		Formation f1 = new Formation("Nom1", "Prenom1", 54);
		Formation f2 = new Formation("Nom2", "Prenom2", 43);
		
}

}