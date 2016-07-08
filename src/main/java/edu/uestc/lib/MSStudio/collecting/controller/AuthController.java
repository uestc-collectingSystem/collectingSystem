package edu.uestc.lib.MSStudio.collecting.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.uestc.lib.MSStudio.collecting.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(HttpServletRequest request,Model model){
		model.addAttribute("welcomeMsg","您好，请输入指定工号和密码");
		return "login";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(
			@RequestParam(value="name") String name,
			@RequestParam(value="password") String password,
			HttpServletRequest request,Model model
			){
		if (userService.UserInfoCheck(name, password)){
			
			return "index";
		}
		model.addAttribute("welcomeMsg","不好意思，您的验证信息有误");
		return "login";
	}
	
	@RequestMapping("/json")
	public @ResponseBody String json(){
		return "hello";
	}
	
	
	
}