package com.example.gestionMed.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gestionMed.entity.Emprunt;
import com.example.gestionMed.entity.Item;
import com.example.gestionMed.entity.Utilisateur;
import com.example.gestionMed.exception.DepassementQuotaException;
import com.example.gestionMed.exception.ItemNonDisponibleException;
import com.example.gestionMed.repository.EmpruntRepository;
import com.example.gestionMed.repository.ItemRepository;
import com.example.gestionMed.repository.UtilisateurRepository;

@Service
@Transactional
public class EmpruntService {

	@Autowired
	EmpruntRepository empruntRepository;
	@Autowired
	ItemRepository itemRepository;

	@Autowired
	UtilisateurRepository utilisateurRepository;


	//Visualiser la liste des emprunts par utilisateur
	public List<Emprunt> getAllEmprunts(Long userId) {

		List<Emprunt> listEmprunt = new ArrayList<>();
		listEmprunt = empruntRepository.findAllByUserId(userId);
		return listEmprunt;

	}

	//Effectuer un emprunt
	public Emprunt effectuerEmprunt(Long idUtilisateur,List<Long> idItems) throws DepassementQuotaException, ItemNonDisponibleException {

		Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new EntityNotFoundException("Utilisateur non reconnu"));

		List<Emprunt> listEmprunts = getAllEmprunts(utilisateur.getId());
		int count=0;
		//compte le nbre total d'items ds tt les emprunts
		for (Emprunt e : listEmprunts) {
			count=+e.getItems().size();
		}
		if (count>2)throw new DepassementQuotaException("Dépassement de la limite d'articles autorisés");
			

		for (Long idItem :  idItems) {

			//Optional<Item> item = itemRepository.findById(idItem);
			Item item = itemRepository.findById(idItem).orElseThrow(() ->new EntityNotFoundException("Article non reconnu"));

//			//verification de la validité de identifiant de item
//			if (!(item.isPresent())) throw new EntityNotFoundException();

			//verification de la disponibilité
			//if (item.get().getNbreExemplaire()==0)throw new ItemNonDisponibleException("Article indisponible");
			if (item.getNbreExemplaire()==0)throw new ItemNonDisponibleException("Article indisponible");
				



		}
		//Initialisation dateEmprunt et date de retour (+7 jrs)
		Calendar c = Calendar.getInstance();
		Date dateEmprunt = c.getTime();
		c.add(Calendar.DAY_OF_MONTH, 7);
		Date dateRetour = c.getTime();


		Emprunt emprunt = new Emprunt();
		emprunt.setDateEmprunt(dateEmprunt);
		emprunt.setDateRetour(dateRetour);
		emprunt.setUser(utilisateur);
		for (Long idItem :  idItems) {

			Item item = itemRepository.findById(idItem).orElseThrow(() ->new EntityNotFoundException("Article non reconnu"));

			emprunt.getItems().add(item);
			item.setNbreExemplaire(item.getNbreExemplaire()-1);
			itemRepository.save(item);

		}

		return empruntRepository.save(emprunt);

	}

	//Restituer un emprunt

	public void restituerEmprunt(Long userId, Long idEmprunt) throws Exception {
		

		Emprunt emprunt =empruntRepository.findById(idEmprunt).orElseThrow(() -> new EntityNotFoundException());
		
		Long userIdEmprunt = emprunt.getUser().getId() ;
		if( userIdEmprunt != userId) throw new Exception() ;  
			
		
		Set<Item> items =  emprunt.getItems();
		
		
		empruntRepository.deleteById(idEmprunt);
		
		for (Item item:items  ) {

			item.setNbreExemplaire(item.getNbreExemplaire()+1);
			itemRepository.save(item);	

		}
		

	}




}
