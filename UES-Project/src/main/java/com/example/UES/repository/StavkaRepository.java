package com.example.UES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Stavka;

public interface StavkaRepository extends JpaRepository<Stavka, Long>{

	Stavka findByIdStavka(Long idStavka);
	
}
