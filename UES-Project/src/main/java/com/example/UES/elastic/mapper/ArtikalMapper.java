package com.example.UES.elastic.mapper;

import java.util.List;

import org.springframework.data.elasticsearch.core.SearchHits;

import com.example.UES.elastic.dto.ArtikalEsDTO;
import com.example.UES.elastic.model.ArtikalES;

public class ArtikalMapper {
	
	public static List<ArtikalEsDTO> mapDtos(SearchHits<ArtikalES> artikalSearchHits){
		return artikalSearchHits
				.map(artikalES -> mapDto(artikalES.getContent()))
				.toList();
	}
	
	private static ArtikalEsDTO mapDto(ArtikalES artikalES) {
		return ArtikalEsDTO.builder()
				.naziv(artikalES.getNaziv())
				.cena(artikalES.getCena())
				.build();
	}

}
