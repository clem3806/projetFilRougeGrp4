package com.example.demo.dao;

import com.example.demo.entities.Prerequis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrerequisRepository extends JpaRepository<Prerequis, Integer> {

}
