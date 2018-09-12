package generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import com.ssf.common.mybatis.plugin.utils.LogUtil;
import com.ssf.common.utils.StringUtilss;
import com.ssf.utils.MyStringUtil;
import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.ShellRunner;
import org.springside.modules.utils.io.URLResourceUtil;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;

/**
 * 修改bug1：mybatis 拼接语句时,Boolean 类型判断为false的时候不生效问题 <a>https://blog.csdn.net/liubinblog/article/details/78035454</a>
 * TODO 生成文件的时候直击读取指定区域的自编写文件内容
 */
public class MybatisGenerator {
	//####################################################
	private static final String ORIGIN_CONFIG = "generatorConfig.xml";
	private static final String OUT_CONFIG   = "src/main/resources/generatorConfigBak.xml";


	public static final Properties PROPERTIES = new Properties();
	public static Map<String,String> COMMENT_MAPS = Maps.newHashMap();
	//####################################################
	public static String BASE_PREFIX= "water_";
	public static String MAPPER_NAME = "Dao";
	public static String DEST_PROJECT_PATH = "D:\\workspace\\IdeaProject\\wy";

	//"/Users/arafat/workspace/IdeaProjects/RiverResponsibleSystem";

	static
	{
		try {
			InputStream is = URLResourceUtil.asStream("classpath://mybatis-generator.properties");//DataSourceFactory.class.getResourceAsStream("/jdbc.properties");
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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
	public static List<String> createConfigs(){
		return createConfigs(PROPERTIES,ORIGIN_CONFIG,OUT_CONFIG);
	}
	
	public static List<String> createConfigs(Properties props,String src,String out){
		String dbName = props.getProperty("dbName");
		String dbType = props.getProperty("dbType");
		if(dbName==null || "".equals(dbName)){
			throw new RuntimeException("dbName没有在配置文件里面设置");
		}
		if(dbType==null || "".equals(dbType)){
			dbType="mysql";
			System.out.println("dbType为空设为默认值mysql");
		}
		List<String> list = new ArrayList<>();
		try {
			list.addAll(GeneratorConfigXMLUtil.convertXmlStrToObjectTest(props,dbName, dbType,src,out));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return list;
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
			//MybatisGenerator.LOG(config);
		}  catch (IOException e) {
			e.printStackTrace();
			return;
		}

		MybatisGenerator.LOG("完整的配置文件路径：" + config);
		String[] arg = { "-configfile", config, "-overwrite" };
		ShellRunner.main(arg);
		MybatisGenerator.LOG("代码生成完成。");
	}

	private static void generateCode(List<String> tableNames){
		//Map<String,String> comments = MybatisGenerator.getTableComments(PROPERTIES);
		//List<String> tableNames = Lists.newArrayList(comments.keySet());
		//MybatisGenerator.LOG(tableNames.toString());
		CodeGeneratorUtil.codeGenerator(PROPERTIES, tableNames, Lists.newArrayList());
	}
	private static void generateCode_web(List<String> tableNames){
		//Map<String,String> comments = MybatisGenerator.getTableComments(PROPERTIES);
		//List<String> tableNames = Lists.newArrayList(comments.keySet());
		CodeGeneratorUtil.codeGenerator_web(PROPERTIES, tableNames, Lists.newArrayList());
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
		//System.out.println("MybatisGenerator.BASE_PREFIX="+MybatisGenerator.BASE_PREFIX);

		return MyStringUtil.underlineToCamel(tableName.replace(MybatisGenerator.BASE_PREFIX, ""));
	}
	//真实类名 首字母大写
	public static String getRealClassNameCapatial(String tableName){
		return StringUtils.capitalize(getRealClassName(tableName));
	}

	public static boolean isUnionKey(String tableName){
		//System.out.println(tableName);
		String ss[] = tableName.split(MybatisGenerator.BASE_PREFIX);
		return ss.length >1 ? ss[1].split("_").length >=2 : false;
	}
	public static  boolean isMacthPrefix(String tableName){
		return tableName.startsWith(MybatisGenerator.BASE_PREFIX);
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


	private static List<File> getDestFileList(String src,String name){
		String spliter = "\\.";
//		String str = (PROPERTIES.getProperty("myModelPackage")+File.separator+name);
//		System.out.println(str+"::::::::::"+	);
//		System.out.println(str.replaceAll(spliter,File.separator));

		String basePath = src+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator;
		String str = (PROPERTIES.getProperty("myModelPackage")+File.separator+name);
		String entity = Joiner.on(File.separator).join(Splitter.on(".").split(str));
		str =  (PROPERTIES.getProperty("myBussinessPackage")+File.separator+name);
		String dao =  Joiner.on(File.separator).join(Splitter.on(".").split(str));
		str = (PROPERTIES.getProperty("myBussinessPackage")+File.separator+name);
		String daoxml = Joiner.on(File.separator).join(Splitter.on(".").split(str));
		str = (PROPERTIES.getProperty("myServicePackage")+File.separator+"I"+name);
		String service = Joiner.on(File.separator).join(Splitter.on(".").split(str));
		str = (PROPERTIES.getProperty("myServicePackage")+File.separator+"impl"+File.separator+name);
		String serviceImpl = Joiner.on(File.separator).join(Splitter.on(".").split(str));
		str = (PROPERTIES.getProperty("myWebPackage")+File.separator+name);
		String controller  = Joiner.on(File.separator).join(Splitter.on(".").split(str));

//		String entity = (PROPERTIES.getProperty("myModelPackage")+File.separator+name).replaceAll(spliter,File.separator);
//		String dao = (PROPERTIES.getProperty("myBussinessPackage")+File.separator+name).replaceAll(spliter,File.separator);
//		String daoxml = (PROPERTIES.getProperty("myBussinessPackage")+File.separator+name).replaceAll(spliter,File.separator);
//		String service = (PROPERTIES.getProperty("myServicePackage")+File.separator+"I"+name).replaceAll(spliter,File.separator);
//		String serviceImpl = (PROPERTIES.getProperty("myServicePackage")+File.separator+"impl"+File.separator+name).replaceAll(spliter,File.separator);
//		String controller = (PROPERTIES.getProperty("myWebPackage")+File.separator+name).replaceAll(spliter,File.separator);

		File entityfile = new File(basePath	+ entity+".java");
		File daofile   = new File(basePath	+ dao+"Dao.java");
		File daoxmlfile = new File( src+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator	+ daoxml+"Dao.xml");
		File servicefile   = new File(basePath + service+"Service.java");
		File serviceImplfile   = new File(basePath + serviceImpl+"ServiceImpl.java");
		File controllerFile    = new File(basePath + controller+"Controller.java");

		List<File> fileList = new ArrayList<>();
		fileList.add(entityfile);
		fileList.add(daofile);
		fileList.add(daoxmlfile);
		fileList.add(servicefile);
		fileList.add(serviceImplfile);
		fileList.add(controllerFile);
		return fileList;
	}

	public static <T> void copyTo(Class<T> cls,String src,String dest){
		if(cls ==null)
		{
			LOG("copyTo className为空");
			return;
		}
		String name = cls.getSimpleName();
		String fullname = cls.getName();

		List<File> srclist = getDestFileList(src,name);
		List<File> destlist = getDestFileList(dest,name);
		try {
			for (int i=0;i<srclist.size();i++) {
				Files.copy(srclist.get(i),destlist.get(i));
				//System.out.println(srclist.get(i) +" , " + destlist.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void runSQL(String config){


		Properties pros = new Properties();
		try {
			InputStream is = URLResourceUtil.asStream("classpath://"+config);
			pros.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		List<String> lists = Lists.newArrayList(
	   		"/Users/arafat/workspace/IdeaProjects/RiverResponsibleSystem/sql/water_create.sql"
	    		,"/Users/arafat/workspace/IdeaProjects/RiverResponsibleSystem/sql/water_data.sql");
		 runSql(pros,lists);
	}

	public static void LOG(String log){
		System.out.println("[Log]:"+log);
	}

	public static void main(String[] args) 
	{
		//init();
		//runSQL("jdbc.properties");

		Options options = new Options();
		options.addOption("l", true, "0生成全部 1生成dao 2生成service 3生成controller");
		options.addOption("c", true, "复制到指定的路径，复制前先做比对");
		options.addOption("p", true, "Prefix 数据库表名前缀");
		options.addOption("conf", false, "指定的配置文件");

		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			String dir = cmd.getOptionValue("l");
			System.out.println(dir);
		} catch (ParseException e) {
			e.printStackTrace();
		}


//		MybatisGenerator.BASE_PREFIX = "water_";
//		List<String> tnameList = createConfigs();
//		generator(OUT_CONFIG);
//		generateCode(tnameList);
//		generateCode_web(tnameList);
//
//      String destPath =  DEST_PROJECT_PATH;
//		for (String tname:tnameList) {
//			String clsName =  PROPERTIES.getProperty("myModelPackage")+"."+MybatisGenerator.getRealClassNameCapatial(tname);
//			System.out.println(clsName);
//			Class cls = null;
//			try {
//				cls = Class.forName(clsName);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			copyTo(cls, System.getProperty("user.dir"),destPath);
//		}

	}

}
