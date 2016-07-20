package vote.com.service;

import javax.servlet.http.HttpServletResponse;

import vote.com.vo.User;

public interface LoginService {

	boolean login(User user, HttpServletResponse response);

}
