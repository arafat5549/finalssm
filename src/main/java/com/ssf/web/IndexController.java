package com.ssf.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssf.model.Category;
import com.ssf.model.Product;
import com.ssf.service.CategoryService;
import com.ssf.service.ProductService;
import com.ssf.util.Globals;


/**
 * Created by wangyoyo on 17/5/7.
 */

@Controller
@RequestMapping("/")
public class IndexController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    private static final String VIEW_PATH = Globals.PREFIX_FRONTEND + "/";

    
    private void listDatas(Model model){
    	List<Category> lists = categoryService.findFirstCategorys();
        model.addAttribute("menuList", lists); 
        
        List<Product> productList = productService.listPage(0, 50);
        model.addAttribute("productList", productList); 
    }
    
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
          LOG.info("main index--------##");
          listDatas(model);
          return VIEW_PATH + "home";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){

        LOG.info("####test index----------2222");
        return VIEW_PATH + "test";
    }
//    //1.简化参数封装
//    @RequestMapping(value = "/v1", method = RequestMethod.GET)
//    public void v1(User user,PrintWriter pw,HttpServletRequest request){
//    	//return ""; 
//    	pw.write(user.toString());
//    	
//    	//User user2 = new User();
//    	//String idStr = request.getParameter("id");
//    	//user2.setId(id);
//    }
    
    /**
     * 测试Thymeleaf
     * @param path
     * @param model
     * @return
     */
    @RequestMapping(value = "/path/{path}", method = RequestMethod.GET)
    public String path(@PathVariable("path") String path, Model model) {
    	  LOG.info("invoke----------/path/"+path);
          
    	  listDatas(model);
          
          return VIEW_PATH + path;
    }
    



}
