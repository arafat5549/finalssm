package generator;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import com.ssf.utils.MyStringUtil;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.ShellRunner;
import org.springside.modules.utils.io.URLResourceUtil;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 修改bug1：mybatis 拼接语句时,Boolean 类型判断为false的时候不生效问题 <a>https://blog.csdn.net/liubinblog/article/details/78035454</a>
 * TODO 生成文件的时候直击读取指定区域的自编写文件内容
 */
public class MybatisGenerator {
	//####################################################
	public static boolean isSwagger = false;
	public static String  swaggerPrefix = "";  //测试
	private static final String ORIGIN_CONFIG = "generatorConfig.xml";
	private static final String OUT_CONFIG   = "src/main/resources/generatorConfigBak.xml";
	private static final String CONFIG_FILE = "mybatis-generator.properties";

	public static final Properties PROPERTIES = new Properties();
	public static Map<String,String> COMMENT_MAPS = Maps.newHashMap();
	//####################################################

	public static String MAPPER_NAME = "Dao";
    public static String SRC_PROJECT_PATH  = "D:\\workspace\\IdeaProject\\wy"; //从src读取配置
	public static String DEST_PROJECT_PATH = "D:\\workspace\\IdeaProject\\wy";
	public static String BASE_PREFIX= "water_";

	//"/Users/arafat/workspace/IdeaProjects/RiverResponsibleSystem";

	static
	{
		try {
			InputStream is = URLResourceUtil.asStream("classpath://"+CONFIG_FILE);

			PROPERTIES.load(is);

			//替换一些常量
			DEST_PROJECT_PATH = PROPERTIES.getProperty("out_path");
			System.out.println("DEST_PROJECT_PATH: "+DEST_PROJECT_PATH);

            SRC_PROJECT_PATH  = PROPERTIES.getProperty("src_path");
            System.out.println("SRC_PROJECT_PATH: "+ SRC_PROJECT_PATH);

			BASE_PREFIX = PROPERTIES.getProperty("db_prefix");
			System.out.println("BASE_PREFIX: "+BASE_PREFIX);

			MAPPER_NAME = PROPERTIES.getProperty("mapper_suffix");
			System.out.println("MAPPER_NAME: "+MAPPER_NAME);


			System.out.println(PROPERTIES.getProperty("myBussinessPackage"));
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
		try {
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
		CodeGeneratorUtil.codeGenerator(PROPERTIES, tableNames, Lists.newArrayList());
	}
	private static void generateCode_web(List<String> tableNames){
		CodeGeneratorUtil.codeGenerator_web(PROPERTIES, tableNames, Lists.newArrayList());
	}


	//工具类
	public static  List<String> getTableContent(Properties props,String tableName){
		String dbName = props.getProperty("dbName");
		String dbType = props.getProperty("dbType");
		return DataBasePopulator.getTableContent(props, dbName,dbType,tableName);
	}
	public static  List<String> getTableNames(Properties props){
		String dbName = props.getProperty("dbName");
		String dbType = props.getProperty("dbType");
		return DataBasePopulator.getTableNames(props, dbName,dbType);
	}
	public static Map<String,String> getTableComments(Properties props,boolean all){
		if(COMMENT_MAPS.size()>0){
			return COMMENT_MAPS;
		}
		String dbName = props.getProperty("dbName");
		String dbType = props.getProperty("dbType");
		System.out.println("dbName="+dbName+",dbType="+dbType);
		return DataBasePopulator.getTableComments(props, dbName,dbType,all);
	}
	/**
	 *
	 * @param key 表名 比如sys_user
	 * @return
	 */
	public static String getTableComment(String key){
		Map<String,String> maps = getTableComments(PROPERTIES,false);
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


//	private static void init(){
//		String basePath_src = System.getProperty("user.dir")+ "\\src\\main\\java\\";
//		Map<String,String> paramMap = Maps.newHashMap();
//		paramMap.put("inherit_basemapper","com.ssf.common.mybatis.base.BaseMapper");//com.ssf.common.mybatis.base.BaseMapper
//		//准备工作
//		for(String key : paramMap.keySet()){
//			String conf = PROPERTIES.getProperty(key);
//			if(conf != null && !"".equals(conf)){
//				System.out.println(key+" : "+paramMap.get(key)+" , "+conf);
//				if(paramMap.get(key) != conf){
//					try {
//						String from = paramMap.get(key).replaceAll("\\.","\\/");
//						String to = conf.replaceAll("\\.","\\/");
//						System.out.println(conf.replace(".BaseMapper",""));
//						File tofile = new File(basePath_src+to+".java");
//						if(!tofile.exists()){
//							Files.createParentDirs(tofile);
//							Files.copy(new File(basePath_src+from+".java"),tofile);
//							StringUtilss.replacTextContent(tofile,"com.ssf.common.mybatis.base",conf.replace(".BaseMapper",""));
//						}
//
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}else{
//				PROPERTIES.put(key,paramMap.get(key));
//			}
//		}
//	}


	private static List<File> getDestFileList(String src,String name,int iscopy){
		List<File> fileList = new ArrayList<>();
		String spliter = "\\.";
		String str = "";
		String basePath = src+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator;

		if(iscopy>=1)
		{
			str = (PROPERTIES.getProperty("myModelPackage")+File.separator+name);
			String entity = Joiner.on(File.separator).join(Splitter.on(".").split(str));
			str =  (PROPERTIES.getProperty("myBussinessPackage")+File.separator+name);
			String dao =  Joiner.on(File.separator).join(Splitter.on(".").split(str));
			str = (PROPERTIES.getProperty("myBussinessPackage")+File.separator+name);
			String daoxml = Joiner.on(File.separator).join(Splitter.on(".").split(str));

			File entityfile = new File(basePath	+ entity+".java");
			File daofile   = new File(basePath	+ dao+"Dao.java");
			File daoxmlfile = new File( src+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator	+ daoxml+"Dao.xml");
			fileList.add(entityfile);
			fileList.add(daofile);
			fileList.add(daoxmlfile);
		}
		if(iscopy>=2)
		{
			str = (PROPERTIES.getProperty("myServicePackage")+File.separator+"I"+name);
			String service = Joiner.on(File.separator).join(Splitter.on(".").split(str));
			str = (PROPERTIES.getProperty("myServicePackage")+File.separator+"impl"+File.separator+name);
			String serviceImpl = Joiner.on(File.separator).join(Splitter.on(".").split(str));
			File servicefile   = new File(basePath + service+"Service.java");
			File serviceImplfile   = new File(basePath + serviceImpl+"ServiceImpl.java");

			fileList.add(servicefile);
			fileList.add(serviceImplfile);
		}
		if(iscopy>=3){
			str = (PROPERTIES.getProperty("myWebPackage")+File.separator+name);
			String controller  = Joiner.on(File.separator).join(Splitter.on(".").split(str));
			File controllerFile    = new File(basePath + controller+"Controller.java");
			fileList.add(controllerFile);
		}

//		String entity = (PROPERTIES.getProperty("myModelPackage")+File.separator+name).replaceAll(spliter,File.separator);
//		String dao = (PROPERTIES.getProperty("myBussinessPackage")+File.separator+name).replaceAll(spliter,File.separator);
//		String daoxml = (PROPERTIES.getProperty("myBussinessPackage")+File.separator+name).replaceAll(spliter,File.separator);
//		String service = (PROPERTIES.getProperty("myServicePackage")+File.separator+"I"+name).replaceAll(spliter,File.separator);
//		String serviceImpl = (PROPERTIES.getProperty("myServicePackage")+File.separator+"impl"+File.separator+name).replaceAll(spliter,File.separator);
//		String controller = (PROPERTIES.getProperty("myWebPackage")+File.separator+name).replaceAll(spliter,File.separator);
		return fileList;
	}

	public static <T> void copyTo(Class<T> cls,String src,String dest,int iscopy){
		if(cls ==null)
		{
			LOG("copyTo className为空");
			return;
		}
		String name = cls.getSimpleName();
		String fullname = cls.getName();

		List<File> srclist = getDestFileList(src,name,iscopy);
		//System.out.println(srclist);
		List<File> destlist = getDestFileList(dest,name,iscopy);
		try {
			for (int i=0;i<srclist.size();i++) {

				File to  = destlist.get(i);
				File p = to.getParentFile();
				if(!p.exists())
					p.mkdirs();
				System.out.println("拷贝到：" +to);
				Files.copy(srclist.get(i),to);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void LOG(String log){
		System.out.println("[Log]:"+log);
	}

	/**
	 * 运行sql语句
	 * @param config
	 */
	private static void runSQL(String config){


		Properties pros = new Properties();
		try {
			InputStream is = URLResourceUtil.asStream("classpath://"+config);
			pros.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		List<String> lists = Lists.newArrayList("/Users/arafat/workspace/IdeaProjects/RiverResponsibleSystem/sql/water_create.sql","/Users/arafat/workspace/IdeaProjects/RiverResponsibleSystem/sql/water_data.sql");
		runSql(pros,lists);
	}

	/**
	 * 根据sql生成文件结构
	 */
	private static void genrateCode(){
		//		Options options = new Options();
//		options.addOption("l", true, "0生成全部 1生成dao 2生成service 3生成controller");
//		options.addOption("c", true, "复制到指定的路径，复制前先做比对");
//		options.addOption("p", true, "Prefix 数据库表名前缀");
//		options.addOption("conf", false, "指定的配置文件");
//
//		CommandLineParser parser = new DefaultParser();
//		try {
//			CommandLine cmd = parser.parse(options, args);
//			String dir = cmd.getOptionValue("l");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

		int generate_level = Integer.parseInt(PROPERTIES.getProperty("generate_level"));
		//runSQL(CONFIG_FILE);
		List<String> tnameList = createConfigs();
		if(generate_level>=1)
			generator(OUT_CONFIG);
		if(generate_level >=2)
			generateCode(tnameList);
		if(generate_level >=3)
			generateCode_web(tnameList);

		int iscopy = Integer.parseInt(PROPERTIES.getProperty("copy_to_target"));
		System.out.println("generate_level: "+generate_level+",iscopy: "+iscopy);
		if(iscopy > 0)
		{
			String db_copytable =  PROPERTIES.getProperty("db_copytable");
			String destPath =  DEST_PROJECT_PATH;
			for (String tname:tnameList) {
				if(Strings.isNullOrEmpty(db_copytable) || (db_copytable.equals(tname))){
					String clsName =  PROPERTIES.getProperty("myModelPackage")+"."+MybatisGenerator.getRealClassNameCapatial(tname);
					System.out.println("开始拷贝:"+clsName);
					Class cls = null;
					try {
						cls = Class.forName(clsName);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					copyTo(cls, System.getProperty("user.dir"),destPath,iscopy);
				}

			}
		}
	}

	/**
	 * 解析数据库
	 */
	private static void parseDateBase(boolean isprint){
		List<String> tnameList = getTableNames(PROPERTIES);
		COMMENT_MAPS.clear();
		Map<String,String> comments = getTableComments(PROPERTIES,true);
		for(String tname:tnameList){
			String comment = comments.get(tname);
			COMMENT_MAPS.put(tname,comment);


			if(isprint && tname.startsWith(BASE_PREFIX)){
				String realname = getRealClassNameCapatial(tname);
				StringBuffer sb =new StringBuffer();
				sb.append("@ApiOperation(\""+comment+"\")"+"\r\n");
				sb.append("@GetMapping(\"/"+getRealClassName(tname)+"/{id}\")"+"\r\n");
				sb.append("public "+realname+" find"+realname+"ById(@PathVariable Long id) {return new "+realname+"();}"+"\r\n");
				System.out.println(sb.toString());
			}
		}
	}

	private static  String _createForiegnKeySql(String tablename,String fkTableName,String bindId,String fkId,String fkname){
//		String tablename   = "article";
//		String fkTableName = "category";
//		String bindId = "id";
//		String fkId = "category_id";
		String fksql = "ALTER TABLE `"+tablename+"` ADD CONSTRAINT `"+fkname+"` FOREIGN KEY (`"+fkId+"`) REFERENCES `"+fkTableName+"` (`"+bindId+"`);";
		return fksql;
	}
	/**
	 * 生成外键
	 */
	public static void createForiegnKey(boolean isprint){
		List<String> fksqlist = Lists.newArrayList();



		List<String> tnameList = getTableNames(PROPERTIES);
		for(String tname:tnameList){
			List<String> list = getTableContent(PROPERTIES,tname);
			List<String> errorsqlist = Lists.newArrayList();
			List<String> rightsqlist = Lists.newArrayList();

			for(String column:list){
				if(column.equals("update_id") || column.equals("create_id")){//不包含默认设置
					 continue;
				}
				if(column.equals("parent_id")){   //不包含自关联
					continue;
				}
				if(column.endsWith("_id")){
					String ret = checkTableList(column,tnameList);
					if(!Strings.isNullOrEmpty(ret)){
						//TestObjectUtils.printColor("\t"+ret);
						rightsqlist.add("\t"+ret);
						String rets[] = ret.split(",");
						String fkname = "fk_"+getRealClassNameCapatial(tname)+"_"+rets[2];
						String fksql = _createForiegnKeySql(tname,rets[3],"id",rets[0],fkname);

						fksqlist.add(fksql);
					}
					else{
						errorsqlist.add("\t"+column);
						//TestObjectUtils.printColor("\t"+column, TestObjectUtils.PrintColor.C_FAIL);
					}
				}
			}

			if(errorsqlist.size()>0){
				System.out.println(tname+","+list.toString());
				for(String error:errorsqlist){
					TestObjectUtils.printColor(error, TestObjectUtils.PrintColor.C_FAIL);
				}
				System.out.println();
			}

		}

		//
		if(isprint){
			for(String fksql:fksqlist){
				TestObjectUtils.printColor("\t"+fksql, TestObjectUtils.PrintColor.C_CYAN);
			}
		}

	}
	//
	private static String checkTableList(String baseCol,List<String> tnameList){
		String ret = null;
		for(String tname:tnameList){
			if(tname.startsWith(BASE_PREFIX) ){
				//String baseCol = column;
				String column = baseCol.replace("_id","");
				String cname = getRealClassNameCapatial(column);
				String realname = getRealClassNameCapatial(tname);

				String retColor = baseCol+","+cname+","+realname+","+tname;
				//System.out.println("==["+retColor);
				if(cname.equals(realname) || realname.equals("Sys"+cname) ){
					ret = retColor;
					break;
				}
				else if(cname.startsWith("Goods") && realname.equals("Shop"+cname)){
					ret = retColor;
					break;
				}
				else if(cname.equals("Operator") && realname.equals("SysEmployee")){
					ret = retColor;
					break;
				}
				else if(cname.equals("Brand") || cname.equals("Category") || cname.equals("Order") || cname.equals("Cart")){
					if(tname.startsWith("T_ShopGoods")&& realname.equals("ShopGoods"+cname)){
						ret = retColor;
						break;
					}
					if(tname.startsWith("T_Hotel")&& realname.equals("Hotel"+cname)){
						ret = retColor;
						break;
					}
				}
				else{
				}


			}
		}
		return  ret;
	}

	public static String getCommentByTableName(String tname){
		return COMMENT_MAPS.get(tname);
	}

	public static void main(String[] args) 
	{

		System.out.println("----------------------------------------------------------------------------");
		BASE_PREFIX = "T_";//"";
		parseDateBase(false);

		createForiegnKey(false);

		genrateCode();
		//

	}

}
