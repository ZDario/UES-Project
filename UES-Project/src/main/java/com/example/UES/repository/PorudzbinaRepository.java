package com.example.UES.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Porudzbina;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long>{

	Porudzbina findByIdPorudzbina(Long idPorudzbina);
	
}
