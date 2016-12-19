package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

/**'
 * 测试生成xml文档，失败
 * @author lenovo
 *
 */

public class Create {
	public static void main(String[] args) {
		try {
			new Create().a();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void a() throws ParserConfigurationException, FileNotFoundException{
		  Document dom=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		  Element root=dom.createElement("XVal");//添加根元素,Xval
		  root.setAttribute("X", "X字符串的值");
		  root.setTextContent("Xval标签中间的值");
		  
		 // String xml=dom.asXML();
		  String xml= dom.getTextContent();
		  
		  
		  File f=new File("d:/xml.xml");
		  PrintWriter pw=new PrintWriter(f);
		  pw.write(xml);
		  pw.close();
	}

}
