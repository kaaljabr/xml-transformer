package com.khashan.bean;

import javax.xml.bind.annotation.XmlElement;

public class Row {

	private String key;

	private String value;

	public Row(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@XmlElement(name = "Key")
	public void setKey(String key) {
		this.key = key;
	}

	@XmlElement(name = "Value")
	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}
