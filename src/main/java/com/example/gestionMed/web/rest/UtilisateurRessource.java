package com.example.gestionMed.web.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.gestionMed.entity.Utilisateur;
import com.example.gestionMed.exception.UserNotFoundException;
import com.example.gestionMed.repository.UtilisateurRepository;


@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurRessource {

	@Autowired
	UtilisateurRepository  utilisateurRepository;



	@GetMapping
	public ResponseEntity<List<Utilisateur>> getAll() {

		List<Utilisateur> allUtilisateur = utilisateurRepository.findAll();

		if (allUtilisateur.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(allUtilisateur);
		}
	}

	@GetMapping("/{userId}")
	public Utilisateur getUtilisateurById(@PathVariable Long userId) {

		return utilisateurRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());

	}

	@GetMapping("/login")
	public ResponseEntity<Utilisateur> getUtilisateurByloginAndPassword(@RequestParam String login,@RequestParam String passWord) {
		try {
			Utilisateur utilisateur = utilisateurRepository.findByLoginAndPasseWord(login, passWord);
			return ResponseEntity.ok(utilisateur);
		} catch (UserNotFoundException e) {
			throw e;
		}

	}


	@PutMapping("/user/{userId}")
	public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable String userId, @RequestBody Utilisateur utilisateur){


		return ResponseEntity.ok(utilisateurRepository.save(utilisateur));
	}

	@PostMapping
	public ResponseEntity<Utilisateur> enregistrerUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
		return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurRepository.save(utilisateur));
	}


	@DeleteMapping("/user/{userId}")
	public ResponseEntity<Void> deleteById(@PathVariable Long userId) {
		try {
			utilisateurRepository.deleteById(userId);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Utilisateur non trouvé avec le id : " + userId);
		}
	}

}
