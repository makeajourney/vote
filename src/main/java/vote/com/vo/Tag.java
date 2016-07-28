package vote.com.vo;

public class Tag {
	private int articleNo;
	private String tag;

	public String getTag() {
		return tag;
	}

	public Tag setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public Tag setArticleNo(int articleNo) {
		this.articleNo = articleNo;
		return this;
	}
}
