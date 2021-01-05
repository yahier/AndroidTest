package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SaxParseXml extends DefaultHandler {
	static HashMap<String, String> cityMap;
	static Map<String, Map> provinceMap;
	static Map<String, Map> countryMap;

	String provinceCode = "";//
	String countryCode = "";
	final static String defaultContryCode = "1";

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		countryMap = new HashMap<String, Map>();
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {

		if (qName.equals("CountryRegion")) {
			provinceMap = new HashMap<String, Map>();
			countryCode = attributes.getValue(1);
		}

		// �õ�ʡ��Code
		if (qName.equals("State")) {
			cityMap = new HashMap<String, String>();
			if (attributes.getValue(1) != null)
				provinceCode = attributes.getValue(1);
			else
				provinceCode = "";

		}

		if (qName.equals("City")) {
			// System.out.println(attributes.getValue(0));
			// System.out.println("���и�����     " + cityMap.size());
			cityMap.put(attributes.getValue(1), attributes.getValue(0));
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (qName.equals("State")) {
			// System.out.println("end   qName is  " + qName);
			provinceMap.put(provinceCode, cityMap);
			// cityMap.clear();
		}

		if (qName.equals("CountryRegion")) {
			// System.out.println("������      " + countryCode);
			countryMap.put(countryCode, provinceMap);
			// provinceMap.clear();
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
		System.out.println("size  is  " + countryMap.size());
	}

	String check(String countryCode, String proviceCode, String CityCode) {
		if (countryCode.equals(""))
			countryCode = defaultContryCode;
		Map<String, Map> conMap = countryMap.get(countryCode);
		String city = null;
		try {
			Map<String, String> proMap = conMap.get(proviceCode);
			city = proMap.get(CityCode);

		} catch (NullPointerException myNull) {

		}
		if (city == null)
			city = "unKnown";
		System.out.println(city);
		return city;

	}

	public static void main(String[] args) throws ParserConfigurationException {
		SAXParser parser = null;
		try {
			parser = SAXParserFactory.newInstance().newSAXParser();
			SaxParseXml parseXml = new SaxParseXml();
			InputStream stream = SaxParseXml.class.getClassLoader()
					.getResourceAsStream("LocList.xml");

			parser.parse(stream, parseXml);

			parseXml.check("1", "11", "ya");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
