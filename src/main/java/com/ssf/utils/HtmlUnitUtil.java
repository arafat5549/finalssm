package com.ssf.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * 网页下载器
 * @author wyy
 *
 */
public class HtmlUnitUtil {

	
	/**
	 * 2.爬取对象网站的文本呢信息
	 */
	private static void downloadURL(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
		//日记
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
		java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		// 设置webClient的相关参数
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setActiveXNative(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.waitForBackgroundJavaScript(60*1000);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());
				
		webClient.getOptions().setJavaScriptEnabled(true); 
		//webClient.setAjaxController(new NicelyResynchronizingAjaxController()); 
		
		// 模拟浏览器打开一个目标网址
		final HtmlPage page = webClient.getPage(url);
//		该方法在getPage()方法之后调用才能生效
		webClient.waitForBackgroundJavaScript(1000*6);
		webClient.setJavaScriptTimeout(0);
//		Thread.sleep(1000 *3L);
		String js = "javascript:checkShowFollow('271942','2');";
		ScriptResult sr = page.executeJavaScript(js);
		HtmlPage newPage = (HtmlPage) sr.getNewPage();
//		System.out.println("page.asText=" + newPage.asXml());
//		
//		String xpath = "//a[@src]";
//		List<HtmlAnchor> links = (List<HtmlAnchor>) newPage.getByXPath (xpath);
		
//		Set<String> set =new HashSet<String>();
//		//System.out.println(links.size());
//		int i =0;
//		for (HtmlAnchor obj : links) {
//			//System.out.println(obj.asXml());
//			String href = obj.getAttribute("href");
//			String id = CharMatcher.DIGIT.retainFrom(href);
//		    set.add(id);
//		    //System.out.println((i++)+": "+id);
//		}
//		//System.out.println(set.size());
		OutputStream out = new FileOutputStream(new File("shop-index.html"));
		IOUtils.write(newPage.asXml(), out);
	}
	
	public static void main(String[] args) {
		String url = "http://metronic.kp7.cn/templates/frontend/shop-index.html";
		try {
			downloadURL(url);
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		}
	}
}
