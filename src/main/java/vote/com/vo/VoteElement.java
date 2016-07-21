package vote.com.vo;

public class VoteElement {
	private int articleNo;
	private int no;
	private String content;
	
	public int getArticleNo() {
		return articleNo;
	}
	public VoteElement setArticleNo(int articleNo) {
		this.articleNo = articleNo;
		return this;
	}
	public int getNo() {
		return no;
	}
	public VoteElement setNo(int no) {
		this.no = no;
		return this;
	}
	public String getContent() {
		return content;
	}
	public VoteElement setContent(String content) {
		this.content = content;
		return this;
	}
}
