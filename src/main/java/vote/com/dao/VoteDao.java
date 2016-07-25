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

	@SuppressWarnings("unchecked")
	public ArrayList<Article> getMyArticleList(int userNo) {
		// TODO Auto-generated method stub
		return (ArrayList<Article>) selectList("vote.selectListOfMyArticles", userNo);
	}
	
	public void updatehitcount(int articleNo) {
		update("vote.updateHitCount", articleNo);
	}

	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		insert("vote.insertOneArticle", article);
	}

	public int getArticleNo() {
		// TODO Auto-generated method stub
		return (int) selectOne("vote.getRecentArticleNo");
	}

	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		insert("vote.addComment", comment);
	}
}
