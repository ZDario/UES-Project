package com.example.UES.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UES.model.Artikal;
import com.example.UES.model.Komentar;

public interface KomentarRepository extends JpaRepository<Komentar, Long>{

	Komentar findByIdKomentar(Long idKomentar);
	
	List<Komentar> findByArtikal(Artikal artikal);
	
}
