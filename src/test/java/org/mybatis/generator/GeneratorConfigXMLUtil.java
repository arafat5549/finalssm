package org.mybatis.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.CloneUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import com.ssf.common.utils.StringUtilss;
import com.ssf.common.utils.XmlParserUtilss;

/**
 * 读取数据库 生成所有table标签
 * 源文件:  src/main/resources/generatorConfig.xml
 * 生成文件: src/main/resources/generatorConfigBak.xml
 * 
 */
public class GeneratorConfigXMLUtil {

	/**
	 * 读取数据库 生成所有table标签<p>
	 * 
	 * 源文件:  src/main/resources/generatorConfig.xml<p>
	 * 生成文件: src/main/resources/generatorConfigBak.xml<p>
	 * 
	 * @param dbName 数据库名称
	 * @param dbType 数据库类型 (支持mysql和oracle) 默认为"mysql"
	 */
	@SuppressWarnings("rawtypes")
	public static void convertXmlStrToObjectTest(String dbName,String dbType) throws SAXException, IOException, CloneNotSupportedException {
		String xmlPath ="src/main/resources/generatorConfig.xml";
		Document document = XmlParserUtilss.getDocument(xmlPath);
		
		deleteXmlNotation(document.getRootElement());
		
		List list = document.selectNodes("//table");
		Iterator  iter = list.iterator(); 
		Element ele =null;
        while (iter.hasNext()) 
        {  
        	ele = (Element) iter.next();   
        }  
        //生成所有table节点
        List<String> tableNames = DataBasePopulator.getTableNames(dbName,dbType);
        for (String tname : tableNames) {
			//System.out.println(tname);
			Element newele = (Element) CloneUtils.clone(ele); 
			String base = StringUtilss.toCamelCase(tname.replace("sys_", ""));
			base = StringUtils.capitalize(base);
			newele.addAttribute("mapperName", base +"Dao");
			newele.addAttribute("tableName",  tname);
			newele.addAttribute("domainObjectName", base);
			newele.addAttribute("alias", tname);  
	        
	        ele.getParent().add(newele);
		}
        ele.getParent().remove(ele);
	
		File outFile = new File("src/main/resources/generatorConfigBak.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();  
        format.setEncoding("UTF-8");//根据需要设置编码  
		XMLWriter writer = new XMLWriter(new FileWriter(outFile),format);  
        writer.write(document);  
        writer.close();  
	}
	
//	private static void edit(Element ele,String baseName){
//		
//		String tableName = "sys_"+baseName;
//		String domain = StringUtils.capitalize(baseName);
//		ele.setAttributeValue("mapperName", domain+"Dao");
//		ele.setAttributeValue("tableName",  tableName);
//		ele.setAttributeValue("domainObjectName", domain);
//		ele.setAttributeValue("alias", tableName);  
//	}
	
    /** 
     * 去掉注释 
     * @param ele 
     */  
    @SuppressWarnings("unchecked")
	private static void deleteXmlNotation(Element ele){  
        Iterator<Node>nodes = ele.nodeIterator();  
        List<Node> rmNodes=new ArrayList<Node>();  
        //循环收集可以删除的节点  
        while(nodes.hasNext()){  
            Node subNode=nodes.next();  
            if(subNode.getNodeType()==Node.COMMENT_NODE){   
                rmNodes.add(subNode);  
               // rmNodes.add(nodes.next());  
            }  
        }  
        //删除收集到的节点  
        for(Node node:rmNodes){  
            ele.remove(node);  
        }  
        //递归，处理下级节点  
        Iterator<Element>eleIt= ele.elementIterator();  
        while(eleIt.hasNext()){  
            deleteXmlNotation(eleIt.next());  
        }
    }
	
	public static void main(String[] args) {
		try {
			String dbName = "finalssm";
			String dbType = "mysql";
			convertXmlStrToObjectTest(dbName,dbType);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}