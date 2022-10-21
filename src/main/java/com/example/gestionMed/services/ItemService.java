package com.example.gestionMed.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionMed.entity.Cd;
import com.example.gestionMed.entity.Dvd;
import com.example.gestionMed.entity.Item;
import com.example.gestionMed.entity.Livre;
import com.example.gestionMed.repository.ItemRepository;



@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	private String titre;


	/*public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;

	}*/

	public List<Item> getAll() {

		List<Item> allItems = itemRepository.findAll();
		return (allItems);
	}
	public List<Item> getAllDisponible() {

		List<Item> allItemsDisponibles = itemRepository.findItemDisponible();
		return (allItemsDisponibles);
	}

	public List<Cd> getAllCdDispo() {

		List<Cd> allCds = new ArrayList<>();
		List<Item> allItemsDisponibles = itemRepository.findItemDisponible();
		for(Item it : allItemsDisponibles) {
			if (it instanceof Cd )
				allCds.add((Cd) it);
		}
		return allCds;

	}

	public List<Dvd> getAllDvdDispo() {

		List<Dvd> allDvds = new ArrayList<>();
		List<Item> allItemsDisponibles = itemRepository.findItemDisponible();
		for(Item it : allItemsDisponibles) {
			if (it instanceof Dvd )
				allDvds.add((Dvd) it);
		}
		return allDvds;

	}
	public List<Livre> getAllLivreDispo() {

		List<Livre> allLivres = new ArrayList<>();
		List<Item> allItemsDisponibles = itemRepository.findItemDisponible();
		for(Item it : allItemsDisponibles) {
			if (it instanceof Livre )
				allLivres.add((Livre) it);
		}
		return allLivres;

	}

	public List<Item> findItemRecent(){
		
		
		Date date = new Date();
		date.setYear(date.getYear()-3);
		
		List<Item> itemsRecents = itemRepository.findItemRecents(date);

		return  itemsRecents;
				
	}
	
	public void getItemByTitle(String titre) {
		
				
		this.titre=titre;
		Item item = new Item();
		item = itemRepository.findItemByTitle(titre);
	
	}
	


	




}
