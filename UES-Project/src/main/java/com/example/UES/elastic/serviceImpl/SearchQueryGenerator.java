package com.example.UES.elastic.serviceImpl;

import org.elasticsearch.index.query.QueryBuilder;

import com.example.UES.elastic.dto.SimpleQueryES;
import com.example.UES.lucene.search.QueryBuilderCustom;
import com.example.UES.util.SearchType;

public class SearchQueryGenerator {
	
    public static QueryBuilder createMatchQueryBuilder(SimpleQueryES simpleQueryES) {

        if(simpleQueryES.getValue().startsWith("\"") && simpleQueryES.getValue().endsWith("\"") ){
            return QueryBuilderCustom.buildQuery(SearchType.PHRASE, simpleQueryES.getField(), simpleQueryES.getValue());

        }else{
            return QueryBuilderCustom.buildQuery(SearchType.MATCH,simpleQueryES.getField(),simpleQueryES.getValue());
        }
    }
    
    public static QueryBuilder createRangeQueryBuilder(SimpleQueryES simpleQueryES){
        return QueryBuilderCustom.buildQuery(SearchType.RANGE, simpleQueryES.getField(), simpleQueryES.getValue());

    }

}

