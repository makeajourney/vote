package vote.com.service;

import javax.annotation.Resource;

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
	public boolean login(User user) {
		// TODO Auto-generated method stub
		User getUser = voteDao.selectUser(user);
		System.out.println(getUser.getId() + " " + getUser.getPassword());
		if (user.getPassword().equals(getUser.getPassword()))
			return true;
		else
			return false;
	}

}
