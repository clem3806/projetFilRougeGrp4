package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Role;
import com.example.demo.service.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class RoleService implements IService<Role> {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role saveOrUpdate(Role o) {
		return roleRepository.save(o);
	}

	@Override
	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		roleRepository.deleteById(id);
	}

}
