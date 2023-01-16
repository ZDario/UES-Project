package com.example.UES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Akcija;

public interface AkcijaRepository extends JpaRepository<Akcija, Long>{

	Akcija findByIdAkcija(Long idAkcija);
	
}
