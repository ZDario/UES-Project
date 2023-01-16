package com.example.UES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	
	Korisnik findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
	
	Korisnik findByIdKorisnik(Long idKorisnik);
}
