package com.inti.service;

import java.util.List;

import com.inti.model.Produit;

public interface ProduitService {
	
	List<Produit> getProduits();
	void saveProduit(Produit produit);
	Produit getProduit(int id);
	void deleteProduit(int id);

}
