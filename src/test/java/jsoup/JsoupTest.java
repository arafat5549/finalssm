package jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springside.modules.utils.io.FilePathUtil;
import org.springside.modules.utils.io.FileTreeWalker;
import org.springside.modules.utils.text.WildcardMatcher;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.google.common.io.Files;

/**
 * 自动替换-并且下载需要的资源
 */
public class JsoupTest {
	private static final String ROOT = "F:\\workspace_javaee\\finalssm\\src\\main\\webapp\\assets";
	private static final String PREFIX     = "src/main/webapp/WEB-INF/pages/";
	private static final String HTTPURL    = "http://metronic.kp7.cn/";
	private static final String DEST_PREFIX = "src/main/webapp/";
	private static int isNeedDownLoad = 0;
	
//	enum DownLoadParameter{
//		DownLoadParameter_NONE(0,"不下载"),
//		DownLoadParameter_Down(1,"下载不覆盖"),
//		DownLoadParameter_Override(2,"下载覆盖");
//		
//		DownLoadParameter(int value,String name){}
//	}
	
	/** 
	 * 下载所需要的资源
	 * @param src 类似于"assets/global/plugins/slider-layer-slider/css/blank.gif"
	 */
	public static void downLoadOne(String src,String spliter)
	{
		downLoadOne(src, spliter, true,null);
	}
	
	public static void downLoadOne(String src,String spliter,boolean isNeedSplit,String realUrl){
		src = src.replace("\\", "/");
		String originSrc = src;
		if(isNeedSplit){
			 List<String> srclist = Splitter.on(spliter).splitToList(src);
	       	 if(srclist.size()>1){
	       		src = spliter + srclist.get(1);
	       	 }
		}
		
		String path = DEST_PREFIX+src;
		String url  = HTTPURL+src;
		if(realUrl!=null){
			url = realUrl;
			originSrc = path;
		}
//src = CharMatcher.is('\"').removeFrom(CharMatcher.is('\\').removeFrom(src));
//  	  List<String> list2 =Splitter.on('/').splitToList(path);
//  	 
//  	  Collection<String> filterList = Collections2.filter(list2, new Predicate<String>(){
//			@Override
//			public boolean apply(String input) {
//				return !(input.matches(".+\\..+"));
//			}
//  	  });
//  	  String filepath = Joiner.on("/").join(filterList);
  	  File file = new File(FilePathUtil.getParentPath(path));
  	  if(!file.exists())
  		  file.mkdirs();
		
  	  		
  	  	  //System.out.println("src:"+originSrc);
	  	  if(isNeedDownLoad>0 && ( isNeedDownLoad == 2 || (isNeedDownLoad == 1 && !new File(originSrc).exists()) )  ){
	  		//System.out.println("src:"+originSrc);
	  		  System.out.println("----download:"+url+"  ,  "+path);
	  		  HttpDownload.download(url, path);
	  	  }
	}	

 /**
  * 
  */
  private static  void parseElements(Document doc,String tagName,String attrName,String spliter){
      Elements links = doc.getElementsByTag(tagName);
      for (Element link : links) {
          String linkHref = link.attr(attrName);
          if(!linkHref.startsWith("http") && !Strings.isNullOrEmpty(linkHref))
          {
        	  List<String> list = Splitter.on(spliter).splitToList(linkHref);
        	  if(list.size()<=1){
        		  continue;
        	  }
        	  String path = spliter+list.get(1);
        	  
        	  String url  = HTTPURL + path;
        	  link.attr("th:"+attrName,"@{/"+path+"}");
        	 // System.out.println(url+"  ,  "+path);
        	  downLoadOne(path,spliter);
          }

      }
  }

   private static void parseHtml(String src,String dest,String spliter,boolean isGenerate){
       try {
           File srcFile = new File(src);
           if(isGenerate && !srcFile.exists()){//如果bak不存在就先复制BAK文件
        	   String origin = src.replace("Bak.html", ".html");
        	   File originFile = new File(origin);
        	   if(!originFile.exists()){
        		   System.out.println("原始文档不存在:"+origin); 
        		   return;
        	   }
        	   Files.asByteSource(originFile).copyTo(new FileOutputStream(srcFile));
           }
           
           Document doc = Jsoup.parse(srcFile ,"utf-8");
           parseElements(doc,"link","href",spliter);
           parseElements(doc,"script","src",spliter);
           parseElements(doc,"img","src",spliter);

          if(isGenerate){
        	  System.out.println("生成文档:"+dest);
              File destFile = new File(dest);
              IOUtils.write(doc.toString(),new FileOutputStream(destFile));
          }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   
   private static void parsePage(String tplName,String spliter){
	   String src   = PREFIX + tplName + "Bak.html";
       String dest  = PREFIX + tplName +".html";
       parseHtml(src,dest,spliter,true);
   }
  
   static void parseHAR(String har,String spliter) {
	   	isNeedDownLoad = 1;
		//parseHtml(har,har,spliter,false);
   }
   
   
   //private static Pattern pattern = Pattern.compile("url\\(.+\\.((eot)|(png))\\)");
   private static Pattern pattern = Pattern.compile("url\\((.+?)\\)");
   private static Pattern pathPattern =  Pattern.compile("(\\.\\./)+?");
   private static void findUrlsFromCSS(File srcFile,Set<String> sets){
		  // File srcFile = new File(har); 
		 try {
			String harContent = Files.toString(srcFile, Charset.forName("utf-8"));
			Matcher matcher = pattern.matcher(harContent);
			while (matcher.find())
			{
				String ret = matcher.group(1);
				ret = ret.replace("\"", "").replace("\'", "");
				//System.out.println(ret);
				if(!ret.startsWith("http")){
					String rootDir = FilePathUtil.getParentPath(srcFile.getPath());
					Matcher pathMatcher = pathPattern.matcher(ret);
					boolean flag = false;
					while (pathMatcher.find())
					{
						rootDir = FilePathUtil.getParentPath(rootDir);
						flag =true;
					}
					//System.out.println("rootDir:"+rootDir+","+ret);
					String laString = rootDir+ret.replace("../", "");
					//System.out.println(laString);
					//sets.add(laString);
					sets.add(laString);
				}
				else{
					System.out.println(ret);
					System.out.println(srcFile);
					String laString = ret+"#"+FilePathUtil.getParentPath(srcFile.getPath())+new File(ret).getName();
					sets.add(laString);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
   }
   /**
    * 下载css里面的所有资源
    * @param args
    */
   public static void loadFromCss(String rootDir,String spliter){
	isNeedDownLoad = 1;
   	Set<String> sets = Sets.newHashSet();
   	List<File> dirs = FileTreeWalker.listFileWithExtension(new File(rootDir), "css");
   	for (File srcFile : dirs) {
   		findUrlsFromCSS(srcFile, sets);
	}
   	
   	for (String path : sets) {
   		if(!path.startsWith("http"))
   		{
   			//System.out.println(path);
   			downLoadOne(path, spliter,true,null);
   		}
   		else{
   			//System.out.println("其他:"+path);
   			String url = path.split("#")[0];
   			String parentPath = path.split("#")[1];
   			downLoadOne(parentPath, spliter,true,url);
   		}
   	}
   }
   //
   public static void loadFromDir(String rootDir,String spliter){
	   loadFromDir(rootDir, spliter,"png");
   }
   public static void loadFromDir(String rootDir,String spliter,String suffix){
	   isNeedDownLoad = 2;
	   List<File> dirs = FileTreeWalker.listFileWithExtension(new File(rootDir), suffix);
	   for (File srcFile : dirs) {
			System.out.println(srcFile);	
   			//String path = path.split("#")[1];
   			downLoadOne(srcFile.getPath(), spliter);
	   };
   }
   
    public static void main(String[] args) throws IOException  {
    	String spliter = "assets";
//        String tplName = "frontend/include/top";
//        isNeedDownLoad = false;
//        parsePage(tplName,spliter);
     
    	
    	//downLoadOne("http://metronic.kp7.cn/assets/frontend/layout/img/icon-color-close.png",spliter);
    	//String har ="C:\\Users\\Administrator\\Downloads\\metronic.kp7.cn.har";
    	//String har ="F:\\workspace_javaee\\finalssm\\src\\main\\webapp\\assets\\frontend\\layout\\css\\style.css";
    	//parseHAR(har,spliter);
    	
    	String rootDir ="F:\\workspace_javaee\\finalssm\\src\\main\\webapp\\assets";
    	
//    	List<File> dirs = FileTreeWalker.listFileWithExtension(new File(rootDir), "css");
//    	//Pattern testPattern = Pattern.compile("googleplus");
//       	for (File srcFile : dirs) {
//       		String harContent = Files.toString(srcFile, Charset.forName("utf-8"));
//			Matcher matcher = pattern.matcher(harContent);
//			while (matcher.find())
//			{
//				System.out.println(srcFile+" # "+matcher.group());
//			}
//    	}
    	
    	loadFromCss(rootDir,spliter);
    	
    	//String rootDir = "F:\\workspace_javaee\\finalssm\\src\\main\\webapp\\assets\\global\\img";
    	//loadFromDir(rootDir,spliter);
    	
    	//rootDir = "F:\\workspace_javaee\\finalssm\\src\\main\\webapp\\assets\\frontend\\layout\\img";
    	//loadFromDir(rootDir,spliter);
       	
       	//loadFromDir(ROOT,spliter,"css");
    }
    
   
}
