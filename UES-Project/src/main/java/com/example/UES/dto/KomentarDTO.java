package com.example.UES.dto;

import com.example.UES.model.Komentar;

public class KomentarDTO {
	
	private Long idKomentar;
	private String tekst;
	private Integer ocena;
	private boolean prihvacen;
	private boolean arhiviran;
	private String idArtikla;
	private String artikal;
	private String idKupac;
	private String kupac;
	
	public KomentarDTO() {
		super();
	}
	
	public KomentarDTO(Long idKomentar, String tekst, Integer ocena, boolean prihvacen, boolean arhiviran, String idArtikla, String artikal,
			String idKupac, String kupac) {
		super();
		this.idKomentar = idKomentar;
		this.tekst = tekst;
		this.ocena = ocena;
		this.prihvacen = prihvacen;
		this.arhiviran = arhiviran;
		this.idArtikla = idArtikla;
		this.artikal = artikal;
		this.idKupac = idKupac;
		this.kupac = kupac;
	}

	public KomentarDTO(Komentar komentar) {
		this(komentar.getIdKomentar(), komentar.getTekst(), komentar.getOcena(), komentar.isPrihvacen(), komentar.isArhiviran(), komentar.getArtikal().getIdArtikal().toString(), komentar.getArtikal().getNaziv(), komentar.getKupac().getIdKorisnik().toString(), komentar.getKupac().getKorisnickoIme());
	}

	public Long getIdKomentar() {
		return idKomentar;
	}

	public void setIdKomentar(Long idKomentar) {
		this.idKomentar = idKomentar;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public boolean isPrihvacen() {
		return prihvacen;
	}

	public void setPrihvacen(boolean prihvacen) {
		this.prihvacen = prihvacen;
	}

	public boolean isArhiviran() {
		return arhiviran;
	}

	public void setArhiviran(boolean arhiviran) {
		this.arhiviran = arhiviran;
	}

	public String getIdArtikla() {
		return idArtikla;
	}

	public void setIdArtikla(String idArtikla) {
		this.idArtikla = idArtikla;
	}

	public String getArtikal() {
		return artikal;
	}

	public void setArtikal(String artikal) {
		this.artikal = artikal;
	}

	public String getIdKupac() {
		return idKupac;
	}

	public void setIdKupac(String idKupac) {
		this.idKupac = idKupac;
	}

	public String getKupac() {
		return kupac;
	}

	public void setKupac(String kupac) {
		this.kupac = kupac;
	}

}
