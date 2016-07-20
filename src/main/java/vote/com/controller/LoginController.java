package vote.com.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vote.com.service.LoginService;

@Controller
public class LoginController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping(value = "/login.do")
	public String openLogin() {
		System.out.println("openLogin()");
		return "login";
	}	
}