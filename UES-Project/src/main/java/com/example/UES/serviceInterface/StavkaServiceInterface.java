package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Stavka;

public interface StavkaServiceInterface {

	public List<Stavka> findAll();
	public Stavka findOne(Long id);
	public Stavka findById(Long stavkaId);
	public Stavka save(Stavka stavka);
	public void remove(Long id);
	
}
