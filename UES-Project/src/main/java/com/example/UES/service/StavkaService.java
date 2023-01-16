package com.example.UES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UES.model.Stavka;
import com.example.UES.serviceInterface.StavkaServiceInterface;

import com.example.UES.repository.StavkaRepository;

@Service
public class StavkaService implements StavkaServiceInterface{

	@Autowired
	StavkaRepository stavkaRepository;
	
	@Override
	public List<Stavka> findAll() {
		return stavkaRepository.findAll();
	}

	@Override
	public Stavka findOne(Long id) {
		return stavkaRepository.getOne(id);
	}

	@Override
	public Stavka findById(Long stavkaId) {
		return stavkaRepository.findByIdStavka(stavkaId);
	}

	@Override
	public Stavka save(Stavka stavka) {
		return stavkaRepository.save(stavka);
	}

	@Override
	public void remove(Long id) {
		stavkaRepository.deleteById(id);
		
	}

}
