package edu.uestc.lib.MSStudio.collecting.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uestc.lib.MSStudio.collecting.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(HttpServletRequest request,Model model){
		model.addAttribute("name",userService.UserInfoCheck());
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(
			@RequestParam(value="name") String name,
			@RequestParam(value="password") String password,
			HttpServletRequest request,Model model
			){
		
		return "login";
	}
	
}