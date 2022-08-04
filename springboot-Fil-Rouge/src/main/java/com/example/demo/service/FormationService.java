package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Formation;
import com.example.demo.dao.FormationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class FormationService implements IService<Formation> {

	@Autowired
	private FormationRepository formationRepository;

	@Override
	public List<Formation> findAll() {
		return formationRepository.findAll();
	}

	@Override
	public Formation saveOrUpdate(Formation o) {
		return formationRepository.save(o);
	}

	@Override
	public Optional<Formation> findById(Integer id) {
		return formationRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		formationRepository.deleteById(id);
	}

}
