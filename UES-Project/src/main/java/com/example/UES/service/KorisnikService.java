package com.example.UES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UES.model.Korisnik;
import com.example.UES.serviceInterface.KorisnikServiceInterface;

import com.example.UES.repository.KorisnikRepository;

@Service
public class KorisnikService implements KorisnikServiceInterface{

	@Autowired
	KorisnikRepository korisnikRepository;

	@Override
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}

	@Override
	public Korisnik findOne(Long id) {
		return korisnikRepository.getOne(id);
	}

	@Override
	public Korisnik findByKorImeAndLozinka(String korIme, String loz) {
		return korisnikRepository.findByKorisnickoImeAndLozinka(korIme, loz);
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}

	@Override
	public void remove(Long id) {
		korisnikRepository.deleteById(id);
		
	}

	@Override
	public Korisnik findById(Long korisnikId) {
		return korisnikRepository.findByIdKorisnik(korisnikId);
	}
	
}
