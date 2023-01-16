package com.example.UES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long>{

	Administrator findByIdKorisnik(Long idKorisnik);
	
	Administrator findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
	
}
