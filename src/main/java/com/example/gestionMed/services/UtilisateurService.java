package com.example.gestionMed.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionMed.entity.Utilisateur;
import com.example.gestionMed.repository.ItemRepository;
import com.example.gestionMed.repository.UtilisateurRepository;

@Service
public class UtilisateurService {


	@Autowired
	UtilisateurRepository utilisateurRepository;

	public Utilisateur findUtilisateurByLogin(String login) {

		Utilisateur user = utilisateurRepository.findUtilisateurByLogin(login);
		return user;

	} 

	/*
	 * public Utilisateur findUserByLoginAndPassword(String login, String passWord)
	 * throws Exception{
	 * 
	 * try { Utilisateur user = utilisateurRepository.findUtilisateurByLogin(login);
	 * 
	 * 
	 * 
	 * 
	 * String motdepasse=user.getPasseWord(); if (motdepasse.equals(passWord))
	 * return user; else return null;
	 * 
	 * 
	 * 
	 * }
	 */

}
