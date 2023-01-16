package com.example.UES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UES.model.Kupac;
import com.example.UES.serviceInterface.KupacServiceInterface;

import com.example.UES.repository.KupacRepository;

@Service
public class KupacService implements KupacServiceInterface{

	@Autowired
	KupacRepository kupacRepository;
	
	@Override
	public List<Kupac> findAll() {
		return kupacRepository.findAll();
	}

	@Override
	public Kupac findOne(Long id) {
		return kupacRepository.getOne(id);
	}

	@Override
	public Kupac findById(Long korisnikId) {
		return kupacRepository.findByIdKorisnik(korisnikId);
	}

	@Override
	public Kupac save(Kupac kupac) {
		return kupacRepository.save(kupac);
	}

	@Override
	public void remove(Long id) {
		kupacRepository.deleteById(id);
		
	}

	@Override
	public Kupac findByKorImeAndLozinka(String korIme, String loz) {
		return kupacRepository.findByKorisnickoImeAndLozinka(korIme, loz);
	}

}
