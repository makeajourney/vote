package vote.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.SuggestLike;
import vote.com.vo.Tag;
import vote.com.vo.User;
import vote.com.vo.VoteElement;
import vote.com.vo.VoteFile;

public interface VoteService {

	ArrayList<Article> getArticleList();

	Article getArticleDetail(int articleNo);

	ArrayList<Comment> getComments(int articleNo);

	ArrayList<Article> getMyArticleList(int userNo);

	int addArticle(Article article, String voteElements, String tags, HttpServletRequest request) throws Exception;

	void addComment(Comment comment);

	void deleteArticle(User user, int articleNo);

	ArrayList<VoteElement> getVoteElements(int articleNo);

	void deleteComment(User user, int commentNo);

	List<VoteFile> getVoteFiles(int articleNo);

	int updateComment(User user, Comment comment);

	void addCommentVoteSuggestElement(Comment comment);

	List<Tag> getTagsForArticle(int articleNo);

	void updateLikeCount(SuggestLike suggestLike);

}
