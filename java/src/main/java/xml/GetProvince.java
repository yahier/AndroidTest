package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class GetProvince extends DefaultHandler {

	static List<String> provinceNameList;
	static List<String> provinceCodeList;

	final static String defaultContryCode = "BHS";
	boolean isIn = false;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		provinceNameList = new ArrayList<String>();
		provinceCodeList = new ArrayList<String>();
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {

		if (qName.equals("CountryRegion")) {
			if (attributes.getValue(1).equals(defaultContryCode)) {
				isIn = true;
			} else {
				isIn = false;
			}
		}

		if (qName.equals("State") && isIn) {
			provinceNameList.add(attributes.getValue(0));
			provinceCodeList.add(attributes.getValue(1));
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (qName.equals("State")) {

		}

		if (qName.equals("CountryRegion")) {

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
		System.out.println("�ĵ�������");
		showCountryList();

	}

	void showCountryList() {

		// countryNamesList
		Object[] names = provinceNameList.toArray();
		int index = -1;
		for (int i = 0; i < names.length; i++) {
			System.out.println("name:  "+names[i]);
		}

	

	
	}
	
	

	public static void main(String[] args) {

		SAXParser parser = null;
		try {
			try {
				parser = SAXParserFactory.newInstance().newSAXParser();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GetProvince parseXml = new GetProvince();
			InputStream stream = SaxParseXml.class.getClassLoader()
					.getResourceAsStream("LocList.xml");

			parser.parse(stream, parseXml);
			// parseXml.check("1", "11", "1");

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