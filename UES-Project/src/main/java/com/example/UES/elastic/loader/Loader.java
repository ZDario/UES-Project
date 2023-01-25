package com.example.UES.elastic.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.UES.elastic.model.ArtikalES;
import com.example.UES.elastic.model.PorudzbinaES;
import com.example.UES.elastic.repository.ArtikalEsRepository;
import com.example.UES.elastic.repository.PorudzbinaEsRepository;
import com.example.UES.elastic.serviceImpl.ArtikalEsService;
import com.example.UES.model.Artikal;
import com.example.UES.model.Porudzbina;
import com.example.UES.repository.ArtikalRepository;
import com.example.UES.repository.PorudzbinaRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {

    /*Komponenta služi da prilikom svakog pokretanja podatke iz sql ubacuje u elastic search bazu*/

    @Autowired
    ArtikalRepository artikalRepository;

    @Autowired
    ArtikalEsRepository artikalEsRepository;

    @Autowired
    ArtikalEsService artikalESService;
    
    @Autowired
    PorudzbinaRepository porudzbinaRepository;
    
    @Autowired
    PorudzbinaEsRepository porudzbinaEsRepository;

	@PostConstruct
    @Transactional
    public void loadAll(){
		
        List<ArtikalES> artikliES = new ArrayList<>();
        for(Artikal artikal: artikalRepository.findAll()){
        	
        	//ovaj if da se ne bi stalno duplirale vrednosti u elasticsearchu
        	if(artikal.getNaziv() != null) {
        		continue;
        	}else {
        		artikliES.add(new ArtikalES(artikal));
        	}        	
        }
        artikalEsRepository.saveAll(artikliES);
        
        List<PorudzbinaES> porudzbinaES = new ArrayList<>();
        for(Porudzbina porudzbina: porudzbinaRepository.findAll()){
        	
        	//ovaj if da se ne bi stalno duplirale vrednosti u elasticsearchu
        	if(porudzbina.getKomentar() != null) {
        		continue;
        	}else {
        		porudzbinaES.add(new PorudzbinaES(porudzbina));
        	} 	
        }
        porudzbinaEsRepository.saveAll(porudzbinaES);

    }
}