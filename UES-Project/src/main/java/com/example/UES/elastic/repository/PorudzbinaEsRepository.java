package com.example.UES.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.UES.elastic.model.PorudzbinaES;

@Repository
public interface PorudzbinaEsRepository extends ElasticsearchRepository<PorudzbinaES, String>{

	List<PorudzbinaES> findAllByKomentar(String komentar);
	
}
