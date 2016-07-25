package vote.com.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.User;
import vote.com.vo.VoteElement;

public interface VoteService {

	ArrayList<Article> getArticleList();

	Article getArticleDetail(int articleNo);

	ArrayList<Comment> getComments(int articleNo);

	ArrayList<Article> getMyArticleList(int userNo);

	int addArticle(Article article, String voteElements, HttpServletRequest request) throws Exception;

	void addComment(Comment comment);

	void deleteArticle(User user, int articleNo);

	ArrayList<VoteElement> getVoteElements(int articleNo);

	void deleteComment(User user, int commentNo);

}
