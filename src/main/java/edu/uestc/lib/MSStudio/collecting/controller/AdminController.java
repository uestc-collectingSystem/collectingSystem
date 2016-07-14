package edu.uestc.lib.MSStudio.collecting.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class AdminController {
	@RequestMapping(method=RequestMethod.GET)
	public String index(HttpServletRequest request,Model model){
		model.addAttribute("welcomeMsg", "= =");
		return "login";
	}
}
