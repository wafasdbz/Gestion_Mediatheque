package com.exemple.gestionMed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionMed.entity.Emprunt;
import com.example.gestionMed.entity.Item;

public interface EmpruntRepository extends JpaRepository <Emprunt, Long> {

	List<Emprunt> findAllById(Long id );
}


