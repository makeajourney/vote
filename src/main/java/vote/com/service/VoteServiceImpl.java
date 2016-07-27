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
	public ArrayList<Comment> getComments(int articleNo) {
		return voteDao.getCommentsForArticle(articleNo);
	}

	@Override
	public ArrayList<Article> getMyArticleList(int userNo) {
		return voteDao.getMyArticleList(userNo);
	}

	@Override
	public int addArticle(Article article, String voteElements, HttpServletRequest request) throws Exception {
		voteDao.addArticle(article);
		int articleNo = voteDao.getLatestArticleNo();
		this.addVoteElement(articleNo, voteElements);
		
		List<VoteFile> list = fileUtils.parseInsertFileInfo(articleNo, request);
		for (int i = 0, size = list.size(); i < size; i ++) {
			voteDao.insertFile(list.get(i));
		}
		
		return voteDao.getLatestArticleNo();
	}

	@Override
	public void addComment(Comment comment) {
		voteDao.addComment(comment);
	}

	@Override
	public void deleteArticle(User user, int articleNo) {
		int getUserNo = voteDao.getWriter(articleNo);
		if (getUserNo == user.getNo())
			voteDao.deleteArticle(articleNo);
	}


	@Override
	public ArrayList<VoteElement> getVoteElements(int articleNo) {
		return voteDao.getVoteElement(articleNo);
	}

	@Override
	public void deleteComment(User user, int commentNo) {
		if (user.getNo() == voteDao.getUserNoToComment(commentNo)) {
			voteDao.deleteComment(commentNo);
		}
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
	public int updateComment(User user, Comment comment) {
		if (user.getNo() == voteDao.getUserNoToComment(comment.getNo())) {
			voteDao.updateComment(comment);
		}
		return voteDao.getArticleNoFromComment(comment.getNo());
	}
}
