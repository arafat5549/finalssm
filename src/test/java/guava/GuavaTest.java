package guava;

import com.google.common.base.*;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * 测试常用的guava方法
 * @author wyy
 *
 */
public class GuavaTest {
	@Test
	public void baseTest(){
		System.out.println("-----------------开启Guava测试-----------------------");
		
		//1.集合的类型转换
		String str = "0,2,4,5";
		List<String> parents = Splitter.on(",")
				.omitEmptyStrings()
				.trimResults(CharMatcher.is('0'))
				.splitToList(str);
		System.out.print("操作前:"+parents+",结果:");
		Function<String,Integer> function = new Function<String, Integer>() {		
			@Override
			public Integer apply(String arg0) {
				return NumberUtils.toInt(arg0);
			}
		};
		List<Integer> ints = Lists.transform(parents, function);
		System.out.println(ints);
		//2.过滤集合
		String url= "assets/global/plugins/slider-layer-slider/css/blank.gif";
		List<String> list2 =Splitter.on('/').splitToList(url);
		System.out.print("操作前:"+url+",结果:"); 
	  	 Collection<String> filterList = Collections2.filter(list2, new Predicate<String>(){
				@Override
				public boolean apply(String input) {
					return !(input.matches(".+\\..+"));
				}
	  	});
	  	String filepath = Joiner.on("/").join(filterList);
	  	System.out.println(filepath);
	  	
	  	//3.
	  	url ="assets/global/plugins/demoBak.html";
	  	String retString = url.replace("Bak.html", ".html");
	  	System.out.println(retString);
	  	System.out.println("-----------------结束Guava测试-----------------------");

		//Hashing.md5()
	}

	@Test
	public void test() {
		String input = "hello, world";
		// 计算MD5
		System.out.println(Hashing.md5().hashBytes(input.getBytes()).toString());
		// 计算sha256
		System.out.println(Hashing.sha256().hashBytes(input.getBytes()).toString());
		// 计算sha512
		System.out.println(Hashing.sha512().hashBytes(input.getBytes()).toString());
		// 计算crc32
		System.out.println(Hashing.crc32().hashBytes(input.getBytes()).toString());

		System.out.println(Hashing.md5().hashUnencodedChars(input).toString());

	}
}
