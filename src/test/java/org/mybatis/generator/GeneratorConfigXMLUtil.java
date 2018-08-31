package org.mybatis.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.CloneUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springside.modules.utils.io.URLResourceUtil;
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
	public static List<String> convertXmlStrToObjectTest(Properties props,String dbName,String dbType,String src,String out) throws SAXException, IOException, CloneNotSupportedException {
		List<String> tnameList = new ArrayList<>();
		
		InputStream is = URLResourceUtil.asStream("classpath://"+src);

		Document document = XmlParserUtilss.getDocument(is);
		deleteXmlNotation(document.getRootElement());
		
		List list = document.selectNodes("//table");
		Iterator  iter = list.iterator(); 
		Element ele =null;
        while (iter.hasNext()) 
        {  
        	ele = (Element) iter.next();   
        }  
        //生成所有table节点
        List<String> tableNames = DataBasePopulator.getTableNames(props,dbName,dbType);
        for (String tname : tableNames) {

			Element newele = (Element) CloneUtils.clone(ele); 
			String base = StringUtilss.toCamelCase(MybatisGenerator.getRealClassName(tname));

			if(MybatisGenerator.isMacthPrefix(tname)){


				String ss[] = tname.split("_");
				int cflag = -1;
				if(ss!=null && ss.length>=3){
					String s1 = ss[0]+"_"+ss[1];
					String s2 = ss[0]+"_"+ss[2];
					boolean f1 = tableNames.contains(s1);
					boolean f2 = tableNames.contains(s2);
					cflag = f1 && f2 ? 1 : 0;
				}else if(ss!=null && ss.length==2){
					cflag = 0;
				}
				if(cflag==0){
					MybatisGenerator.LOG(tname+"，"+base+","+ss.length);
					tnameList.add(tname);
					base = StringUtils.capitalize(base);
					newele.addAttribute("mapperName", base + MybatisGenerator.MAPPER_NAME);
					newele.addAttribute("tableName",  tname);
					newele.addAttribute("domainObjectName", base);
					//newele.addAttribute("alias", tname);
					ele.getParent().add(newele);
				}

			}
			else{

			}

		}
        ele.getParent().remove(ele);
        String outpath = URLResourceUtil.asFile("file:"+out).toString();
		File outFile = new File(outpath);
		OutputFormat format = OutputFormat.createPrettyPrint();  
        format.setEncoding("UTF-8");//根据需要设置编码  
		XMLWriter writer = new XMLWriter(new FileWriter(outFile),format);  
        writer.write(document);  
        writer.close();
		MybatisGenerator.LOG("生成Generator配置文件:"+outpath);
        return tnameList;
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
	
}
