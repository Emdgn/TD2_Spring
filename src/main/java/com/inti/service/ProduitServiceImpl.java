package com.inti.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Produit;
import com.inti.util.HibernateUtil;

@Service
public class ProduitServiceImpl implements ProduitService {

	
	private Session session;
	

	public ProduitServiceImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public List<Produit> getProduits() {
		List<Produit> listeProduit = new ArrayList<>();
		
		try {
			session.beginTransaction();
			
			listeProduit = session.createNativeQuery("select * from produit", Produit.class).list();
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return listeProduit;
	}

	@Override
	public void saveProduit(Produit produit) {
		try {
			session.beginTransaction();
			
			session.save(produit);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public Produit getProduit(int id) {
		Produit produit = null;
		
		try {
			session.beginTransaction();
			
			produit = session.get(Produit.class, id);
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return produit;
	}

	@Override
	public void deleteProduit(int id) {
		try {
			session.beginTransaction();
			
			session.delete(session.get(Produit.class, id));
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}
	
	
}
