package com.example.gestionMed.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = " Emprunt")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dateEmprunt;

	private Date dateRetour;

	@ManyToMany(mappedBy = "emprunts", cascade = CascadeType.ALL)
	private Set<Item> items = new HashSet<>();

	@ManyToOne
	private User user;













}
