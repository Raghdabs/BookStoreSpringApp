package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Commande;
import com.sip.ams.entities.Book;
import com.sip.ams.repositories.CommandeRepository;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/commande/")
public class CommandeController {
	private final CommandeRepository commandeRepository;
	@Autowired
	public CommandeController(CommandeRepository commandeRepository) {
	this.commandeRepository = commandeRepository;
	}
	@GetMapping("list")
	public String listCommandes(Model model) {
		List<Commande> lp = (List<Commande>) commandeRepository.findAll();
		if (lp.size() == 0)
		lp = null;
		model.addAttribute("commandes", lp);
		return "commande/listCommandes";
		
		}
	@GetMapping("add")
	public String showAddCommandeForm(Model model) {
	Commande commande = new Commande();
	model.addAttribute("commande", commande);
	return "commande/addCommande";
	}
	@PostMapping("add")
	public String addCommande(@Valid Commande commande, BindingResult result, Model
	model) {
	if (result.hasErrors()) {
	return "commande/addCommande";
	}
	commandeRepository.save(commande);
	return "redirect:list";
	}
	@GetMapping("delete/{id}")
	public String deleteCommande(@PathVariable("id") long id, Model model) {
	
	Commande commande = commandeRepository.findById(id)
	.orElseThrow(() -> new IllegalArgumentException("Invalid commande Id:" + id));
	System.out.println("suite du programme...");
	commandeRepository.delete(commande);
	
	return "redirect:../list";
	}
	@GetMapping("edit/{id}")
	public String showCommandeFormToUpdate(@PathVariable("id") long id, Model model)
	{
		
	Commande commande = commandeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid commande Id:" + id));
	model.addAttribute("commande", commande);
	return "commande/updateCommande";
	}
	@PostMapping("update")
	public String updateCommande(@Valid Commande commande, BindingResult result, Model model) {
	if (result.hasErrors()) {
	return "commande/updateCommande";
	}
	commandeRepository.save(commande);
	return "redirect:list";
	}
}
