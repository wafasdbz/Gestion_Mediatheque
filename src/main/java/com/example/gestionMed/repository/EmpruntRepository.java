package com.example.gestionMed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionMed.entity.Emprunt;
import com.example.gestionMed.entity.Item;


@Repository
public interface EmpruntRepository extends JpaRepository <Emprunt, Long> {

	List<Emprunt> findAllById(Long id );
}


