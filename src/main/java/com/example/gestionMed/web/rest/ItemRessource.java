package com.example.gestionMed.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionMed.entity.Cd;
import com.example.gestionMed.entity.Dvd;
import com.example.gestionMed.entity.Item;
import com.example.gestionMed.entity.Livre;
import com.example.gestionMed.services.EmpruntService;
import com.example.gestionMed.services.ItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/items")
public class ItemRessource {
	
	private final ItemService itemService;
	
	
	public ItemRessource(ItemService itemService) {
        this.itemService = itemService;
        
    }
	
	@Operation(summary="Visualiser tous les Items")
	@GetMapping
    public ResponseEntity<List<Item>> getAll() {
        
        List<Item> allItems = itemService.getAll();

        if (allItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allItems);
        }
    }
	
	@Operation(summary="Visualiser les Items Disponibles ")
	@GetMapping("/disponibles")
    public ResponseEntity<List<Item>> getAllDisponible() {
        
        List<Item> allItemsDispo = itemService.getAllDisponible();

        if (allItemsDispo.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allItemsDispo);
        }
    }
	
	@Operation(summary="Visualiser les CD Disponibles ")
	@GetMapping("/disponibles/CD")
    public ResponseEntity<List<Cd>> getAllCdDispo() {
        
        List<Cd> allCdDispo = itemService.getAllCdDispo();

        if (allCdDispo.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allCdDispo);
        }
    }
	
	@Operation(summary="Visualiser les Dvd Disponibles ")
	@GetMapping("/disponibles/Dvd")
    public ResponseEntity<List<Dvd>> getAllDvdDispo() {
        
        List<Dvd> allDvdDispo = itemService.getAllDvdDispo();

        if (allDvdDispo.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allDvdDispo);
        }
    }
	
	@Operation(summary="Visualiser les Livres Disponibles ")
	@GetMapping("/disponibles/Livre")
    public ResponseEntity<List<Livre>> getAllLivreDispo() {
        
        List<Livre> allLivreDispo = itemService.getAllLivreDispo();

        if (allLivreDispo.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allLivreDispo);
        }
    }
	
	@Operation(summary="Visualiser les Items Recents ")
	@GetMapping("/Recents")
    public ResponseEntity<List<Item>> getItemRecent() {
        
        List<Item> allItemRecent = itemService.findItemRecent();

        if (allItemRecent.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allItemRecent);
        }
	}
	
	

}
