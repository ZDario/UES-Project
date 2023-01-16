package com.example.UES.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Artikal;
import com.example.UES.model.Prodavac;

public interface ArtikalRepository extends JpaRepository<Artikal, Long>{

	Artikal findByIdArtikal(Long idArtikal);
	
	List<Artikal> findByProdavac(Prodavac prodavac);
	
}
