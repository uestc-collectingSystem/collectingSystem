package edu.uestc.lib.MSStudio.collecting.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.uestc.lib.MSStudio.collecting.controller.AuthController;
import edu.uestc.lib.MSStudio.collecting.model.User;
import edu.uestc.lib.MSStudio.collecting.service.UserService;

public class AdminAuth implements HandlerInterceptor {

	@Resource
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO 验证 Session 中是否带有需要验证的信息，如果没有 Session 信息，返回403错误,验证当前 Session
		// 中的信息
		HttpSession temp = request.getSession(false);
		if (temp == null || temp.getAttribute(AuthController.sessionKey) == null) {
			response.sendError(403, "No Session Data");
			return false;
		}
		String userId = temp.getAttribute(AuthController.sessionKey).toString();
		if (userService.getUserLevel(Integer.valueOf(userId)).equals(User.ADMINISTER)) {
			System.out.println(userService.getUserLevel(Integer.valueOf(userId)));
			request.getSession().invalidate();
			request.getSession().setAttribute(AuthController.sessionKey, userId);
			//记得要把这个 Session 控制写到任何响应报文控制的后面
			return true;
		} else {
			response.sendError(403,"No Enough Right");
			return false;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
