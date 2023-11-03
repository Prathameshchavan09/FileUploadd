package springSearch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class interceptorController implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler , Model model)
			throws Exception {
	
		
		System.out.println("prehandler");
		
		String name = request.getParameter("userName");
		if(name.startsWith("d")) {
			
			System.out.println("Invalid");
			model.addAttribute("message" ,name);
			
		}
		
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandler");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("AfterHandler");
		
	
	}

	
	
	
}
