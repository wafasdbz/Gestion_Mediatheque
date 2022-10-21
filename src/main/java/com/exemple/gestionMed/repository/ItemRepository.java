package com.exemple.gestionMed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.gestionMed.entity.Item;

public interface ItemRepository extends JpaRepository <Item, Long> {
	
	
	@Query("select * from Item ")
	List<Item> findAll();
	
	@Query("select i from Item where i.nbreExemplaire >0")
	public List<Item> findItemDisponible();
}
