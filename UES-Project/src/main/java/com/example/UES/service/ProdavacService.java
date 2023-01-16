package com.example.UES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UES.model.Prodavac;
import com.example.UES.serviceInterface.ProdavacServiceInterface;

import com.example.UES.repository.ProdavacRepository;

@Service
public class ProdavacService implements ProdavacServiceInterface{

	@Autowired
	ProdavacRepository prodavacRepository;
	
	@Override
	public List<Prodavac> findAll() {
		return prodavacRepository.findAll();
	}

	@Override
	public Prodavac findOne(Long id) {
		return prodavacRepository.getOne(id);
	}

	@Override
	public Prodavac findById(Long korisnikId) {
		return prodavacRepository.findByIdKorisnik(korisnikId);
	}

	@Override
	public Prodavac save(Prodavac prodavac) {
		return prodavacRepository.save(prodavac);
	}

	@Override
	public void remove(Long id) {
		prodavacRepository.deleteById(id);
		
	}

	@Override
	public Prodavac findByKorImeAndLozinka(String korIme, String loz) {
		return prodavacRepository.findByKorisnickoImeAndLozinka(korIme, loz);
	}

}
