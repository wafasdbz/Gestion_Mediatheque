package com.example.gestionMed;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gestionMed.entity.Item;
import com.example.gestionMed.repository.ItemRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Test
	void testFindItemNonDisponible() {
		
		int nbreItemNonDispo = 3;
		
		int res= ((itemRepository.findAll().size())- (itemRepository.findItemDisponible().size()));
		
	
		
		assertEquals(nbreItemNonDispo, res);
		
	}

		
	}	
		
		
		
		
		


