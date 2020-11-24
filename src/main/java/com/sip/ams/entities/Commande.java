package com.sip.ams.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private double prix;
    private Date Dcommande;
    private int idClient;
    private String nom;
    private String  prenom;
    private String email;
    private int tel;
    private String adress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDcommande() {
		return Dcommande;
	}
	public void setDcommande(Date dcommande) {
		Dcommande = dcommande;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Commande(int id, double prix, Date dcommande, int idClient, String nom, String prenom, String email, int tel,
			String adress) {
		super();
		this.id = id;
		this.prix = prix;
		Dcommande = dcommande;
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.adress = adress;
	}
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Command [id=" + id + ", prix=" + prix + ", Dcommande=" + Dcommande + ", idClient=" + idClient + ", nom="
				+ nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel + ", adress=" + adress + "]";
	}
    
    
}
