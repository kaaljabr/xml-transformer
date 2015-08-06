package com.khashan.bean;

import javax.xml.bind.annotation.XmlElement;

public class UrunGorsel {
	private String img;

	public String getImg() {
		return img;
	}

	@XmlElement(name = "IMG1")
	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ClassPojo [IMG1 = " + img + "]";
	}
}