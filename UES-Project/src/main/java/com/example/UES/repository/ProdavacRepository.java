package com.example.UES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Prodavac;

public interface ProdavacRepository extends JpaRepository<Prodavac, Long>{

	Prodavac findByIdKorisnik(Long idKorisnik);
	
	Prodavac findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
	
}
