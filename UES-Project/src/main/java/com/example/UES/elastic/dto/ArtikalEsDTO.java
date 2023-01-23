package com.example.UES.elastic.dto;

import org.springframework.web.multipart.MultipartFile;

import com.example.UES.elastic.model.ArtikalES;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtikalEsDTO {

    private String naziv;

    private Double cena;
    
    private MultipartFile[] opisFile;
    
	public ArtikalEsDTO(String naziv, Double cena) {
		super();
		this.naziv = naziv;
		this.cena = cena;
	}
    
    //mapper
    public ArtikalEsDTO(ArtikalES artikalEs) {
    	this(artikalEs.getNaziv(), artikalEs.getCena());
    }
	
}
