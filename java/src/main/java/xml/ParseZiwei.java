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

public class ParseZiwei extends DefaultHandler {

	// 省份名称列表 。 怎么加入好呢 你觉得
	static List<String> provinceNameList;
	static List<String> provinceCodeList;

	final static String defaultContryCode = "BHS"; // BEL比利时 state为空
	final static String defaultContryName = "中国";
	boolean isIn = false;
	StringBuffer sb = new StringBuffer();
	String key = "tinsoeng";

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		// System.out.println(1234);
		provinceNameList = new ArrayList<String>();
		provinceCodeList = new ArrayList<String>();
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {
		if (qName.equals("string-array")) {
			String arr = attributes.getValue(0);
			if (arr.equals(key)) {
				isIn = true;
			} else
				isIn = false;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		if (isIn == false)
			return;
		super.characters(ch, start, length);
		String data = new String(ch, start, length);
		
		if (data != null && !data.equals("")) {
			// System.out.println(data);
			//data=data.trim();
			sb.append(data);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		// System.out.println("文档结束了");
		showList();

	}

	void showList() {
		System.out.println(sb.toString());
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
			ParseZiwei parseXml = new ParseZiwei();
			InputStream stream = SaxParseXml.class.getClassLoader()
					.getResourceAsStream("arrays.xml");
			parser.parse(stream, parseXml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
