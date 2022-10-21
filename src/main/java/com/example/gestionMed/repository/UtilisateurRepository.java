package com.example.gestionMed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionMed.entity.Item;
import com.example.gestionMed.entity.User;


@Repository
public interface UtilisateurRepository extends JpaRepository<User, Long> {
	public User findUserByLogin (String login) ;

}
