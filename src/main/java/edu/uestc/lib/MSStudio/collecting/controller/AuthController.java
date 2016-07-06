package edu.uestc.lib.MSStudio.collecting.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.uestc.lib.MSStudio.collecting.dao.AuditSchoolMapper;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Resource
	private AuditSchoolMapper dao;
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model){
		String username = request.getParameter("name");
		model.addAttribute("name",username);
		return "login";
	}
}
