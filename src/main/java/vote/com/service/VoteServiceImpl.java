package vote.com.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import vote.com.dao.VoteDao;
import vote.com.vo.Article;

@Service("voteService")
public class VoteServiceImpl implements VoteService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="voteDao")
	private VoteDao voteDao;

	@Override
	public ArrayList<Article> getArticleList() {
		// TODO Auto-generated method stub
		return voteDao.getArticleList();
	}

	@Override
	public Article getArticleDetail(int articleNo) {
		// TODO Auto-generated method stub
		return voteDao.getArticleDetail(articleNo);
	}
	
	
}
