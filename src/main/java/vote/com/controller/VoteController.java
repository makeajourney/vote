package vote.com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import vote.com.vo.VoteElement;

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
		ArrayList<Comment> comments = voteService.getComments(articleNo);
		ArrayList<VoteElement> voteElements = voteService.getVoteElements(articleNo);
		
		mv.addObject("article", article);
		mv.addObject("comments", comments);
		mv.addObject("voteElements", voteElements);
		
		return mv;
	}

	@RequestMapping(value="/writeVote.do", method=RequestMethod.GET)
	public ModelAndView showWriteWindow(HttpSession session) {
		if (((User) session.getAttribute("user")) != null ){
			return new ModelAndView("/writevote");
		} else {
			return new ModelAndView("redirect:/login.do");
		}
	}
	
	@RequestMapping(value="/writeVote.do", method=RequestMethod.POST)
	public ModelAndView addArticle(
			@RequestParam("title") String title, 
			@RequestParam("content") String content,
			@RequestParam("voteElement") String voteElements,
			HttpServletRequest request,
			HttpSession session) throws Exception {
		User user = (User) session.getAttribute("user");
				
		int articleNo = voteService.addArticle(
				new Article().setTitle(title)
					.setContent(content)
					.setUserNo(user.getNo()), voteElements, request);
		
		return new ModelAndView("redirect:/voteDetail.do?articleno=" + articleNo);	
	}
	
	@RequestMapping(value="/showMyVoteList.do") 
	public ModelAndView showMyVoteList (HttpSession session) {
		User user = ((User) session.getAttribute("user"));
		ModelAndView mv = null;
		if (user != null) {
			mv = new ModelAndView("/myvote");
			ArrayList<Article> myArticles = voteService.getMyArticleList(user.getNo());
			mv.addObject("articleList", myArticles);			
		} else {
			mv = new ModelAndView("redirect:/login.do");
		}
		return mv;
	}
	
	@RequestMapping("/addComment.do")
	public ModelAndView addComment(
			@RequestParam("context") String commentContext,
			@RequestParam("articleno") int articleNo,
			HttpSession session) {
		User user = ((User) session.getAttribute("user"));

		if (user != null) {
			voteService.addComment(new Comment()
					.setArticleNo(articleNo)
					.setContext(commentContext)
					.setUserNo(user.getNo()));
			
			return new ModelAndView("redirect:/voteDetail.do?articleno=" + articleNo);
		} else {
			return new ModelAndView("redirect:/login.do");
		}
	}
	
	@RequestMapping(value="/deleteVote.do")
	public ModelAndView deleteMyVote(
			@RequestParam("articleno") int articleNo,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		voteService.deleteArticle(user, articleNo);
		
		return new ModelAndView("redirect:/main.do");
	}
	
	@RequestMapping(value="/deleteComment.do")
	public ModelAndView deleteComment (
			@RequestParam("commentno") int commentNo,
			@RequestParam("articleno") int articleNo,
			HttpSession session) {
		User user = ((User) session.getAttribute("user"));
		
		voteService.deleteComment(user, commentNo);
		
		return new ModelAndView("redirect:/voteDetail.do?articleno=" + articleNo);
	}
	
}
