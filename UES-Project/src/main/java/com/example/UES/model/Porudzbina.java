package com.example.UES.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "porudzbina")
public class Porudzbina {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPorudzbina", nullable = false, unique = true)
	private Long idPorudzbina;
	
	@Column(name = "satnica", nullable = false)
	private Date satnica;
	
	@Column(name = "ocena", nullable = false)
	private int ocena;
	
	@Column(name = "komentar", nullable = false)
	private String komentar;
	
	@Column(name = "dostavljeno", nullable = false)
	private boolean dostavljeno;
	
	@Column(name = "anonimanKomentar", nullable = false)
	private boolean anonimanKomentar;
	
	@Column(name = "arhiviranKomentar", nullable = false)
	private boolean arhiviranKomentar;
	
	@ManyToOne
	@JoinColumn(name = "korisnik", referencedColumnName = "idKorisnik", nullable = false)
	private Kupac kupac;
	
	@OneToOne
	@JoinColumn(name = "artikal", referencedColumnName = "idArtikal", nullable = false)
	private Artikal artikal;
	
	public Porudzbina() {
		super();
	}

	public Porudzbina(Long idPorudzbina, Date satnica, int ocena, String komentar, boolean dostavljeno,
			boolean anonimanKomentar, boolean arhiviranKomentar, Kupac kupac, Artikal artikal) {
		super();
		this.idPorudzbina = idPorudzbina;
		this.satnica = satnica;
		this.ocena = ocena;
		this.komentar = komentar;
		this.dostavljeno = dostavljeno;
		this.anonimanKomentar = anonimanKomentar;
		this.arhiviranKomentar = arhiviranKomentar;
		this.kupac = kupac;
		this.artikal = artikal;
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

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	
}
