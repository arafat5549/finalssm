package com.ssf.common.mybatis.plugin;

import com.ssf.common.mybatis.plugin.utils.CommentTools;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Document;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 强制覆盖xml文件(注意这样每次都会生成新的mapper.xml会覆盖掉你编写的部分)
 * 利用反射设置isMergeable为false
 * 放在最后执行 同时会生成自定义方法区域的注释
 * @author wyy
 *
 */
public class OverIsMergeablePlugin extends PluginAdapter{
	@Override
	public boolean validate(List warnings) {
		return true;
	}
	@Override
	public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
		try {
			Field field = sqlMap.getClass().getDeclaredField("isMergeable");
			field.setAccessible(true);
			field.setBoolean(sqlMap, false);

			//CommentTools.addCustomCodeComment(new XmlElement(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
		String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
		CommentTools.addCustomCodeComment(document.getRootElement(),"daoxml",tableName);
		return true;
	}

	//model类顶部
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable){

		List<Method> lists = topLevelClass.getMethods();
		Method m = lists.size()>0 ? lists.get(0) :null;
		if(m!=null)
		{

			String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
			//LogUtil.printLog("========",tableName+","+ MybatisGenerator.getRealClassNameCapatial(tableName));
			CommentTools.addCustomCodeComment(m,"model",tableName);

		}
		return true;
	}

	//接口顶部
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable){
		if(interfaze!=null)
		{
			List<Method> lists = interfaze.getMethods();
			Method m = lists.size()>0 ? lists.get(0) :null;
			if(m!=null)
			{
				String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
				//LogUtil.printLog("dao",tableName);
				CommentTools.addCustomCodeComment(m,"dao",tableName);

			}

		}

		return  true;
	}

	@Override
	public boolean providerGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
	{
		System.out.println("providerGenerated，"+topLevelClass+", "+introspectedTable);
		return true;
	}

}
