
  package com.sip.ams.controllers; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.ResponseEntity; import
  org.springframework.stereotype.Controller;
  
  import org.springframework.ui.Model; import
  org.springframework.validation.BindingResult; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Book;
import com.sip.ams.entities.Commande; import
  com.sip.ams.exceptions.ResourceNotFoundException;
import com.sip.ams.repositories.BookRepository;
import
  com.sip.ams.repositories.CommandeRepository;
  
  
  import java.util.List; import javax.validation.Valid;
  
  @RestController
  
  @RequestMapping({"/commande"}) public class CommandeRestController {
  
  @Autowired private CommandeRepository commandeRepository;
  @Autowired private BookRepository bookRepository;
  @GetMapping("/list") public List<Commande> getAllCommande() { return
  (List<Commande>) commandeRepository.findAll(); }
  
  @PostMapping("/add/{bookId}")
  Commande createCommande(@PathVariable (value = "bookId") int bookId,@Valid @RequestBody Commande commande) {
 return bookRepository.findById(bookId).map(book ->
 {
 commande.setBook(book);
 return commandeRepository.save(commande);
 }).orElseThrow(() -> new ResourceNotFoundException("bookId" + bookId + " not found"));
 }
  @PutMapping("/update/{bookId}/{commandeId}")
  public Commande updateCommande(@PathVariable (value = "bookId") int bookId,
  @PathVariable (value = "commandeId") int commandeId,
  @Valid @RequestBody Commande commandeRequest) {
  if(!bookRepository.existsById(bookId)) {
  throw new ResourceNotFoundException("BookId " + bookId + "not found");
  }
  return commandeRepository.findById(commandeId).map(commande -> {
  commande.setFullname(commandeRequest.getFullname());
  commande.setDateCommande(commandeRequest.getDateCommande());
  commande.setPrice(commandeRequest.getPrice());
  
  return commandeRepository.save(commande);
  }).orElseThrow(() -> new ResourceNotFoundException("CommandeId " +commandeId + "not found"));
  }

  
  @DeleteMapping("/{commandeId}") public Commande deleteCommande(@PathVariable
  int commandeId) { Commande commande =
  commandeRepository.findById(commandeId) .orElseThrow(() -> new
  IllegalArgumentException("Invalid commande Id:" + commandeId));
  System.out.println("suite du programme...");
  commandeRepository.delete(commande); return commande ;
  
  }
  
  }
 