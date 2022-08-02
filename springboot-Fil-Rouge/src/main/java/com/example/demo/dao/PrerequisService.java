package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Prerequis;
import com.example.demo.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class PrerequisService implements IService<Prerequis> {

	@Autowired
	private PrerequisRepository prerequisRepository;

	@Override
	public List<Prerequis> findAll() {
		return prerequisRepository.findAll();
	}

	@Override
	public Prerequis saveOrUpdate(Prerequis o) {
		return prerequisRepository.save(o);
	}

	@Override
	public Optional<Prerequis> findById(Integer id) {
		return prerequisRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		prerequisRepository.deleteById(id);
	}

}
