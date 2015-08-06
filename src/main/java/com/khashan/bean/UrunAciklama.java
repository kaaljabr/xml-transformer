package com.khashan.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class UrunAciklama {

	private List<Row> rows = new ArrayList<Row>();

	@XmlElement(name = "Row")
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	/**
	 * @return the rows
	 */
	public List<Row> getRows() {
		return rows;
	}

}
