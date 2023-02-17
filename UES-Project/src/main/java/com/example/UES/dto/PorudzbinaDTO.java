package com.example.UES.dto;

import java.util.Date;

import com.example.UES.model.Porudzbina;

public class PorudzbinaDTO {
	
	private Long idPorudzbina;
	private Date satnica;
	private int ocena;
	private String komentar;
	private boolean dostavljeno;
	private boolean anonimanKomentar;
	private boolean arhiviranKomentar;
	private String idKupac;
	private String kupac;
	private String idArtikal;
	private String artikal;
	
	public PorudzbinaDTO() {
		super();
	}

	public PorudzbinaDTO(Long idPorudzbina, Date satnica, int ocena, String komentar, boolean dostavljeno,
			boolean anonimanKomentar, boolean arhiviranKomentar, String idKupac, String kupac, String idArtikal, String artikal) {
		super();
		this.idPorudzbina = idPorudzbina;
		this.satnica = satnica;
		this.ocena = ocena;
		this.komentar = komentar;
		this.dostavljeno = dostavljeno;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
		this.idKupac = idKupac;
		this.kupac = kupac;
		this.idArtikal = idArtikal;
		this.artikal = artikal;
	}

	public PorudzbinaDTO(Porudzbina p) {
		this(p.getIdPorudzbina(), p.getSatnica(), p.getOcena(), p.getKomentar(), p.isDostavljeno(), p.isAnonimanKomentar(), p.isArhiviranKomentar(), 
				p.getKupac().getIdKorisnik().toString(), p.getKupac().getKorisnickoIme(), p.getArtikal().getIdArtikal().toString(), p.getArtikal().getNaziv());
	}

	public Long getIdPorudzbina() {
		return idPorudzbina;
	}

	public void setIdPorudzbina(Long idPorudzbina) {
		this.idPorudzbina = idPorudzbina;
	}

	public Date getSatnica() {
		return satnica;
	}

	public void setSatnica(Date satnica) {
		this.satnica = satnica;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public boolean isDostavljeno() {
		return dostavljeno;
	}

	public void setDostavljeno(boolean dostavljeno) {
		this.dostavljeno = dostavljeno;
	}

	public boolean isAnonimanKomentar() {
		return anonimanKomentar;
	}

	public void setAnonimanKomentar(boolean anonimanKomentar) {
		this.anonimanKomentar = anonimanKomentar;
	}

	public boolean isArhiviranKomentar() {
		return arhiviranKomentar;
	}

	public void setArhiviranKomentar(boolean arhiviranKomentar) {
		this.arhiviranKomentar = arhiviranKomentar;
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

	public String getIdArtikal() {
		return idArtikal;
	}

	public void setIdArtikal(String idArtikal) {
		this.idArtikal = idArtikal;
	}

	public String getArtikal() {
		return artikal;
	}

	public void setArtikal(String artikal) {
		this.artikal = artikal;
	}


}
