package ch16_lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@EqualsAndHashCode
//@Getter
//@Setter
//@ToString
@Data // 위의 4가지가 합쳐져 있는것
@AllArgsConstructor
@RequiredArgsConstructor // 쓸때는 자료형앞에 final을 달아 줘야한다 
public class Slave {
	
	private final String name;
	
	private int age;
	
	
	
}
