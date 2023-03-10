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

import com.example.UES.dto.PorudzbinaDTO;
import com.example.UES.elastic.model.PorudzbinaES;
import com.example.UES.elastic.serviceInterface.PorudzbinaEsServiceInterface;
import com.example.UES.model.Artikal;
import com.example.UES.model.Kupac;
import com.example.UES.model.Porudzbina;
import com.example.UES.serviceInterface.ArtikalServiceInterface;
import com.example.UES.serviceInterface.KupacServiceInterface;
import com.example.UES.serviceInterface.PorudzbinaServiceInterface;

@RestController
@RequestMapping(value = "api/porudzbina")
public class PorudzbinaController {
	
	public static final String PORUDZBINA_KEY = "odabranaPorudzbina";

	@Autowired
	PorudzbinaServiceInterface porudzbinaServiceInterface;
	
	@Autowired
	KupacServiceInterface kupacServiceInterface;
	
	@Autowired
	PorudzbinaEsServiceInterface porudzbinaEsServiceInterface;
	
	@Autowired
	ArtikalServiceInterface artikalServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<PorudzbinaDTO>> getPorudzbine(){

		List<Porudzbina> porudzbine = porudzbinaServiceInterface.findAll();
		
		List<PorudzbinaDTO> porudzbinaDTO = new ArrayList<PorudzbinaDTO>();
		for(Porudzbina por: porudzbine) {
			porudzbinaDTO.add(new PorudzbinaDTO(por));
		}
		return new ResponseEntity<List<PorudzbinaDTO>>(porudzbinaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PorudzbinaDTO> getPorudzbina(@PathVariable("id") Long id, HttpSession session){
		Porudzbina porudzbina = porudzbinaServiceInterface.findOne(id);
		
		session.setAttribute(PorudzbinaController.PORUDZBINA_KEY, porudzbina);
		
		if(porudzbina == null) {
			return new ResponseEntity<PorudzbinaDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PorudzbinaDTO>(new PorudzbinaDTO(porudzbina), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PorudzbinaDTO> addPorudzbina(@RequestBody PorudzbinaDTO porudzbinaDTO, HttpSession session){

		Artikal artikal = (Artikal) session.getAttribute(ArtikalController.ODABRANI_ARTIKAL);
		Kupac kupac = (Kupac) session.getAttribute(KorisnikController.KORISNIK_KEY);
		
		Porudzbina por = new Porudzbina();
		por.setSatnica(new Date());
		por.setOcena(porudzbinaDTO.getOcena());
		por.setKomentar(porudzbinaDTO.getKomentar());
		por.setDostavljeno(true); 
		por.setAnonimanKomentar(false); 
		por.setArhiviranKomentar(true); 
		por.setKupac(kupac);
		por.setArtikal(artikal);
		
		por = porudzbinaServiceInterface.save(por);
		porudzbinaEsServiceInterface.index(new PorudzbinaES(por));
		return new ResponseEntity<PorudzbinaDTO>(new PorudzbinaDTO(por), HttpStatus.CREATED);
	}

//	@PutMapping(value = "/{id}", consumes = "application/json")
//	public ResponseEntity<PorudzbinaDTO> updatePorudzbina(@RequestBody PorudzbinaDTO porudzbinaDTO, @PathVariable("id") Long id){
//		
//		Porudzbina porudzbina = porudzbinaServiceInterface.findById(id);
//		Kupac kupac = kupacServiceInterface.findById(porudzbinaDTO.getIdKupac());
//		Artikal artikal = artikalServiceInterface.findById(porudzbinaDTO.getIdArtikal());
//		
//		if(porudzbina == null) {
//			return new ResponseEntity<PorudzbinaDTO>(HttpStatus.BAD_REQUEST);
//		}
//		
//		porudzbina.setSatnica(porudzbinaDTO.getSatnica());
//		porudzbina.setOcena(porudzbinaDTO.getOcena());
//		porudzbina.setKomentar(porudzbinaDTO.getKomentar());
//		porudzbina.setDostavljeno(porudzbinaDTO.isDostavljeno()); //?
//		porudzbina.setAnonimanKomentar(porudzbinaDTO.isAnonimanKomentar()); //?
//		porudzbina.setArhiviranKomentar(porudzbinaDTO.isArhiviranKomentar()); //?
//		porudzbina.setKupac(kupac);
//		porudzbina.setArtikal(artikal);
//
//		porudzbina = porudzbinaServiceInterface.save(porudzbina);
//		return new ResponseEntity<PorudzbinaDTO>(new PorudzbinaDTO(porudzbina), HttpStatus.OK);
//	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePorudzbina(@PathVariable("id") Long id){
		Porudzbina porudzbina = porudzbinaServiceInterface.findById(id);
		if(porudzbina != null) {
			porudzbinaServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
