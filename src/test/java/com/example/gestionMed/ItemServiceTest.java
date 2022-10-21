package com.example.gestionMed;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.gestionMed.entity.Item;
import com.example.gestionMed.repository.ItemRepository;
import com.example.gestionMed.services.ItemService;

@DataJpaTest
public class ItemServiceTest {

	

	@Autowired
	ItemService itemService;
	@Autowired 
	ItemRepository itemRepository;
	

	@Test
	void testGetAll() {

		List<Item> listItem = itemService.getAll();

		assertEquals(listItem.size(),15);

	}
	
	@Test
	void testGetAllDisponible() {

		List<Item> listItem = itemService.getAllDisponible();

		assertEquals(listItem.size(),12);

	}

}
