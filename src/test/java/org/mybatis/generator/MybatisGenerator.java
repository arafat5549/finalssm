package org.mybatis.generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import com.jqm.ssm.entity.Menucate;
import com.ssf.common.utils.StringUtilss;
import org.apache.commons.collections.ArrayStack;
import org.mybatis.generator.api.ShellRunner;
import org.springside.modules.utils.io.IOUtil;
import org.springside.modules.utils.io.URLResourceUtil;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;


public class MybatisGenerator {
	private static final String ORIGIN_CONFIG = "generatorConfig.xml";
	private static final String OUT_CONFIG   = "src/main/resources/generatorConfigBak.xml";
	
	public static final Properties PROPERTIES = new Properties();
	public static Map<String,String> COMMENT_MAPS = Maps.newHashMap();
	public static final String BASE_PREFIX= "water_";
	static
	{
		try {
			InputStream is = URLResourceUtil.asStream("classpath://mybatis-generator.properties");//DataSourceFactory.class.getResourceAsStream("/jdbc.properties");
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public static  List<String> getTableNames(Properties props){
//		String dbName = props.getProperty("dbName");
//		String dbType = props.getProperty("dbType");
//		return DataBasePopulator.getTableNames(props, dbName,dbType);
//	}
	
	/**
	 * 第一步生成-数据库结构
	 * 记得修改dbName 默认为finalssm
	 * @param props  传入properties对象 默认为 "classpath://mybatis-generator.properties"
	 * @param lists  需要执行的sql语句集合
	 */
	public static void runSql(Properties props,List<String> lists){
		DataBasePopulator.initDatabase(props,lists);
	}
	/**
	 * 第二步-生成配置文件
	 */
	public static void createConfigs(){
		createConfigs(PROPERTIES,ORIGIN_CONFIG,OUT_CONFIG);
	}
	
	public static void createConfigs(Properties props,String src,String out){
		String dbName = props.getProperty("dbName");
		String dbType = props.getProperty("dbType");
		if(dbName==null || "".equals(dbName)){
			throw new RuntimeException("dbName没有在配置文件里面设置");
		}
		if(dbType==null || "".equals(dbType)){
			dbType="mysql";
			System.out.println("dbType为空设为默认值mysql");
		}
		
		try {
			GeneratorConfigXMLUtil.convertXmlStrToObjectTest(props,dbName, dbType,src,out);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 第三部生成-Model/DAO/Mapper映射文件
	 * @param config 指定的配置文件
	 */
	public static void generator(String config){
		System.out.println("开始生成代码...");
		//String config = OUT_CONFIG;
		try {
			//Resources.getResourceAsFile(config)
			config = URLResourceUtil.asFile("file:"+config).getPath();
			System.out.println(config);
		}  catch (IOException e) {
			e.printStackTrace();
			return;
		}

		System.out.println("完整的配置文件路径：" + config);
		String[] arg = { "-configfile", config, "-overwrite" };
		ShellRunner.main(arg);
		System.out.println("代码生成完成。");
	}

	private static void generateCode(){
		Map<String,String> comments = MybatisGenerator.getTableComments(PROPERTIES);
		List<String> tableNames = Lists.newArrayList(comments.keySet());
		System.out.println(tableNames);
		CodeGeneratorUtil.BASE_PACKAGE = "com.jqm.ssm";
		CodeGeneratorUtil.codeGenerator(PROPERTIES, tableNames, Lists.newArrayList());
	}

	//工具类
	public static  List<String> getTableNames(Properties props){
		String dbName = props.getProperty("dbName");
		String dbType = props.getProperty("dbType");
		return DataBasePopulator.getTableNames(props, dbName,dbType);
	}
	public static Map<String,String> getTableComments(Properties props){
		if(COMMENT_MAPS.size()>0){
			return COMMENT_MAPS;
		}
		String dbName = props.getProperty("dbName");
		String dbType = props.getProperty("dbType");
		return DataBasePopulator.getTableComments(props, dbName,dbType);
	}
	/**
	 *
	 * @param key 表名 比如sys_user
	 * @return
	 */
	public static String getTableComment(String key){
		Map<String,String> maps = getTableComments(PROPERTIES);
		return maps.get(key);
	}

	/**
	 * 首字母小写
	 * @param str
	 * @return
	 */
	public static String lowerCapital(final String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}

		char firstChar = str.charAt(0);
		if (Character.isTitleCase(firstChar)) {
			return str;
		}

		return new StringBuilder(strLen)
				.append(Character.toLowerCase(firstChar))
				.append(str.substring(1))
				.toString();
	}
	/**
	 * 将基础包名比如com.ssf.dao 转化为指定的包名
	 */
	public static String parsePackageName(String basePackageName,String key){
		int idx = basePackageName.lastIndexOf(".");
		String pName = basePackageName.substring(0,idx)+"." + key+"."+basePackageName.substring(idx+1);
		pName = Joiner.on(".").join(Splitter.on(".").omitEmptyStrings().split(pName));
		return pName;
	}

	public static Multimap<String, String> getTableMultimap(List<String> tableNames, List<String> prefixs){
		String regex = "";
		if(prefixs != null)
			regex = "("+Joiner.on("|").join(prefixs)+")";

		Pattern pattern = Pattern.compile(regex);
		Multimap<String, String> multimap = ArrayListMultimap.create();
		for (String tname : tableNames)
		{
			String base = tname;
			Matcher macther = pattern.matcher(tname);
			String find = "";
			if(macther.find())
			{
				find = macther.group();
				tname = tname.replace(find, "");
			}
			String packageName = (find).replace("_", ".");
			multimap.put(packageName, base);
		}
		return multimap;
	}
	public static String getRealClassName(String tableName){
		return tableName.replace(MybatisGenerator.BASE_PREFIX, "");
	}
	public static boolean isUnionKey(String tableName){
		return tableName.split(MybatisGenerator.BASE_PREFIX)[1].split("_").length >=2;
	}

	private static void init(){
		String basePath_src = System.getProperty("user.dir")+ "\\src\\main\\java\\";
		Map<String,String> paramMap = Maps.newHashMap();
		paramMap.put("inherit_basemapper","com.ssf.common.mybatis.base.BaseMapper");//com.ssf.common.mybatis.base.BaseMapper
		//准备工作
		for(String key : paramMap.keySet()){
			String conf = PROPERTIES.getProperty(key);
			if(conf != null && !"".equals(conf)){
				System.out.println(key+" : "+paramMap.get(key)+" , "+conf);
				if(paramMap.get(key) != conf){
					try {
						String from = paramMap.get(key).replaceAll("\\.","\\/");
						String to = conf.replaceAll("\\.","\\/");
						System.out.println(conf.replace(".BaseMapper",""));
						File tofile = new File(basePath_src+to+".java");
						if(!tofile.exists()){
							Files.createParentDirs(tofile);
							Files.copy(new File(basePath_src+from+".java"),tofile);
							StringUtilss.replacTextContent(tofile,"com.ssf.common.mybatis.base",conf.replace(".BaseMapper",""));
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else{
				PROPERTIES.put(key,paramMap.get(key));
			}
		}
	}

	public static <T> void copyTo(Class<T> cls,String src,String dest){
		String name = cls.getSimpleName();
		String fullname = cls.getName();

		String basePath = src+"\\src\\main\\java\\";
		String entity = (PROPERTIES.getProperty("myModelPackage")+"\\"+name).replaceAll("\\.","\\\\");
		String dao = (PROPERTIES.getProperty("myBussinessPackage")+"\\"+name).replaceAll("\\.","\\\\");
		String daoxml = (PROPERTIES.getProperty("myBussinessPackage")+"\\"+name).replaceAll("\\.","\\\\");
		String service = (PROPERTIES.getProperty("myServicePackage")+"\\I"+name).replaceAll("\\.","\\\\");
		String serviceImpl = (PROPERTIES.getProperty("myServicePackage")+"\\impl\\"+name).replaceAll("\\.","\\\\");
		File entityfile = new File(basePath	+ entity+".java");
		File daofile   = new File(basePath	+ dao+"Dao.java");
		File daoxmlfile = new File( src+"\\src\\main\\resources\\"	+ daoxml+"Dao.xml");
		File servicefile   = new File(basePath + service+"Service.java");
		File serviceImplfile   = new File(basePath + serviceImpl+"ServiceImpl.java");

		String dest_basePath = dest+"\\src\\main\\java\\";
		String dest_entity = (PROPERTIES.getProperty("myModelPackage")+"\\"+name).replaceAll("\\.","\\\\");
		String dest_dao = (PROPERTIES.getProperty("myBussinessPackage")+"\\"+name).replaceAll("\\.","\\\\");
		String dest_daoxml = (name).replaceAll("\\.","\\\\");
		String dest_service = (PROPERTIES.getProperty("myServicePackage")+"\\I"+name).replaceAll("\\.","\\\\");
		String dest_serviceImpl = (PROPERTIES.getProperty("myServicePackage")+"\\impl\\"+name).replaceAll("\\.","\\\\");
		File dest_entityfile = new File(dest_basePath	+ dest_entity+".java");
		File dest_daofile   = new File(dest_basePath	+ dest_dao+"Dao.java");
		File dest_daoxmlfile = new File( dest+"\\src\\main\\resources\\mapper\\"	+ dest_daoxml+"Dao.xml");
		File dest_servicefile   = new File(dest_basePath + dest_service+"Service.java");
		File dest_serviceImplfile   = new File(dest_basePath + dest_serviceImpl+"ServiceImpl.java");
//		System.out.println(entityfile +" 	"+dest_entityfile);
//		System.out.println(daofile+" 	"+dest_daofile);
//		System.out.println(daoxmlfile+" 	"+dest_daoxmlfile);
//		System.out.println(servicefile+" 	"+dest_servicefile);
//		System.out.println(serviceImplfile+" 	"+dest_serviceImplfile);

		try {
			Files.copy(entityfile,dest_entityfile);
			Files.copy(daofile,dest_daofile);
			Files.copy(daoxmlfile,dest_daoxmlfile);
			Files.copy(servicefile,dest_servicefile);
			Files.copy(serviceImplfile,dest_serviceImplfile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//
	public static void main(String[] args) 
	{
		//init();
		//List<String> lists = Lists.newArrayList("sql/finalssm.sql","sql/finalssm_data.sql");
		//runSql(PROPERTIES,lists);
		//createConfigs();
		//generator(OUT_CONFIG);
		//generateCode();

		copyTo(Menucate.class, System.getProperty("user.dir"),"D:\\workspace\\IdeaProject\\RiverResponsibleSystem\\RiverResponsibleSystem");
	}

}
