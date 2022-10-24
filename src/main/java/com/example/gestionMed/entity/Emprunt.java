package com.example.gestionMed.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
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

	public Set<Item> getItems() {
		return items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Optional<Utilisateur> getUser() {
		return user;
	}

	public void setUser(Optional<Utilisateur> utilisateur) {
		this.user = utilisateur;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@ManyToOne
	private Optional<Utilisateur> user;













}
