package com.example.demo.dao;


import com.example.demo.entities.UtilisateursDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateursDetailsRepository extends JpaRepository<UtilisateursDetails, Integer> {
	

	
}
