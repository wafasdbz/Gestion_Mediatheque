package com.example.gestionMed.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionMed.entity.Emprunt;
import com.example.gestionMed.entity.Item;
import com.example.gestionMed.repository.EmpruntRepository;
import com.example.gestionMed.repository.ItemRepository;
import com.example.gestionMed.services.EmpruntService;
import com.example.gestionMed.services.ItemService;



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
	
	
	/*
	 * @GetMapping public ResponseEntity<List<Emprunt>> getAll() {
	 * 
	 * List<Emprunt> allEmprunt = empruntRepository.findAll();
	 * 
	 * if (allEmprunt.isEmpty()) { return ResponseEntity.notFound().build(); } else
	 * { return ResponseEntity.ok(allEmprunt); } }
	 */
	
	
	@GetMapping
    public ResponseEntity<List<Emprunt>> getAllById() {
        
        List<Emprunt> allEmprunt = empruntService.getAllEmprunts(1L);

        if (allEmprunt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allEmprunt);
        }
    }	
}
