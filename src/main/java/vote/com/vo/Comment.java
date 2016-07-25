package vote.com.vo;

import java.sql.Date;

public class Comment {
	private int articleNo;
	private int no;
	private int parentNo;
	private int userNo;
	private String userName;
	private String context;
	private Date createDate;
	private Date updateDate;
	
	public int getArticleNo() {
		return articleNo;
	}
	public Comment setArticleNo(int articleNo) {
		this.articleNo = articleNo;
		return this;
	}
	public int getNo() {
		return no;
	}
	public Comment setNo(int no) {
		this.no = no;
		return this;
	}
	public int getParentNo() {
		return parentNo;
	}
	public Comment setParentNo(int parentNo) {
		this.parentNo = parentNo;
		return this;
	}
	public int getUserNo() {
		return userNo;
	}
	public Comment setUserNo(int userNo) {
		this.userNo = userNo;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public Comment setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public String getContext() {
		return context;
	}
	public Comment setContext(String context) {
		this.context = context;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Comment setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public Comment setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
}
