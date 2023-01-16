package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Artikal;
import com.example.UES.model.Komentar;

public interface KomentarServiceInterface {

	public List<Komentar> findAll();
	public Komentar findOne(Long id);
	public Komentar findById(Long komentarId);
	public Komentar save(Komentar komentar);
	public void remove(Long id);
	public List<Komentar> findAllByArtikal(Artikal artikal);
	
}
