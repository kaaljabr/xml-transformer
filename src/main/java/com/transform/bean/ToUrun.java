package com.transform.bean;

import javax.xml.bind.annotation.XmlElement;

public class ToUrun {
	private String urunFiyat;

	private String urunGaranti;

	private String urunStok;

	private String urunAd;

	private String urunKur;

	private String urunKategori;

	private String urunKod;

	private UrunGorsel urunGorsel;

	private String urunKDV;

	private UrunAciklama urunAciklama;

	@XmlElement(name = "UrunAciklama")
	public void setUrunAciklama(UrunAciklama urunAciklama) {
		this.urunAciklama = urunAciklama;
	}

	@XmlElement(name = "UrunFiyat")
	public void setUrunFiyat(String urunFiyat) {
		this.urunFiyat = urunFiyat;
	}

	@XmlElement(name = "UrunGaranti")
	public void setUrunGaranti(String urunGaranti) {
		this.urunGaranti = urunGaranti;
	}

	@XmlElement(name = "UrunStok")
	public void setUrunStok(String urunStok) {
		this.urunStok = urunStok;
	}

	@XmlElement(name = "UrunAd")
	public void setUrunAd(String urunAd) {
		this.urunAd = urunAd;
	}

	@XmlElement(name = "UrunKur")
	public void setUrunKur(String urunKur) {
		this.urunKur = urunKur;
	}

	@XmlElement(name = "UrunKategori")
	public void setUrunKategori(String urunKategori) {
		this.urunKategori = urunKategori;
	}

	@XmlElement(name = "UrunKod")
	public void setUrunKod(String urunKod) {
		this.urunKod = urunKod;
	}

	@XmlElement(name = "UrunGorsel")
	public void setUrunGorsel(UrunGorsel urunGorsel) {
		this.urunGorsel = urunGorsel;
	}

	@XmlElement(name = "UrunKDV")
	public void setUrunKDV(String urunKDV) {
		this.urunKDV = urunKDV;
	}

	public String getUrunFiyat() {
		return urunFiyat;
	}

	public String getUrunGaranti() {
		return urunGaranti;
	}

	public String getUrunStok() {
		return urunStok;
	}

	public String getUrunAd() {
		return urunAd;
	}

	public String getUrunKur() {
		return urunKur;
	}

	public String getUrunKategori() {
		return urunKategori;
	}

	public String getUrunKod() {
		return urunKod;
	}

	public UrunGorsel getUrunGorsel() {
		return urunGorsel;
	}

	public String getUrunKDV() {
		return urunKDV;
	}

	public UrunAciklama getUrunAciklama() {
		return urunAciklama;
	}

	@Override
	public String toString() {
		return "ClassPojo [UrunFiyat = " + urunFiyat + ", UrunGaranti = " + urunGaranti + ", UrunStok = " + urunStok
				+ ", UrunAd = " + urunAd + ", UrunKur = " + urunKur + ", UrunKategori = " + urunKategori
				+ ", UrunKod = " + urunKod + ", UrunGorsel = " + urunGorsel + ", UrunKDV = " + urunKDV + "]";
	}
}
