package com.khashan.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khashan.bean.Urunler;

public class HttpUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static Urunler parseXML(String reqUrl) {
		Urunler urunler = null;
		try {
			URL url = new URL(reqUrl);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			JAXBContext jaxbContext = JAXBContext.newInstance(Urunler.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			InputStream inputStream = conn.getInputStream();
			/*
			 * Reader reader = new InputStreamReader(inputStream); InputSource
			 * inputSource = new InputSource(reader);
			 * inputSource.setEncoding("UTF-8"); // set UTF-8 character enco
			 */
			urunler = (Urunler) jaxbUnmarshaller.unmarshal(inputStream);

		} catch (MalformedURLException e) {
			logger.error("Error MalformedURLException", e);
		} catch (IOException e) {
			logger.error("Error IOException", e.getMessage());

		} catch (JAXBException e) {
			logger.error("Error JAXBException", e);

		}
		return urunler;
	}

}
