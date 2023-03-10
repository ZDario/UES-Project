package com.example.UES.elastic.serviceImpl;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.example.UES.elastic.dto.PorudzbinaEsDTO;
import com.example.UES.elastic.dto.SimpleQueryES;
import com.example.UES.elastic.mapper.PorudzbinaMapper;
import com.example.UES.elastic.model.PorudzbinaES;
import com.example.UES.elastic.repository.PorudzbinaEsRepository;
import com.example.UES.elastic.serviceInterface.PorudzbinaEsServiceInterface;

@Service
public class PorudzbinaEsService implements PorudzbinaEsServiceInterface{

	private final PorudzbinaEsRepository porudzbinaEsRepository;
	private final ElasticsearchRestTemplate elasticsearchRestTemplate;
	
	public PorudzbinaEsService(PorudzbinaEsRepository porudzbinaEsRepository, ElasticsearchRestTemplate elasticsearchRestTemplate) {
		this.porudzbinaEsRepository = porudzbinaEsRepository;
		this.elasticsearchRestTemplate = elasticsearchRestTemplate;
	}

	@Override
	public void index(PorudzbinaES porudzbinaES) {
		porudzbinaEsRepository.save(porudzbinaES);
	}

	@Override
	public List<PorudzbinaES> getPorudzbinaByKomentar(String komentar) {
		return porudzbinaEsRepository.findAllByKomentar(komentar);
	}

	@Override
	public List<PorudzbinaEsDTO> findByOcena(int from, int to) {

		String range = from + "-" + to;
		
		QueryBuilder ocenaQuery = SearchQueryGenerator.createRangeQueryBuilder(new SimpleQueryES("ocena", range));
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
				.must(ocenaQuery);
		
		return PorudzbinaMapper.mapDtos(searchByBoolQuery(boolQuery));
		
	}

    private SearchHits<PorudzbinaES> searchByBoolQuery(BoolQueryBuilder boolQuery) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQuery)
                .build();

        return elasticsearchRestTemplate.search(searchQuery, PorudzbinaES.class,  IndexCoordinates.of("porudzbine"));
    }

	@Override
	public List<PorudzbinaEsDTO> findByKomentarAndOcena(String komentar, int from, int to) {

		String ocena = from + "-" + to;
		QueryBuilder komentarQuery = SearchQueryGenerator.createMatchQueryBuilder(new SimpleQueryES("komentar", komentar));
		QueryBuilder ocenaQuery = SearchQueryGenerator.createRangeQueryBuilder(new SimpleQueryES("ocena", ocena));
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
				.must(komentarQuery)
				.must(ocenaQuery);
		
		return PorudzbinaMapper.mapDtos(searchByBoolQuery(boolQuery));
		
	}

	@Override
	public List<PorudzbinaEsDTO> findByKomentarOrOcena(String komentar, int from, int to) {

		String ocena = from + "-" + to;
		QueryBuilder komentarQuery = SearchQueryGenerator.createMatchQueryBuilder(new SimpleQueryES("komentar", komentar));
		QueryBuilder ocenaQuery = SearchQueryGenerator.createRangeQueryBuilder(new SimpleQueryES("ocena", ocena));
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
				.should(komentarQuery)
				.should(ocenaQuery);
		
		return PorudzbinaMapper.mapDtos(searchByBoolQuery(boolQuery));
		
	}

	@Override
	public List<PorudzbinaEsDTO> findByCenaPorudzbine(double from, double to) {

		String range = from + "-" + to;
		
		QueryBuilder priceQuery = SearchQueryGenerator.createRangeQueryBuilder(new SimpleQueryES("cena", range));
		
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
				.must(priceQuery);
		
		return PorudzbinaMapper.mapDtos(searchByBoolQuery(boolQuery));
		
	}

}
