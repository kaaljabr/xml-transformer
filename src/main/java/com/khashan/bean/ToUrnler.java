package com.khashan.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Urunler")
public class ToUrnler {
	private List<ToUrun> urun = new ArrayList<ToUrun>();

	private String toplam;

	@XmlElement(name = "Urun")
	public void setUrun(List<ToUrun> urun) {
		this.urun = urun;
	}

	@XmlElement(name = "Toplam")
	public void setToplam(String toplam) {
		this.toplam = toplam;
	}

	public String getToplam() {
		return toplam;
	}

	public List<ToUrun> getUrun() {
		return urun;
	}

	@Override
	public String toString() {
		return "ClassPojo [Urun = " + urun + ", Toplam = " + toplam + "]";
	}
}