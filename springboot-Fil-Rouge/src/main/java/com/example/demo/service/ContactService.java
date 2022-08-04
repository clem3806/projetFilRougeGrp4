package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.ContactRepository;
import com.example.demo.entities.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personneService")
public class ContactService implements IService<Contact> {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public Contact saveOrUpdate(Contact o) {
		return contactRepository.save(o);
	}

	@Override
	public Optional<Contact> findById(Integer id) {
		return contactRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}

}
