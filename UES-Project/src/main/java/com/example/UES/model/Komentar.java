package com.example.UES.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "komentar")
public class Komentar {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idKomentar", nullable = false, unique = true)
	private Long idKomentar;
	
	@Column(name = "tekst", nullable = false)
	private String tekst;
	
	@Column(name = "ocena", nullable = false)
	private Integer ocena;
	
	@Column(name = "prihvacen", nullable = false)
	private boolean prihvacen;
	
	@Column(name = "arhiviran", nullable = false)
	private boolean arhiviran;
	
	@ManyToOne
	@JoinColumn(name = "artikal", referencedColumnName = "idArtikal", nullable = true)
	private Artikal artikal;
	
	@ManyToOne
	@JoinColumn(name = "korisnik", referencedColumnName = "idKorisnik", nullable = true)
	private Kupac kupac;
	
	public Komentar() {
		super();
	}

	public Komentar(Long idKomentar, String tekst, Integer ocena, boolean prihvacen, boolean arhiviran, Artikal artikal, Kupac kupac) {
		super();
		this.idKomentar = idKomentar;
		this.tekst = tekst;
		this.ocena = ocena;
		this.prihvacen = prihvacen;
		this.arhiviran = arhiviran;
		this.artikal = artikal;
		this.kupac = kupac;
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

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}
}
