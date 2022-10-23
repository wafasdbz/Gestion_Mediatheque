package com.example.gestionMed.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gestionMed.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long> {
	
	
	
	@Query("select i from Item i where i.nbreExemplaire >0")
	public List<Item> findItemDisponible();
	
	@Query("select i from Item i where i.titre = ?1")
	public Item findItemByTitle(String titre);
	
	

	
	
	
	



	
	
	
	
	
}
