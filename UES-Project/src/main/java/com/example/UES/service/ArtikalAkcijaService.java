package com.example.UES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UES.model.ArtikalAkcija;
import com.example.UES.serviceInterface.ArtikalAkcijaServiceInterface;

import com.example.UES.repository.ArtikalAkcijaRepository;

@Service
public class ArtikalAkcijaService implements ArtikalAkcijaServiceInterface{

	@Autowired
	ArtikalAkcijaRepository artikalAkcijaRepository;
	
	@Override
	public List<ArtikalAkcija> findAll() {
		return artikalAkcijaRepository.findAll();
	}

	@Override
	public ArtikalAkcija findOne(Long id) {
		return artikalAkcijaRepository.getOne(id);
	}

	@Override
	public ArtikalAkcija findById(Long artikalAkcijaId) {
		return artikalAkcijaRepository.findByIdArtikalAkcija(artikalAkcijaId);
	}

	@Override
	public ArtikalAkcija save(ArtikalAkcija artikalAkcija) {
		return artikalAkcijaRepository.save(artikalAkcija);
	}

	@Override
	public void remove(Long id) {
		artikalAkcijaRepository.deleteById(id);
		
	}

}
