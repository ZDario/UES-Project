package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Artikal;
import com.example.UES.model.Prodavac;

public interface ArtikalServiceInterface {

	public List<Artikal> findAll();
	public Artikal findOne(Long id);
	public Artikal findById(Long artikalId);
	public Artikal save(Artikal artikal);
	public void remove(Long id);
	public List<Artikal> findAllByProdavac(Prodavac prodavac);
	
}
