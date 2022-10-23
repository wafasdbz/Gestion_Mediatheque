package com.example.gestionMed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gestionMed.entity.Cd;
import com.example.gestionMed.entity.Item;
import com.example.gestionMed.repository.ItemRepository;
import com.example.gestionMed.services.ItemService;

@SpringBootTest
public class ItemServiceTest {

	

	@Autowired
	ItemService itemService;
	@Autowired 
	ItemRepository itemRepository;
	

	/*@Test
	void testGetAll() {

		List<Item> listItem = itemService.getAll();

		assertEquals(listItem.size(),15);

	}
	
	@Test
	void testGetAllDisponible() {

		List<Item> listItem = itemService.getAllDisponible();

		assertEquals(listItem.size(),12);
	}*/
	
	/*@Test
	void testGetAllCdDispo() {
		List<Cd> listCdsDispo = itemService.getAllCdDispo();
		assertEquals(listCdsDispo.size(),4);
	}*/
	
	//Test de la recherche des items récents (à partir de 2020)
		/* @Test 
		
		  void testfindItemRecent() { 
			  
			  List<Item> listItemRecents =itemService.findItemRecent(); 
			
			  assertTrue(listItemRecents.size()==2); }*/
		 @Test
		 void testfindItemByTitle() { 
			  
			  Item item =itemService.getItemByTitle("Le feu");
			
			  assertTrue(item.getId()==4); }

}
