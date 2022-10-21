package com.exemple.gestionMed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestionMed.entity.Item;
import com.example.gestionMed.entity.User;

public interface UtilisateurRepository extends JpaRepository<User, Long> {
	public User findUserByLogin (String login) ;

}
