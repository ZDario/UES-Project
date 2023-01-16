package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Akcija;

public interface AkcijaServiceInterface {

	public List<Akcija> findAll();
	public Akcija findOne(Long id);
	public Akcija findById(Long akcijaId);
	public Akcija save(Akcija akcija);
	public void remove(Long id);
	
}
