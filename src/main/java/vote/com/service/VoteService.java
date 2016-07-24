package vote.com.service;

import java.util.ArrayList;

import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.User;

public interface VoteService {

	ArrayList<Article> getArticleList();

	Article getArticleDetail(int articleNo);

	ArrayList<Comment> getComments(int articleNo);

	ArrayList<Article> getMyArticleList(int userNo);

}
