package com.sip.ams.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Commande;
import com.sip.ams.repositories.CommandeRepository;
@Service
public class CommandeService {
	@Autowired
	CommandeRepository commandeRepo;
	
	public List<Commande> getAllCommande() {
		
		List<Commande> commandeList = new ArrayList<>();
		commandeRepo.findAll().forEach(commandeList::add);
		return commandeList;
	}
	public Commande addCommande(Commande commande) {

		commande= commandeRepo.save(commande);
		
		return commande;
	}
}
