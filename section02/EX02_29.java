package section02;

public class EX02_29 {

	public static void main(String[] args) {
		// 정수형과 실수형 간의 강제형변환 예제
		
		// float ---> int
		float f1 = 12345.67f; //f 를 표현해야 float형이 된다. 그렇지 않으면 double형
		int i1 = (int) f1;
		System.out.println("[float -> int] f1의 값 :" + f1 + ", i1의 값 :" + i1);
		
		double f2 = 12345.678; 
		int i2 = (int)f2;
		System.out.println("i2 :" + i2);
		

	}

}
