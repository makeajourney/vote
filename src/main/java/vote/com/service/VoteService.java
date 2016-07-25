package vote.com.service;

import java.util.ArrayList;

import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.User;
import vote.com.vo.VoteElement;

public interface VoteService {

	ArrayList<Article> getArticleList();

	Article getArticleDetail(int articleNo);

	ArrayList<Comment> getComments(int articleNo);

	ArrayList<Article> getMyArticleList(int userNo);

	int addArticle(Article article);

	void addComment(Comment comment);

	void deleteArticle(User user, int articleNo);

	void addVoteElement(String voteElements);

	ArrayList<VoteElement> getVoteElements(int articleNo);

}
