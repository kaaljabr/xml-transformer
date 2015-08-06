package com.transform.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Urunler")
public class Urunler {
	private List<Urun> urun = new ArrayList<Urun>();

	private String toplam;

	@XmlElement(name = "Urun")
	public void setUrun(List<Urun> urun) {
		this.urun = urun;
	}

	@XmlElement(name = "Toplam")
	public void setToplam(String toplam) {
		this.toplam = toplam;
	}

	public String getToplam() {
		return toplam;
	}

	public List<Urun> getUrun() {
		return urun;
	}

	@Override
	public String toString() {
		return "ClassPojo [Urun = " + urun + ", Toplam = " + toplam + "]";
	}
}