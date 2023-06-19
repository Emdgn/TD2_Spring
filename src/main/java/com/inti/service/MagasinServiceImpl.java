package com.inti.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.inti.model.Magasin;
import com.inti.util.HibernateUtil;

@Service
public class MagasinServiceImpl implements MagasinService {
	
	private Session session;
	
	

	public MagasinServiceImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public List<Magasin> getMagasins() {
		List<Magasin> listeMagasin = new ArrayList<>();
		
		try {
			session.beginTransaction();
			
			listeMagasin = session.createNativeQuery("select * from magasin", Magasin.class).list();
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return listeMagasin;
	}

	@Override
	public void saveMagasin(Magasin magasin) {
		try {
			session.beginTransaction();
			
			session.save(magasin);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public Magasin getMagasin(int id) {
		Magasin magasin = null;
		
		try {
			session.beginTransaction();
			
			magasin = session.get(Magasin.class, id);
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return magasin;
	}

	@Override
	public void deleteMagasin(int id) {
		try {
			session.beginTransaction();
			
			session.delete(session.get(Magasin.class, id));
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}
