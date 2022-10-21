package com.example.gestionMed.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionMed.entity.Cd;
import com.example.gestionMed.entity.Emprunt;
import com.example.gestionMed.entity.Item;
import com.example.gestionMed.repository.EmpruntRepository;
import com.example.gestionMed.repository.ItemRepository;

@Service
public class EmpruntService {

	@Autowired
	EmpruntRepository empruntRepository;

	
	//Visualiser la liste des emprunts par utilisateur
	public List<Emprunt> getAllEmprunts(Long userId) {

		List<Emprunt> listEmprunt = new ArrayList<>();
		listEmprunt = empruntRepository.findAllByUserId(userId);
		
		return listEmprunt;

	}
	
	//Effectuer un emprunt
	 
	
}
