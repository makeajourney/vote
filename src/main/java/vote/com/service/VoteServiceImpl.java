package vote.com.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import vote.com.dao.VoteDao;

@Service("voteService")
public class VoteServiceImpl implements VoteService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="voteDao")
	private VoteDao voteDao;
	
	
}
