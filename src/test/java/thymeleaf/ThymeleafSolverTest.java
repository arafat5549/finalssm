package thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.linkbuilder.StandardLinkBuilder;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Map;

/**
 * 生成HTML模板
 * 包含了th属性的HTML5模板
 * @author Administrator
 *
 */
public class ThymeleafSolverTest {

	
	private static final String PREFIX = "templates/test/";
	private static void test(final String templateName, final String expectedResultLocation, final IContext context) throws Exception {
		
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setTemplateMode("HTML");
        templateResolver.setPrefix(PREFIX);//("src/main/webapp/WEB-INF/pages/");//("templateparser/decoupled/gtvg/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setUseDecoupledLogic(true);


        final TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setLinkBuilder(new StandardLinkBuilder() {
            @Override
            protected String computeContextPath(final IExpressionContext context, final String base, final Map<String, Object> parameters) {
                return "";
            }
        });


        final String result = templateEngine.process(templateName, context);
        System.out.println(result);
//        final String expected =
//                ResourceUtils.read(
//                        ClassLoaderUtils.getClassLoader(DecoupledGTVGTest.class).getResourceAsStream(expectedResultLocation),
//                        "ISO-8859-1",
//                        true);
//
//        Assert.assertEquals(ResourceUtils.normalize(expected), ResourceUtils.normalize(result));
	}
	 
	public static void main(String[] args) throws Exception {
		 	final Context ctx = new Context();
	        //ctx.setVariable("user", new User("John", "Apricot", "Antarctica", null));
	        //ctx.setVariable("today", DateUtils.create(2016, 02, 18));
	        //test("layout2", "src/main/webapp/WEB-INF/pages/layoutResult.html", ctx);
		 	test("home", PREFIX+"Result/layoutResult.html", ctx);
	}
}
