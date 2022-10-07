package com.example.gestionMed.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "utilisateur")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String passeWord;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Emprunt> emprunts = new HashSet<>();

}

