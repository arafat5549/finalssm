package quiz;

import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quiz {

	enum QuizType{
		QuizType_0(0,"选择题 "),
		QuizType_1(1,"多选题 "),
		QuizType_2(2,"填空题 "),
		QuizType_3(3,"描述题 "),
		;
		
		int type;
		String value;
		QuizType(int type,String value){
			this.type = type;
			this.value = value;
		}
	}
	enum QuizScope{
		QuizScope_0(0,"Java基础"),
		QuizScope_1(1,"面向对象 "),
		QuizScope_2(2,"集合类 "),
		QuizScope_3(3,"IO流"),
		;
		
		int type;
		String value;
		QuizScope(int type,String value){
			this.type = type;
			this.value = value;
		}
	}
	
	private Integer id;
	private Integer type;//0选择题 1多选题 2填空题 3描述题
	
	private Integer  scope;//0java基础， 
	
	private String question;//问题描述(支持HTML代码)
	private String answers; //选项xxxxxxxx,,,,
	private String correct; //0,1,2,3 
	
	private String hint;    //提示
	private String desc;    //解答
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public String getCorrect() {
		return correct;
	}
	public void setCorrect(String correct) {
		this.correct = correct;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Integer getScope() {
		return scope;
	}
	public void setScope(Integer scope) {
		this.scope = scope;
	}
	//读取所有的题库
	private static Pattern pattern = Pattern.compile("\\d、.+");
	private static Pattern pattern_scope = Pattern.compile("(一|二|三|四|五|六|七|八|九|十|十一|十二)\\. .+2");
	private static void readDoc() throws IOException, InvalidFormatException, OpenXML4JException, XmlException{
		File file = new File("F:\\workspace_javaee\\MyShop\\我的文档\\Java面试宝典2013版.doc");
		//InputStream is = new FileInputStream(file);
		//String content  = IOUtils.toString(is);
		//System.out.println(content);
		POITextExtractor extractor = ExtractorFactory.createExtractor(file);  
		
		String content  = extractor.getText();
		Matcher m = pattern.matcher(content);
		int count = 0;
		while (m.find()) {
			System.out.println(m.group());
			count++;
		}
		
		Matcher m_scope = pattern_scope.matcher(content);
		while (m_scope.find()) {
			System.out.println(m_scope.group());
		}
		System.out.println("总数为:"+count);
	}
	
	public static void main(String[] args) {
		try {
			readDoc();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (OpenXML4JException e) {
			e.printStackTrace();
		} catch (XmlException e) {
			e.printStackTrace();
		}
	}
	
}
