//package edu.uestc.lib.MSStudio.collecting.test;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import edu.uestc.lib.MSStudio.collecting.dao.AuditSchoolMapper;
//
///**
// * Maven 中test 包是不会部署到 war 中的，所以如果要放置在服务器上运行，需要将此测试类放置到 src/main/java 中 * 
// * */
//@Controller
//@RequestMapping("/test/auth")
//public class ControllerTest {
//
//	@Resource
//	private AuditSchoolMapper dao;
//	@RequestMapping("/login")
//	public String login(HttpServletRequest request,Model model){
//		String username = request.getParameter("name");
//		model.addAttribute("name",username);
//		return "login";
//	}
//}
