package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXPersonService {
	public static void main(String[] args) throws Exception {

		SAXPersonService sax = new SAXPersonService();
		FileInputStream input = new FileInputStream("D://my.xml");
		System.out.println(sax.getPerson(input));

	}

	public List<PersonBean> getPerson(InputStream inStream) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();//
		PersonHanlder hanlder = new PersonHanlder();//
		parser.parse(inStream, hanlder);
		return hanlder.getPersons();
	}

	private class PersonHanlder extends DefaultHandler {
		private List<PersonBean> persons;
		PersonBean person = null;
		private String tag = null;

		public List<PersonBean> getPersons() {
			return persons;
		}

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			persons = new ArrayList<PersonBean>();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			// TODO Auto-generated method stub

			if ("person".equals(localName)) {
				person = new PersonBean();
				person.setId(new Integer(attributes.getValue(0)));
				// �õ���һ������ id
			}

			tag = localName;// tag==person
		}

		@Override
		public void characters(char[] ch, int start, int length)//
				throws SAXException {
			// TODO Auto-generated method stub
			/*
			 * String data = new String(ch, start, length); if(c==stu){
			 * c.add(data) }
			 */
			if (tag != null) {
				String data = new String(ch, start, length);//
				if ("name".equals(tag)) {

					person.setName(data);
				} else if ("age".equals(tag)) {
					person.setAge(new Short(data));
				}

			}

		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			if ("person".equals(localName)) {
				persons.add(person);
				person = null;
			}
			tag = null;
		}

	}
}
