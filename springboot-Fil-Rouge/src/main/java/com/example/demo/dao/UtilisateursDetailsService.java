package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.UtilisateursDetails;
import com.example.demo.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class UtilisateursDetailsService implements IService<UtilisateursDetails> {

	@Autowired
	private UtilisateursDetailsRepository utilisateurDetailsRepository;

	@Override
	public List<UtilisateursDetails> findAll() {
		return utilisateurDetailsRepository.findAll();
	}

	@Override
	public UtilisateursDetails saveOrUpdate(UtilisateursDetails o) {
		return utilisateurDetailsRepository.save(o);
	}

	@Override
	public Optional<UtilisateursDetails> findById(Integer id) {
		return utilisateurDetailsRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		utilisateurDetailsRepository.deleteById(id);
	}

}
