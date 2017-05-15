package org.mybatis.generator.plugins;


import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * @author 我的文档
 * @create 2016/11/5
 */
public class MutiDataSourcePaginationPlugin extends PluginAdapter {

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addPage(topLevelClass, introspectedTable, "page");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement parentElement = document.getRootElement();

        //Begin Oracle分页，生成相关sql部分语句
        //产生分页语句前半部分
        XmlElement oraclePaginationPrefixElement = new XmlElement("sql");
        oraclePaginationPrefixElement.addAttribute(new Attribute("id", "OracleDialectPrefix"));

        XmlElement pageStart = new XmlElement("if");
        pageStart.addAttribute(new Attribute("test", "page != null and _databaseId == 'oracle'"));
        pageStart.addElement(new TextElement("select * from (select row_.*, rownum_ from ( "));
        oraclePaginationPrefixElement.addElement(pageStart);
        parentElement.addElement(oraclePaginationPrefixElement);

        //产生分页语句后半部分
        XmlElement oraclePaginationSuffixElement = new XmlElement("sql");
        oraclePaginationSuffixElement.addAttribute(new Attribute("id", "OracleDialectSuffix"));
        XmlElement pageEnd = new XmlElement("if");
        pageEnd.addAttribute(new Attribute("test", "page != null and _databaseId == 'oracle'"));
        pageEnd.addElement(new TextElement("<![CDATA[ ) row_ ) where rownum_ > #{page.begin} and" +
                " rownum_ <= #{page.end} ]]>"));
        oraclePaginationSuffixElement.addElement(pageEnd);
        parentElement.addElement(oraclePaginationSuffixElement);
        //End

        XmlElement mysqlPaginationSuffixElement = new XmlElement("sql");
        mysqlPaginationSuffixElement.addAttribute(new Attribute("id", "MysqlDialect"));

        XmlElement oraclePage = new XmlElement("if");
        oraclePage.addAttribute(new Attribute("test", "page != null and _databaseId == 'mysql'"));
        oraclePage.addElement(new TextElement("limit #{page.begin}, #{page.length}"));
        mysqlPaginationSuffixElement.addElement(oraclePage);
        parentElement.addElement(mysqlPaginationSuffixElement);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {
        XmlElement oraclePageStart = new XmlElement("include");
        oraclePageStart.addAttribute(new Attribute("refid", "OracleDialectPrefix"));
        element.getElements().add(0, oraclePageStart);

        XmlElement oraclePageEnd = new XmlElement("include");
        oraclePageEnd.addAttribute(new Attribute("refid", "OracleDialectSuffix"));
        element.getElements().add(oraclePageEnd);

        XmlElement mysqlPage = new XmlElement("include");
        mysqlPage.addAttribute(new Attribute("refid", "MysqlDialect"));
        element.getElements().add(mysqlPage);

        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable,
                         String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType("com.evan.vo.PageVo"));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("com.evan.vo.PageVo"));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType("com.evan.vo.PageVo"), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("com.evan.vo.PageVo"));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

}
