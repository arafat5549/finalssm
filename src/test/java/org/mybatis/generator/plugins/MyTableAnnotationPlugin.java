package org.mybatis.generator.plugins;


import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.List;

/**
 * 生成实体类时，对整个类增加Table的注释部分
 *
 * @author 我的文档
 * @create 2016/11/5
 */
public class MyTableAnnotationPlugin extends PluginAdapter {

    /**
     * 生成基础实体类
     *
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 处理实体类的包和@Table注解
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    private void processEntityClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //引入JPA注解
        topLevelClass.addImportedType("com.evan.annotation.*");
        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        String tableAliasName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
        String namespaceStr = introspectedTable.getMyBatis3SqlMapNamespace();

        if (StringUtility.stringContainsSpace(tableName)) {
            tableName = context.getBeginningDelimiter() + tableName + context.getEndingDelimiter();
        }

        topLevelClass.addAnnotation("@MyBatisTableAnnotation(name = \"" + tableName + "\","
            + "namespace = \"" + namespaceStr + "\","
            + "remarks = \"" + " remark \","
            + "aliasName = \"" + tableAliasName + "\" )");
    }

    @Override
    public boolean validate(List<String> list) {
        return false;
    }

}
