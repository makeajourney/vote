package vote.com.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import vote.com.dao.VoteDao;
import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.User;

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
		voteDao.updatehitcount(articleNo);
		return voteDao.getArticleDetail(articleNo);
	}

	@Override
	public ArrayList<Comment> getComments(int articleNo) {
		// TODO Auto-generated method stub
		return voteDao.getCommentsForArticle(articleNo);
	}

	@Override
	public ArrayList<Article> getMyArticleList(int userNo) {
		// TODO Auto-generated method stub
		return voteDao.getMyArticleList(userNo);
	}

	@Override
	public int addArticle(Article article) {
		// TODO Auto-generated method stub
		voteDao.addArticle(article);
		
		return voteDao.getArticleNo();
	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		voteDao.addComment(comment);
	}

	@Override
	public void deleteArticle(User user, int articleNo) {
		// TODO Auto-generated method stub
		int getUserNo = voteDao.getWriter(articleNo);
		if (getUserNo == user.getNo())
			voteDao.deleteArticle(articleNo);
	}

}
