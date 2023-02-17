package com.example.UES.elastic.mapper;

import java.util.List;

import org.springframework.data.elasticsearch.core.SearchHits;

import com.example.UES.elastic.dto.PorudzbinaEsDTO;
import com.example.UES.elastic.model.PorudzbinaES;

public class PorudzbinaMapper {

	public static List<PorudzbinaEsDTO> mapDtos(SearchHits<PorudzbinaES> porudzbinaSearchHits){
		return porudzbinaSearchHits
				.map(porudzbinaES -> mapDto(porudzbinaES.getContent()))
				.toList();
	}
	
	private static PorudzbinaEsDTO mapDto(PorudzbinaES porudzbinaES) {
		return PorudzbinaEsDTO.builder()
				.datum(porudzbinaES.getDatum())
				.ocena(porudzbinaES.getOcena())
				.komentar(porudzbinaES.getKomentar())
				.anonimanKomentar(porudzbinaES.isAnonimanKomentar())
				.build();
	}
	
}
