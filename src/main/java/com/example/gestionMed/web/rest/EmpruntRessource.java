package com.example.gestionMed.web.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionMed.entity.Emprunt;
import com.example.gestionMed.entity.Item;
import com.example.gestionMed.exception.DepassementQuotaException;
import com.example.gestionMed.exception.ItemNonDisponibleException;
import com.example.gestionMed.repository.EmpruntRepository;
import com.example.gestionMed.repository.ItemRepository;
import com.example.gestionMed.services.EmpruntService;
import com.example.gestionMed.services.ItemService;

import io.swagger.v3.oas.annotations.Operation;




@RestController
@RequestMapping("/api/emprunts")
public class EmpruntRessource {

	@Autowired
	EmpruntRepository empruntRepository;
	@Autowired
	ItemRepository itemRepository;

	private final EmpruntService empruntService;

	public EmpruntRessource(EmpruntService empruntService) {
		this.empruntService = empruntService;

	}


	@Operation(summary="Visualiser tous les emprunts")
	@GetMapping
	public ResponseEntity<List<Emprunt>> getAll() {

		List<Emprunt> allEmprunt = empruntRepository.findAll();

		if (allEmprunt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(allEmprunt);
		}
	}
	
	@Operation(summary="Visualiser les emprunts par utilisateur")
	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<Emprunt>> getEmpruntByUser(@PathVariable Long userId) {

		List<Emprunt> allEmpruntByUser = empruntRepository.findAllByUserId(userId);

		if (allEmpruntByUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(allEmpruntByUser);
		}
	}
	
	@Operation(summary="Effectuer un nouveau Emprunt")
	@PostMapping("/{userId}")
	public ResponseEntity<Emprunt> effectuerEmprunt(@PathVariable Long userId, @RequestBody List<Long> idItems)throws  DepassementQuotaException, ItemNonDisponibleException {

		return ResponseEntity.status(HttpStatus.CREATED).body(empruntService.effectuerEmprunt(userId, idItems));


	}
	
	@Operation(summary="Restituer un Emprunt")
	@PutMapping("/{userId}")
    public ResponseEntity<Void>restituerEmprunt(@PathVariable Long userId , @RequestBody Long idEmprunt) throws Exception {
       
        empruntService.restituerEmprunt(userId, idEmprunt);
        
       return ResponseEntity.ok().build();
    }



}
