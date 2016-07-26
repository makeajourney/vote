package vote.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.User;
import vote.com.vo.VoteElement;
import vote.com.vo.VoteFile;
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

	public int getLatestArticleNo() {
		// TODO Auto-generated method stub
		return (int) selectOne("vote.getLatestArticleNo");
	}

	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		insert("vote.addComment", comment);
	}

	public int getWriter(int articleNo) {
		// TODO Auto-generated method stub
		return (int) selectOne("vote.getWriter", articleNo);
	}

	public void deleteArticle(int articleNo) {
		// TODO Auto-generated method stub
		update("vote.deleteOneArticle", articleNo);
	}

	public void addVoteElement(VoteElement voteElement) {
		// TODO Auto-generated method stub
		insert("vote.insertVoteElement", voteElement);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<VoteElement> getVoteElement(int articleNo) {
		// TODO Auto-generated method stub
		return (ArrayList<VoteElement>) selectList("vote.selectVoteElementsByArticle", articleNo);
	}

	public int getUserNoToComment(int commentNo) {
		// TODO Auto-generated method stub
		return (int) selectOne("vote.selectUserNoToSingleComment", commentNo);
	}

	public void deleteComment(int commentNo) {
		// TODO Auto-generated method stub
		update("vote.deleteComment", commentNo);
	}

	public void insertFile(VoteFile voteFile) {
		// TODO Auto-generated method stub
		insert("vote.insertFile", voteFile);
	}
	
	@SuppressWarnings("unchecked")
	public List<VoteFile> selectFileList(int articleNo) {
		return selectList("vote.selectFileList", articleNo);
	}
}
