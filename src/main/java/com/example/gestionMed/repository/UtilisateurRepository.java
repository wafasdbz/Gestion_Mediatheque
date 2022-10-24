package com.example.gestionMed.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionMed.entity.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	public Utilisateur findUtilisateurByLogin (String login) ;
	
	
	public Optional<Utilisateur> findByLoginAndPasseWord(String login,String passWord);
	//public Utilisateur findUserByLogigggg (String login,String passWord);
	
	
	

}
