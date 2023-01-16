package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Korisnik;

public interface KorisnikServiceInterface {

	public List<Korisnik> findAll();
	public Korisnik findOne(Long id);
	public Korisnik findById(Long korisnikId);
	public Korisnik findByKorImeAndLozinka(String korIme, String loz);
	public Korisnik save(Korisnik korisnik);
	public void remove(Long id);
	
}
