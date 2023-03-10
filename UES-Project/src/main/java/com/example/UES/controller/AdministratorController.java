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

import com.example.UES.model.Administrator;
import com.example.UES.model.TipKorisnika;
import com.example.UES.serviceInterface.AdministratorServiceInterface;

import com.example.UES.dto.AdministratorDTO;

@RestController
@RequestMapping(value = "api/admin")
public class AdministratorController { 

	@Autowired
	AdministratorServiceInterface administratorServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<AdministratorDTO>> getAdministratori(){

		List<Administrator> administratori = administratorServiceInterface.findAll();
		
		List<AdministratorDTO> administratorDTO = new ArrayList<AdministratorDTO>();
		for(Administrator admin: administratori) {
			administratorDTO.add(new AdministratorDTO(admin));
		}
		return new ResponseEntity<List<AdministratorDTO>>(administratorDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdministratorDTO> getAdministrator(@PathVariable("id") Long id){
		Administrator admin = administratorServiceInterface.findOne(id);
		
		if(admin == null) {
			return new ResponseEntity<AdministratorDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AdministratorDTO>(new AdministratorDTO(admin), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AdministratorDTO> addAdministrator(@RequestBody AdministratorDTO administratorDTO){

		Administrator admin = new Administrator();
		admin.setIme(administratorDTO.getImeAdmina());
		admin.setPrezime(administratorDTO.getPrezimeAdmina());
		admin.setKorisnickoIme(administratorDTO.getKorImeAdmina());
		admin.setLozinka(administratorDTO.getLozinkaAdmina());
		admin.setBlokiran(administratorDTO.isBlokiran()); //?
		admin.setTipKorisnika(TipKorisnika.ADMINISTRATOR);
		
		admin = administratorServiceInterface.save(admin);
		return new ResponseEntity<AdministratorDTO>(new AdministratorDTO(admin), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<AdministratorDTO> updateAdministrator(@RequestBody AdministratorDTO administratorDTO, @PathVariable("id") Long id){

		Administrator admin = administratorServiceInterface.findById(id);
		
		if(admin == null) {
			return new ResponseEntity<AdministratorDTO>(HttpStatus.BAD_REQUEST);
		}
		admin.setIme(administratorDTO.getImeAdmina());
		admin.setPrezime(administratorDTO.getPrezimeAdmina());
		admin.setKorisnickoIme(administratorDTO.getKorImeAdmina());
		admin.setLozinka(administratorDTO.getLozinkaAdmina());
		admin.setBlokiran(administratorDTO.isBlokiran()); //?

		admin = administratorServiceInterface.save(admin);
		return new ResponseEntity<AdministratorDTO>(new AdministratorDTO(admin), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAdministrator(@PathVariable("id") Long id){
		Administrator admin = administratorServiceInterface.findById(id);
		if(admin != null) {
			administratorServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/{id}/blokiranje")
	public ResponseEntity<AdministratorDTO> blok(@PathVariable("id") Long id){

		Administrator admin = administratorServiceInterface.findById(id);
		
		if(admin.isBlokiran() == false) {
			admin.setBlokiran(true);
		}else {
			admin.setBlokiran(false);
		}
		
		admin = administratorServiceInterface.save(admin);
		return new ResponseEntity<AdministratorDTO>(new AdministratorDTO(admin), HttpStatus.CREATED);
	}
	
}
