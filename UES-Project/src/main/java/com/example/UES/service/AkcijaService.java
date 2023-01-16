package com.example.UES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UES.model.Akcija;
import com.example.UES.serviceInterface.AkcijaServiceInterface;

import com.example.UES.repository.AkcijaRepository;

@Service
public class AkcijaService implements AkcijaServiceInterface{

	@Autowired
	AkcijaRepository akcijaRepository;
	
	@Override
	public List<Akcija> findAll() {
		return akcijaRepository.findAll();
	}

	@Override
	public Akcija findOne(Long id) {
		return akcijaRepository.getOne(id);
	}

	@Override
	public Akcija findById(Long akcijaId) {
		return akcijaRepository.findByIdAkcija(akcijaId);
	}

	@Override
	public Akcija save(Akcija akcija) {
		return akcijaRepository.save(akcija);
	}

	@Override
	public void remove(Long id) {
		akcijaRepository.deleteById(id);
		
	}

}
