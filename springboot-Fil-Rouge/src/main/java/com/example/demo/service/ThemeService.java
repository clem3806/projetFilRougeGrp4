package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.ThemeRepository;
import com.example.demo.entities.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class ThemeService implements IService<Theme> {

	@Autowired
	private ThemeRepository themeRepository;

	@Override
	public List<Theme> findAll() {
		return themeRepository.findAll();
	}

	@Override
	public Theme saveOrUpdate(Theme o) {
		return themeRepository.save(o);
	}

	@Override
	public Optional<Theme> findById(Integer id) {
		return themeRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		themeRepository.deleteById(id);
	}

}
