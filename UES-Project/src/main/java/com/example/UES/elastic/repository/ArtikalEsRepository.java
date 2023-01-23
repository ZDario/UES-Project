package com.example.UES.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.UES.elastic.model.ArtikalES;

@Repository
public interface ArtikalEsRepository extends ElasticsearchRepository<ArtikalES, String>{

	List<ArtikalES> findAllByNaziv(String naziv);
	
	List<ArtikalES> findAllByOpis(String opis);
	
}
