package com.example.UES.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UES.model.Artikal;
import com.example.UES.model.Prodavac;
import com.example.UES.model.TipKorisnika;
import com.example.UES.serviceInterface.ArtikalServiceInterface;
import com.example.UES.serviceInterface.ProdavacServiceInterface;

import com.example.UES.dto.ArtikalDTO;
import com.example.UES.dto.ProdavacDTO;

@RestController
@RequestMapping(value = "api/prodavac")
public class ProdavacController {
	
	public static final String PRODAVAC_KEY = "prijavljeniProdavac";
	
	@Autowired
	ProdavacServiceInterface prodavacServiceInterface;
	
	@Autowired
	ArtikalServiceInterface artikalServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ProdavacDTO>> getProdavci(){

		List<Prodavac> prodavci = prodavacServiceInterface.findAll();
		
		List<ProdavacDTO> prodavacDTO = new ArrayList<ProdavacDTO>();
		for(Prodavac prodavac: prodavci) {
			prodavacDTO.add(new ProdavacDTO(prodavac));
		}
		return new ResponseEntity<List<ProdavacDTO>>(prodavacDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdavacDTO> getProdavac(@PathVariable("id") Long id){
		Prodavac prodavac = prodavacServiceInterface.findOne(id);
		
		if(prodavac == null) {
			return new ResponseEntity<ProdavacDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProdavacDTO>(new ProdavacDTO(prodavac), HttpStatus.OK);
	}
	
	@GetMapping(value = "/artikli")
	public ResponseEntity<List<ArtikalDTO>> getArtikleProdavca(HttpSession session){
				
		Prodavac prodavac = (Prodavac) session.getAttribute(PRODAVAC_KEY);
		
		if(prodavac == null) {
			return new ResponseEntity<List<ArtikalDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<Artikal> artikli = artikalServiceInterface.findAllByProdavac(prodavac);
			List<ArtikalDTO> artikalDTO = new ArrayList<ArtikalDTO>();
			for (Artikal artikal : artikli) {
				ArtikalDTO dto = new ArtikalDTO(artikal);
				artikalDTO.add(dto);
			}
			return new ResponseEntity<List<ArtikalDTO>>(artikalDTO, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/{id}/artikli")
	public ResponseEntity<List<ArtikalDTO>> getArtikleProdavcaKodAdmina(@PathVariable("id") Long id, HttpSession session){
				
		Prodavac prodavac = prodavacServiceInterface.findOne(id);
		
		if(prodavac == null) {
			return new ResponseEntity<List<ArtikalDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<Artikal> artikli = artikalServiceInterface.findAllByProdavac(prodavac);
			List<ArtikalDTO> artikalDTO = new ArrayList<ArtikalDTO>();
			for (Artikal artikal : artikli) {
				session.setAttribute(ArtikalController.ODABRANI_ARTIKAL, artikal);
				Artikal ar = (Artikal) session.getAttribute(ArtikalController.ODABRANI_ARTIKAL);
				System.out.println("Artikal je: "+ar.getNaziv());
				ArtikalDTO dto = new ArtikalDTO(artikal);
				artikalDTO.add(dto);
			}
			return new ResponseEntity<List<ArtikalDTO>>(artikalDTO, HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<ProdavacDTO> addProdavac(@RequestBody ProdavacDTO prodavacDTO){

		Prodavac prodavac = new Prodavac();
		prodavac.setIme(prodavacDTO.getIme());
		prodavac.setPrezime(prodavacDTO.getPrezime());
		prodavac.setKorisnickoIme(prodavacDTO.getKorIme());
		prodavac.setLozinka(prodavacDTO.getLozinka());
		prodavac.setBlokiran(prodavacDTO.isBlokiran()); //?
		prodavac.setNazivProdavca(prodavacDTO.getNazivProdavca());
		prodavac.setEmail(prodavacDTO.getEmail());
		prodavac.setAdresa(prodavacDTO.getAdresa());
		prodavac.setPoslujeOd(new Date());
		prodavac.setTipKorisnika(TipKorisnika.PRODAVAC);
		
		prodavac = prodavacServiceInterface.save(prodavac);
		return new ResponseEntity<ProdavacDTO>(new ProdavacDTO(prodavac), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<ProdavacDTO> updateProdavac(@RequestBody ProdavacDTO prodavacDTO, @PathVariable("id") Long id){

		Prodavac prodavac = prodavacServiceInterface.findById(id);
		
		if(prodavac == null) {
			return new ResponseEntity<ProdavacDTO>(HttpStatus.BAD_REQUEST);
		}
		prodavac.setIme(prodavacDTO.getIme());
		prodavac.setPrezime(prodavacDTO.getPrezime());
		prodavac.setKorisnickoIme(prodavacDTO.getKorIme());
		prodavac.setLozinka(prodavacDTO.getLozinka());
		prodavac.setBlokiran(prodavacDTO.isBlokiran()); //?
		prodavac.setNazivProdavca(prodavacDTO.getNazivProdavca());
		prodavac.setEmail(prodavacDTO.getEmail());
		prodavac.setAdresa(prodavacDTO.getAdresa());
		prodavac.setPoslujeOd(prodavacDTO.getPoslujeOd());

		prodavac = prodavacServiceInterface.save(prodavac);
		return new ResponseEntity<ProdavacDTO>(new ProdavacDTO(prodavac), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProdavac(@PathVariable("id") Long id){
		Prodavac prodavac = prodavacServiceInterface.findById(id);
		if(prodavac != null) {
			prodavacServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/{id}/blokiranje")
	public ResponseEntity<ProdavacDTO> blok(@PathVariable("id") Long id){

		Prodavac prodavac = prodavacServiceInterface.findById(id);
		
		if(prodavac.isBlokiran() == false) {
			prodavac.setBlokiran(true);
		}else {
			prodavac.setBlokiran(false);
		}
		
		prodavac = prodavacServiceInterface.save(prodavac);
		return new ResponseEntity<ProdavacDTO>(new ProdavacDTO(prodavac), HttpStatus.CREATED);
	}
	
}
