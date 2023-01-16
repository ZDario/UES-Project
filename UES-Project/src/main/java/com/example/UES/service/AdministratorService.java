package com.example.UES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UES.model.Administrator;
import com.example.UES.serviceInterface.AdministratorServiceInterface;

import com.example.UES.repository.AdministratorRepository;

@Service
public class AdministratorService implements AdministratorServiceInterface{

	@Autowired
	AdministratorRepository administratorRepository;
	
	@Override
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	@Override
	public Administrator findOne(Long id) {
		return administratorRepository.getOne(id);
	}

	@Override
	public Administrator findById(Long korisnikId) {
		return administratorRepository.findByIdKorisnik(korisnikId);
	}

	@Override
	public Administrator save(Administrator administrator) {
		return administratorRepository.save(administrator);
	}

	@Override
	public void remove(Long id) {
		administratorRepository.deleteById(id);
		
	}

	@Override
	public Administrator findByKorImeAndLozinka(String korIme, String loz) {
		return administratorRepository.findByKorisnickoImeAndLozinka(korIme, loz);
	}

}
