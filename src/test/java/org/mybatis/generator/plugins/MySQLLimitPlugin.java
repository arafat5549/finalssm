package org.mybatis.generator.plugins;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.ibatis.annotations.Param;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class MySQLLimitPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	
	/**
	 * 增加接口方法
	 */
	@Override
	public boolean clientGenerated(Interface interfaze,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
		FullyQualifiedJavaType type_limit = 
				new FullyQualifiedJavaType(Integer.class.getName());
		
		FullyQualifiedJavaType type_offset = 
				new FullyQualifiedJavaType(Integer.class.getName());
		
		importedTypes.add(type_limit);
		importedTypes.add(type_offset);
		
		importedTypes.add(new FullyQualifiedJavaType(Param.class.getName()));
		importedTypes.add(FullyQualifiedJavaType.getNewListInstance());

		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);

		FullyQualifiedJavaType returnType = FullyQualifiedJavaType
				.getNewListInstance();
		FullyQualifiedJavaType listType;
		if (introspectedTable.getRules().generateBaseRecordClass()) {
			listType = new FullyQualifiedJavaType(introspectedTable
					.getBaseRecordType());
		} else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
			listType = new FullyQualifiedJavaType(introspectedTable
					.getPrimaryKeyType());
		} else {
			throw new RuntimeException("RuntimeError.12");
		}

		importedTypes.add(listType);
		returnType.addTypeArgument(listType);
		method.setReturnType(returnType);

		method.setName("listPage");
		Parameter p1 = new Parameter(type_offset, "offset");
		p1.addAnnotation("@Param(\"offset\")");
		method.addParameter(p1); //$NON-NLS-1$   
		Parameter p2 = new Parameter(type_limit, "limit");
		p2.addAnnotation("@Param(\"limit\")");
		method.addParameter(p2); //$NON-NLS-1$   
		

		interfaze.addImportedTypes(importedTypes);
		interfaze.addMethod(method);

		return true;
	}
	
	/**
	 * 增加配置文件域
	 */
	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {
		// 获取returnType
/*		String returnType = null;
		if (introspectedTable.getRules().generateBaseRecordClass()) {
			returnType = introspectedTable.getBaseRecordType();
		} else {
			returnType = introspectedTable.getPrimaryKeyType();
		}*/

		FullyQualifiedJavaType listType1;
		if (introspectedTable.getRules().generateBaseRecordClass()) {
			listType1 = new FullyQualifiedJavaType(introspectedTable
					.getBaseRecordType());
		} else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
			listType1 = new FullyQualifiedJavaType(introspectedTable
					.getPrimaryKeyType());
		} else {
			throw new RuntimeException("RuntimeError.12");
		}
		
		// 新建一个select Statement
		XmlElement answer = new XmlElement("select");
		answer.addAttribute(new Attribute("id", "listPage"));
		answer.addAttribute(new Attribute("parameterType", "java.lang.Integer"));
		answer.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		
		
		 String str =
			"select\r\n"+
			"	<include refid=\"Base_Column_List\" />\r\n"+
		    "	from " +introspectedTable.getTableConfiguration().getTableName()+"\r\n"
		   +"	limit #{offset},#{limit}";
		
		answer.addElement(new TextElement(str));
		
		XmlElement parentElement = document.getRootElement();
		parentElement.addElement(answer);
		
//		// 新建一个select Statement
//		XmlElement answer1 = new XmlElement("select");
//		answer1.addAttribute(new Attribute("id", "select"+listType1.getShortName()));
//		answer1.addAttribute(new Attribute("parameterType", "java.lang.String"));
//		answer1.addAttribute(new Attribute("resultMap", "BaseResultMap"));
//		answer1.addElement(new TextElement("<![CDATA[ ${value} ]]>"));
//
//		XmlElement parentElement = document.getRootElement();
//		parentElement.addElement(answer);
//		parentElement.addElement(answer1);
		return true;
	}
	
	
//
//    /**
//     * 为每个Example类添加limit和offset属性已经set、get方法
//     */
//    @Override
//    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//
//        PrimitiveTypeWrapper integerWrapper = FullyQualifiedJavaType.getIntInstance().getPrimitiveTypeWrapper();
//
//        Field limit = new Field();
//        limit.setName("limit");
//        limit.setVisibility(JavaVisibility.PRIVATE);
//        limit.setType(integerWrapper);
//        topLevelClass.addField(limit);
//
//        Method setLimit = new Method();
//        setLimit.setVisibility(JavaVisibility.PUBLIC);
//        setLimit.setName("setLimit");
//        setLimit.addParameter(new Parameter(integerWrapper, "limit"));
//        setLimit.addBodyLine("this.limit = limit;");
//        topLevelClass.addMethod(setLimit);
//
//        Method getLimit = new Method();
//        getLimit.setVisibility(JavaVisibility.PUBLIC);
//        getLimit.setReturnType(integerWrapper);
//        getLimit.setName("getLimit");
//        getLimit.addBodyLine("return limit;");
//        topLevelClass.addMethod(getLimit);
//
//        Field offset = new Field();
//        offset.setName("offset");
//        offset.setVisibility(JavaVisibility.PRIVATE);
//        offset.setType(integerWrapper);
//        topLevelClass.addField(offset);
//
//        Method setOffset = new Method();
//        setOffset.setVisibility(JavaVisibility.PUBLIC);
//        setOffset.setName("setOffset");
//        setOffset.addParameter(new Parameter(integerWrapper, "offset"));
//        setOffset.addBodyLine("this.offset = offset;");
//        topLevelClass.addMethod(setOffset);
//
//        Method getOffset = new Method();
//        getOffset.setVisibility(JavaVisibility.PUBLIC);
//        getOffset.setReturnType(integerWrapper);
//        getOffset.setName("getOffset");
//        getOffset.addBodyLine("return offset;");
//        topLevelClass.addMethod(getOffset);
//
//        return true;
//    }
//
//    /**
//     * 为Mapper.xml的selectByExample添加limit
//     */
//    @Override
//    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
//            IntrospectedTable introspectedTable) {
//
//        XmlElement ifLimitNotNullElement = new XmlElement("if");
//        ifLimitNotNullElement.addAttribute(new Attribute("test", "limit != null"));
//
//        XmlElement ifOffsetNotNullElement = new XmlElement("if");
//        ifOffsetNotNullElement.addAttribute(new Attribute("test", "offset != null"));
//        ifOffsetNotNullElement.addElement(new TextElement("limit ${offset}, ${limit}"));
//        ifLimitNotNullElement.addElement(ifOffsetNotNullElement);
//
//        XmlElement ifOffsetNullElement = new XmlElement("if");
//        ifOffsetNullElement.addAttribute(new Attribute("test", "offset == null"));
//        ifOffsetNullElement.addElement(new TextElement("limit ${limit}"));
//        ifLimitNotNullElement.addElement(ifOffsetNullElement);
//
//        element.addElement(ifLimitNotNullElement);
//
//        return true;
//    }
}
