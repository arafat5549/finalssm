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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssf.dto.BaseResult;
import com.ssf.dto.BootStrapTableResult;
import com.ssf.exception.BizException;
import com.ssf.model.Category;
import com.ssf.model.Product;
import com.ssf.service.CategoryService;
import com.ssf.service.ProductService;
import com.ssf.util.Globals;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    private static final String VIEW_PATH = Globals.PREFIX_FRONTEND + "/product/";
    
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    /**
     * 商品列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, Integer offset, Integer limit) {
        LOG.info("invoke----------/product/list");
        offset = offset == null ? 0 : offset;
        limit = limit == null ? 50 : limit;
        List<Product> list = productService.listPage(offset, limit);
        model.addAttribute("productList", list);
        return VIEW_PATH+"productList";
    }
    
    /**
     * 商品详细信息
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model,@PathVariable("id") Integer id) {
        LOG.info("invoke----------/detail/{id}"+id);
        Product p = productService.findById(id);
        model.addAttribute("product", p);
        
        List<Product> relateProducts = productService.listRelatedProducts(p);
        model.addAttribute("relateProducts", relateProducts);
        
        List<Category> parentCategorys = categoryService.findParentCategorysByPid(id);
        model.addAttribute("parentCategorys", parentCategorys);
        
        return VIEW_PATH+"productDetail";
    }
    
    /**
     * -----------------------------------AJAX区域----------------------------------
     */
    @RequestMapping(value = "/ajax/{id}",method=RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> ajax(@PathVariable("id") Integer id)
    {
    	LOG.info("invoke----------Product/ajax/id="+id);
    	
    	Product p = null;
		try {
			p = productService.findById(id);
		} catch (BizException e) {
			return new BaseResult<Object>(false, e.getMessage());
		}
    	return new BaseResult<Object>(true, p);
    }
    
    @RequestMapping(value = "/ajax/list",method=RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BootStrapTableResult<Product> ajaxList()
    {
    	LOG.info("invoke----------Product/ajax/list");
    	
//    	List<Product> data = null;
//		try {
//			data = productService.listPage(0, 50);
//		} catch (BizException e) {
//			return new BaseResult<Object>(false, e.getMessage());
//		}
//    	return new BaseResult<Object>(true, data);
    	
    	List<Product> list = productService.listPage(0, 50);
    	return new BootStrapTableResult<Product>(list);
    }
    
//
//    @RequestMapping(value = "/{goodsId}/buy", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public BaseResult<Object> buy(@CookieValue(value = "userPhone", required = false) Long userPhone,
//        /*@PathVariable("goodsId") Long goodsId*/ @Valid Goods goods, BindingResult result) {
//        LOG.info("invoke----------/" + goods.getGoodsId() + "/buy userPhone:" + userPhone);
//        if (userPhone == null) {
//            return new BaseResult<Object>(false, ResultEnum.INVALID_USER.getMsg());
//        }
//        //Valid 参数验证(这里注释掉，采用AOP的方式验证,见BindingResultAop.java)
//        //if (result.hasErrors()) {
//        //    String errorInfo = "[" + result.getFieldError().getField() + "]" + result.getFieldError().getDefaultMessage();
//        //    return new BaseResult<Object>(false, errorInfo);
//        //}
//        try {
//            goodsService.buyGoods(userPhone, goods.getGoodsId(), false);
//        } catch (BizException e) {
//            return new BaseResult<Object>(false, e.getMessage());
//        } catch (Exception e) {
//            return new BaseResult<Object>(false, ResultEnum.INNER_ERROR.getMsg());
//        }
//        return new BaseResult<Object>(true, null);
//    }
}
