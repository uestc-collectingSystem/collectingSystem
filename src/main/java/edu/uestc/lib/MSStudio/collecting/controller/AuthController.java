package edu.uestc.lib.MSStudio.collecting.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import edu.uestc.lib.MSStudio.collecting.model.User;
import edu.uestc.lib.MSStudio.collecting.service.UserService;
import edu.uestc.lib.MSStudio.collecting.test.DaoTest;

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
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(
			@RequestParam(value="name") String name,
			@RequestParam(value="password") String password,
			@RequestParam(value="rememberme",required = false) String rememberMe,
			HttpServletRequest request,Model model,HttpServletResponse response
			){
		String userId = userService.UserInfoCheck(name, password);
		if (userId != null){
			/*
			  用户的权限级别方式为：录入人员<检查人员<管理员
			  因此录入人员权限为检查 Cookie 中的内容即可，检查人员为检查 Cookie 中人员等级大于2即可
			  管理员则是检查会话中的信息，也就是说超过会话期将失去权限
			  用户有不同登录级别，管理员登录后将登录信息保存在 Session 中，每次登录后重置Session 防止会话固定
			  将登录情况数据置入 Cookie 中以达到记住我效果，默认登录时长3600秒或3600*24秒
			  为了帮助管理员通过低层级的身份拦截，同样为其分配 Cookie，
			  但是管理员权限才能通过的部分还是要验证 session 信息
			*/
			if (userService.getUserLevel(Integer.valueOf(userId)).equals(User.ADMINISTER)){
				request.getSession().invalidate();
				request.getSession().setAttribute("UserID", userId);
			}
			
			if (rememberMe == null || rememberMe.equals("")){
				Cookie identity = new Cookie("UserID",userId);
				identity.setMaxAge(3600);//设定超时日期
				response.addCookie(identity);
			}
			else{
				Cookie identity = new Cookie("UserID",userId);
				identity.setMaxAge(3600*24);//设定超时日期
				response.addCookie(identity);
			}
			
			return "index";
		}
		model.addAttribute("welcomeMsg","不好意思，您的验证信息有误");		
		return "login";
	}
	
	@RequestMapping("/json")
	public @ResponseBody String json(HttpServletRequest request,Model model){
		request.setAttribute("userID", "h1?");
		String result = JSON.toJSON(userService.UserInfoCheck("20161", "111111")).toString();
		return result;
	}
}