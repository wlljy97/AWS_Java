package Test;

public class UserMain {
	public static void main(String[] args) {
		
		User user = new User("junil", "1234", "김준일", "junil@gmail.com");
		System.out.println(user);
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("name : " + user.getName());
		System.out.println("email : " + user.getEmail());
		
	}
}
