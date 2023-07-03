package ch18_빌더;

	//Builder
	// 객체를 대신 만듬, 생성을 효과적을 하기 위해 사용됨
public class KoreaUserBuilder2 {
	
	private int userId;
	private String username;
	private String password;
	private String name;
	private String eamail;
	
	public KoreaUser build() {
		return new KoreaUser(userId, username, password, name, eamail);
	}
	
	public KoreaUserBuilder2 userId(int userId) {
		this.userId = userId;
		return this;
	}
	
	public KoreaUserBuilder2 username(String username) {
		this.username = username;
		return this;
	}
	
	public KoreaUserBuilder2 password(String password) {
		this.password = password;
		return this;
	}
	
	public KoreaUserBuilder2 name(String name) {
		this.name = name;
		return this;
	}
	
	public KoreaUserBuilder2 eamail(String eamail) {
		this.eamail = eamail;
		return this;
	}
		
		
		
	
}
	
	

