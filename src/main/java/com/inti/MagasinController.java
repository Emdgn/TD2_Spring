package com.inti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Magasin;
import com.inti.model.Produit;
import com.inti.service.MagasinService;

@Controller
public class MagasinController {

	@Autowired
	MagasinService ms;
	
	
	@GetMapping("ajoutMagasin")
	public String ajoutMagasin() {
		return "ajoutMagasin";
	}
	
	@PostMapping("ajoutMagasin")
	public String ajoutMagasin(@ModelAttribute("magasin") Magasin magasin) { //Le modelattribute permet de donner le même nom aux deux fonctions
		
		ms.saveMagasin(magasin);
		
		return "redirect:ajoutMagasin";
	}
	
	
	@GetMapping("listeMagasin")
	public String listeMagasin(Model m) {
		
		List<Magasin> listeMagasin = ms.getMagasins();
		
		m.addAttribute("listeMagasin", listeMagasin);
		
		return "listeMagasin";
	}
	
	@GetMapping("supprimerMagasin/{id}")
	public String supprimerMagasin(@PathVariable("id") int id) {
		
		ms.deleteMagasin(id);
		
		return "redirect:/listeMagasin"; //quand on met le / il part de la racine
	}
	
	
	
	
	
	@GetMapping("afficheMagasin")
	public String afficheMagasin() {
		return "getIdMagasin";
	}
	
	@PostMapping("afficheMagasin") 
	public String afficheMagasin(@ModelAttribute("id") int id, Model m) {
		
		Magasin magasin = ms.getMagasin(id);
		m.addAttribute("magasin", magasin);
		
		return "afficheMagasin";
	}
}
