package vote.com.service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import vote.com.dao.VoteDao;
import vote.com.vo.User;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="voteDao")
	private VoteDao voteDao;

	@Override
	public User login(User user, HttpServletResponse response) {
		// TODO Auto-generated method stub
		User getUser = voteDao.selectUser(user);
		System.out.println(getUser.getId() + " " + getUser.getPassword());
		
		if (user.getPassword().equals(getUser.getPassword())) {	
			return getUser;
		}
		else
			return null;
	}

	@Override
	public User signup(User user, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return voteDao.addUser(user);
	}
}
