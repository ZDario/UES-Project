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

import com.example.UES.model.Akcija;
import com.example.UES.model.Artikal;
import com.example.UES.model.ArtikalAkcija;
import com.example.UES.serviceInterface.AkcijaServiceInterface;
import com.example.UES.serviceInterface.ArtikalAkcijaServiceInterface;
import com.example.UES.serviceInterface.ArtikalServiceInterface;

import com.example.UES.dto.ArtikalAkcijaDTO;

@RestController
@RequestMapping(value = "api/artikal_akcija")
public class ArtikalAkcijaController {

	@Autowired
	ArtikalAkcijaServiceInterface artikalAkcijaServiceInterface;
	
	@Autowired
	ArtikalServiceInterface artikalServiceInterface;
	
	@Autowired
	AkcijaServiceInterface akcijaServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ArtikalAkcijaDTO>> getArtikleAkcije(){

		List<ArtikalAkcija> artikliAkcije = artikalAkcijaServiceInterface.findAll();
		
		List<ArtikalAkcijaDTO> artikalAkcijaDTO = new ArrayList<ArtikalAkcijaDTO>();
		for(ArtikalAkcija artakc: artikliAkcije) {
			artikalAkcijaDTO.add(new ArtikalAkcijaDTO(artakc));
		}
		return new ResponseEntity<List<ArtikalAkcijaDTO>>(artikalAkcijaDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ArtikalAkcijaDTO> getArtikalAkcija(@PathVariable("id") Long id){
		ArtikalAkcija artikalAkcija = artikalAkcijaServiceInterface.findOne(id);
		
		if(artikalAkcija == null) {
			return new ResponseEntity<ArtikalAkcijaDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ArtikalAkcijaDTO>(new ArtikalAkcijaDTO(artikalAkcija), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ArtikalAkcijaDTO> addArtikalAkcija(@RequestBody ArtikalAkcijaDTO artikalAkcijaDTO){
		
		ArtikalAkcija aa = new ArtikalAkcija();
		Artikal artikal = artikalServiceInterface.findById(artikalAkcijaDTO.getIdArtikal());
		Akcija akcija = akcijaServiceInterface.findOne(artikalAkcijaDTO.getIdAkcija());
		aa.setArtikal(artikal);
		aa.setAkcija(akcija);
		
		aa = artikalAkcijaServiceInterface.save(aa);
		return new ResponseEntity<ArtikalAkcijaDTO>(new ArtikalAkcijaDTO(aa), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<ArtikalAkcijaDTO> updateArtikalAkcija(@RequestBody ArtikalAkcijaDTO artikalAkcijaDTO, @PathVariable("id") Long id){
		
		ArtikalAkcija aa = artikalAkcijaServiceInterface.findById(id);
		Artikal artikal = artikalServiceInterface.findById(artikalAkcijaDTO.getIdArtikal());
		Akcija akcija = akcijaServiceInterface.findOne(artikalAkcijaDTO.getIdAkcija());
		
		if(aa == null) {
			return new ResponseEntity<ArtikalAkcijaDTO>(HttpStatus.BAD_REQUEST);
		}
		
		aa.setArtikal(artikal);
		aa.setAkcija(akcija);
		
		aa = artikalAkcijaServiceInterface.save(aa);

		return new ResponseEntity<ArtikalAkcijaDTO>(new ArtikalAkcijaDTO(aa), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteArtikalAkcija(@PathVariable("id") Long id){
		ArtikalAkcija artikalAkcija = artikalAkcijaServiceInterface.findById(id);
		if(artikalAkcija != null) {
			artikalAkcijaServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
