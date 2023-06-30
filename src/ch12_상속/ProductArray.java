package ch12_상속;

public class ProductArray {
	public static void main(String[] args) {
		
		Product[] products = new Product[5];
		
		products[0] = new Computer("삼성컴퓨터", 1000, "데스크탑");
		products[1] = new Clothes("하의", 4000, "L" , "red");
		products[2] = new Computer("맥북", 2000, "랩탑");
		products[3] = new Clothes("상의", 5000, "M" , "black");
		products[4] = new Computer("그램", 3000, "랩탑");
		
		for (int i = 0; i < products.length; i++) {
			System.out.println("모델명 : " + products[i].getModel());
			System.out.println("가격 : " + products[i].getPrice());
			
			// instanceof : - instanceof는 객체 타입을 확인하는 연산자이다.
			//				형변환 가능 여부를 확인하며 true / false로 결과를 반환한다.
			//				주로 상속 관계에서 부모객체인지 자식 객체인지 확인하는 데 사용된다.
			
			if(products[i] instanceof Computer) {
				System.out.println("컴퓨터임");
				Computer computer = (Computer) products[i];
				System.out.println("종류 : " + computer.getType());
				
			}else if (products[i] instanceof Clothes) {
				System.out.println("옷임");
				Clothes clothes = (Clothes) products[i];
				System.out.println("사이즈 : " + clothes.getSize());
				System.out.println("색상 : " + clothes.getColor());
				
			}
			
			System.out.println("===============================");
		}
	}
}
