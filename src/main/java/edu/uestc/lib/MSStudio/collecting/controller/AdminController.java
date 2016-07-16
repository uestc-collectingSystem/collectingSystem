package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private UserService userService;
	
	private final String userListKey = "list";
	
	private final String userPageName = "user";
	
	private final String errorPageName = "error";
	
	@RequestMapping(method=RequestMethod.GET)
	private String index(HttpServletRequest request,Model model){
		model.addAttribute("welcomeMsg", "= =");
		return "login";
	}
	
	//展示用户，返回页面user
	@RequestMapping(value="user",method=RequestMethod.GET)
	public String userList(HttpServletRequest request,Model model){
		List<User> userList = userService.getUserList();
		model.addAttribute(userListKey, userList);
		return userPageName;
	}
	
	//创建用户，创建成功后返回 user 页面，创建失败返回错误信息
	@RequestMapping(value="user",method=RequestMethod.POST)
	public String createUser(
			@RequestParam String usercode,
			@RequestParam String password,
			@RequestParam String level,
			@RequestParam String schoolname,			
			HttpServletRequest request,Model model){
		User record = new User();
		record.setLevel(level);
		record.setPassword(password);
		record.setSchoolname(schoolname);
		record.setUsercode(usercode);
		if (userService.createUser(record)){
			
		}
		else{
			return errorPageName;
		}
		List<User> userList = userService.getUserList();
		model.addAttribute(userListKey, userList);
		return userPageName;
	}
	
	@ResponseBody
	@RequestMapping(value="user",method=RequestMethod.DELETE)
	public Object deleteUserByAjax(//这里函数的返回类型不能为String型，不然 json 格式中键值的双引号会被转义而无法被前端解析
			@RequestParam String id,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		if (userService.deleteUser(id)){
			List<User> userList = userService.getUserList();
			model.addAttribute(userListKey, userList);
			return JSON.toJSON(userList);
		}
		response.sendError(404,"can not find object");
		return null;
	}
	
	
	@ResponseBody
	@RequestMapping(value="user",method=RequestMethod.PATCH)
	public Object modifyUserByAjax(
			@RequestParam String id,
			@RequestParam(value="usercode",required=false) String usercode,
			@RequestParam(value="password",required=false) String password,
			@RequestParam(value="level",required=false) String level,
			@RequestParam(value="schoolname",required=false) String schoolname,
			HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
		User temp = userService.findUser(id);
		if(temp == null ){
			response.sendError(404,"can not find object");
			return null;
		}
		else{
			if (usercode != null) temp.setUsercode(usercode);
			if (password != null) temp.setUsercode(password);
			if (level != null) temp.setUsercode(level);
			if (schoolname != null) temp.setUsercode(schoolname);
			if (userService.updateUser(temp)){
				AjaxMessage result = new AjaxMessage();
				result.OK();
				result.setResult(temp);
				return result;
			}
		}
		return null;
	}
	
	
	
}
