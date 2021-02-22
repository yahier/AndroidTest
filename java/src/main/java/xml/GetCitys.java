package xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetCitys extends DefaultHandler {

	static List<String> cityNameList;
	static List<String> cityCodeList;

	final static String defaultprovinceCode = "44";
	final static String defaultprovinceName = "�㶫";
	boolean isIn = false;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		cityNameList = new ArrayList<String>();
		cityCodeList = new ArrayList<String>();
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {

		if (qName.equals("State")) {
			// System.out.println(attributes.getValue(0)+"  "+attributes.getValue(1));
			if (attributes.getValue(0) != null
					&& attributes.getValue(1).equals(defaultprovinceCode)
					&& attributes.getValue(0).equals(defaultprovinceName)) {
				isIn = true;
			} else {
				isIn = false;
			}
			// System.out.println("isIn is  "+isIn);
		}

		// �õ�ʡ��Code
		if (qName.equals("City") && isIn) {
			System.out.println(attributes.getValue(0) + "  yahier");
			cityNameList.add(attributes.getValue(0));
			cityCodeList.add(attributes.getValue(1));
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

	}

	void showCountryList() {

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
			GetCitys parseXml = new GetCitys();
			InputStream stream = SaxParseXml.class.getClassLoader()
					.getResourceAsStream("LocList.xml");
			if (defaultprovinceCode == null)
				return;
			parser.parse(stream, parseXml);
		    //parseXml.check("1", "11", "1");

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