package com.example.gestionMed.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "livre")
public class Livre extends Item {
	
	private String ecrivain;
	private Long numIsbn;

}

