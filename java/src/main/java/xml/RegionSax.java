package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegionSax extends DefaultHandler {

	static HashMap<String, String> cityMap;
	static Map<String, Map> provinceCodeMap;
	static Map<String, Map> countryCodeMap;

	static List<String> countryList;
	static List<String> countryNamesList;
	static List<String> countryCodesList;



	String countryCode = "";
	String countryName;
	final static String defaultContryCode = "1";
	final static String defaultContryName = "�й�";

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		countryCodeMap = new HashMap<String, Map>();

		// װ�����й���code,���й�������
		countryList = new ArrayList<String>();
		countryNamesList = new ArrayList<String>();
		countryCodesList = new ArrayList<String>();
		
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {

		if (qName.equals("CountryRegion")) {
			provinceCodeMap = new HashMap<String, Map>();
			// �����ֶ���

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
	 * ���ݹ����룬ʡ���룬�����룬�õ�������
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
			System.out.println("��������");
		}
		if (city == null)
			city = "unKnown";
		System.out.println(city);
		return city;

	}

	/**
	 * ���ݹ��������ع���code
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
		System.out.println("��������    " + codes[index].toString());
		return codes[index].toString();

	}



}
