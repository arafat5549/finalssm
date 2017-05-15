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

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private static final String VIEW_PATH = Globals.PREFIX_FRONTEND + "/"; // + "/category/";
    
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    
    
    /**
     * 某个分类底下的所有商品列表
     * id为分类iD
     */
    
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable("id")Long cid) {
        LOG.info("invoke----------/category/list");
        
        List<Category> lists = categoryService.findFirstCategorys();
        model.addAttribute("menuList", lists);
        
        List<Product> productList =productService.listPageByCategoryId(cid);
        model.addAttribute("productList", productList);
        
        return VIEW_PATH+"product-list";
    }
    
    

}
