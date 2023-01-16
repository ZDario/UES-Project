package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Prodavac;

public interface ProdavacServiceInterface {

	public List<Prodavac> findAll();
	public Prodavac findOne(Long id);
	public Prodavac findById(Long korisnikId);
	public Prodavac findByKorImeAndLozinka(String korIme, String loz);
	public Prodavac save(Prodavac prodavac);
	public void remove(Long id);
	
}
