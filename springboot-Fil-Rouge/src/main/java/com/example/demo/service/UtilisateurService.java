package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entities.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class UtilisateurService implements IService<Utilisateurs> {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateurs> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateurs saveOrUpdate(Utilisateurs o) {
		return utilisateurRepository.save(o);
	}

	@Override
	public Optional<Utilisateurs> findById(Integer id) {
		return utilisateurRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		utilisateurRepository.deleteById(id);
	}

}
