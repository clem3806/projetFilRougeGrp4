package com.example.demo.dao;

import com.example.demo.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository <Theme, Integer>  {

}
