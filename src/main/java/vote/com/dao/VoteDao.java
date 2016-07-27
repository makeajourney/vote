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
		return (User) selectOne("vote.selectUser", user);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Article> getArticleList() {
		return (ArrayList<Article>) selectList("vote.selectListOfArticles");
	}

	public User addUser(User user) {
		insert("vote.insertCommonUser", user);
		return (User) selectOne("vote.selectUser", user);
	}

	public Article getArticleDetail(int articleNo) {
		return (Article) selectOne("vote.selectOneArticle", articleNo);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Comment> getCommentsForArticle(int articleNo) {
		return (ArrayList<Comment>) selectList("vote.selectCommentsForArticle", articleNo);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Article> getMyArticleList(int userNo) {
		return (ArrayList<Article>) selectList("vote.selectListOfMyArticles", userNo);
	}
	
	public void updatehitcount(int articleNo) {
		update("vote.updateHitCount", articleNo);
	}

	public void addArticle(Article article) {
		insert("vote.insertOneArticle", article);
	}

	public int getLatestArticleNo() {
		return (int) selectOne("vote.getLatestArticleNo");
	}

	public void addComment(Comment comment) {
		insert("vote.addComment", comment);
	}

	public int getWriter(int articleNo) {
		return (int) selectOne("vote.getWriter", articleNo);
	}

	public void deleteArticle(int articleNo) {
		update("vote.deleteOneArticle", articleNo);
	}

	public void addVoteElement(VoteElement voteElement) {
		insert("vote.insertVoteElement", voteElement);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<VoteElement> getVoteElement(int articleNo) {
		return (ArrayList<VoteElement>) selectList("vote.selectVoteElementsByArticle", articleNo);
	}

	public int getUserNoToComment(int commentNo) {
		return (int) selectOne("vote.selectUserNoToSingleComment", commentNo);
	}

	public void deleteComment(int commentNo) {
		update("vote.deleteComment", commentNo);
	}

	public void insertFile(VoteFile voteFile) {
		insert("vote.insertFile", voteFile);
	}
	
	@SuppressWarnings("unchecked")
	public List<VoteFile> selectFileList(int articleNo) {
		return selectList("vote.selectFileList", articleNo);
	}

	public void updateComment(Comment comment) {
		update("vote.updateComment", comment);
	}

	public int getArticleNoFromComment(int commentNo) {
		// TODO Auto-generated method stub
		return (int) selectOne("vote.selectAriticleNoFrom", commentNo);
	}

	public void addSuggestElement(Comment comment) {
		// TODO Auto-generated method stub
		insert("vote.insertSuggestElement", comment);
	}

	public int getLatestCommentNo() {
		// TODO Auto-generated method stub
		return (int) selectOne("selectLatestCommentNo");
	}
}
