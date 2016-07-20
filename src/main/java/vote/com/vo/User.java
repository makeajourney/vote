package vote.com.vo;

public class User {
	private int no;
	private String id;
	private String name;
	private String password;
	private String oAuthCode;
	private String accessToken;
	private String primaryKey;
	
	public int getNo() {
		return no;
	}
	public User setNo(int no) {
		this.no = no;
		return this;
	}
	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getoAuthCode() {
		return oAuthCode;
	}
	public User setoAuthCode(String oAuthCode) {
		this.oAuthCode = oAuthCode;
		return this;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public User setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public User setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
		return this;
	}
}
