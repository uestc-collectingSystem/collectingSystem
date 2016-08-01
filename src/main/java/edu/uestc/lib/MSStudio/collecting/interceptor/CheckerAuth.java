package edu.uestc.lib.MSStudio.collecting.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.uestc.lib.MSStudio.collecting.controller.AuthController;
import edu.uestc.lib.MSStudio.collecting.model.User;
import edu.uestc.lib.MSStudio.collecting.service.UserService;

public class CheckerAuth implements HandlerInterceptor {
	
	@Resource
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		Cookie[] cookieList = request.getCookies();
		//遍历所有 Cookie，如果存在名字为 UserID 的值，重置，如果遍历之后没有，返回403，并通告用户需要登录
		//检查者要略高一些，需要验证 UserID 后继续获取该用户的用户等级，只要有一个验证权限即可
		if (cookieList!=null){
			for(Cookie temp : cookieList){
				if (temp.getName().equals(AuthController.attriKey)){
					String userID = temp.getValue();
					response.addCookie(temp);
					request.removeAttribute(AuthController.attriKey);
					request.setAttribute(AuthController.attriKey, userID);
					if (!userService.getUserLevel(Integer.valueOf(userID)).equals(User.COLLECTOR)){
						return true;
					}
					else{
						response.sendError(403,"Have No Enough Right");
						return false;
					}
				}
			}
		}
		response.sendError(403, "No Log in Trace");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 在控制器处理完毕之后做的收尾工作，比如对象处理
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO 额。。。就是用来处理链式拦截器调用的资源释放问题，发生在 Controller 处理完之后
	}
}
