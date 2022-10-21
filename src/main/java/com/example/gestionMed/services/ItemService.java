package com.example.gestionMed.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionMed.entity.Cd;
import com.example.gestionMed.entity.Item;
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
	
	



}
