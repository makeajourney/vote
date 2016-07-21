package vote.com.service;

import java.util.ArrayList;

import vote.com.vo.Article;

public interface VoteService {

	ArrayList<Article> getArticleList();

	Article getArticleDetail(int articleNo);

}
