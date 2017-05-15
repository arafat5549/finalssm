
package thymeleaf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.linkbuilder.StandardLinkBuilder;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import thymeleaf.TebModel;

public class ThymeleafTest {

	private TemplateEngine engine;

    public ThymeleafTest init(Properties properties) throws Exception {

        FileTemplateResolver templateResolver =  new FileTemplateResolver();
        templateResolver.setPrefix(properties.getProperty("prefix"));
        templateResolver.setSuffix(properties.getProperty("suffix"));
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode("HTML");

        engine = new TemplateEngine();
        engine.setTemplateResolver(templateResolver);
        engine.setLinkBuilder(new StandardLinkBuilder() {
            @Override
            protected String computeContextPath(final IExpressionContext context, final String base, final Map<String, Object> parameters) {
                return "";
            }
        });
        engine.isInitialized();
        return this;
    }

    public void test(String tplName,Map<String,Object> arguments, Writer writer) throws Exception {
        Context ctx = new Context();
        ctx.setVariables(arguments);
        engine.process(tplName,  ctx, writer);
    }
    public void shut() throws Exception { }

    private static final String PREFIX = "./src/main/webapp/WEB-INF/pages/";



    public static void main(String args[]) throws Exception {
        String source="UTF-8", target = "UTF-8";
        FileOutputStream out = new FileOutputStream(new File(".\\src\\main\\webapp\\a.html"));
        Writer writer = new OutputStreamWriter(out, target);
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("target", target);
        data.put("models", TebModel.dummyModels(20));
        
        
        Properties properties = new Properties();
        //properties.setProperty("source", source);
        //properties.setProperty("target", target);
        properties.setProperty("prefix", PREFIX);
        properties.setProperty("suffix", ".html");
        String tplName = "layout";
        
        ThymeleafTest engine = new ThymeleafTest().init(properties);
        engine.test(tplName,data, writer);
        writer.flush();
        engine.shut();
    }

}
