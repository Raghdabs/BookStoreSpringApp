
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
  
  import com.sip.ams.entities.Commande; import
  com.sip.ams.exceptions.ResourceNotFoundException; import
  com.sip.ams.repositories.CommandeRepository;
  
  
  import java.util.List; import javax.validation.Valid;
  
  @RestController
  
  @RequestMapping({"/commande"}) public class CommandeRestController {
  
  @Autowired private CommandeRepository commandeRepository;
  
  @GetMapping("/list") public List<Commande> getAllCommande() { return
  (List<Commande>) commandeRepository.findAll(); }
  
  @PostMapping("/add") public Commande createCommande(@Valid @RequestBody
  Commande commande) { return commandeRepository.save(commande); }
  
  @PutMapping("/{commandeId}") public Commande updateCommande(@PathVariable
  int commandeId, @Valid
  
  @RequestBody Commande commandeRequest) { return
  commandeRepository.findById(commandeId).map(commande -> {
  commande.setFullname(commandeRequest.getFullname());
  commande.setPrice(commandeRequest.getPrice());
  commande.setDateCommande(commandeRequest.getDateCommande());
  commande.setIdClient(commandeRequest.getIdClient()); return
  commandeRepository.save(commande); }).orElseThrow(() -> new
  ResourceNotFoundException("CommandeId " + commandeId + " not found")); }
  
  @DeleteMapping("/{commandeId}") public Commande deleteCommande(@PathVariable
  int commandeId) { Commande commande =
  commandeRepository.findById(commandeId) .orElseThrow(() -> new
  IllegalArgumentException("Invalid commande Id:" + commandeId));
  System.out.println("suite du programme...");
  commandeRepository.delete(commande); return commande ;
  
  }
  
  }
 