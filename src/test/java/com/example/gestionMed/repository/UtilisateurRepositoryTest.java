package com.example.gestionMed.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.gestionMed.entity.Utilisateur;

@DataJpaTest
public class UtilisateurRepositoryTest {

	
	@Autowired 
	UtilisateurRepository utilisateurRepository;
	
	@Test
	void testfindUtilisateurByLoginAndPAssWord() {
		
		Optional<Utilisateur> utilisateur;
		try {
			utilisateur = utilisateurRepository.findByLoginAndPasseWord("zeyna@yahoo.fr","mdpzeyna");
			assertTrue(utilisateur.isPresent());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}
