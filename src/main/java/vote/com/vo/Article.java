package vote.com.vo;

import java.util.Date;

public class Article {
	private int no;
	private String title;
	private String content;
	private int hitCount;
	private Date createTime;
	private Date updateTime;
	private int userNo;
	private boolean delete;
	
	private User user;
	
	public int getNo() {
		return no;
	}
	public Article setNo(int no) {
		this.no = no;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Article setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Article setContent(String content) {
		this.content = content;
		return this;
	}
	public int getHitCount() {
		return hitCount;
	}
	public Article setHitCount(int hitCount) {
		this.hitCount = hitCount;
		return this;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Article setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public Article setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}
	public int getUserNo() {
		return userNo;
	}
	public Article setUserNo(int userNo) {
		this.userNo = userNo;
		return this;
	}
	public boolean isDelete() {
		return delete;
	}
	public Article setDelete(boolean delete) {
		this.delete = delete;
		return this;
	}
	public User getUser() {
		return user;
	}
	public Article setUser(User user) {
		this.user = user;
		return this;
	}
}
