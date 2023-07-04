package ch14_싱글톤;

import java.time.LocalDate;
import java.util.Date;

public class Samsung {
	private static Samsung instance; 
	// instanace 에 Samsung 객체를 가질수 있다 static 변수
	
	private String companyName;
	private int autoIncrementSerialNumber = LocalDate.now().getYear() * 10000;
	
	private Samsung() {
		companyName = "SAMSUNG"; 
		// "SAMSUNG"; 을 Samsung.class.getSimpleName().toUpperCase();로 나타낼수 있다. 생성자는 private 여야 한다.
		
	}
	
	public static Samsung getInstance() { //해당 인스턴스를 공유 할 수 있게 getInstance를 만들어야 한다
		if (instance == null) {
			instance = new Samsung();
		}
		return instance;
	}
	
	public int getAutoIncrementSerialNumber() {
		return autoIncrementSerialNumber;
	}
	public void setAutoIncrementSerialNumber(int autoIncrementSerialNumber) {
		this.autoIncrementSerialNumber = autoIncrementSerialNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	
}
