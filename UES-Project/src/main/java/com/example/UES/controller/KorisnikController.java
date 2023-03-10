package com.example.UES.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UES.model.Korisnik;
import com.example.UES.serviceInterface.AdministratorServiceInterface;
import com.example.UES.serviceInterface.KorisnikServiceInterface;
import com.example.UES.serviceInterface.KupacServiceInterface;
import com.example.UES.serviceInterface.ProdavacServiceInterface;

import  com.example.UES.dto.KorisnikDTO;

@RestController
@RequestMapping(value = "api/korisnik")
public class KorisnikController {
	
	public static final String KORISNIK_KEY = "prijavljeniKorisnik";
	
	@Autowired
	KorisnikServiceInterface korisnikServiceInterface;
	
	@Autowired
	AdministratorServiceInterface administratorServiceInterface;
	
	@Autowired
	ProdavacServiceInterface prodavacServiceInterface;
	
	@Autowired
	KupacServiceInterface kupacServiceInterface;
	
	@PostMapping(value = "/login")
	public ResponseEntity<KorisnikDTO> login(@RequestBody KorisnikDTO korisnikDTO, HttpSession session){

		Korisnik kupac =  kupacServiceInterface.findByKorImeAndLozinka(korisnikDTO.getKorIme(), korisnikDTO.getLozinka());
		Korisnik admin = administratorServiceInterface.findByKorImeAndLozinka(korisnikDTO.getKorIme(), korisnikDTO.getLozinka());
		Korisnik prodavac = prodavacServiceInterface.findByKorImeAndLozinka(korisnikDTO.getKorIme(), korisnikDTO.getLozinka());
		
		session.setAttribute(KorisnikController.KORISNIK_KEY, kupac);
		
		if(kupac==null) {
			kupac = prodavac;
		}
		if(kupac==null) {
			kupac = admin;
		}
				
		if (kupac==null) {
			return new ResponseEntity<KorisnikDTO>(HttpStatus.NOT_FOUND); 
		}else{
			KorisnikDTO korDTO = new KorisnikDTO();
			korDTO.setIdKorisnik(kupac.getIdKorisnik());
			korDTO.setKorIme(kupac.getKorisnickoIme());
			korDTO.setLozinka(kupac.getLozinka());
			korDTO.setTipKorisnika(kupac.getTipKorisnika());
			korDTO.setBlokiran(kupac.isBlokiran());
			session.setAttribute(ProdavacController.PRODAVAC_KEY, prodavac);
			return new ResponseEntity<KorisnikDTO>(korDTO,HttpStatus.OK);
		}

	}

}
