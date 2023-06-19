package com.inti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.service.ProduitService;
import com.inti.model.Produit;

@Controller
public class ProduitController {
	
	@Autowired
	ProduitService ps;
	
	@GetMapping("produit")
	public String affichageNomProduit(@RequestParam(value = "nom", required = false, 
	defaultValue = "Nom produit indisponible") String nom, Model m) {
		
		m.addAttribute("nom", nom);
		
		return "afficherProduit";
	}
	
	
	@GetMapping("prix")
	public String affichagePrixProduit(@RequestParam(value = "prix", required = true, 
	defaultValue = "Prix produit indisponible") String prix, Model m) {
		
		m.addAttribute("prix", prix);
		
		return "afficherPrix";
	}
	
	
	@GetMapping("calcul")
	public String Produit(@RequestParam(value = "nom", required = false, 
			defaultValue = "Nom produit indisponible") String nom, 
			@RequestParam(value = "prixHT", required = false, 
			defaultValue = "Prix HT produit indisponible") String prixHT, Model m) {
		
		
		double taxe = 0.2;
		double prixTTC = Integer.parseInt(prixHT) + Integer.parseInt(prixHT)*taxe;
		
		m.addAttribute("nom", nom);
		m.addAttribute("prixTTC", prixTTC);
	
		return "afficherInfoProduit";
	}
	
	@GetMapping("ajoutProduit")
	public String ajoutProduit() {
		return "ajoutProduit";
	}
	
	@PostMapping("ajoutProduit")
	public String ajoutProduit(@ModelAttribute("produit") Produit produit) { //Le modelattribute permet de donner le même nom aux deux fonctions
		
		ps.saveProduit(produit);
		
		return "redirect:ajoutProduit";
	}
	
	
	@GetMapping("listeProduit")
	public String listeProduit(Model m) {
		
		List<Produit> listeProduit = ps.getProduits();
		
		m.addAttribute("listeProduit", listeProduit);
		
		return "listeProduit";
	}
	
	@GetMapping("supprimerProduit/{id}")
	public String supprimerProduit(@PathVariable("id") int id) {
		
		ps.deleteProduit(id);
		
		return "redirect:/listeProduit"; //quand on met le / il part de la racine
	}
	
	
	
	
	
	@GetMapping("afficheProduit")
	public String afficheProduit() {
		return "getIdProduit";
	}
	
	@PostMapping("afficheProduit") 
	public String afficheProduit(@ModelAttribute("id") int id, Model m) {
		
		Produit produit = ps.getProduit(id);
		m.addAttribute("produit", produit);
		
		return "afficheProduitEx2";
	}
}
