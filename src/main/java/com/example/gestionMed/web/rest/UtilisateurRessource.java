package com.example.gestionMed.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionMed.entity.Emprunt;
import com.example.gestionMed.entity.Utilisateur;
import com.example.gestionMed.exception.DepassementQuotaException;
import com.example.gestionMed.exception.ItemNonDisponibleException;
import com.example.gestionMed.repository.UtilisateurRepository;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurRessource {

@Autowired
UtilisateurRepository  utilisateurRepository;
Utilisateur utilisateur = new Utilisateur();

	
@GetMapping
public ResponseEntity<List<Utilisateur>> getAll() {

	List<Utilisateur> allUtilisateur = utilisateurRepository.findAll();

	if (allUtilisateur.isEmpty()) {
		return ResponseEntity.notFound().build();
	} else {
		return ResponseEntity.ok(allUtilisateur);
	}
}
	

@PostMapping("/user/{longin}")
public ResponseEntity<Utilisateur> enregistrerUtilisateur(@PathVariable String longin, @RequestBody String passWord){
	
	
			
	
	return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurRepository.save);


}

}
