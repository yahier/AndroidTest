package xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxLocation {
	public static void main(String[] args) {
		RegionSax regionSax = new RegionSax();
		sax(regionSax);
		//System.out.println(regionSax.countryNamesList.size());
		changeListToStrArray(regionSax.countryNamesList);
	}

	static void sax(DefaultHandler object) {
		SAXParser parser = null;
		try {
			try {
				parser = SAXParserFactory.newInstance().newSAXParser();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			InputStream stream = SaxParseXml.class.getClassLoader()
					.getResourceAsStream("LocList.xml");

			parser.parse(stream, object);
			// parseXml.check("1", "11", "1");
			// parseXml.checkCountryCode("阿富汗");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 将list转成arrays
	 */
	static void changeListToStrArray(List list) {
		String[] objs = (String[]) list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(objs));
		

	}

}
