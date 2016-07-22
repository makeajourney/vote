package vote.com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vote.com.service.LoginService;
import vote.com.vo.User;

@Controller
public class LoginController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView openLoginPage() {
		
		System.out.println("openLogin()");
		return new ModelAndView("/login");
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(
			@RequestParam("id") String id, @RequestParam("password") String password,
			HttpSession session, HttpServletResponse response) {
		
		User user = loginService.login(new User().setId(id).setPassword(password), response);
		if (user != null) {
			session.setAttribute("user", user);
			return new ModelAndView("redirect:/main.do");
		} else {
			return null;			
		}
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public ModelAndView signup(
			@RequestParam("id") String id,
			@RequestParam("password") String password, @RequestParam("name") String name,
			HttpSession session, HttpServletResponse response) {
		
		User user = loginService.signup(new User().setId(id).setPassword(password).setName(name), response);
		session.setAttribute("user", user);
		return new ModelAndView("redirect:/main.do");
	}
	
	@RequestMapping(value="/logout.do")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/login.do");
	}
}