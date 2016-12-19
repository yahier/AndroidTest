package xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RegionSax extends DefaultHandler {

	static HashMap<String, String> cityMap;
	static Map<String, Map> provinceCodeMap;
	static Map<String, Map> countryCodeMap;

	static List<String> countryList;
	// 存储国家名
	static List<String> countryNamesList;
	static List<String> countryCodesList;



	String countryCode = "";
	String countryName;
	final static String defaultContryCode = "1";
	final static String defaultContryName = "中国";

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		countryCodeMap = new HashMap<String, Map>();

		// 装载所有国家code,所有国家名，
		countryList = new ArrayList<String>();
		countryNamesList = new ArrayList<String>();
		countryCodesList = new ArrayList<String>();
		
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {

		if (qName.equals("CountryRegion")) {
			provinceCodeMap = new HashMap<String, Map>();
			// 加入字段名

			countryCode = attributes.getValue(1);
			countryName = attributes.getValue(0);
			countryNamesList.add(countryName);
			countryCodesList.add(countryCode);
		}



	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);


		// 一个国家完了
		if (qName.equals("CountryRegion")) {
			countryCodeMap.put(countryCode, provinceCodeMap);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String data = new String(ch, start, length);
		// System.out.println("data is " + data);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("size  is  " + countryCodeMap.size());

	}


	/**
	 * 根据国家码，省份码，城市码，得到城市名
	 * 
	 * @return
	 */
	String check(String countryCode, String proviceCode, String CityCode) {
		if (countryCode.equals(""))
			countryCode = defaultContryCode;

		Map<String, Map> provinceCodemap = countryCodeMap.get(countryCode);
		String city = null;
		try {
			Map<String, String> proMap = provinceCodemap.get(proviceCode);
			city = proMap.get(CityCode);

		} catch (NullPointerException myNull) {
			System.out.println("参数有误");
		}
		if (city == null)
			city = "unKnown";
		System.out.println(city);
		return city;

	}

	/**
	 * 根据国家名返回国家code
	 * 
	 * @param countryName
	 * @return
	 */
	String checkCountryCode(String countryName) {
		// countryNamesList
		Object[] names = countryNamesList.toArray();
		int index = -1;
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(countryName)) {
				index = i;
			}
		}

		Object[] codes = countryCodesList.toArray();
		System.out.println("国家码是    " + codes[index].toString());
		return codes[index].toString();

	}



}
