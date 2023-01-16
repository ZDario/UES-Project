package com.example.UES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.ArtikalAkcija;

public interface ArtikalAkcijaRepository extends JpaRepository<ArtikalAkcija, Long>{

	ArtikalAkcija findByIdArtikalAkcija(Long idArtikalAkcija);
	
}
