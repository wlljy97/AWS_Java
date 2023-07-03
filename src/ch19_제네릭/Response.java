package ch19_제네릭;
 // 제네릭 자료형에 대한 변수명
 // <> <- 제네릭
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response<T> {
	
	private int statusCode;
	private T data;
	
}
