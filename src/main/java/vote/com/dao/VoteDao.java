package vote.com.dao;

import org.springframework.stereotype.Repository;

import vote.com.vo.User;
import vote.common.dao.AbstractDAO;

@Repository
public class VoteDao extends AbstractDAO{

	public User selectUser(User user) {
		// TODO Auto-generated method stub
		return (User)selectOne("vote.selectUser", user);
	}

}
