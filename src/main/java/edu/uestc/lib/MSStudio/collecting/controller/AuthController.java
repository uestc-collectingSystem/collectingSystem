package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import edu.uestc.lib.MSStudio.collecting.model.User;
import edu.uestc.lib.MSStudio.collecting.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	public final static String attriKey = "UserID";

	public final static String typeKey = "UserType";
	
	@Resource
	private UserService userService;
	
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
	public String index(HttpServletRequest request,Model model,HttpServletResponse response){
		if (request.getRequestURL().reverse().charAt(0)!='/'){
			try {
				response.sendRedirect(request.getRequestURL().append('/').toString());
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("welcomeMsg","您好，请输入指定工号和密码");
		return "login";
	}
	
	@RequestMapping("/loggout")
	public void loggout(HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		Cookie[] currentCookies = request.getCookies();
		for(Cookie temp : currentCookies){
			if (temp.getName().equals(AuthController.attriKey)){
				temp.setMaxAge(0);
				response.addCookie(temp);
			}
		}
		response.sendRedirect("../");
		model.addAttribute("welcomeMsg","您好，请输入指定工号和密码");
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(
			@RequestParam(value="name") String name,
			@RequestParam(value="password") String password,
			@RequestParam(value="rememberme",required = false) String rememberMe,
			HttpServletRequest request,Model model,HttpServletResponse response
			){
		int userId = userService.UserInfoCheck(name, password);
		if (userId != 0){
			/*
			  用户的权限级别方式为：录入人员<检查人员<管理员
			  因此录入人员权限为检查 Cookie 中的内容即可，检查人员为检查 Cookie 中人员等级大于2即可
			  管理员则是检查会话中的信息，也就是说超过会话期将失去权限
			  用户有不同登录级别，管理员登录后将登录信息保存在 Session 中，每次登录后重置Session 防止会话固定
			  将登录情况数据置入 Cookie 中以达到记住我效果，默认登录时长3600秒或3600*24秒
			  为了帮助管理员通过低层级的身份拦截，同样为其分配 Cookie，
			  但是管理员权限才能通过的部分还是要验证 session 信息
			*/
			//System.out.print(Integer.valueOf(userId));
			request.getSession(true).invalidate();
			if (userService.getUserLevel(userId).equals(User.ADMINISTER)){
				//request.getSession().invalidate();
				request.getSession().setAttribute(AuthController.attriKey, userId);
			}
			
			if (rememberMe == null || rememberMe.equals("")){
				Cookie identity = new Cookie(AuthController.attriKey,String.valueOf(userId));
				identity.setMaxAge(3600);//设定超时日期
				response.addCookie(identity);
			}
			else{
				Cookie identity = new Cookie(AuthController.attriKey,String.valueOf(userId));
				identity.setMaxAge(3600*24);//设定超时日期
				response.addCookie(identity);
			}
			
			return "index";
		}
		model.addAttribute("welcomeMsg","不好意思，您的验证信息有误");		
		return "login";
	}
	
	@RequestMapping("/collectorAuth")
	public @ResponseBody String collectorAuth(HttpServletRequest request,Model model){
		request.setAttribute("userID", "h1?");
		String result = JSON.toJSON(userService.UserInfoCheck("20161", "111111")).toString();
		return result;
	}
	
	@RequestMapping("/checkerAuth")
	public @ResponseBody String checkerAuth(HttpServletRequest request,Model model){
		request.setAttribute("userID", "h1?");
		String result = JSON.toJSON(userService.UserInfoCheck("20161", "111111")).toString();
		return result;
	}
	
	@RequestMapping("/adminAuth")
	public @ResponseBody String adminAuth(HttpServletRequest request,Model model){
		request.setAttribute("userID", "h1?");
		String result = JSON.toJSON(userService.UserInfoCheck("20161", "111111")).toString();
		return result;
	}
	
	@RequestMapping("/current")
	public @ResponseBody String currentUser(HttpServletRequest request,Model model){
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(AuthController.attriKey) == null){
			Cookie[] cookieList = request.getCookies();
			for(Cookie temp : cookieList){
				if (temp.getName().equals(AuthController.attriKey)) {
					User curr = userService.findUser(temp.getValue());
					String UserLevel=null;
					switch (curr.getLevel()) {
						case User.ADMINISTER : UserLevel = "管理员";break;
						case User.CHECHKER : UserLevel = "检查员";break;
						case User.COLLECTOR : UserLevel = "录入员";break;
					}
					return UserLevel+" 学校名:"+curr.getSchoolname() +" 学校编号:"+curr.getUsercode();
				}
			}//遍历无果
			return "You Need To Login";
		}
		else {
			try {
				User curr = userService.findUser(session.getAttribute(AuthController.attriKey).toString());
				String UserLevel=null;
				switch (curr.getLevel()) {
					case User.ADMINISTER : UserLevel = "管理员";break;
					case User.CHECHKER : UserLevel = "检查员";break;
					case User.COLLECTOR : UserLevel = "录入员";break;
				}
				return UserLevel+" 学校名:"+curr.getSchoolname() +" 学校编号:"+curr.getUsercode();
			}catch(Exception e){
				return "You Need To Login";
			}
		}//处理 Session
	}
}