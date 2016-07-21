package vote.com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.User;
import vote.common.dao.AbstractDAO;

@Repository
public class VoteDao extends AbstractDAO{

	public User selectUser(User user) {
		// TODO Auto-generated method stub
		return (User) selectOne("vote.selectUser", user);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Article> getArticleList() {
		// TODO Auto-generated method stub
		return (ArrayList<Article>) selectList("vote.selectListOfArticles");
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		insert("vote.insertCommonUser", user);
		return (User) selectOne("vote.selectUser", user);
	}

	public Article getArticleDetail(int articleNo) {
		// TODO Auto-generated method stub
		return (Article) selectOne("vote.selectOneArticle", articleNo);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Comment> getCommentsForArticle(int articleNo) {
		// TODO Auto-generated method stub
		return (ArrayList<Comment>) selectList("vote.selectCommentsForArticle", articleNo);
	}
}
