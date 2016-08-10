package edu.uestc.lib.MSStudio.collecting.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import edu.uestc.lib.MSStudio.collecting.dao.InformantMapper;
import edu.uestc.lib.MSStudio.collecting.model.Equipment;
import edu.uestc.lib.MSStudio.collecting.model.Informant;
import edu.uestc.lib.MSStudio.collecting.model.User;
import edu.uestc.lib.MSStudio.collecting.service.InformantService;
import edu.uestc.lib.MSStudio.collecting.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private UserService userService;

	@Resource
	private InformantMapper dao;
	
	private static final String listForAdms = "admList";
	
	private static final String listForInformants = "informantList";
	
	private static final String informantForSingle = "li";
	
	private static final String userListKey = "list";

	private static final String userListPage = "auth/user";
	
	private static final String userInfoPage = "auth/me";
	
	private static final String userAccountPage = "auth/account";
	
	private final int pageSize=10;

	@RequestMapping("user")
	public String userList(HttpServletRequest request,Model model,HttpServletResponse response){
		return userList(1,request,model,response);
	}
	
	// 展示用户，返回页面user
	@RequestMapping("user/{pageNum}")
	public String userList(@PathVariable int pageNum,HttpServletRequest request, Model model, HttpServletResponse response) {
		Integer id = Integer.valueOf(request.getAttribute(AuthController.attriKey).toString());
		List<User> userList = userService.getUserList();
		
		model.addAttribute("firstMenu", "用户管理");
		model.addAttribute("subMenu", "个人信息");
		
		if (userService.getUserLevel(id).equals(User.ADMINISTER)){
			model.addAttribute(userListKey, userList);
			model.addAttribute(listForInformants, dao.getAllObject(pageSize*(pageNum-1), pageSize*pageNum));
			return userListPage;
		}
		else{
			Informant temp = dao.selectByPrimaryKey(id);
			model.addAttribute(informantForSingle,temp);
			return userInfoPage;
		}
		
	}

	//修改用户个人信息，只能修改自己的
	@RequestMapping(value="input")
	public String inputPage(HttpServletRequest request){
		String requestDict = request.getRequestURI();
		String[] targets = requestDict.split("/");
		return "inputs/"+targets[targets.length-2];
	}
	
	@RequestMapping("create")
	@ResponseBody
	public String createUser(@ModelAttribute("createTable") User record,HttpServletResponse response) throws IOException{
//		return JSON.toJSON(sizeService.update(test));
		try{
			userService.createUser(record);
		}catch(Exception e){
			return e.getMessage();
		}
		return "Create Success";
	}
	
	@RequestMapping("update")
	public void updateInformant(@ModelAttribute("createTable") Informant record,HttpServletResponse response) throws IOException{
//		return JSON.toJSON(sizeService.update(test));
		try{
			dao.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			e.printStackTrace();
			response.sendError(400, "error parameters");
			return ;
		}
		response.sendRedirect("./user");
	}
	
	// //创建用户，创建成功后返回 user 页面，创建失败返回错误信息
	// @RequestMapping(value="user/create",method=RequestMethod.POST)
	// public String createUser(
	// @RequestParam String usercode,
	// @RequestParam String password,
	// @RequestParam String level,
	// @RequestParam String schoolname,
	// HttpServletRequest request,Model model){
	// User record = new User();
	// record.setLevel(level);
	// record.setPassword(password);
	// record.setSchoolname(schoolname);
	// record.setUsercode(usercode);
	// if (userService.createUser(record)){
	//
	// }
	// else{
	// return errorPageName;
	// }
	// List<User> userList = userService.getUserList();
	// model.addAttribute(userListKey, userList);
	// return userPageName;
	// }
	//
	// @ResponseBody
	// @RequestMapping("user/create/{id}")
	// public String deleteUser(//这里函数的返回类型不能为String型，不然 json
	// 格式中键值的双引号会被转义而无法被前端解析
	// @PathVariable String id,
	// HttpServletRequest request,Model model,HttpServletResponse response)
	// throws IOException{
	// if (userService.deleteUser(id)){
	// return userPage;
	// }
	// }
	//
	//
	// @ResponseBody
	// @RequestMapping("user/update")
	// public Object modifyUserByAjax(
	// @RequestParam String id,
	// @RequestParam(value="usercode",required=false) String usercode,
	// @RequestParam(value="password",required=false) String password,
	// @RequestParam(value="level",required=false) String level,
	// @RequestParam(value="schoolname",required=false) String schoolname,
	// HttpServletRequest request,Model model,HttpServletResponse response)
	// throws IOException{
	// User temp = userService.findUser(id);
	// if(temp == null ){
	// response.sendError(404,"can not find object");
	// return null;
	// }
	// else{
	// if (usercode != null) temp.setUsercode(usercode);
	// if (password != null) temp.setUsercode(password);
	// if (level != null) temp.setUsercode(level);
	// if (schoolname != null) temp.setUsercode(schoolname);
	// if (userService.updateUser(temp)){
	// AjaxMessage result = new AjaxMessage();
	// result.OK();
	// result.setResult(temp);
	// return result;
	// }
	// }
	// return null;
	// }
	//

}
