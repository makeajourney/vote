package vote.com.service;

import java.util.ArrayList;

import vote.com.vo.Article;
import vote.com.vo.Comment;

public interface VoteService {

	ArrayList<Article> getArticleList();

	Article getArticleDetail(int articleNo);

	ArrayList<Comment> getComments(int articleNo);

	ArrayList<Article> getMyArticleList(int userNo);

	int addArticle(Article article);

	void addComment(Comment comment);

}
