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
	//on a changé le type par LocalDate au lieu de Date
	//Recherche des nouveautés
	public List<Item> findItemRecent(){

		List<Item> items= itemRepository.findAll();
		List<Item> itemsRecents =new ArrayList<>();

		for (Item i :items)
		{

			if (i.getDateParution().isAfter(LocalDate.now().minusYears(3))) {
				itemsRecents.add(i);
			}

		}

		return itemsRecents;

	}
	
	
	//Recherche item par titre
	public Item getItemByTitle(String titre) {
		Item item = itemRepository.findItemByTitle(titre);
		return item;
	}








}
