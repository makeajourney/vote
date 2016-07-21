package vote.com.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.util.CookieGenerator;

import vote.com.dao.VoteDao;
import vote.com.vo.User;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="voteDao")
	private VoteDao voteDao;

	@Override
	public boolean login(User user, HttpServletResponse response) {
		// TODO Auto-generated method stub
		User getUser = voteDao.selectUser(user);
		System.out.println(getUser.getId() + " " + getUser.getPassword());
		
		if (user.getPassword().equals(getUser.getPassword())) {
			this.addCookie(getUser, response);			
			return true;
		}
		else
			return false;
	}

	@Override
	public void signup(User user, HttpServletResponse response) {
		// TODO Auto-generated method stub
		User signupUser = voteDao.addUser(user);
		
		this.addCookie(signupUser, response);
	}
	
	private void addCookie(User user, HttpServletResponse response) {
		CookieGenerator cg = new CookieGenerator();
		
		cg.setCookieName("vote_username");
		cg.addCookie(response, user.getId());
	}
}
