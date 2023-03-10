package com.example.UES.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.example.UES.model.Kupac;
import com.example.UES.model.Stavka;
import com.example.UES.serviceInterface.ArtikalServiceInterface;
import com.example.UES.serviceInterface.KupacServiceInterface;
import com.example.UES.serviceInterface.StavkaServiceInterface;

import com.example.UES.dto.StavkaDTO;

@RestController
@RequestMapping(value = "api/stavka")
public class StavkaController {
	
	@Autowired
	StavkaServiceInterface stavkaServiceInterface;
	
	@Autowired
	ArtikalServiceInterface artikalServiceInterface;
	
	@Autowired
	KupacServiceInterface kupacServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<StavkaDTO>> getStavke(){

		List<Stavka> stavke = stavkaServiceInterface.findAll();
		
		List<StavkaDTO> stavkaDTO = new ArrayList<StavkaDTO>();
		for(Stavka stavka: stavke) {
			stavkaDTO.add(new StavkaDTO(stavka));
		}
		return new ResponseEntity<List<StavkaDTO>>(stavkaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StavkaDTO> getStavka(@PathVariable("id") Long id){
		Stavka stavka = stavkaServiceInterface.findById(id);
		
		if(stavka == null) {
			return new ResponseEntity<StavkaDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StavkaDTO>(new StavkaDTO(stavka), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<StavkaDTO> addArtikal(@RequestBody StavkaDTO stavkaDTO){
				
		Stavka stavka = new Stavka();
		
		Artikal artikal = artikalServiceInterface.findById(stavkaDTO.getIdArtikal());
		Kupac kupac = kupacServiceInterface.findById(stavkaDTO.getIdKupca());
		
		stavka.setKolicina(stavkaDTO.getKolicina());
		stavka.setArtikal(artikal);
		stavka.setKupac(kupac);
		
		stavka = stavkaServiceInterface.save(stavka);
		return new ResponseEntity<StavkaDTO>(new StavkaDTO(stavka), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<StavkaDTO> updateStavka(@RequestBody StavkaDTO stavkaDTO, @PathVariable("id") Long id){
		
		Stavka stavka = stavkaServiceInterface.findById(id);
		Artikal artikal = artikalServiceInterface.findById(stavkaDTO.getIdArtikal());
		Kupac kupac = kupacServiceInterface.findById(stavkaDTO.getIdKupca());
		
		if(artikal == null) {
			return new ResponseEntity<StavkaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		stavka.setKolicina(stavkaDTO.getKolicina());
		stavka.setArtikal(artikal);
		stavka.setKupac(kupac);

		stavka = stavkaServiceInterface.save(stavka);
		return new ResponseEntity<StavkaDTO>(new StavkaDTO(stavka), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteStavka(@PathVariable("id") Long id){
		Stavka stavka = stavkaServiceInterface.findById(id);
		if(stavka != null) {
			stavkaServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
