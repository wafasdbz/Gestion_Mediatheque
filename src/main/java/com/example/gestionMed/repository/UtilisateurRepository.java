package com.example.gestionMed.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gestionMed.entity.Item;
import com.example.gestionMed.entity.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	public Utilisateur findUtilisateurByLogin (String login) ;
	
	
	//public Utilisateur findUserByLogigggg (String login,String passWord);
	
	
	

}
