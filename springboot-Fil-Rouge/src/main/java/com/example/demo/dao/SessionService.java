package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Session;
import com.example.demo.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class SessionService implements IService<Session> {

	@Autowired
	private SessionRepository sessionRepository;

	@Override
	public List<Session> findAll() {
		return sessionRepository.findAll();
	}

	@Override
	public Session saveOrUpdate(Session o) {
		return sessionRepository.save(o);
	}

	@Override
	public Optional<Session> findById(Integer id) {
		return sessionRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		sessionRepository.deleteById(id);
	}

}
