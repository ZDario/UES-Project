package com.example.UES.serviceInterface;

import java.util.List;

import com.example.UES.model.Kupac;

public interface KupacServiceInterface {
	
	public List<Kupac> findAll();
	public Kupac findOne(Long id);
	public Kupac findById(Long korisnikId);
	public Kupac findByKorImeAndLozinka(String korIme, String loz);
	public Kupac save(Kupac kupac);
	public void remove(Long id);

}
