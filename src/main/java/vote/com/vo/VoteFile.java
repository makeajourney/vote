package vote.com.vo;

import java.sql.Date;

public class VoteFile {
	private int no;
	private int articleNo;
	private String originalFileName;
	private String storedFileName;
	private long fileSize;
	private Date createDate;
	private boolean deleteField;
	
	public int getNo() {
		return no;
	}
	public VoteFile setNo(int no) {
		this.no = no;
		return this;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public VoteFile setArticleNo(int articleNo) {
		this.articleNo = articleNo;
		return this;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public VoteFile setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
		return this;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public VoteFile setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
		return this;
	}
	public long getFileSize() {
		return fileSize;
	}
	public VoteFile setFileSize(long fileSize) {
		this.fileSize = fileSize;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public VoteFile setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public boolean isDeleteField() {
		return deleteField;
	}
	public VoteFile setDeleteField(boolean deleteField) {
		this.deleteField = deleteField;
		return this;
	}
}
