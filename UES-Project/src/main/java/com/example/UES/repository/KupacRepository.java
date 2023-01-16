package com.example.UES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Kupac;

public interface KupacRepository extends JpaRepository<Kupac, Long>{

	Kupac findByIdKorisnik(Long idKorisnik);
	
	Kupac findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
	
}
