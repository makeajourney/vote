package vote.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import vote.com.dao.VoteDao;
import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.SuggestLike;
import vote.com.vo.Tag;
import vote.com.vo.User;
import vote.com.vo.VoteElement;
import vote.com.vo.VoteFile;
import vote.common.util.FileUtils;

@Service("voteService")
public class VoteServiceImpl implements VoteService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Resource(name="voteDao")
	private VoteDao voteDao;

	/* article */
	
	@Override
	public ArrayList<Article> getArticleList() {
		return voteDao.getArticleList();
	}

	@Override
	public Article getArticleDetail(int articleNo) {
		voteDao.updatehitcount(articleNo);
		
		return voteDao.getArticleDetail(articleNo);
	}

	@Override
	public ArrayList<Article> getMyArticleList(int userNo) {
		return voteDao.getMyArticleList(userNo);
	}

	@Override
	public int addArticle(Article article, String voteElements, String tags, HttpServletRequest request) throws Exception {
		voteDao.addArticle(article);
		int articleNo = voteDao.getLatestArticleNo();
		this.addVoteElement(articleNo, voteElements);
		
		// 파일추가 
		List<VoteFile> list = fileUtils.parseInsertFileInfo(articleNo, request);
		for (int i = 0, size = list.size(); i < size; i ++) {
			voteDao.insertFile(list.get(i));
		}
		// 태그추가 
		tags.replace(" ", "");
		StringTokenizer st = new StringTokenizer(tags, ",");
		
		while(st.hasMoreTokens()) {
//			VoteElement voteElement = new VoteElement()
//			.setArticleNo(articleNo)
//			.setContent(st.nextToken())
//			.setNo(count);
//			voteDao.addVoteElement(voteElement);
//			count ++;
			Tag tag = new Tag().setArticleNo(articleNo).setTag(st.nextToken());
			voteDao.addTag(tag);
		}
		
		// 글 번호 반환 
		return articleNo;
	}
	
	@Override
	public void deleteArticle(User user, int articleNo) {
		int getUserNo = voteDao.getWriter(articleNo);
		if (getUserNo == user.getNo())
			voteDao.deleteArticle(articleNo);
	}

	/* comment */
	
	@Override
	public ArrayList<Comment> getComments(int articleNo) {
		return voteDao.getCommentsForArticle(articleNo);
	}
	@Override
	public void addComment(Comment comment) {
		voteDao.addComment(comment);
	}

	@Override
	public void deleteComment(User user, int commentNo) {
		if (user.getNo() == voteDao.getUserNoToComment(commentNo)) {
			voteDao.deleteComment(commentNo);
		}
	}

	@Override
	public int updateComment(User user, Comment comment) {
		if (user.getNo() == voteDao.getUserNoToComment(comment.getNo())) {
			voteDao.updateComment(comment);
		}
		return voteDao.getArticleNoFromComment(comment.getNo());
	}
	
	/* vote suggest */
	
	
	
	/* voteElement */
	
	@Override
	public ArrayList<VoteElement> getVoteElements(int articleNo) {
		return voteDao.getVoteElement(articleNo);
	}

	private void addVoteElement(int articleNo, String voteElements) {
		StringTokenizer st = new StringTokenizer(voteElements, ",");
		int count = 1;
		
		while(st.hasMoreTokens()) {
			VoteElement voteElement = new VoteElement()
			.setArticleNo(articleNo)
			.setContent(st.nextToken())
			.setNo(count);
			voteDao.addVoteElement(voteElement);
			count ++;
		}
	}

	@Override
	public List<VoteFile> getVoteFiles(int articleNo) {
		return voteDao.selectFileList(articleNo);
	}

	@Override
	public void addCommentVoteSuggestElement(Comment comment) {
		voteDao.addComment(comment);
		comment.setNo(voteDao.getLatestCommentNo());
		voteDao.addSuggestElement(comment);
	}

	@Override
	public List<Tag> getTagsForArticle(int articleNo) {
		return voteDao.getTagsForArticle(articleNo);
	}

	@Override
	public void updateLikeCount(SuggestLike suggestLike) {
		voteDao.insertSuggestLike(suggestLike);
	}

}
