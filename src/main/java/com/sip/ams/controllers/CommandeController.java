package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Book;
import com.sip.ams.entities.Commande;
import com.sip.ams.repositories.BookRepository;
import com.sip.ams.repositories.CommandeRepository;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/commande/")
public class CommandeController {
	private final CommandeRepository commandeRepository;
	private final BookRepository bookRepository;
	@Autowired
	public CommandeController(CommandeRepository commandeRepository,BookRepository bookRepository) {
		this.commandeRepository = commandeRepository;
		this.bookRepository=bookRepository;
	}
	
	@GetMapping("list")
	public String listCommandes(Model model) {
		List<Commande> lc = (List<Commande>) commandeRepository.findAll();
		List<Book> lb = (List<Book>) bookRepository.findAll();
		
		model.addAttribute("commandes", lc);
		model.addAttribute("selBooks",lb);
		return "commande/listCommandes";

	}

	@GetMapping("add")
	public String showAddCommandeForm(Model model) {
		Commande commande = new Commande();
		model.addAttribute("commande", commande);
		return "commande/addCommande";
	}

	@PostMapping("add")
	@ResponseBody
	public String addCommande(@Valid Commande commande, BindingResult result, Model model , 
			@RequestParam("vendu")List listBooks) {
		/*if (result.hasErrors()) {
			return "commande/addCommande";
		}*/
		System.out.println(listBooks);
		//commandeRepository.save(commande);
		
		return ""+listBooks.size();
		//return "redirect:list";
		//return "Spring";
	}

	@GetMapping("delete/{id}")
	public String deleteCommande(@PathVariable("id") int id, Model model) {

		Commande commande = commandeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid commande Id:" + id));
		System.out.println("suite du programme...");
		commandeRepository.delete(commande);

		return "redirect:../list";
	}

	@GetMapping("edit/{id}")
	public String showCommandeFormToUpdate(@PathVariable("id") int id, Model model) {

		Commande commande = commandeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid commande Id:" + id));
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
