package com.example.UES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UES.model.Artikal;
import com.example.UES.model.Prodavac;
import com.example.UES.serviceInterface.ArtikalServiceInterface;

import com.example.UES.repository.ArtikalRepository;

@Service
public class ArtikalService implements ArtikalServiceInterface{

	@Autowired 
	ArtikalRepository artikalRepository;
	
	@Override
	public List<Artikal> findAll() {
		return artikalRepository.findAll();
	}

	@Override
	public Artikal findOne(Long id) {
		return artikalRepository.getOne(id);
	}

	@Override
	public Artikal findById(Long artikalId) {
		return artikalRepository.findByIdArtikal(artikalId);
	}

	@Override
	public Artikal save(Artikal artikal) {
		return artikalRepository.save(artikal);
	}

	@Override
	public void remove(Long id) {
		artikalRepository.deleteById(id);
		
	}

	@Override
	public List<Artikal> findAllByProdavac(Prodavac prodavac) {
		return artikalRepository.findByProdavac(prodavac);
	}
}
