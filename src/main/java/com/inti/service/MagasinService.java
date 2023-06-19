package com.inti.service;

import java.util.List;

import com.inti.model.Magasin;

public interface MagasinService {
	
	List<Magasin> getMagasins();
	void saveMagasin(Magasin magasin);
	Magasin getMagasin(int id);
	void deleteMagasin(int id);

}
