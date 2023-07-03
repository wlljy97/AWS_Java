package ch18_빌더;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // @Builder 을 쓰면 밑의 주석 되있는곳을 생략할 수 있다. 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KoreaUser {
	private int userId;
	private String username;
	private String password;
	private String name;
	private String eamail;
	
	public static KoreaUserBuilder builder() {
		return new KoreaUserBuilder();
	}
	
	public static class KoreaUserBuilder {
		
		
		private int userId;
		private String username;
		private String password;
		private String name;
		private String eamail;
		
//		public KoreaUser build() {
//			return new KoreaUser(userId, username, password, name, eamail);
//		}
//		
//		public KoreaUserBuilder userId(int userId) {
//			this.userId = userId;
//			return this;
//		}
//		
//		public KoreaUserBuilder username(String username) {
//			this.username = username;
//			return this;
//		}
//		
//		public KoreaUserBuilder password(String password) {
//			this.password = password;
//			return this;
//		}
//		
//		public KoreaUserBuilder name(String name) {
//			this.name = name;
//			return this;
//		}
//		
//		public KoreaUserBuilder eamail(String eamail) {
//			this.eamail = eamail;
//			return this;
//		}
	
	}
}
