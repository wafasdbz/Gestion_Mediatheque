package com.example.gestionMed.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gestionMed.entity.Utilisateur;
import com.example.gestionMed.repository.UtilisateurRepository;

import com.example.gestionMed.services.UtilisateurService;

@SpringBootTest
public class UtilisateurServiceTest {
	
	@Autowired
	UtilisateurService utilisateurService;

	
	@Test
	void testfindUtilisateurByLogin() {
		
		Utilisateur utilisateur = utilisateurService.findUtilisateurByLogin("zeyna@yahoo.fr");

		assertTrue(utilisateur.getLogin().equalsIgnoreCase("zeyna@yahoo.fr"));

	}
	
	

}
