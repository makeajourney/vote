package vote.com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vote.com.service.VoteService;
import vote.com.vo.Article;
import vote.com.vo.Comment;
import vote.com.vo.User;

@Controller
public class VoteController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="voteService")
	private VoteService voteService;
	
	@RequestMapping(value="/main.do")
	public ModelAndView mainPage() {
		ModelAndView mv = new ModelAndView("/main");
		ArrayList<Article> articleList =  voteService.getArticleList();
		mv.addObject("articleList", articleList);		
		return mv;
	}
	
	@RequestMapping(value="/voteDetail.do")
	public ModelAndView voteDetail(@RequestParam("articleno") int articleNo) {
		ModelAndView mv = new ModelAndView("/votecontents");
		Article article = voteService.getArticleDetail(articleNo);
		ArrayList<Comment> comments = new ArrayList<Comment>();
		comments = 	voteService.getComments(articleNo);
		mv.addObject("article", article);
		mv.addObject("comments", comments);
		
		return mv;
	}

	@RequestMapping(value="/showWriteVoteWindow.do", method=RequestMethod.GET)
	public ModelAndView showWriteWindow() {
		return new ModelAndView("/writevote");
	}
	
	// /showMyVoteList.do?userNo=${user.no}
	@RequestMapping(value="/showMyVoteList.do") 
	public ModelAndView showMyVoteList (HttpSession session) {
		int userNo = ((User) session.getAttribute("user")).getNo();
		ModelAndView mv = new ModelAndView("/myvote");
		ArrayList<Article> myArticles = voteService.getMyArticleList(userNo);
		mv.addObject("articleList", myArticles);
		return mv;
	}
	
	
	//@RequestMapping(value="/writeVote.do" method=RequestMethod.POST)
	
	
	
}
