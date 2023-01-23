package com.example.UES.elastic.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UES.elastic.dto.ArtikalEsDTO;
import com.example.UES.elastic.dto.PorudzbinaEsDTO;
import com.example.UES.elastic.dto.TextRequestDTO;
import com.example.UES.elastic.model.ArtikalES;
import com.example.UES.elastic.model.PorudzbinaES;
import com.example.UES.elastic.serviceInterface.ArtikalEsServiceInterface;
import com.example.UES.elastic.serviceInterface.PorudzbinaEsServiceInterface;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
	
	@Autowired
	ArtikalEsServiceInterface artikalEsServiceInterface;
	
	@Autowired
	PorudzbinaEsServiceInterface porudzbinaEsServiceInterface;
	
	@PostMapping("/artikal")
	public void index(@RequestBody ArtikalES artikalEs) {
		artikalEsServiceInterface.index(artikalEs);
	}
	
	@PostMapping("/artikalNaziv")
	public List<ArtikalES> getByNaziv(@RequestBody TextRequestDTO textRequestDTO){
		return artikalEsServiceInterface.getArtikalByNaziv(textRequestDTO.getText());
	}
	
	@PostMapping("/artikalOpis")
	public List<ArtikalES> getByOpis(@RequestBody TextRequestDTO textRequestDTO){
		return artikalEsServiceInterface.getArtikalByOpis(textRequestDTO.getText());
	}
	
	@PostMapping("/artikalCena")
	public List<ArtikalEsDTO> getByCena(@RequestParam(name = "from") double from, @RequestParam(name = "to") double to){
		return artikalEsServiceInterface.findByCena(from, to);
	}
	
	//reindexira fajlove
	@GetMapping("/reindex")
	public void reindex() {
		artikalEsServiceInterface.reindex();
	}

	@PostMapping(path = "/pdf", consumes = "multipart/form-data")
	public void uploadPdf(@ModelAttribute ArtikalEsDTO uploadModel) throws IOException{
		ArtikalES a = new ArtikalES();
		a.setNaziv(uploadModel.getNaziv());
		a.setCena(uploadModel.getCena());
		
		a = artikalEsServiceInterface.save(a);
		artikalEsServiceInterface.index(a);
		artikalEsServiceInterface.indexUploadFile(uploadModel);
	}
	
	@PostMapping("/nazivQuery")
	public List<ArtikalEsDTO> getByNaziv(@RequestParam(name = "naziv") String naziv){
		return artikalEsServiceInterface.findByNaziv(naziv);
	}
	
	@PostMapping("/artikalNazivAndCena")
	public List<ArtikalEsDTO> getByNazivAndCena(@RequestParam(name = "naziv") String naziv, @RequestParam(name = "from") double from, @RequestParam(name = "to") double to){
		return artikalEsServiceInterface.findByNazivAndCena(naziv, from, to);
	}
	
	@PostMapping("/artikalNazivOrCena")
	public List<ArtikalEsDTO> getByNazivOrCena(@RequestParam(name = "naziv") String naziv, @RequestParam(name = "from") double from, @RequestParam(name = "to") double to){
		return artikalEsServiceInterface.findByNazivOrCena(naziv, from, to);
	}
	
// PORUDZBINA --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/porudzbina")
	public void index(@RequestBody PorudzbinaES porudzbinaES) {
		porudzbinaEsServiceInterface.index(porudzbinaES);
	}
	
	@PostMapping("/porudzbinaKomentar")
	public List<PorudzbinaES> getAllPorudzbinaKomentar(@RequestBody TextRequestDTO textRequestDTO){
		return porudzbinaEsServiceInterface.getPorudzbinaByKomentar(textRequestDTO.getText());
	}
	
	@PostMapping("/porudzbinaOcena")
	public List<PorudzbinaEsDTO> getByOcena(@RequestParam(name = "from") int from, @RequestParam(name = "to") int to){
		return porudzbinaEsServiceInterface.findByOcena(from, to);
	}
	
	@PostMapping("/porudzbinaKomentarAndOcena")
	public List<PorudzbinaEsDTO> getByKomentarAndOcena(@RequestParam(name = "komentar") String komentar, @RequestParam(name = "from") int from, @RequestParam(name = "to") int to){
		return porudzbinaEsServiceInterface.findByKomentarAndOcena(komentar, from, to);
	}
	
	@PostMapping("/porudzbinaKomentarOrOcena")
	public List<PorudzbinaEsDTO> getByKomentarOrOcena(@RequestParam(name = "komentar") String komentar, @RequestParam(name = "from") int from, @RequestParam(name = "to") int to){
		return porudzbinaEsServiceInterface.findByKomentarOrOcena(komentar, from, to);
	}
	
	@PostMapping("/porudzbinaCena")
	public List<PorudzbinaEsDTO> getByCenaPorudzbine(@RequestParam(name = "from") double from, @RequestParam(name = "to") double to){
		return porudzbinaEsServiceInterface.findByCenaPorudzbine(from, to);
	}
}
