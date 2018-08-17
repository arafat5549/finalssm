package com.ssf.common.mybatis.plugin;

import com.ssf.common.mybatis.plugin.utils.CommentTools;
import com.ssf.common.mybatis.plugin.utils.XmlElementGeneratorTools;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.*;
import org.mybatis.generator.internal.util.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

/**
 * ---------------------------------------------------------------------------
 * 连接查询插件插件
 * ---------------------------------------------------------------------------
 *
 * @author: wang
 * @time:2017/4/19 10:59
 * ---------------------------------------------------------------------------
 */
public class MyJoinPlugin extends PluginAdapter {
    private static final Logger logger = LoggerFactory.getLogger(MyJoinPlugin.class);
    public static final String METHOD_NAME = "joinSelectByExample";  // 方法名

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(List<String> warnings) {
        // 插件使用前提是targetRuntime为MyBatis3
        if (stringHasValue(getContext().getTargetRuntime()) && "MyBatis3".equalsIgnoreCase(getContext().getTargetRuntime()) == false) {
            logger.warn("itfsw:插件" + this.getClass().getTypeName() + "要求运行targetRuntime必须为MyBatis3！");
            return false;
        }
        return true;
    }

    /**
     * Java Client Methods 生成
     * 具体执行顺序 http://www.mybatis.org/generator/reference/pluggingIn.html
     *
     * @param interfaze
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType map = new FullyQualifiedJavaType("java.utils.HashMap");
        // 方法生成
        Method method = new Method(METHOD_NAME);
        // 方法可见性 interface会忽略
        // method.setVisibility(JavaVisibility.PUBLIC);
        // 返回值类型
        FullyQualifiedJavaType rettype = new FullyQualifiedJavaType("java.utils.List");
        rettype.addTypeArgument(map);
        method.setReturnType(rettype);

        // 添加参数
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getExampleType());
        method.addParameter(new Parameter(type, "example"));
//        method.addParameter(new Parameter(new FullyQualifiedJavaType(Class.class.getName()), "cls"));
        // 添加方法说明
        CommentTools.addGeneralMethodComment(method, introspectedTable);
        // interface 增加方法
        interfaze.addMethod(method);
        interfaze.addImportedType(map);
        logger.debug("itfsw(查询单条数据插件):" + interfaze.getType().getShortName() + "增加SelectOneByExample方法。");
        return true;
    }

    @Override
    public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        element.getElements().clear();
        String table = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        StringBuffer sb = new StringBuffer();
        for (IntrospectedColumn col : introspectedTable.getAllColumns()) {
            sb.append(",").append(table).append(".").append(col.getActualColumnName());
        }
        logger.info(sb.toString());
        element.getElements().add(new TextElement(sb.substring(1)));
        return super.sqlMapBaseColumnListElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        String table = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        //sql/where/foreach/if/trim/foreach/choose/when
        XmlElement where = (XmlElement) element.getElements().get(0);
        XmlElement foreach = (XmlElement) where.getElements().get(0);
        XmlElement ife = (XmlElement) foreach.getElements().get(0);
        XmlElement trim = (XmlElement) ife.getElements().get(0);
        XmlElement foreache = (XmlElement) trim.getElements().get(0);
        XmlElement choose = (XmlElement) foreache.getElements().get(0);
        for (Element e : choose.getElements()) {
            XmlElement xe = (XmlElement) e;
            if (xe.getElements().size() == 1) {
                String content = ((TextElement) xe.getElements().get(0)).getContent();
                xe.getElements().clear();
                xe.getElements().add(new TextElement(content.replace("and ", "and " + table + ".")));
            } else {
                Element sub = xe.getElements().get(1);
                String content = ((TextElement) xe.getElements().get(0)).getContent();
                xe.getElements().clear();
                xe.getElements().add(new TextElement(content.replace("and ", "and " + table + ".")));
                xe.getElements().add(sub);
            }
        }
        return super.sqlMapExampleWhereClauseElementGenerated(element, introspectedTable);
    }

    /**
     * SQL Map Methods 生成
     * 具体执行顺序 http://www.mybatis.org/generator/reference/pluggingIn.html
     *
     * @param document
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        //数据库表名
        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();

        // 生成查询语句
        XmlElement selectOneElement = new XmlElement("select");
        // 添加注释(!!!必须添加注释，overwrite覆盖生成时，@see XmlFileMergerJaxp.isGeneratedNode会去判断注释中是否存在OLD_ELEMENT_TAGS中的一点，例子：@mbg.generated)
        //CommentTools.addComment(selectOneElement);

        // 添加ID
        selectOneElement.addAttribute(new Attribute("id", METHOD_NAME));

        // ----------------------------------------- 表中是否有blob类型字段 ---------------------------------------
        if (introspectedTable.hasBLOBColumns()) {
            // 添加返回类型
            selectOneElement.addAttribute(new Attribute("resultType", "java.utils.HashMap"));
            // 添加参数类型
            selectOneElement.addAttribute(new Attribute("parameterType", introspectedTable.getExampleType()));
            // 添加查询SQL
            selectOneElement.addElement(new TextElement("select")); //$NON-NLS-1$

            StringBuilder sb = new StringBuilder();
            if (stringHasValue(introspectedTable.getSelectByExampleQueryId())) {
                sb.append('\'');
                sb.append(introspectedTable.getSelectByExampleQueryId());
                sb.append("' as QUERYID,"); //$NON-NLS-1$
                selectOneElement.addElement(new TextElement(sb.toString()));
            }

            selectOneElement.addElement(XmlElementGeneratorTools.getBaseColumnListElement(introspectedTable));
            selectOneElement.addElement(new TextElement(",")); //$NON-NLS-1$
            selectOneElement.addElement(XmlElementGeneratorTools.getBlobColumnListElement(introspectedTable));

            XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
            ifElement.addAttribute(new Attribute("test", "extFields != null")); //$NON-NLS-1$ //$NON-NLS-2$
            XmlElement foreachElement = new XmlElement("foreach"); //$NON-NLS-1$
            foreachElement.addAttribute(new Attribute("collection", "extFields")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement.addAttribute(new Attribute("item", "field")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement.addElement(new TextElement(",${field}")); //$NON-NLS-1$
            ifElement.addElement(foreachElement); //$NON-NLS-1$
            selectOneElement.addElement(ifElement);

            sb.setLength(0);
            sb.append("from "); //$NON-NLS-1$
            sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
            selectOneElement.addElement(new TextElement(sb.toString()));

            ifElement = new XmlElement("if"); //$NON-NLS-1$
            ifElement.addAttribute(new Attribute("test", "joins != null")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement = new XmlElement("foreach"); //$NON-NLS-1$
            foreachElement.addAttribute(new Attribute("collection", "joins")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement.addAttribute(new Attribute("item", "join")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement.addElement(new TextElement("${join}")); //$NON-NLS-1$
            ifElement.addElement(foreachElement); //$NON-NLS-1$
            selectOneElement.addElement(ifElement);

            selectOneElement.addElement(XmlElementGeneratorTools.getExampleIncludeElement(introspectedTable));

            ifElement = new XmlElement("if"); //$NON-NLS-1$
            ifElement.addAttribute(new Attribute("test", "orderByClause != null")); //$NON-NLS-1$ //$NON-NLS-2$
            ifElement.addElement(new TextElement("order by ${orderByClause}")); //$NON-NLS-1$
            selectOneElement.addElement(ifElement);

            // 分页查询
            XmlElement ifLimitNotNullElement = new XmlElement("if");
            ifLimitNotNullElement.addAttribute(new Attribute("test", "rows != null"));

            XmlElement ifOffsetNotNullElement = new XmlElement("if");
            ifOffsetNotNullElement.addAttribute(new Attribute("test", "offset != null"));
            ifOffsetNotNullElement.addElement(new TextElement("limit ${offset}, ${rows}"));
            ifLimitNotNullElement.addElement(ifOffsetNotNullElement);

            XmlElement ifOffsetNullElement = new XmlElement("if");
            ifOffsetNullElement.addAttribute(new Attribute("test", "offset == null"));
            ifOffsetNullElement.addElement(new TextElement("limit ${rows}"));
            ifLimitNotNullElement.addElement(ifOffsetNullElement);

            selectOneElement.addElement(ifLimitNotNullElement);

//            selectOneElement.addElement(new TextElement("limit 1"));
        } else {
            // 添加返回类型
            selectOneElement.addAttribute(new Attribute("resultType", "java.utils.HashMap"));
            // 添加参数类型
            selectOneElement.addAttribute(new Attribute("parameterType", introspectedTable.getExampleType()));
            selectOneElement.addElement(new TextElement("select")); //$NON-NLS-1$

            StringBuilder sb = new StringBuilder();
            if (stringHasValue(introspectedTable.getSelectByExampleQueryId())) {
                sb.append('\'');
                sb.append(introspectedTable.getSelectByExampleQueryId());
                sb.append("' as QUERYID,"); //$NON-NLS-1$
                selectOneElement.addElement(new TextElement(sb.toString()));
            }
            selectOneElement.addElement(XmlElementGeneratorTools.getBaseColumnListElement(introspectedTable));

            XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
            ifElement.addAttribute(new Attribute("test", "extFields != null")); //$NON-NLS-1$ //$NON-NLS-2$
            XmlElement foreachElement = new XmlElement("foreach"); //$NON-NLS-1$
            foreachElement.addAttribute(new Attribute("collection", "extFields")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement.addAttribute(new Attribute("item", "field")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement.addElement(new TextElement(",${field}")); //$NON-NLS-1$
            ifElement.addElement(foreachElement); //$NON-NLS-1$
            selectOneElement.addElement(ifElement);

            sb.setLength(0);
            sb.append("from "); //$NON-NLS-1$
            sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
            selectOneElement.addElement(new TextElement(sb.toString()));

            ifElement = new XmlElement("if"); //$NON-NLS-1$
            ifElement.addAttribute(new Attribute("test", "joins != null")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement = new XmlElement("foreach"); //$NON-NLS-1$
            foreachElement.addAttribute(new Attribute("collection", "joins")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement.addAttribute(new Attribute("item", "join")); //$NON-NLS-1$ //$NON-NLS-2$
            foreachElement.addElement(new TextElement("${join}")); //$NON-NLS-1$
            ifElement.addElement(foreachElement); //$NON-NLS-1$
            selectOneElement.addElement(ifElement);

            selectOneElement.addElement(XmlElementGeneratorTools.getExampleIncludeElement(introspectedTable));

            ifElement = new XmlElement("if"); //$NON-NLS-1$
            ifElement.addAttribute(new Attribute("test", "orderByClause != null")); //$NON-NLS-1$ //$NON-NLS-2$
            ifElement.addElement(new TextElement("order by ${orderByClause}")); //$NON-NLS-1$
            selectOneElement.addElement(ifElement);

            // 分页查询
            XmlElement ifLimitNotNullElement = new XmlElement("if");
            ifLimitNotNullElement.addAttribute(new Attribute("test", "rows != null"));

            XmlElement ifOffsetNotNullElement = new XmlElement("if");
            ifOffsetNotNullElement.addAttribute(new Attribute("test", "offset != null"));
            ifOffsetNotNullElement.addElement(new TextElement("limit ${offset}, ${rows}"));
            ifLimitNotNullElement.addElement(ifOffsetNotNullElement);

            XmlElement ifOffsetNullElement = new XmlElement("if");
            ifOffsetNullElement.addAttribute(new Attribute("test", "offset == null"));
            ifOffsetNullElement.addElement(new TextElement("limit ${rows}"));
            ifLimitNotNullElement.addElement(ifOffsetNullElement);

            selectOneElement.addElement(ifLimitNotNullElement);
        }

        // 添加到根节点
        document.getRootElement().addElement(selectOneElement);
        logger.debug("itfsw(查询单条数据插件):" + introspectedTable.getMyBatis3XmlMapperFileName() + "增加SelectOneByExample方法(" + (introspectedTable.hasBLOBColumns() ? "有" : "无") + "Blob类型))。");

        return true;
    }

    /**
     * ModelExample Methods 生成
     * 具体执行顺序 http://www.mybatis.org/generator/reference/pluggingIn.html
     *
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 添加joins字段
        FullyQualifiedJavaType joinstype = FullyQualifiedJavaType.getNewListInstance();
        joinstype.addTypeArgument(FullyQualifiedJavaType.getStringInstance());
        Field joins = new Field();
        joins.setName("joins");
        joins.setVisibility(JavaVisibility.PROTECTED);
        joins.setType(joinstype);
        CommentTools.addFieldComment(joins, introspectedTable);
        topLevelClass.addField(joins);

        // 添加extFields字段
        FullyQualifiedJavaType extFieldstype = FullyQualifiedJavaType.getNewListInstance();
        extFieldstype.addTypeArgument(FullyQualifiedJavaType.getStringInstance());
        Field extFields = new Field();
        extFields.setName("extFields");
        extFields.setVisibility(JavaVisibility.PROTECTED);
        extFields.setType(extFieldstype);
        CommentTools.addFieldComment(extFields, introspectedTable);
        topLevelClass.addField(extFields);

        // 增加getter && setter 方法
        Method getExtFields = new Method();
        getExtFields.setVisibility(JavaVisibility.PUBLIC);
        getExtFields.setReturnType(joinstype);
        getExtFields.setName("getExtFields");
        getExtFields.addBodyLine("return extFields;");
        CommentTools.addGeneralMethodComment(getExtFields, introspectedTable);
        topLevelClass.addMethod(getExtFields);

        Method getJoins = new Method();
        getJoins.setVisibility(JavaVisibility.PUBLIC);
        getJoins.setReturnType(joinstype);
        getJoins.setName("getJoins");
        getJoins.addBodyLine("return joins;");
        CommentTools.addGeneralMethodComment(getJoins, introspectedTable);
        topLevelClass.addMethod(getJoins);

        Method join = new Method();
        join.setVisibility(JavaVisibility.PUBLIC);
        join.setName("join");
        join.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "table"));
        join.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
        join.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "fields"));
        join.addBodyLine("if(this.joins == null){");
        join.addBodyLine("this.joins = new ArrayList<String>();");
        join.addBodyLine("}");
        join.addBodyLine("this.joins.add(\"left join \"+table+\" on \"+condition);");
        join.addBodyLine("if(this.extFields == null){");
        join.addBodyLine("this.extFields = new ArrayList<String>();");
        join.addBodyLine("}");
        join.addBodyLine("this.extFields.add(fields);");
        join.addBodyLine("return this;");
        join.setReturnType(new FullyQualifiedJavaType(introspectedTable.getExampleType()));
        CommentTools.addGeneralMethodComment(join, introspectedTable);
        topLevelClass.addMethod(join);

        // !!! clear 方法增加 offset 和 rows的清理
        List<Method> methodList = topLevelClass.getMethods();
        for (Method method : methodList) {
            if (method.getName().equals("clear")) {
                method.addBodyLine("joins = null;");
                method.addBodyLine("extFields = null;");
                logger.debug("itfsw(MySQL分页插件):" + topLevelClass.getType().getShortName() + "修改joins方法,增加rows和extFields字段的清空");
            }
        }

        return true;
    }
}
