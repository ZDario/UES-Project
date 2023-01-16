package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Administrator;

public interface AdministratorServiceInterface {

	public List<Administrator> findAll();
	public Administrator findOne(Long id);
	public Administrator findById(Long korisnikId);
	public Administrator findByKorImeAndLozinka(String korIme, String loz);
	public Administrator save(Administrator administrator);
	public void remove(Long id);
	
}
