package com.ssf.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssf.exception.BizException;
import com.ssf.model.User;
import com.ssf.service.UserService;
import com.ssf.util.Globals;

@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private static final String VIEW_PATH = Globals.PREFIX_FRONTEND + "/";//user/
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/list");
		offset = offset == null ? 0 : offset;//默认便宜0
		limit = limit == null ? 50 : limit;//默认展示50条
		List<User> list = userService.listPage(offset, limit);
		model.addAttribute("userlist", list);
		return VIEW_PATH + "userlist";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginUI(){
		return VIEW_PATH + "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model,@Valid User user, BindingResult result){
		//AOP验证参数
	      if (result.hasErrors()) {
	          String errorInfo = "[" + result.getFieldError().getField() + "]" + result.getFieldError().getDefaultMessage();
	          model.addAttribute("errorMsg",errorInfo);
	          return VIEW_PATH + "login";
	      }
		  try {
			  userService.login(user);
		  } catch (BizException e) {
			  model.addAttribute("errorMsg", e.getMessage());
			  return VIEW_PATH + "login";
		  }catch (Exception e) {
			 	LOG.error("用户登录发生错误", e);
			 	model.addAttribute("msg", "登录失败,系统发生问题");
	            return VIEW_PATH + "login";
	      }
		  
		  //登录成功
		  return VIEW_PATH + "login";
	}
}
