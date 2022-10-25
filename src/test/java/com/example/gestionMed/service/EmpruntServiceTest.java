package com.example.gestionMed.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gestionMed.entity.Emprunt;
import com.example.gestionMed.exception.DepassementQuotaException;
import com.example.gestionMed.exception.ItemNonDisponibleException;
import com.example.gestionMed.repository.EmpruntRepository;
import com.example.gestionMed.services.EmpruntService;

@SpringBootTest
public class EmpruntServiceTest {
	
	@Autowired
	EmpruntService empruntService;
	@Autowired
	EmpruntRepository empruntRepository;
	
	List<Long> idItems = new ArrayList<>();
	
	//Test effectuer emprunt disponible
	
	@Test
	void effectuerEmpruntTest() throws  DepassementQuotaException, ItemNonDisponibleException{
		idItems.add(1l);
		idItems.add(2l);
		int sizeEmprunts1 = empruntRepository.findAll().size();
		Emprunt emprunt = empruntService.effectuerEmprunt(1l,idItems);
		int sizeEmprunts2 = empruntRepository.findAll().size();
		assertEquals(sizeEmprunts1+1,sizeEmprunts2);
	}
	
	//Test effectuer emprunt indisponible
	
	@Test
	void effectuerEmpruntNonDispoTest() throws  DepassementQuotaException, ItemNonDisponibleException{
		idItems.add(4l);
		
		try {
			Emprunt emprunt = empruntService.effectuerEmprunt(4l,idItems);
			fail("ItemNonDisponibleException n a pas été lancée");
		} catch (ItemNonDisponibleException e) {
		}

	}

}
