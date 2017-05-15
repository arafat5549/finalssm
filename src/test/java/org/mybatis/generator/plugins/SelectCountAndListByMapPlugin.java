package org.mybatis.generator.plugins;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import java.util.List;

/**
 * @author 我的文档
 * @create 2016/11/5
 */
public class SelectCountAndListByMapPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method,
                   Interface interfaze, IntrospectedTable introspectedTable) {
        //后续替代为BaseMapper类的通用接口部分，则取消这里的代码
//        interfaze.addMethod(generateSelectListByMap(method, introspectedTable));
//        interfaze.addMethod(generateSelectCountByMap(method, introspectedTable));
//        interfaze.addImportedType(new FullyQualifiedJavaType("java.util.Map"));
//        interfaze.addImportedType(new FullyQualifiedJavaType("java.util.List"));
        return true;
    }

    private Method generateSelectCountByMap(Method method, IntrospectedTable introspectedTable) {
        Method m = new Method("selectCountByMap");
        m.setVisibility(method.getVisibility());
        m.setReturnType(FullyQualifiedJavaType.getIntInstance());
        m.addParameter(new Parameter(new FullyQualifiedJavaType("Map<Object, Object>"), "map"));
        context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);
        return m;
    }

    private Method generateSelectListByMap(Method method, IntrospectedTable introspectedTable) {
        Method m = new Method("selectListByMap");
        m.setVisibility(method.getVisibility());
        m.setReturnType(new FullyQualifiedJavaType("java.util.List<" + introspectedTable.getBaseRecordType()
            + ">"));
        m.addParameter(new Parameter(new FullyQualifiedJavaType("Map<Object, Object>"), "map"));
        context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);
        return m;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        XmlElement parentElement = document.getRootElement();

        //产生selectCountByMap方法
        XmlElement selectCountByMapElement = new XmlElement("select");
        selectCountByMapElement.addAttribute(new Attribute("id", "selectCountByMap"));
        selectCountByMapElement.addAttribute(new Attribute("parameterType", "map"));
        selectCountByMapElement.addAttribute(new Attribute("resultType", "int"));
        selectCountByMapElement.addElement(new TextElement("select count(*) from "
            + tableName + "<include refid=\"Base_Query_Map_Condition\" />"));
        parentElement.addElement(selectCountByMapElement);

        //产生selectListByMap方法
        XmlElement selectListByMapElement = new XmlElement("select");
        selectListByMapElement.addAttribute(new Attribute("id", "selectListByMap"));
        selectListByMapElement.addAttribute(new Attribute("parameterType", "map"));
        selectListByMapElement.addAttribute(new Attribute("returnMap", "BaseResultMap"));

        //order by 后缀的部分的集合，比如这张表里主键字段为id，则这段代码返回id desc字符串
        StringBuilder _orderByStr = new StringBuilder();
        _orderByStr.setLength(0);
        for (IntrospectedColumn introspectedColumn : introspectedTable.getPrimaryKeyColumns()) {
            _orderByStr.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn)
                + "desc, ");
        }
        _orderByStr.delete(_orderByStr.length() - 2, _orderByStr.length());

        selectListByMapElement.addElement(new TextElement("<include refid=\"OracleDialectPrefix\" />"
            + "select <include refid=\"Base_Column_List\" /> from " + tableName
            + "<include refid=\"Base_Query_Map_Condition\" />"
            + " order by " + _orderByStr.toString()
            + "<include refid=\"OracleDialectSuffix\" /><include refid=\"MysqlDialect\" />"));
        parentElement.addElement(selectListByMapElement);

        //产生Base_Query_Map_Condition sql 语句
        XmlElement baseQueryMapConditionElement = new XmlElement("sql");
        baseQueryMapConditionElement.addAttribute(new Attribute("id", "Base_Query_Map_Condition"));

        XmlElement trimElement = new XmlElement("trim");
        trimElement.addAttribute(new Attribute("prefix", "where"));
        trimElement.addAttribute(new Attribute("prefixOverrides", "and | or"));

        //equal begin 相等部分的操作
        StringBuilder sbEqual = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement valueNotNullElement = new XmlElement("if");
            sbEqual.setLength(0);
            sbEqual.append(introspectedColumn.getJavaProperty());
            sbEqual.append(" != null");
            sbEqual.append(" and ");
            sbEqual.append(introspectedColumn.getJavaProperty());
            sbEqual.append(" != ''");
            valueNotNullElement.addAttribute(new Attribute("test", sbEqual.toString()));
            sbEqual.setLength(0);
            sbEqual.append(" and ");
            sbEqual.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sbEqual.append(" = ");
            sbEqual.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            valueNotNullElement.addElement(new TextElement(sbEqual.toString()));
            trimElement.addElement(valueNotNullElement);
        }
        //equal end

        //greater begin
        StringBuilder sbGreater = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement valuesNotNullElement = new XmlElement("if");
            sbGreater.setLength(0);
            sbGreater.append("myGreater_" + introspectedColumn.getJavaProperty());
            sbGreater.append(" != null");
            sbGreater.append(" and ");
            sbGreater.append("myGreater_" + introspectedColumn.getJavaProperty());
            sbGreater.append(" != ''");
            valuesNotNullElement.addAttribute(new Attribute("test", sbGreater.toString()));
            sbGreater.setLength(0);
            sbGreater.append(" and ");
            sbGreater.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sbGreater.append(" &gt; ");
            sbGreater.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn,
                    "myGreater_"));
            valuesNotNullElement.addElement(new TextElement(sbGreater.toString()));
            trimElement.addElement(valuesNotNullElement);
        }
        //greater end

        //lesser begin
        StringBuilder sbLesser = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement valuesNotNullElement = new XmlElement("if");
            sbLesser.setLength(0);
            sbLesser.append("myLesser_" + introspectedColumn.getJavaProperty());
            sbLesser.append(" != null");
            sbLesser.append(" and ");
            sbLesser.append("myLesser_" + introspectedColumn.getJavaProperty());
            sbLesser.append(" != ''");
            valuesNotNullElement.addAttribute(new Attribute("test", sbLesser.toString()));
            sbLesser.setLength(0);
            sbLesser.append(" and ");
            sbLesser.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sbLesser.append(" &lt; ");
            sbLesser.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "myLesser_"));
            valuesNotNullElement.addElement(new TextElement(sbLesser.toString()));
            trimElement.addElement(valuesNotNullElement);
        }
        //lesser end

        //like begin 相似部分的操作 --- 前后完全匹配相似
        StringBuilder sbLike = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement valuesNotNullElement = new XmlElement("if");
            sbLike.setLength(0);
            sbLike.append("myLike_" + introspectedColumn.getJavaProperty());
            sbLike.append(" != null");
            sbLike.append(" and ");
            sbLike.append("myLike_" + introspectedColumn.getJavaProperty());
            sbLike.append(" != ''");
            valuesNotNullElement.addAttribute(new Attribute("test", sbLike.toString()));
            sbLike.setLength(0);
            sbLike.append(" and ");
            sbLike.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sbLike.append(" like ");
            sbLike.append("CONCAT('%', " + MyBatis3FormattingUtilities.getParameterClause(introspectedColumn,
                    "myLike_") + ", '%' )");
            valuesNotNullElement.addElement(new TextElement(sbLike.toString()));
            trimElement.addElement(valuesNotNullElement);
        }
        //like end

        //like begin 相似部分的操作 --- 前端匹配
        StringBuilder sbLikeStart = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement valuesNotNullElement = new XmlElement("if");
            sbLikeStart.setLength(0);
            sbLikeStart.append("myLikeStart_" + introspectedColumn.getJavaProperty());
            sbLikeStart.append(" != null");
            sbLikeStart.append(" and ");
            sbLikeStart.append("myLikeStart_" + introspectedColumn.getJavaProperty());
            sbLikeStart.append(" != ''");
            valuesNotNullElement.addAttribute(new Attribute("test", sbLikeStart.toString()));
            sbLikeStart.setLength(0);
            sbLikeStart.append(" and ");
            sbLikeStart.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sbLikeStart.append(" like ");
            sbLikeStart.append("CONCAT('%', " + MyBatis3FormattingUtilities.getParameterClause(introspectedColumn,
                    "myLikeStart_") + ", '%' )");
            valuesNotNullElement.addElement(new TextElement(sbLikeStart.toString()));
            trimElement.addElement(valuesNotNullElement);
        }
        //like end

        //like begin 相似部分的操作 --- 后端匹配
        StringBuilder sbLikeEnd = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement valuesNotNullElement = new XmlElement("if");
            sbLikeEnd.setLength(0);
            sbLikeEnd.append("myLikeEnd_" + introspectedColumn.getJavaProperty());
            sbLikeEnd.append(" != null");
            sbLikeEnd.append(" and ");
            sbLikeEnd.append("myLikeEnd_" + introspectedColumn.getJavaProperty());
            sbLikeEnd.append(" != ''");
            valuesNotNullElement.addAttribute(new Attribute("test", sbLikeEnd.toString()));
            sbLikeEnd.setLength(0);
            sbLikeEnd.append(" and ");
            sbLikeEnd.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sbLikeEnd.append(" like ");
            sbLikeEnd.append("CONCAT('%', " + MyBatis3FormattingUtilities.getParameterClause(introspectedColumn,
                    "myLikeEnd_") + ", '%' )");
            valuesNotNullElement.addElement(new TextElement(sbLikeEnd.toString()));
            trimElement.addElement(valuesNotNullElement);
        }
        //like end

        //in begin
        StringBuilder sbIn = new StringBuilder();
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement valuesNotNullElement = new XmlElement("if");
            sbIn.setLength(0);
            sbIn.append("myIn_" + introspectedColumn.getJavaProperty());
            sbIn.append(" != null");
            sbIn.append(" and ");
            sbIn.append("myIn_" + introspectedColumn.getJavaProperty());
            sbIn.append(" != ''");
            valuesNotNullElement.addAttribute(new Attribute("test", sbIn.toString()));
            sbIn.setLength(0);
            sbIn.append(" and ");
            sbIn.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sbIn.append(" in ");
            sbIn.append("<foreach item=\"item\" index=\"index\" collection=\"" + "myIn_"
                    + introspectedColumn.getJavaProperty() + "\" open=\"(\" separator=\",\" close=\")\">"
                    + "#{item} </foreach>");
            valuesNotNullElement.addElement(new TextElement(sbIn.toString()));
            trimElement.addElement(valuesNotNullElement);
        }
        //in end

        baseQueryMapConditionElement.addElement(trimElement);
        parentElement.addElement(baseQueryMapConditionElement);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

}