package com.example.UES.elastic.serviceInterface;

import java.io.IOException;
import java.util.List;

import com.example.UES.elastic.dto.ArtikalEsDTO;
import com.example.UES.elastic.model.ArtikalES;


public interface ArtikalEsServiceInterface {

	void index(ArtikalES artikalEs);
	
	List<ArtikalES> getArtikalByNaziv(String naziv);
	
	List<ArtikalES> getArtikalByOpis(String opis);
	
	void reindex();
	
	void indexUploadFile(ArtikalEsDTO artikalEsDTO) throws IOException;
	
	List<ArtikalEsDTO> findByNaziv(String naziv);
	
	public ArtikalES save(ArtikalES artikalES);
	
	List<ArtikalEsDTO> findByCena(double from, double to);
	
	List<ArtikalEsDTO> findByNazivAndCena(String naziv, double from, double to);
	
	List<ArtikalEsDTO> findByNazivOrCena(String naziv, double from, double to);
	
}
