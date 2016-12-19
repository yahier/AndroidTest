package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXPersonService {
	public static void main(String[] args) throws Exception {

		SAXPersonService sax = new SAXPersonService();
		FileInputStream input = new FileInputStream("D://my.xml");
		System.out.println(sax.getPerson(input));

	}

	public List<PersonBean> getPerson(InputStream inStream) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();// 得到解析器
		PersonHanlder hanlder = new PersonHanlder();// 得到继承自DefaultHandler的对象
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
				// 得到第一个属性 id
			}

			tag = localName;// tag==person
		}

		@Override
		// 处理文本类型节点
		public void characters(char[] ch, int start, int length)// 参数所表示的是什么
																// 在xml中的表示
				throws SAXException {
			// TODO Auto-generated method stub
			/*
			 * String data = new String(ch, start, length); if(c==stu){
			 * c.add(data) }
			 */
			if (tag != null) {
				String data = new String(ch, start, length);// 数组 起始位置和 结束位置
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
