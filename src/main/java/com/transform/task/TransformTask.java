package com.transform.task;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transform.bean.Row;
import com.transform.bean.ToUrnler;
import com.transform.bean.ToUrun;
import com.transform.bean.Urun;
import com.transform.bean.UrunAciklama;
import com.transform.bean.Urunler;
import com.transform.util.HttpUtil;
import com.transform.util.PropertiesManager;

public class TransformTask extends TaskExecutor {

	private static final String FILE_PATH = "C:\\";
	private static final String FILE_NAME = "kachan.xml";
	private static final Logger log = LoggerFactory.getLogger(TransformTask.class);
	private static final String XML_URL_ENDPOINT = "xml.url.endpoint";
	public static volatile Boolean update = false;

	@Override
	public void doTask() {
		log.warn("#### STARTED EXECUTING TRANSFORM TASK NOW ####");
		try {

			Urunler urunler = HttpUtil.parseXML(PropertiesManager.getInstance().getProperty(XML_URL_ENDPOINT));
			if (urunler != null) {
				ToUrnler toUrnler = new ToUrnler();
				toUrnler.setToplam(urunler.getToplam());
				List<Urun> urun = urunler.getUrun();
				if (!urun.isEmpty()) {
					log.debug("Size of Uruns retrieved is: {}", urun.size());
					for (Urun urunItem : urun) {
						ToUrun toUrun = new ToUrun();
						toUrun.setUrunAd(urunItem.getUrunAd());
						toUrun.setUrunFiyat(urunItem.getUrunFiyat());
						toUrun.setUrunGaranti(urunItem.getUrunGaranti());
						toUrun.setUrunGorsel(urunItem.getUrunGorsel());
						toUrun.setUrunKategori(urunItem.getUrunKategori());
						toUrun.setUrunKDV(urunItem.getUrunKDV());
						toUrun.setUrunKod(urunItem.getUrunKod());
						toUrun.setUrunKur(urunItem.getUrunKur());
						toUrun.setUrunStok(urunItem.getUrunStok());
						String urunAciklama = urunItem.getUrunAciklama();
						if (urunAciklama != null && !"".equals(urunAciklama)) {
							UrunAciklama uAciklama = new UrunAciklama();
							Document doc = Jsoup.parse(urunAciklama);
							for (Element table : doc.select("table")) {
								for (Element tr : table.select("tr")) {
									Row row = new Row(tr.select("td").get(0).text(), tr.select("td").get(1).text());
									uAciklama.getRows().add(row);
								}
							}
							toUrun.setUrunAciklama(uAciklama);
						}
						toUrnler.getUrun().add(toUrun);
					}
				}

				File file = new File(FILE_PATH + FILE_NAME);
				JAXBContext jaxbContext = JAXBContext.newInstance(ToUrnler.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(toUrnler, file);
			}

		} catch (Exception e) {
			log.error("ERROR while EXECUTING TRANSFORM TASK", e);
		}
		log.warn("#### FINISHED EXECUTING TRANSFORM TASK NOW ####");

	}

}
