package com.example.gestionMed.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionMed.entity.Utilisateur;
import com.example.gestionMed.repository.ItemRepository;
import com.example.gestionMed.repository.UtilisateurRepository;

@Service
public class UtilisateurService {


	@Autowired
	UtilisateurRepository utilisateurRepository;



}
