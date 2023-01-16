package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.ArtikalAkcija;

public interface ArtikalAkcijaServiceInterface {

	public List<ArtikalAkcija> findAll();
	public ArtikalAkcija findOne(Long id);
	public ArtikalAkcija findById(Long artikalAkcijaId);
	public ArtikalAkcija save(ArtikalAkcija artikalAkcija);
	public void remove(Long id);
	
}
