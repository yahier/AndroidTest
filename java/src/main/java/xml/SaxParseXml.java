package xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 根据(countCode,provinceCode,cityCode)得到城市名
 * 解析区域表   形式是 三层map嵌套 已经完好
 * @author lenovo
 *
 */
public class SaxParseXml extends DefaultHandler {
	static HashMap<String, String> cityMap;
	static Map<String, Map> provinceMap;
	static Map<String, Map> countryMap;

	String provinceCode = "";// 有的根本没有这个值
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

		// 得到省份Code
		if (qName.equals("State")) {
			cityMap = new HashMap<String, String>();
			if (attributes.getValue(1) != null)
				provinceCode = attributes.getValue(1);
			else
				provinceCode = "";

		}

		if (qName.equals("City")) {
			// System.out.println(attributes.getValue(0));
			// System.out.println("城市个数是     " + cityMap.size());
			cityMap.put(attributes.getValue(1), attributes.getValue(0));
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		// 一个省份完了
		if (qName.equals("State")) {
			// System.out.println("end   qName is  " + qName);
			provinceMap.put(provinceCode, cityMap);
			// 我本来觉得 已经 clear的啊 哦 其实不用 因为本来也要重新得到新的map
			// cityMap.clear();
		}

		// 一个国家完了
		if (qName.equals("CountryRegion")) {
			// System.out.println("国家有      " + countryCode);
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

	/**
	 *  有可能没有写国家 ， 有可能只填写省份 默认第一站
	 * @return
	 */
	String check(String countryCode, String proviceCode, String CityCode) {
		if (countryCode.equals(""))
			countryCode = defaultContryCode;
		Map<String, Map> conMap = countryMap.get(countryCode);
		String city = null;
		try {
			Map<String, String> proMap = conMap.get(proviceCode);
			city = proMap.get(CityCode);

		} catch (NullPointerException myNull) {
			System.out.println("城市判断失误");
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
