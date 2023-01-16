package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Porudzbina;

public interface PorudzbinaServiceInterface {

	public List<Porudzbina> findAll();
	public Porudzbina findOne(Long id);
	public Porudzbina findById(Long porudzbinaId);
	public Porudzbina save(Porudzbina porudzbina);
	public void remove(Long id);

}
