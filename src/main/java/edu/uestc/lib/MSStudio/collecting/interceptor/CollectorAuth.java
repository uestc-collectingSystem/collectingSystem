package edu.uestc.lib.MSStudio.collecting.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.uestc.lib.MSStudio.collecting.controller.AuthController;

public class CollectorAuth implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO 请求控制器之前需要做的事情，返回值决定是否有后续拦截器的同时，也直接决定了整个调用链的终点
		Cookie[] cookieList = request.getCookies();
		//遍历所有 Cookie，如果存在名字为 UserID 的值，重置，如果遍历之后没有，返回403错误
		//收集者权限最低，只要有一个验证权限即可
		for(Cookie temp : cookieList){
			if (temp.getName().equals(AuthController.cookieKey)){
				String userID = temp.getValue();
				response.addCookie(temp);
				request.removeAttribute(AuthController.cookieKey);
				request.setAttribute(AuthController.cookieKey, userID);
				return true;
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