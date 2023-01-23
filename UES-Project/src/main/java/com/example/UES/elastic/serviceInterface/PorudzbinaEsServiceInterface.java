package com.example.UES.elastic.serviceInterface;

import java.util.List;

import com.example.UES.elastic.dto.PorudzbinaEsDTO;
import com.example.UES.elastic.model.PorudzbinaES;

public interface PorudzbinaEsServiceInterface {

	void index(PorudzbinaES porudzbinaES);
	
	List<PorudzbinaES> getPorudzbinaByKomentar(String komentar);
	
	List<PorudzbinaEsDTO> findByOcena(int from, int to);
	
	List<PorudzbinaEsDTO> findByKomentarAndOcena(String komentar, int from, int to);
	
	List<PorudzbinaEsDTO> findByKomentarOrOcena(String komentar, int from, int to);
	
	List<PorudzbinaEsDTO> findByCenaPorudzbine(double from, double to);
	
}
