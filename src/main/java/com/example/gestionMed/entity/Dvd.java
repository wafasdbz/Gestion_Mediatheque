package com.example.gestionMed.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "dvd")
public class Dvd extends Item{
	
	private String realisateur;
	private Long duree;
	//pour préciser le type de la variable String car par défaut Integer
	@Enumerated(EnumType.STRING)
	private Type type;

}
