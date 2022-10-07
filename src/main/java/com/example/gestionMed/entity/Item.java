package com.example.gestionMed.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "item")
@Inheritance(strategy=InheritanceType.JOINED)
public class Item implements Serializable{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private Long nbreExemplaire;
	private Date dateParution;
	
	
	//pas besoin de cette ref
	@ManyToMany
	@JoinTable(name = "item_emprunt",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "emprunt_id", referencedColumnName = "id"))
	private Set<Emprunt> emprunts = new HashSet<>();
	
	

}
