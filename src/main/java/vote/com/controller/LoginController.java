package vote.com.controller;

import javax.annotation.Resource;

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
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("password") String password) {
		if (loginService.login(new User().setId(id).setPassword(password))) {
//			CookieGenerator cg = new CookieGenerator();
//
//			cg.setCookieName("cookie_value_test");
//			cg.addCookie(response, "vote");
			return new ModelAndView("redirect:/main.do");
		} else {
			return null;			
		}
	}
	
	@RequestMapping(value="/main.do")
	public ModelAndView mainPage() {
		return new ModelAndView("/main");
	}
}