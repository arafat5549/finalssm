package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXWriter;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.google.common.base.Strings;
import com.ssf.common.utils.StringUtilss;
import com.ssf.common.utils.XmlParserUtilss;

public class XmlParseUtilsTest {

	@Test
	public void convertXmlStrToObjectTest() throws SAXException, IOException {
		//String inputXML = "<item><MANDT>300</MANDT><POSNR>000010</POSNR><MATNR>000000000006020001</MATNR><KWMENG>34.000</KWMENG><VRKME1>KG</VRKME1><LFIMG>12.000</LFIMG><REKMG>22.000</REKMG><VRKME2>KG</VRKME2><KBETR>440.00</KBETR><NETPR>440.00</NETPR><NETWR>0.00</NETWR><WAERK>CNY</WAERK></item>";
		String xmlPath ="src/main/resources/generatorConfigBak.xml";
		Document document = XmlParserUtilss.getDocument(xmlPath);
		//System.out.println(document.getRootElement());
		//document.selectSingleNode(xpathExpression)
		Element rootElement = XmlParserUtilss.getRootNode(document);
		
		Node node = XmlParserUtilss.getSingleNode(rootElement,"table");
		String baseName = "product";
		String tableName = "sys_"+baseName;
		String domain = StringUtils.capitalize(baseName);
		
		//Element node = rootElement.element("table");
		//rootElement.attribute(node);
		
		
		Element ele = XmlParserUtilss.getChild(node.getParent(), "table");
		System.out.println(ele.toString());
		//ele.setAttributeValue(name, value);
		ele.setAttributeValue("mapperName", domain+"Dao");
		ele.setAttributeValue("tableName",  tableName);
		ele.setAttributeValue("domainObjectName", domain);
		ele.setAttributeValue("alias", tableName);
		System.out.println(ele.toString());
		
		System.out.println(document.asXML());
		
		//XmlParserUtilss.generateXML("test/1.xml", null, classPath, extraXML)
		//new SAXWriter().write(document);
		//document.write(new FileWriter(new File("src/main/resources/generatorConfigBak.xml")));
		
//		for (Node node : nodes) {
//			System.out.println(node);
//		}
		//Item item = (Item)XmlParserUtilss.convertXmlStrToObject(Item.class, inputXML);
		//System.out.println(item.getKBETR());
	}
}
