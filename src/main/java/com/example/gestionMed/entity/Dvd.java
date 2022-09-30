package com.example.gestionMed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "dvd")
public class Dvd extends Item{
	
	private String realisateur;
	private Long duree;
	private Type type;

}
