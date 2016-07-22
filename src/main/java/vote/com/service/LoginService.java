package vote.com.service;

import javax.servlet.http.HttpServletResponse;

import vote.com.vo.User;

public interface LoginService {

	User login(User user, HttpServletResponse response);

	User signup(User user, HttpServletResponse response);

}
